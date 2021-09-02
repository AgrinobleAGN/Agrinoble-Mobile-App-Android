using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Android.App;
using Android.Content;
using Android.OS;
using Java.Lang;
using Newtonsoft.Json;
using WoWonder.Activities.NativePost.Post;
using WoWonder.Activities.Tabbes;
using WoWonder.Helpers.Controller;
using WoWonder.Helpers.Utils;
using WoWonder.SQLite;
using WoWonderClient;
using WoWonderClient.Classes.Posts;
using WoWonderClient.Requests;
using Exception = Java.Lang.Exception;

namespace WoWonder.Activities.NativePost.Services
{
    [Service(Exported = false)]
    public class PostApiService : Service
    { 
        public override IBinder OnBind(Intent intent)
        {
            return null;
        }
        
        public override void OnCreate()
        {
            try
            {
                base.OnCreate();
                //ToastUtils.ShowToast(Application.Context, "OnCreate", ToastLength.Short);
                new Handler(Looper.MainLooper).PostDelayed(new PostUpdaterHelper(new Handler(Looper.MainLooper)), AppSettings.RefreshPostSeconds);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            } 
        }

        public override StartCommandResult OnStartCommand(Intent intent, StartCommandFlags flags, int startId)
        {
            try
            {
                base.OnStartCommand(intent, flags, startId);

                new Handler(Looper.MainLooper).PostDelayed(new PostUpdaterHelper(new Handler(Looper.MainLooper)), AppSettings.RefreshPostSeconds);

                //ToastUtils.ShowToast(Application.Context, "OnStartCommand", ToastLength.Short);

                return StartCommandResult.Sticky;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                return StartCommandResult.NotSticky;
            } 
        }
    }

    public class PostUpdaterHelper : Java.Lang.Object, IRunnable
    {
        private static Handler MainHandler;

        public PostUpdaterHelper(Handler mainHandler)
        {
            MainHandler = mainHandler;
        }
         
        public void Run()
        {
            try
            { 
                if (string.IsNullOrEmpty(Methods.AppLifecycleObserver.AppState))
                    Methods.AppLifecycleObserver.AppState = "Background";
                 
                //ToastUtils.ShowToast(Application.Context, "AppState " + Methods.AppLifecycleObserver.AppState, ToastLength.Short);

                if (Methods.AppLifecycleObserver.AppState == "Background" && string.IsNullOrEmpty(Current.AccessToken))
                {
                    SqLiteDatabase dbDatabase = new SqLiteDatabase();
                    var login = dbDatabase.Get_data_Login_Credentials();
                    Console.WriteLine(login);
                }

                if (string.IsNullOrEmpty(Current.AccessToken))
                    return;

                if (Methods.CheckConnectivity())
                    PollyController.RunRetryPolicyFunction(new List<Func<Task>> { () =>  FetchFirstNewsFeedApiPosts(false) });

                MainHandler ??= new Handler(Looper.MainLooper);
                MainHandler?.PostDelayed(new PostUpdaterHelper(new Handler(Looper.MainLooper)), AppSettings.RefreshPostSeconds); 
            }
            catch (Exception e)
            {
                //ToastUtils.ShowToast(Application.Context, "ResultSender failed",ToastLength.Short);
                MainHandler ??= new Handler(Looper.MainLooper);
                MainHandler?.PostDelayed(new PostUpdaterHelper(new Handler(Looper.MainLooper)), AppSettings.RefreshPostSeconds);
                Methods.DisplayReportResultTrack(e);
            } 
        }

        private static bool ByOffset;

        public static async Task FetchFirstNewsFeedApiPosts(bool cash)
        {
            try
            {
                if (!Methods.CheckConnectivity())
                    return;

                string offset = "0";
                if (Methods.AppLifecycleObserver.AppState == "Foreground" && ByOffset)
                {
                    ByOffset = false;
                    
                    var item = TabbedMainActivity.GetInstance()?.NewsFeedTab.PostFeedAdapter?.ListDiffer?.LastOrDefault(a => a.TypeView != PostModelType.Divider && a.TypeView != PostModelType.ViewProgress && a.TypeView != PostModelType.AdMob1 && a.TypeView != PostModelType.AdMob2 && a.TypeView != PostModelType.AdMob3 && a.TypeView != PostModelType.FbAdNative && a.TypeView != PostModelType.AdsPost && a.TypeView != PostModelType.SuggestedPagesBox && a.TypeView != PostModelType.SuggestedGroupsBox && a.TypeView != PostModelType.SuggestedUsersBox && a.TypeView != PostModelType.CommentSection && a.TypeView != PostModelType.AddCommentSection);
                    offset = item?.PostData?.PostId ?? "0"; 
                }
                else
                {
                    ByOffset = true;
                }

                var (apiStatus, respond) = await RequestsAsync.Posts.GetGlobalPost(AppSettings.PostApiLimitOnBackground, offset);
                if (apiStatus != 200 || respond is not PostObject result)
                {
                    //Methods.DisplayReportResult(ActivityContext, respond);
                }
                else
                {
                    if (result?.Data?.Count > 0)
                    {
                        if (cash)
                        {
                            result.Data.RemoveAll(a => a.Publisher == null && a.UserData == null);
                            SqLiteDatabase dbDatabase = new SqLiteDatabase();
                            //Insert All data to database
                            dbDatabase.InsertOrUpdatePost(JsonConvert.SerializeObject(result));

                            foreach (var post in from post in result.Data let check = ListUtils.NewPostList.FirstOrDefault(a => a?.PostId == post.PostId) where check == null select post)
                            { 
                                ListUtils.NewPostList.Add(post);
                            } 
                        }
                        else
                        {
                            if (Methods.AppLifecycleObserver.AppState == "Foreground")
                            {
                                TabbedMainActivity.GetInstance()?.NewsFeedTab?.MainRecyclerView?.ApiPostAsync?.LoadDataApi(apiStatus, respond, offset, "Insert");
                            }
                            else
                            {
                                result.Data.RemoveAll(a => a.Publisher == null && a.UserData == null);
                                SqLiteDatabase dbDatabase = new SqLiteDatabase();
                                //Insert All data to database
                                dbDatabase.InsertOrUpdatePost(JsonConvert.SerializeObject(result));
                            }
                        }
                    }
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
    }
}