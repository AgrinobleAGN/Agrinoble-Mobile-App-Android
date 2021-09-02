using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Net.Security;
using System.Threading.Tasks;
using System.Timers;
using Android.App;
using Android.Widget;
using Java.Lang;
using SocketIOClient;
using SocketIOClient.Exceptions;
using SocketIOClient.WebSocketClient;
using WoWonder.Activities.Chat.ChatWindow;
using WoWonder.Activities.Chat.MsgTabbes;
using WoWonder.Activities.Chat.MsgTabbes.Services;
using WoWonder.Activities.Chat.PageChat;
using WoWonder.Helpers.Controller;
using WoWonder.Helpers.Model;
using WoWonder.Helpers.Utils;
using WoWonder.SQLite;
using WoWonderClient;
using WoWonderClient.Classes.Socket;
using Exception = System.Exception;

namespace WoWonder.SocketSystem
{
    public class WoSocketHandler
    {
        private SocketIO Client;
        private readonly bool IsSocketWithSsl = false;
        public static bool IsJoined;
        private static MsgTabbedMainActivity GlobalContext;
        private int MTries;

        public void InitStart()
        {
            try
            {
                GlobalContext = MsgTabbedMainActivity.GetInstance();

                DisconnectSocket();

                //string port = ListUtils.SettingsSiteList?.NodejsSsl == "1" ? ListUtils.SettingsSiteList?.NodejsSslPort : ListUtils.SettingsSiteList?.NodejsPort;

                //var options = new SocketIOOptions
                //{
                //    ConnectionTimeout = TimeSpan.FromSeconds(20),
                //    Reconnection = true,
                //    ReconnectionDelay = 1000,
                //    ReconnectionDelayMax = 5000,
                //    AllowedRetryFirstConnection = false,
                //    EIO = 3,
                //    RandomizationFactor = 0.37450578826223768,
                //    Path = "/socket.io",
                //}; 

                string website = InitializeWoWonder.WebsiteUrl;
                char last = InitializeWoWonder.WebsiteUrl.Last();
                if (last.Equals('/'))
                {
                    website = InitializeWoWonder.WebsiteUrl.Remove(InitializeWoWonder.WebsiteUrl.Length - 1, 1);
                }

                Client = new SocketIO(new Uri(website + ":" + AppSettings.PortSocketServer));
                if (Client != null)
                {
                    //Client.JsonSerializer = new MyJsonSerializer(Client.Options.EIO);
                    //Client.Socket?.ConnectAsync(new Uri(InitializeWoWonder.WebsiteUrl + ":" + port));

                    UseSocketWithSsl();

                    WoSocketEvents events = new WoSocketEvents();
                    events.InitEvents(Client);

                    //Socket_On_Alert(Client);
                    Socket_On_Private_Message(Client);
                    //Socket_On_Private_Message_page(Client); 
                    Socket_On_User_Status_Change(Client);
                    Socket_On_RecordingEvent(Client);
                    Socket_On_TypingEvent(Client);
                    Socket_On_StopTypingEvent(Client);
                    Socket_On_Seen_Messages(Client);
                    Socket_On_new_video_call(Client);
                    Socket_On_loggedintEvent(Client);
                    Socket_On_loggedoutEvent(Client);
                    //Socket_On_message_reaction(Client);
                    //Socket_On_message_reply(Client);
                    //Socket_On_Private_PageMessage(Client);
                }
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (OperationCanceledException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //class MyJsonSerializer : NewtonsoftJsonSerializer
        //{
        //    public MyJsonSerializer(int eio) : base(eio) { }

        //    public override JsonSerializerSettings CreateOptions()
        //    {
        //        try
        //        {
        //            return new JsonSerializerSettings
        //            {
        //                ContractResolver = new DefaultContractResolver
        //                {
        //                    NamingStrategy = new CamelCaseNamingStrategy()
        //                },
        //                Formatting = Formatting.Indented
        //            };
        //        }
        //        catch (InvalidSocketStateException e)
        //        {
        //            Methods.DisplayReportResultTrack(e);
        //            return new JsonSerializerSettings();
        //        }
        //        catch (Exception ex)
        //        {
        //            Methods.DisplayReportResultTrack(ex);
        //            return new JsonSerializerSettings();
        //        }
        //    }
        //}

        public void UseSocketWithSsl()
        {
            try
            {
                if (IsSocketWithSsl)
                {
                    //********* For Proxy settings ***********
                    //var proxy = new System.Net.WebProxy("http://example.com");
                    //proxy.Credentials = new NetworkCredential("username", "password");
                    //********************

                    if (Client?.Socket is ClientWebSocket websocket)
                    {
                        websocket.Config = options =>
                        {
                            options.RemoteCertificateValidationCallback = (sender, certificate, chain, sslPolicyErrors) =>
                            {
                                Console.WriteLine("SslPolicyErrors: " + sslPolicyErrors);
                                if (sslPolicyErrors == SslPolicyErrors.None)
                                {
                                    return true;
                                }

                                return true;
                            };

                            // Set Proxy
                            //options.Proxy = proxy;
                        };
                    }
                    else
                    {
                        ServicePointManager.ServerCertificateValidationCallback = (sender, certificate, chain, sslPolicyErrors) =>
                        {
                            if (sslPolicyErrors == SslPolicyErrors.None)
                            {
                                return true;
                            }

                            Console.WriteLine(sslPolicyErrors);
                            return false;
                        };

                        //********* For Proxy settings ***********
                        //websocket.Config = options => options.Proxy = proxy;
                        //********************
                    }
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
        }

        public async void Emit_Join(string username, string accessToken)
        {
            try
            {
                if (Client == null)
                    InitStart();

                if (Client != null)
                {
                    if (!Client.Connected || !IsJoined)
                        await Client?.ConnectAsync();

                    Client.OnConnected += async (sender, args) =>
                    {
                        try
                        {
                            Console.WriteLine("Socket_OnConnected");
                            Console.WriteLine("Socket.Id:" + Client?.Id);

                            Dictionary<string, string> value = new Dictionary<string, string>
                            {
                                {"username", username}, {"user_id", accessToken}
                            };

                            await Client?.EmitAsync("join", response =>
                            {
                                try
                                {
                                    Console.WriteLine("Socket_joined");
                                    IsJoined = true;

                                    var result = response;
                                    Console.WriteLine(result);
                                    MTries = 0;
                                    Socket_ping_for_lastseen(UserDetails.AccessToken);

                                    if (UserDetails.OnlineUsers)
                                        Emit_loggedintEvent(UserDetails.AccessToken);

                                    //Add all On_ functions here 
                                    //Socket_On_Alert(Client);
                                    Socket_On_Private_Message(Client);
                                    //Socket_On_Private_Message_page(Client); 
                                    Socket_On_User_Status_Change(Client);
                                    Socket_On_RecordingEvent(Client);
                                    Socket_On_TypingEvent(Client);
                                    Socket_On_StopTypingEvent(Client);
                                    Socket_On_Seen_Messages(Client);
                                    Socket_On_new_video_call(Client);
                                    Socket_On_loggedintEvent(Client);
                                    Socket_On_loggedoutEvent(Client);
                                    Socket_On_message_reply(Client);
                                    Socket_On_message_reaction(Client);
                                    //Socket_On_Private_PageMessage(Client); 
                                }
                                catch (InvalidSocketStateException e)
                                {
                                    Methods.DisplayReportResultTrack(e);
                                }
                                catch (Exception exception)
                                {
                                    Methods.DisplayReportResultTrack(exception);
                                }
                            }, value);
                        }
                        catch (InvalidSocketStateException e)
                        {
                            Methods.DisplayReportResultTrack(e);
                        }
                        catch (Exception ex)
                        {
                            Methods.DisplayReportResultTrack(ex);
                        }
                    };
                }
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //set type text
        public async void EmitAsync_RecordingEvent(string recipientId, string accessToken)
        {
            try
            {
                if (!Client.Connected)
                    await Client?.ConnectAsync();

                Console.WriteLine("Socket.Id:" + Client?.Id);

                Dictionary<string, string> value = new Dictionary<string, string>
                {
                    {"recipient_id", recipientId}, {"user_id", accessToken}
                };

                await Client?.EmitAsync("recording", response =>
                {
                    try
                    {
                        var result = response.GetValue();
                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                }, value);
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //set type text
        public async void EmitAsync_TypingEvent(string recipientId, string accessToken)
        {
            try
            {
                if (!Client.Connected)
                    await Client?.ConnectAsync();

                Console.WriteLine("Socket.Id:" + Client?.Id);

                Dictionary<string, string> value = new Dictionary<string, string>
                {
                    {"recipient_id", recipientId}, {"user_id", accessToken}
                };

                await Client?.EmitAsync("typing", response =>
                {
                    try
                    {
                        var result = response.GetValue();
                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                }, value);
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //set Stop text
        public async void EmitAsync_StoppedEvent(string recipientId, string accessToken)
        {
            try
            {
                if (!Client.Connected)
                    await Client?.ConnectAsync();

                Dictionary<string, string> value = new Dictionary<string, string>
                {
                    {"recipient_id", recipientId}, {"user_id", accessToken}
                };

                await Client?.EmitAsync("typing_done", response =>
                {
                    try
                    {
                        var result = response.GetValue();
                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                }, value);
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //set seen messages
        public async void EmitAsync_SendSeenMessages(string recipientId, string accessToken, string fromUserId)
        {
            try
            {
                if (!Client.Connected)
                    await Client?.ConnectAsync();

                Dictionary<string, string> value = new Dictionary<string, string>
                {
                    {"recipient_id", recipientId}, {"user_id", accessToken}, {"current_user_id", fromUserId}
                };

                await Client?.EmitAsync("seen_messages", response =>
                {
                    try
                    {
                        var result = response.GetValue();
                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                }, value);
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //Send Page Message text
        public async void EmitAsync_SendPageMessage(string toId, string accessToken, string username, string msg, string color, bool isSticker, string messageHashId)
        {
            try
            {
                if (!Client.Connected)
                    await Client?.ConnectAsync();

                Dictionary<string, string> value = new Dictionary<string, string>
                {
                    {"to_id", toId},
                    {"from_id", accessToken},
                    {"username", username},
                    {"msg", msg},
                    {"color", color},
                    {"isSticker", "false"}
                };

                await Client?.EmitAsync("page_message", response =>
                {
                    try
                    {
                        var json = response.GetValue();
                        var result = response.GetValue<PrivateMessageObject>();
                        if (result != null)
                        {
                            var chatWindowActivity = PageChatWindowActivity.GetInstance();
                            chatWindowActivity?.RunOnUiThread(async () =>
                            {
                                try
                                {
                                    AdapterModelsClassMessage checker = chatWindowActivity?.MAdapter?.DifferList?.FirstOrDefault(a => a.MesData.Id == messageHashId);
                                    if (checker != null)
                                    {
                                        //Wael Update data mesasage and get type
                                        checker.Id = Long.ParseLong(result.MessageId);
                                        checker.MesData.Id = result.MessageId;
                                        checker.MesData.Seen = "0";

                                        //SqLiteDatabase dbDatabase = new SqLiteDatabase();
                                        //dbDatabase.Insert_Or_Update_To_one_MessagesTable(checker.MesData);

                                        //chatWindowActivity?.Update_One_Messages(checker.MesData);

                                        if (UserDetails.SoundControl)
                                            Methods.AudioRecorderAndPlayer.PlayAudioFromAsset("Popup_SendMesseges.mp3");

                                        await Task.Delay(1500);

                                        //if (Methods.CheckConnectivity())
                                        //    PollyController.RunRetryPolicyFunction(new List<Func<Task>> {() => chatWindowActivity.GetMessagesById(result.MessageId) });
                                    }

                                    if (Methods.CheckConnectivity())
                                        PollyController.RunRetryPolicyFunction(new List<Func<Task>> { PostUpdaterHelper.LoadChatAsync });
                                }
                                catch (InvalidSocketStateException e)
                                {
                                    Methods.DisplayReportResultTrack(e);
                                }
                                catch (Exception e)
                                {
                                    Methods.DisplayReportResultTrack(e);
                                }
                            });
                        }
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                }, value);
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //Get New PageMessage 
        public static void Socket_On_Private_PageMessage(SocketIO client)
        {
            try
            {
                client?.On("page_message", response =>
                {
                    try
                    {
                        var json = response.GetValue();

                        var result = response.GetValue<PrivateMessageObject>();
                        if (result != null)
                        {
                            if (Methods.CheckConnectivity())
                                PollyController.RunRetryPolicyFunction(new List<Func<Task>> { PostUpdaterHelper.LoadChatAsync });

                            var chatWindowActivity = PageChatWindowActivity.GetInstance();
                            if (chatWindowActivity != null)
                            {
                                if (chatWindowActivity.UserId == result.Sender)
                                {
                                    chatWindowActivity.TaskWork = "Working";
                                    chatWindowActivity.RunOnUiThread(chatWindowActivity.MessageUpdater);

                                    //Wael add data Messages and get type 
                                    UserDetails.Socket?.EmitAsync_SendSeenMessages(result.Sender, UserDetails.AccessToken, UserDetails.UserId);
                                }
                                else if (UserDetails.UserId == result.Sender)
                                {
                                    chatWindowActivity.TaskWork = "Working";
                                    chatWindowActivity.RunOnUiThread(chatWindowActivity.MessageUpdater);
                                }
                            }
                            else
                            {
                                ListUtils.MessageUnreadList ??= new ObservableCollection<PrivateMessageObject>();

                                if (AppSettings.LastChatSystem == SystemGetLastChat.Default)
                                {
                                    var updaterUser = GlobalContext?.LastChatTab?.MAdapter?.LastChatsList?.FirstOrDefault(a => a.LastChat?.UserId == result.Sender && a.LastChat?.ChatType == "page");
                                    if (updaterUser != null)
                                    {
                                        if (result.IsMedia != null && result.IsMedia.Value)
                                        {
                                            var data = ListUtils.MessageUnreadList.FirstOrDefault(a => a.Sender == result.Sender && a.Message == Methods.FunString.DecodeString(result.Message));
                                            if (data == null)
                                            {
                                                ListUtils.MessageUnreadList.Add(new PrivateMessageObject
                                                {
                                                    Sender = result.Sender,
                                                    Message = GlobalContext.GetText(Resource.String.Lbl_SendMessage)
                                                });
                                            }

                                            AppNotificationsManager.Instance?.ShowUserNotification(Application.Context, result.MessageId, Methods.FunString.DecodeString(updaterUser.LastChat.Name), GlobalContext.GetText(Resource.String.Lbl_SendMessage), result.Sender, result.Sender, updaterUser.LastChat.Avatar, AppSettings.MainColor, Convert.ToInt32(updaterUser.LastChat.MessageCount));
                                        }
                                        else
                                        {
                                            var data = ListUtils.MessageUnreadList.FirstOrDefault(a => a.Sender == result.Sender && a.Message == Methods.FunString.DecodeString(result.Message));
                                            if (data == null)
                                            {
                                                ListUtils.MessageUnreadList.Add(new PrivateMessageObject
                                                {
                                                    Sender = result.Sender,
                                                    Message = Methods.FunString.DecodeString(result.Message)
                                                });
                                            }

                                            AppNotificationsManager.Instance?.ShowUserNotification(Application.Context, result.MessageId, Methods.FunString.DecodeString(updaterUser.LastChat.Name), Methods.FunString.DecodeString(result.Message), result.Sender, result.Sender, updaterUser.LastChat.Avatar, AppSettings.MainColor, Convert.ToInt32(updaterUser.LastChat.MessageCount));
                                        }
                                    }
                                    else if (UserDetails.UserId != result.Sender)
                                        AppNotificationsManager.Instance?.ShowUserNotification(Application.Context, result.MessageId, "", result.Message, result.Sender, result.Sender, "", AppSettings.MainColor);
                                }
                                else
                                {
                                    //wael check id
                                    var updaterUser = GlobalContext?.LastPageChatsTab?.MAdapter?.LastChatsList.FirstOrDefault(a => a.LastChatPage?.PageId == result.Sender && a.LastChatPage?.LastMessage?.ToData?.UserId == result.Sender);
                                    if (updaterUser != null)
                                    {
                                        if (result.IsMedia != null && result.IsMedia.Value)
                                        {
                                            var data = ListUtils.MessageUnreadList.FirstOrDefault(a => a.Sender == result.Sender && a.Message == Methods.FunString.DecodeString(result.Message));
                                            if (data == null)
                                            {
                                                ListUtils.MessageUnreadList.Add(new PrivateMessageObject
                                                {
                                                    Sender = result.Sender,
                                                    Message = GlobalContext.GetText(Resource.String.Lbl_SendMessage)
                                                });
                                            }

                                            AppNotificationsManager.Instance?.ShowUserNotification(Application.Context, result.MessageId, Methods.FunString.DecodeString(updaterUser.LastChat.Name), GlobalContext.GetText(Resource.String.Lbl_SendMessage), result.Sender, result.Sender, updaterUser.LastChat.Avatar, AppSettings.MainColor, Convert.ToInt32(updaterUser.LastChat.MessageCount));
                                        }
                                        else
                                        {
                                            var data = ListUtils.MessageUnreadList.FirstOrDefault(a => a.Sender == result.Sender && a.Message == Methods.FunString.DecodeString(result.Message));
                                            if (data == null)
                                            {
                                                ListUtils.MessageUnreadList.Add(new PrivateMessageObject
                                                {
                                                    Sender = result.Sender,
                                                    Message = Methods.FunString.DecodeString(result.Message)
                                                });
                                            }

                                            AppNotificationsManager.Instance?.ShowUserNotification(Application.Context, result.MessageId, Methods.FunString.DecodeString(updaterUser.LastChat.Name), Methods.FunString.DecodeString(result.Message), result.Sender, result.Sender, updaterUser.LastChat.Avatar, AppSettings.MainColor, Convert.ToInt32(updaterUser.LastChat.MessageCount));
                                        }
                                    }
                                    else if (UserDetails.UserId != result.Sender)
                                        AppNotificationsManager.Instance?.ShowUserNotification(Application.Context, result.MessageId, "", result.Message, result.Sender, result.Sender, "", AppSettings.MainColor);
                                }
                            }
                        }
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //Send Message text
        public async void EmitAsync_SendMessage(string toId, string accessToken, string username, string msg, string color, bool isSticker, string messageHashId)
        {
            try
            {
                if (!Client.Connected)
                    await Client?.ConnectAsync();

                Dictionary<string, string> value = new Dictionary<string, string>
                {
                    {"to_id", toId},
                    {"from_id", accessToken},
                    {"username", username},
                    {"msg", msg},
                    {"color", color},
                    {"isSticker", "false"}
                };

                await Client?.EmitAsync("private_message", response =>
                {
                    try
                    {
                        //var json = response.GetValue();
                        var result = response.GetValue<PrivateMessageObject>();
                        if (result != null)
                        {
                            var chatWindowActivity = ChatWindowActivity.GetInstance();
                            chatWindowActivity?.RunOnUiThread(async () =>
                            {
                                try
                                {
                                    AdapterModelsClassMessage checker = chatWindowActivity?.MAdapter?.DifferList?.FirstOrDefault(a => a.MesData.Id == messageHashId);
                                    if (checker != null)
                                    {
                                        //Wael Update data mesasage and get type
                                        checker.Id = Long.ParseLong(result.MessageId);
                                        checker.MesData.Id = result.MessageId;
                                        checker.MesData.Seen = "0";

                                        SqLiteDatabase dbDatabase = new SqLiteDatabase();
                                        dbDatabase.Insert_Or_Update_To_one_MessagesTable(checker.MesData);

                                        chatWindowActivity?.Update_One_Messages(checker.MesData);

                                        if (UserDetails.SoundControl)
                                            Methods.AudioRecorderAndPlayer.PlayAudioFromAsset("Popup_SendMesseges.mp3");

                                        await Task.Delay(1500);

                                        if (Methods.CheckConnectivity())
                                            PollyController.RunRetryPolicyFunction(new List<Func<Task>> { () => chatWindowActivity.GetMessagesById(result.MessageId) });
                                    }

                                    if (Methods.CheckConnectivity())
                                        PollyController.RunRetryPolicyFunction(new List<Func<Task>> { PostUpdaterHelper.LoadChatAsync });
                                }
                                catch (InvalidSocketStateException e)
                                {
                                    Methods.DisplayReportResultTrack(e);
                                }
                                catch (Exception e)
                                {
                                    Methods.DisplayReportResultTrack(e);
                                }
                            });
                        }
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                }, value);
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //Get New Message 
        public static void Socket_On_Private_Message(SocketIO client)
        {
            try
            {
                client?.On("private_message", response =>
                {
                    try
                    {
                        var result = response.GetValue<PrivateMessageObject>();
                        if (result != null)
                        {
                            if (Methods.CheckConnectivity())
                                PollyController.RunRetryPolicyFunction(new List<Func<Task>> { PostUpdaterHelper.LoadChatAsync });

                            var chatWindowActivity = ChatWindowActivity.GetInstance();
                            if (chatWindowActivity != null)
                            {
                                if (chatWindowActivity.UserId == result.Sender)
                                {
                                    chatWindowActivity.TaskWork = "Working";
                                    chatWindowActivity.RunOnUiThread(chatWindowActivity.MessageUpdater);

                                    //Wael add data Messages and get type 
                                    UserDetails.Socket?.EmitAsync_SendSeenMessages(result.Sender, UserDetails.AccessToken, UserDetails.UserId);
                                }
                                else if (UserDetails.UserId == result.Sender)
                                {
                                    chatWindowActivity.TaskWork = "Working";
                                    chatWindowActivity.RunOnUiThread(chatWindowActivity.MessageUpdater);
                                }
                            }
                            else
                            {
                                ListUtils.MessageUnreadList ??= new ObservableCollection<PrivateMessageObject>();

                                var updaterUser = GlobalContext?.LastChatTab?.MAdapter?.LastChatsList?.FirstOrDefault(a => a.LastChat?.UserId == result.Sender && a.LastChat?.ChatType == "user");
                                if (updaterUser != null)
                                {
                                    if (result.IsMedia != null && result.IsMedia.Value)
                                    {
                                        var data = ListUtils.MessageUnreadList.FirstOrDefault(a => a.Sender == result.Sender && a.Message == Methods.FunString.DecodeString(result.Message));
                                        if (data == null)
                                        {
                                            ListUtils.MessageUnreadList.Add(new PrivateMessageObject
                                            {
                                                Sender = result.Sender,
                                                Message = GlobalContext.GetText(Resource.String.Lbl_SendMessage)
                                            });
                                        }

                                        AppNotificationsManager.Instance?.ShowUserNotification(Application.Context, result.MessageId, Methods.FunString.DecodeString(updaterUser.LastChat.Name), GlobalContext.GetText(Resource.String.Lbl_SendMessage), result.Sender, result.Sender, updaterUser.LastChat.Avatar, AppSettings.MainColor, Convert.ToInt32(updaterUser.LastChat.MessageCount));
                                    }
                                    else
                                    {
                                        var data = ListUtils.MessageUnreadList.FirstOrDefault(a => a.Sender == result.Sender && a.Message == Methods.FunString.DecodeString(result.Message));
                                        if (data == null)
                                        {
                                            ListUtils.MessageUnreadList.Add(new PrivateMessageObject
                                            {
                                                Sender = result.Sender,
                                                Message = Methods.FunString.DecodeString(result.Message)
                                            });
                                        }

                                        AppNotificationsManager.Instance?.ShowUserNotification(Application.Context, result.MessageId, Methods.FunString.DecodeString(updaterUser.LastChat.Name), Methods.FunString.DecodeString(result.Message), result.Sender, result.Sender, updaterUser.LastChat.Avatar, AppSettings.MainColor, Convert.ToInt32(updaterUser.LastChat.MessageCount));
                                    }
                                }
                                else if (UserDetails.UserId != result.Sender)
                                    AppNotificationsManager.Instance?.ShowUserNotification(Application.Context, result.MessageId, "", result.Message, result.Sender, result.Sender, "", AppSettings.MainColor);
                            }
                        }
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //Get New Message 
        //public static void Socket_On_Private_Message_page(SocketIO client)
        //{
        //    try
        //    {
        //        client?.On("private_message_page", response =>
        //        {
        //            try
        //            {
        //                var json = response.GetValue();

        //                var result = response.GetValue<PrivateMessageObject>();
        //                if (result != null)
        //                {

        //                }
        //            }
        //            catch (Exception exception)
        //            {
        //                Methods.DisplayReportResultTrack(exception);
        //            }
        //        });
        //    }
        //    catch (Exception ex)
        //    {
        //        Methods.DisplayReportResultTrack(ex);
        //    }
        //}

        //public static void Socket_On_Alert(SocketIO client)
        //{
        //    try
        //    { 
        //        client?.On("alert", response =>
        //        {
        //            try
        //            {
        //                var result = response.GetValue(); 
        //                Console.WriteLine(result);
        //            }
        //            catch (InvalidSocketStateException e)
        //            {
        //                Methods.DisplayReportResultTrack(e);
        //            }
        //            catch (Exception exception)
        //            {
        //                Methods.DisplayReportResultTrack(exception);
        //            }
        //        });
        //    }
        //    catch (InvalidSocketStateException e)
        //    {
        //        Methods.DisplayReportResultTrack(e);
        //    }
        //    catch (Exception ex)
        //    {
        //        Methods.DisplayReportResultTrack(ex);
        //    }
        //}

        public static void Socket_On_message_reaction(SocketIO client)
        {
            try
            {
                client?.On("register_reaction", response =>
                {
                    try
                    {
                        var result = response.GetValue();
                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        public static void Socket_On_message_reply(SocketIO client)
        {
            try
            {
                client?.On("message_reply_id", response =>
                {
                    try
                    {
                        var result = response.GetValue();
                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        public static void Socket_On_Seen_Messages(SocketIO client)
        {
            try
            {
                client?.On("seen_messages", response =>
                {
                    try
                    {
                        var result = response.GetValue();
                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });

                client?.On("lastseen", response =>
                {
                    try
                    {
                        var result = response.GetValue();
                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //Get new user in last user messages 
        public static void Socket_On_User_Status_Change(SocketIO client)
        {
            try
            {
                client?.On("user_status_change", response =>
                {
                    try
                    {
                        var result = response.GetValue();

                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //Check who is recording now
        public void Socket_On_RecordingEvent(SocketIO client)
        {
            try
            {
                client?.On("recording", response =>
                {
                    try
                    {
                        var json = response.GetValue();

                        var result = response.GetValue<ChatTypingObject>();
                        Console.WriteLine(result);
                        if (result != null)
                        {
                            var data = GlobalContext?.LastChatTab?.MAdapter?.LastChatsList?.FirstOrDefault(a => a.LastChat?.UserId == result.SenderId);
                            if (data != null)
                            {
                                Console.WriteLine(data);
                            }

                            var chatWindowActivity = ChatWindowActivity.GetInstance();
                            chatWindowActivity?.RunOnUiThread(() =>
                            {
                                try
                                {
                                    var typing = result.IsTyping;
                                    chatWindowActivity.ActionBarSubTitle.Text = typing == "200" ? chatWindowActivity.GetString(Resource.String.Lbl_Typping) : chatWindowActivity.LastSeen ?? chatWindowActivity.LastSeen;
                                }
                                catch (InvalidSocketStateException e)
                                {
                                    Methods.DisplayReportResultTrack(e);
                                }
                                catch (Exception e)
                                {
                                    Methods.DisplayReportResultTrack(e);
                                }
                            });
                        }
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //Check who is Typing now
        public void Socket_On_TypingEvent(SocketIO client)
        {
            try
            {
                client?.On("typing", response =>
                {
                    try
                    {
                        var result = response.GetValue<ChatTypingObject>();
                        Console.WriteLine(result);
                        if (result != null)
                        {
                            var data = GlobalContext?.LastChatTab?.MAdapter?.LastChatsList?.FirstOrDefault(a => a.LastChat?.UserId == result.SenderId);
                            if (data != null)
                            {
                                Console.WriteLine(data);
                            }

                            var chatWindowActivity = ChatWindowActivity.GetInstance();
                            chatWindowActivity?.RunOnUiThread(() =>
                            {
                                try
                                {
                                    var typing = result.IsTyping;
                                    chatWindowActivity.ActionBarSubTitle.Text = typing == "200" ? chatWindowActivity.GetString(Resource.String.Lbl_Typping) : chatWindowActivity.LastSeen ?? chatWindowActivity.LastSeen;
                                }
                                catch (InvalidSocketStateException e)
                                {
                                    Methods.DisplayReportResultTrack(e);
                                }
                                catch (Exception e)
                                {
                                    Methods.DisplayReportResultTrack(e);
                                }
                            });
                        }
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //Check who is finish Typing
        public void Socket_On_StopTypingEvent(SocketIO client)
        {
            try
            {
                client?.On("typing_done", response =>
                {
                    try
                    {
                        if (response != null)
                        {
                            var result = response.GetValue<ChatTypingObject>();
                            if (result != null)
                            {
                                var data = GlobalContext?.LastChatTab?.MAdapter?.LastChatsList?.FirstOrDefault(a => a.LastChat?.UserId == result.SenderId);
                                if (data != null)
                                {
                                    Console.WriteLine(data);
                                }

                                var chatWindowActivity = ChatWindowActivity.GetInstance();
                                chatWindowActivity?.RunOnUiThread(() =>
                                {
                                    try
                                    {
                                        chatWindowActivity.ActionBarSubTitle.Text = chatWindowActivity.LastSeen;
                                    }
                                    catch (InvalidSocketStateException e)
                                    {
                                        Methods.DisplayReportResultTrack(e);
                                    }
                                    catch (Exception e)
                                    {
                                        Methods.DisplayReportResultTrack(e);
                                    }
                                });
                            }
                        }
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //Check new video call 
        public void Socket_On_new_video_call(SocketIO client)
        {
            try
            {
                client?.On("new_video_call", response =>
                {
                    try
                    {
                        var result = response.GetValue<NewVideoCallObject>();
                        if (result != null)
                        {
                            if (Methods.CheckConnectivity())
                                PollyController.RunRetryPolicyFunction(new List<Func<Task>> { PostUpdaterHelper.LoadChatAsync });
                        }
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //Check new video call 
        public async void EmitAsync_Create_callEvent(string recipientId)
        {
            try
            {
                if (!Client.Connected)
                    await Client?.ConnectAsync();

                //{to_id: toUSERID, type: 'create_video'}
                Dictionary<string, string> value = new Dictionary<string, string>
                {
                    {"to_id", recipientId}, {"type", "create_video"}
                };

                await Client?.EmitAsync("user_notification", response =>
                {
                    try
                    {
                        var result = response.GetValue();
                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                }, value);
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //online
        public async void Emit_loggedintEvent(string accessToken)
        {
            try
            {
                if (!Client.Connected)
                    await Client?.ConnectAsync();

                Dictionary<string, string> value = new Dictionary<string, string> { { "from_id", accessToken } };

                await Client?.EmitAsync("on_user_loggedin", response =>
                {
                    try
                    {
                        var result = response.GetValue();

                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                }, value);
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //offline
        public async void Emit_loggedoutEvent(string accessToken)
        {
            try
            {
                if (!Client.Connected)
                    await Client?.ConnectAsync();

                Dictionary<string, string> value = new Dictionary<string, string> { { "from_id", accessToken } };

                await Client?.EmitAsync("on_user_loggedoff", response =>
                {
                    try
                    {
                        var result = response.GetValue();

                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                }, value);
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //online
        public void Socket_On_loggedintEvent(SocketIO client)
        {
            try
            {
                client?.On("on_user_loggedin", response =>
                {
                    try
                    {
                        var result = response.GetValue();

                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        //offline
        public void Socket_On_loggedoutEvent(SocketIO client)
        {
            try
            {
                client?.On("on_user_loggedoff", response =>
                {
                    try
                    {
                        var result = response.GetValue();

                        Console.WriteLine(result);
                    }
                    catch (InvalidSocketStateException e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                });
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        private static Timer Timer;

        //UPDATE USER LAST SEEN
        public async void Socket_ping_for_lastseen(string accessToken)
        {
            try
            {
                if (!Client.Connected)
                    await Client?.ConnectAsync();

                Console.WriteLine("Socket.Id:" + Client?.Id);

                if (Timer != null)
                    return;

                Timer = new Timer { Interval = 2000 };
                Timer.Elapsed += (o, eventArgs) =>
                {
                    try
                    {
                        Dictionary<string, string> valueDictionary = new Dictionary<string, string>
                        {
                            {"user_id", accessToken}
                        };

                        Client?.EmitAsync("ping_for_lastseen", valueDictionary);
                    }
                    catch (Exception exception)
                    {
                        Methods.DisplayReportResultTrack(exception);
                    }
                };
                Timer.Enabled = true;
                Timer.Start();
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception ex)
            {
                Methods.DisplayReportResultTrack(ex);
            }
        }

        public void DisconnectSocket()
        {
            try
            {
                if (Client != null)
                {
                    Client?.Off("join");
                    Client?.Off("private_message");
                    //Client?.Off("alert");
                    Client?.Off("seen_messages");
                    Client?.Off("lastseen");
                    Client?.Off("user_status_change");
                    Client?.Off("recording");
                    Client?.Off("typing");
                    Client?.Off("typing_done");
                    Client?.Off("new_video_call");
                    Client?.Off("user_notification");
                    Client?.Off("on_user_loggedin");
                    Client?.Off("on_user_loggedoff");
                    Client?.Off("ping_for_lastseen");
                    //Client?.Off("message_reply_id");
                    //Client?.Off("register_reaction");

                    Client?.DisconnectAsync();
                    Client = null;
                }

                if (Timer != null)
                {
                    Timer.Stop();
                    Timer = null;
                }

                IsJoined = false;
            }
            catch (InvalidSocketStateException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public void ReconnectSocket()
        {
            try
            {
                if (MTries < 5)
                {
                    MTries++;

                    DisconnectSocket();

                    //Connect to socket with access token
                    UserDetails.Socket?.Emit_Join(UserDetails.Username, UserDetails.AccessToken);
                }
                else
                {
                    ToastUtils.ShowToast(Application.Context, Application.Context.GetText(Resource.String.Error_connectServer), ToastLength.Short);
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
    }
}