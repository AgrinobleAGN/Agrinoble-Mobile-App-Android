using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using Android.OS;
using Android.Widget;
using Iceteck.SiliCompressorrLib;
using Java.Net;
using WoWonder.Activities.Chat.Adapters;
using WoWonder.Activities.Chat.MsgTabbes;
using WoWonder.Activities.Chat.MsgTabbes.Services;
using WoWonder.Activities.Chat.PageChat;
using WoWonder.Helpers.Jobs;
using WoWonder.Helpers.Model;
using WoWonder.Helpers.Utils;
using WoWonder.SQLite;
using WoWonderClient.Classes.Global;
using WoWonderClient.Classes.Message;
using WoWonderClient.Classes.PageChat;
using WoWonderClient.JobWorker;
using WoWonderClient.Requests;
using File = Java.IO.File;
using MessageData = WoWonderClient.Classes.Message.MessageData;

namespace WoWonder.Helpers.Controller
{
    public static class PageMessageController
    {
        //############# DONT'T MODIFY HERE ############# 
        private static ChatObject PageData;
        private static PageClass DataProfilePage;
        private static PageChatWindowActivity MainWindowActivity;

        private static MsgTabbedMainActivity GlobalContext;

        //========================= Functions ========================= 
        public static async Task SendMessageTask(PageChatWindowActivity windowActivity, string pageId, string id, string chatId, string messageId, string text = "", string contact = "", string pathFile = "", string imageUrl = "", string stickerId = "", string gifUrl = "", string lat = "", string lng = "", string replyId = "")
        {
            try
            {
                MainWindowActivity = windowActivity;
                if (windowActivity.PageData != null)
                    PageData = windowActivity.PageData;
                else if (windowActivity.DataProfilePage != null)
                    DataProfilePage = windowActivity.DataProfilePage;

                GlobalContext = MsgTabbedMainActivity.GetInstance();

                if (!string.IsNullOrEmpty(pathFile))
                {
                    if (AppSettings.EnableVideoCompress && Methods.AttachmentFiles.Check_FileExtension(pathFile) == "Video")
                    {
                        File destinationPath = new File(Methods.Path.FolderDcimVideo + "/Compressor");

                        if (!Directory.Exists(destinationPath.Path))
                            Directory.CreateDirectory(destinationPath.Path);

                        await Task.Factory.StartNew(() => new VideoCompressAsyncTask(windowActivity, pageId, id, chatId, messageId, text, pathFile, replyId).Execute("false", pathFile, destinationPath.Path));
                    }
                    else
                    {
                        new UploadSingleFileToServerWorker(windowActivity, "PageChatWindowActivity").UploadFileToServer(windowActivity, new MessageModel
                        {
                            MessageHashId = messageId,
                            ChatId = chatId,
                            UserId = id,
                            PageId = pageId,
                            FilePath = pathFile,
                            ReplyId = replyId,
                        });
                    }
                }
                else
                {
                    StartApiService(pageId, id, messageId, text, contact, pathFile, imageUrl, stickerId, gifUrl, lat, lng, replyId);
                }

                await Task.Delay(0);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        private static void StartApiService(string pageId, string id, string messageId, string text = "", string contact = "", string pathFile = "", string imageUrl = "", string stickerId = "", string gifUrl = "", string lat = "", string lng = "", string replyId = "")
        {
            if (!Methods.CheckConnectivity())
                ToastUtils.ShowToast(MainWindowActivity, MainWindowActivity.GetString(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
            else
                PollyController.RunRetryPolicyFunction(new List<Func<Task>> { () => SendMessage(pageId, id, messageId, text, contact, pathFile, imageUrl, stickerId, gifUrl, lat, lng, replyId) });
        }

        private static async Task SendMessage(string pageId, string id, string messageId, string text = "", string contact = "", string pathFile = "", string imageUrl = "", string stickerId = "", string gifUrl = "", string lat = "", string lng = "", string replyId = "")
        {
            var (apiStatus, respond) = await RequestsAsync.PageChat.SendMessageToPageChatAsync(pageId, id, messageId, text, contact, pathFile, imageUrl, stickerId, gifUrl, lat, lng, replyId);
            if (apiStatus == 200)
            {
                if (respond is PageSendMessageObject result)
                {
                    UpdateLastIdMessage(result.Data, pageId, id);
                }
            }
            else Methods.DisplayReportResult(MainWindowActivity, respond);
        }

        public static void UpdateLastIdMessage(List<MessageData> chatMessages, string pageId, string id)
        {
            try
            {
                MessageData messageInfo = chatMessages?.FirstOrDefault();
                if (messageInfo != null)
                {
                    var typeModel = Holders.GetTypeModel(messageInfo);
                    if (typeModel == MessageModelType.None)
                        return;

                    var checker = MainWindowActivity?.MAdapter.DifferList?.FirstOrDefault(a => a.MesData.Id == messageInfo.MessageHashId);
                    if (checker != null)
                    {
                        var message = WoWonderTools.MessageFilter(messageInfo.ToId, messageInfo, typeModel, true);
                        message.ModelType = typeModel;

                        checker.MesData = message;
                        checker.Id = Java.Lang.Long.ParseLong(message.Id);
                        checker.TypeView = typeModel;

                        #region LastChat

                        if (AppSettings.LastChatSystem == SystemGetLastChat.Default)
                        {
                            var updaterUser = GlobalContext?.LastChatTab?.MAdapter?.LastChatsList?.FirstOrDefault(a => a.LastChat?.PageId == message.PageId && a.LastChat?.ChatType == "page");
                            if (updaterUser?.LastChat != null)
                            {
                                var index = GlobalContext.LastChatTab.MAdapter.LastChatsList.IndexOf(updaterUser);
                                if (index > -1)
                                {
                                    updaterUser.LastChat.LastMessage.LastMessageClass.Text = typeModel switch
                                    {
                                        MessageModelType.RightGif => MainWindowActivity?.GetText(Resource.String.Lbl_SendGifFile),
                                        MessageModelType.RightText => !string.IsNullOrEmpty(message.Text) ? Methods.FunString.DecodeString(message.Text) : MainWindowActivity?.GetText(Resource.String.Lbl_SendMessage),
                                        MessageModelType.RightSticker => MainWindowActivity?.GetText(Resource.String.Lbl_SendStickerFile),
                                        MessageModelType.RightContact => MainWindowActivity?.GetText(Resource.String.Lbl_SendContactnumber),
                                        MessageModelType.RightFile => MainWindowActivity?.GetText(Resource.String.Lbl_SendFile),
                                        MessageModelType.RightVideo => MainWindowActivity?.GetText(Resource.String.Lbl_SendVideoFile),
                                        MessageModelType.RightImage => MainWindowActivity?.GetText(Resource.String.Lbl_SendImageFile),
                                        MessageModelType.RightAudio => MainWindowActivity?.GetText(Resource.String.Lbl_SendAudioFile),
                                        MessageModelType.RightMap => MainWindowActivity?.GetText(Resource.String.Lbl_SendLocationFile),
                                        _ => updaterUser.LastChat?.LastMessage.LastMessageClass.Text
                                    };

                                    GlobalContext?.RunOnUiThread(() =>
                                    {
                                        try
                                        {
                                            if (!updaterUser.LastChat.IsPin)
                                            {
                                                var checkPin = GlobalContext?.LastChatTab?.MAdapter?.LastChatsList?.LastOrDefault(o => o.LastChat != null && o.LastChat.IsPin);
                                                if (checkPin != null)
                                                {
                                                    var toIndex = GlobalContext.LastChatTab.MAdapter.LastChatsList.IndexOf(checkPin) + 1;

                                                    if (index != toIndex)
                                                    {
                                                        GlobalContext?.LastChatTab?.MAdapter?.LastChatsList?.Move(index, toIndex);
                                                        GlobalContext?.LastChatTab?.MAdapter?.NotifyItemMoved(index, toIndex);
                                                    }

                                                    GlobalContext?.LastChatTab?.MAdapter?.NotifyItemChanged(toIndex, "WithoutBlobText");
                                                }
                                                else
                                                {
                                                    if (ListUtils.FriendRequestsList.Count > 0)
                                                    {
                                                        if (index != 1)
                                                        {
                                                            GlobalContext?.LastChatTab?.MAdapter?.LastChatsList?.Move(index, 1);
                                                            GlobalContext?.LastChatTab?.MAdapter?.NotifyItemMoved(index, 1);
                                                        }

                                                        GlobalContext?.LastChatTab?.MAdapter?.NotifyItemChanged(1, "WithoutBlobText");
                                                    }
                                                    else
                                                    {
                                                        if (index != 0)
                                                        {
                                                            GlobalContext?.LastChatTab?.MAdapter?.LastChatsList?.Move(index, 0);
                                                            GlobalContext?.LastChatTab?.MAdapter?.NotifyItemMoved(index, 0);
                                                        }

                                                        GlobalContext?.LastChatTab?.MAdapter?.NotifyItemChanged(0, "WithoutBlobText");
                                                    }
                                                }
                                            }
                                        }
                                        catch (Exception e)
                                        {
                                            Methods.DisplayReportResultTrack(e);
                                        }
                                    });

                                    SqLiteDatabase dbSqLite = new SqLiteDatabase();
                                    //Update All data users to database
                                    dbSqLite.Insert_Or_Update_one_LastUsersChat(updaterUser.LastChat);
                                }
                            }
                            else
                            {
                                //insert new user  
                                if (Methods.CheckConnectivity())
                                    PollyController.RunRetryPolicyFunction(new List<Func<Task>> { PostUpdaterHelper.LoadChatAsync });
                            }
                        }
                        else
                        {
                            var updaterUser = GlobalContext?.LastPageChatsTab?.MAdapter?.LastChatsList?.FirstOrDefault(a => a.LastChatPage?.PageId == message.PageId);
                            if (updaterUser?.LastChatPage != null)
                            {
                                var index = GlobalContext.LastPageChatsTab.MAdapter.LastChatsList.IndexOf(GlobalContext.LastPageChatsTab.MAdapter.LastChatsList.FirstOrDefault(x => x.LastChatPage?.PageId == message.PageId));
                                if (index > -1)
                                {
                                    updaterUser.LastChatPage.LastMessage.Text = typeModel switch
                                    {
                                        MessageModelType.RightGif => MainWindowActivity?.GetText(Resource.String.Lbl_SendGifFile),
                                        MessageModelType.RightText => !string.IsNullOrEmpty(message.Text) ? Methods.FunString.DecodeString(message.Text) : MainWindowActivity?.GetText(Resource.String.Lbl_SendMessage),
                                        MessageModelType.RightSticker => MainWindowActivity?.GetText(Resource.String.Lbl_SendStickerFile),
                                        MessageModelType.RightContact => MainWindowActivity?.GetText(Resource.String.Lbl_SendContactnumber),
                                        MessageModelType.RightFile => MainWindowActivity?.GetText(Resource.String.Lbl_SendFile),
                                        MessageModelType.RightVideo => MainWindowActivity?.GetText(Resource.String.Lbl_SendVideoFile),
                                        MessageModelType.RightImage => MainWindowActivity?.GetText(Resource.String.Lbl_SendImageFile),
                                        MessageModelType.RightAudio => MainWindowActivity?.GetText(Resource.String.Lbl_SendAudioFile),
                                        MessageModelType.RightMap => MainWindowActivity?.GetText(Resource.String.Lbl_SendLocationFile),
                                        _ => updaterUser.LastChatPage?.LastMessage.Text
                                    };

                                    GlobalContext?.RunOnUiThread(() =>
                                    {
                                        try
                                        {
                                            if (!updaterUser.LastChatPage.IsPin)
                                            {
                                                var checkPin = GlobalContext?.LastPageChatsTab?.MAdapter.LastChatsList.LastOrDefault(o => o.LastChatPage != null && o.LastChatPage.IsPin);
                                                if (checkPin != null)
                                                {
                                                    var toIndex = GlobalContext.LastPageChatsTab.MAdapter.LastChatsList.IndexOf(checkPin) + 1;
                                                    GlobalContext?.LastPageChatsTab?.MAdapter.LastChatsList.Move(index, toIndex);
                                                    GlobalContext?.LastPageChatsTab?.MAdapter.NotifyItemMoved(index, toIndex);
                                                }
                                                else
                                                {
                                                    if (ListUtils.FriendRequestsList.Count > 0)
                                                    {
                                                        GlobalContext?.LastPageChatsTab?.MAdapter.LastChatsList.Move(index, 1);
                                                        GlobalContext?.LastPageChatsTab?.MAdapter.NotifyItemMoved(index, 1);
                                                    }
                                                    else
                                                    {
                                                        GlobalContext?.LastPageChatsTab?.MAdapter.LastChatsList.Move(index, 0);
                                                        GlobalContext?.LastPageChatsTab?.MAdapter.NotifyItemMoved(index, 0);
                                                    }
                                                }
                                            }
                                        }
                                        catch (Exception e)
                                        {
                                            Methods.DisplayReportResultTrack(e);
                                        }
                                    });

                                }
                            }
                            else
                            {
                                //insert new user  
                                if (Methods.CheckConnectivity())
                                    PollyController.RunRetryPolicyFunction(new List<Func<Task>> { PostUpdaterHelper.LoadChatAsync });
                            }
                        }

                        #endregion

                        GlobalContext?.RunOnUiThread(() =>
                        {
                            try
                            {
                                //Update data RecyclerView Messages.
                                if (message.ModelType != MessageModelType.RightSticker || message.ModelType != MessageModelType.RightImage || message.ModelType != MessageModelType.RightMap || message.ModelType != MessageModelType.RightVideo)
                                    MainWindowActivity.Update_One_Messages(checker.MesData);

                                if (UserDetails.SoundControl)
                                    Methods.AudioRecorderAndPlayer.PlayAudioFromAsset("Popup_SendMesseges.mp3");
                            }
                            catch (Exception e)
                            {
                                Methods.DisplayReportResultTrack(e);
                            }
                        });
                    }

                    PageData = null!;
                    DataProfilePage = null!;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private class VideoCompressAsyncTask : AsyncTask<string, string, string>
        {
            private readonly PageChatWindowActivity MContext;
            private readonly string PageId;
            private readonly string Id;
            private readonly string ChatId;
            private readonly string MessageHashId;
            private readonly string Text;
            private string FilePath;
            private string ReplyId;

            public VideoCompressAsyncTask(PageChatWindowActivity context, string pageId, string id, string chatId, string messageHashId, string text, string filePath, string replyId)
            {
                try
                {
                    MContext = context;
                    PageId = pageId;
                    Id = id;
                    ChatId = chatId;
                    MessageHashId = messageHashId;
                    Text = text;
                    FilePath = filePath;
                    ReplyId = replyId;
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            protected override string RunInBackground(params string[] paths)
            {
                string filePath = null!;
                try
                {
                    //This bellow is just a temporary solution to test that method call works
                    var b = bool.Parse(paths[0]);
                    if (b)
                    {
                        filePath = SiliCompressor.With(MContext).CompressVideo(paths[1], paths[2]);
                    }
                    else
                    {
                        Android.Net.Uri videoContentUri = Android.Net.Uri.Parse(paths[1]);

                        // Example using the bitrate and video size parameters = >> filePath = SiliCompressor.with(mContext).compressVideo(videoContentUri, paths[2], 1280,720,1500000);*/
                        filePath = SiliCompressor.With(MContext).CompressVideo(videoContentUri?.ToString(), paths[2]);
                    }
                }
                catch (URISyntaxException e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
                return filePath;
            }

            protected override void OnPostExecute(string compressedFilePath)
            {
                try
                {
                    base.OnPostExecute(compressedFilePath);

                    File imageFile = new File(compressedFilePath);
                    //float length = imageFile.Length() / 1024f; // Size in KB
                    //string value;
                    //if (length >= 1024)
                    //    value = length / 1024f + " MB";
                    //else
                    //    value = length + " KB";

                    //Methods.DisplayReportResultTrack("Name: " + imageFile.Name + " Size: " + value);

                    //Methods.DisplayReportResultTrack("Silicompressor Path: " + compressedFilePath);

                    var attach = imageFile.Path;
                    if (attach != null)
                    {
                        FilePath = imageFile.Path;

                        new UploadSingleFileToServerWorker(MContext, "PageChatWindowActivity").UploadFileToServer(MContext, new MessageModel
                        {
                            MessageHashId = MessageHashId,
                            ChatId = ChatId,
                            UserId = Id,
                            PageId = PageId,
                            FilePath = FilePath,
                            ReplyId = ReplyId,
                        });

                        //StartApiService(PageId, Id, MessageHashId, Text, "", FilePath);
                    }
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }

    }
}