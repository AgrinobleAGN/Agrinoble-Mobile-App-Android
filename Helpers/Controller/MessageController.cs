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
using WoWonder.Activities.Chat.ChatWindow;
using WoWonder.Activities.Chat.MsgTabbes;
using WoWonder.Activities.Chat.MsgTabbes.Services;
using WoWonder.Helpers.Jobs;
using WoWonder.Helpers.Model;
using WoWonder.Helpers.Utils;
using WoWonder.SQLite;
using WoWonderClient.Classes.Message;
using WoWonderClient.JobWorker;
using WoWonderClient.Requests;
using File = Java.IO.File;
using MessageData = WoWonderClient.Classes.Message.MessageData;

namespace WoWonder.Helpers.Controller
{
    public static class MessageController
    {
        //############# DON'T  MODIFY HERE ############# 

        private static ChatWindowActivity WindowActivity;

        private static MsgTabbedMainActivity GlobalContext;
        //========================= Functions =========================
        public static async Task SendMessageTask(ChatWindowActivity windowActivity, string userId, string chatId, string messageHashId, string text = "", string contact = "", string filePath = "", string imageUrl = "", string stickerId = "", string gifUrl = "", string productId = "", string lat = "", string lng = "", string storyId = "", string replyId = "")
        {
            try
            {
                WindowActivity = windowActivity;

                GlobalContext = MsgTabbedMainActivity.GetInstance();

                if (!string.IsNullOrEmpty(filePath))
                {
                    if (AppSettings.EnableVideoCompress && Methods.AttachmentFiles.Check_FileExtension(filePath) == "Video")
                    {
                        File destinationPath = new File(Methods.Path.FolderDcimVideo + "/Compressor");

                        if (!Directory.Exists(destinationPath.Path))
                            Directory.CreateDirectory(destinationPath.Path);

                        await Task.Factory.StartNew(() => new VideoCompressAsyncTask(windowActivity, userId, chatId, messageHashId, text, filePath, storyId, replyId).Execute("false", filePath, destinationPath.Path));
                    }
                    else
                    {
                        new UploadSingleFileToServerWorker(windowActivity, "ChatWindowActivity").UploadFileToServer(windowActivity, new MessageModel
                        {
                            MessageHashId = messageHashId,
                            ChatId = chatId,
                            UserId = userId,
                            FilePath = filePath,
                            ReplyId = replyId,
                            StoryId = storyId,
                        });
                    }
                }
                else
                {
                    StartApiService(userId, messageHashId, text, contact, filePath, imageUrl, stickerId, gifUrl, productId, lat, lng, storyId, replyId);
                }
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        private static void StartApiService(string userId, string messageHashId, string text = "", string contact = "", string filePath = "", string imageUrl = "", string stickerId = "", string gifUrl = "", string productId = "", string lat = "", string lng = "", string storyId = "", string replyId = "")
        {
            if (!Methods.CheckConnectivity())
                ToastUtils.ShowToast(WindowActivity, WindowActivity?.GetString(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
            else
                PollyController.RunRetryPolicyFunction(new List<Func<Task>> { () => SendMessage(userId, messageHashId, text, contact, filePath, imageUrl, stickerId, gifUrl, productId, lat, lng, storyId, replyId) });
        }

        private static async Task SendMessage(string userId, string messageHashId, string text = "", string contact = "", string filePath = "", string imageUrl = "", string stickerId = "", string gifUrl = "", string productId = "", string lat = "", string lng = "", string storyId = "", string replyId = "")
        {
            var (apiStatus, respond) = await RequestsAsync.Message.SendMessageAsync(userId, messageHashId, text, contact, filePath, imageUrl, stickerId, gifUrl, productId, lat, lng, storyId, replyId);
            if (apiStatus == 200)
            {
                if (respond is SendMessageObject result)
                {
                    UpdateLastIdMessage(result);
                }
            }
            else Methods.DisplayReportResult(WindowActivity, respond);
        }

        public static void UpdateLastIdMessage(SendMessageObject chatMessages)
        {
            try
            {
                MessageData messageInfo = chatMessages?.MessageData?.FirstOrDefault();
                if (messageInfo != null)
                {
                    var typeModel = Holders.GetTypeModel(messageInfo);
                    if (typeModel == MessageModelType.None)
                        return;

                    AdapterModelsClassMessage checker = WindowActivity?.MAdapter?.DifferList?.FirstOrDefault(a => a.MesData?.Id == messageInfo.MessageHashId);
                    if (checker != null)
                    {
                        var message = WoWonderTools.MessageFilter(messageInfo.ToId, messageInfo, typeModel, true);
                        message.ModelType = typeModel;
                        message.ErrorSendMessage = false;
                        message.Seen ??= "0";

                        checker.MesData = message;
                        checker.Id = Java.Lang.Long.ParseLong(message.Id);
                        checker.TypeView = typeModel;

                        #region LastChat

                        var updaterUser = GlobalContext?.LastChatTab?.MAdapter?.LastChatsList?.FirstOrDefault(a => a.LastChat?.UserId == message.ToId && a.LastChat?.ChatType == "user");
                        if (updaterUser?.LastChat != null)
                        {
                            var index = GlobalContext.LastChatTab.MAdapter.LastChatsList.IndexOf(updaterUser);
                            if (index > -1)
                            {
                                updaterUser.LastChat.LastMessage.LastMessageClass.Text = typeModel switch
                                {
                                    MessageModelType.RightGif => WindowActivity?.GetText(Resource.String.Lbl_SendGifFile),
                                    MessageModelType.RightText => !string.IsNullOrEmpty(message.Text) ? Methods.FunString.DecodeString(message.Text) : WindowActivity?.GetText(Resource.String.Lbl_SendMessage),
                                    MessageModelType.RightSticker => WindowActivity?.GetText(Resource.String.Lbl_SendStickerFile),
                                    MessageModelType.RightContact => WindowActivity?.GetText(Resource.String.Lbl_SendContactnumber),
                                    MessageModelType.RightFile => WindowActivity?.GetText(Resource.String.Lbl_SendFile),
                                    MessageModelType.RightVideo => WindowActivity?.GetText(Resource.String.Lbl_SendVideoFile),
                                    MessageModelType.RightImage => WindowActivity?.GetText(Resource.String.Lbl_SendImageFile),
                                    MessageModelType.RightAudio => WindowActivity?.GetText(Resource.String.Lbl_SendAudioFile),
                                    MessageModelType.RightMap => WindowActivity?.GetText(Resource.String.Lbl_SendLocationFile),
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
                                dbSqLite.Insert_Or_Update_one_LastUsersChat(updaterUser?.LastChat);

                            }
                        }
                        else
                        {
                            //insert new user  
                            if (Methods.CheckConnectivity())
                                PollyController.RunRetryPolicyFunction(new List<Func<Task>> { PostUpdaterHelper.LoadChatAsync });
                        }

                        #endregion

                        //Update All data users to database
                        SqLiteDatabase dbDatabase = new SqLiteDatabase();
                        dbDatabase.Insert_Or_Update_To_one_MessagesTable(checker.MesData);

                        WindowActivity?.RunOnUiThread(() =>
                        {
                            try
                            {
                                //Update data RecyclerView Messages.
                                //if (message.ModelType == MessageModelType.RightSticker || message.ModelType == MessageModelType.RightImage || message.ModelType == MessageModelType.RightMap || message.ModelType == MessageModelType.RightVideo)
                                WindowActivity?.Update_One_Messages(checker.MesData);

                                if (UserDetails.SoundControl)
                                    Methods.AudioRecorderAndPlayer.PlayAudioFromAsset("Popup_SendMesseges.mp3");
                            }
                            catch (Exception e)
                            {
                                Methods.DisplayReportResultTrack(e);
                            }
                        });
                    }
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private class VideoCompressAsyncTask : AsyncTask<string, string, string>
        {
            private readonly ChatWindowActivity MContext;
            private readonly string UserId;
            private readonly string ChatId;
            private readonly string MessageHashId;
            private readonly string Text;
            private string FilePath;
            private readonly string StoryId;
            private readonly string ReplyId;
            public VideoCompressAsyncTask(ChatWindowActivity context, string userId, string chatId, string messageHashId, string text, string filePath, string storyId, string replyId)
            {
                try
                {
                    MContext = context;
                    UserId = userId;
                    ChatId = chatId;
                    MessageHashId = messageHashId;
                    Text = text;
                    FilePath = filePath;
                    StoryId = storyId;
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
                        new UploadSingleFileToServerWorker(MContext, "ChatWindowActivity").UploadFileToServer(MContext, new MessageModel
                        {
                            MessageHashId = MessageHashId,
                            ChatId = ChatId,
                            UserId = UserId,
                            FilePath = imageFile.Path,
                            ReplyId = ReplyId,
                            StoryId = StoryId,
                        });

                        //StartApiService(UserId, MessageHashId, Text, "", imageFile.Path);
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