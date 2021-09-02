using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Threading.Tasks;
using Aghajari.EmojiView.Views;
using Android.App;
using Android.Content;
using Android.Content.PM;
using Android.Content.Res;
using Android.Gms.Ads;
using Android.Graphics;
using Android.OS; 
using Android.Views;
using Android.Widget;
using AndroidX.RecyclerView.Widget;
using Com.Google.Android.Youtube.Player;
using Com.Luseen.Autolinklibrary;
using Newtonsoft.Json;
using WoWonder.Activities.Movies.Adapters;
using WoWonder.Activities.Tabbes;
using WoWonder.Helpers.Ads;
using WoWonder.Helpers.CacheLoaders;
using WoWonder.Helpers.Controller;
using WoWonder.Helpers.Model;
using WoWonder.Helpers.Utils;
using WoWonder.Library.Anjo.EmojiView;
using WoWonder.Library.Anjo.IntegrationRecyclerView;
using WoWonder.SQLite;
using WoWonderClient.Classes.Movies;
using WoWonderClient.Requests;
using VideoController = WoWonder.Helpers.Controller.VideoController;

namespace WoWonder.Activities.Videos
{
    [Activity(Icon = "@mipmap/icon", Theme = "@style/MyTheme", ConfigurationChanges = ConfigChanges.Keyboard | ConfigChanges.Orientation | ConfigChanges.KeyboardHidden | ConfigChanges.ScreenLayout | ConfigChanges.ScreenSize | ConfigChanges.SmallestScreenSize | ConfigChanges.UiMode, ResizeableActivity = true)]
    public class VideoViewerActivity : YouTubeBaseActivity, IYouTubePlayerOnInitializedListener
    {
        #region Variables Basic

        private VideoController VideoActionsController;
        private GetMoviesObject.Movie Video; 
        private IYouTubePlayer YoutubePlayer { get; set; }
        private string VideoIdYoutube;
        private static VideoViewerActivity Instance; 
        private string MoviesId; 
        

        //About 
        private AdView MAdView;
        private TextView TxtVideoName, TxtName, TxtViewCount, TxtCreateTime, TxtCategory, TxtTags, VideoStars;
        private AutoLinkTextView VideoVideoDescription;
        private TextSanitizer TextSanitizerAutoLink;

        //Comment
        public MoviesCommentAdapter MAdapter;
        private LinearLayoutManager LayoutManager;
        private RecyclerViewOnScrollListener MainScrollEvent;
        private RecyclerView MRecycler;
        private AXEmojiEditText TxtComment;
        private ImageView EmojisView,ImgSent, ImgAvatar; 

        #endregion

        #region General

        protected override void OnCreate(Bundle savedInstanceState)
        {
            try
            {
                base.OnCreate(savedInstanceState);
                Window?.SetSoftInputMode(SoftInput.AdjustResize);

                SetTheme(AppSettings.SetTabDarkTheme ? Resource.Style.MyTheme_Dark_Base : Resource.Style.MyTheme_Base);
                Methods.App.FullScreenApp(this);

                SetContentView(Resource.Layout.Video_Viewer_Layout);

                Instance = this;

                MoviesId = Intent?.GetStringExtra("VideoId") ?? "";

                VideoActionsController = new VideoController(this, "Viewer_Video");
                InitComponent();
                SetRecyclerViewAdapters();

                GetDataVideo();
                //SetPlayer();

                AdsGoogle.Ad_RewardedVideo(this);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        protected override void OnPause()
        {
            try
            {
                AddOrRemoveEvent(false);
                MAdView?.Pause();
                
                base.OnPause();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        protected override void OnResume()
        {
            try
            {
                base.OnResume();
                AddOrRemoveEvent(true);
                MAdView?.Resume();
                
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public override void OnTrimMemory(TrimMemory level)
        {
            try
            {
                GC.Collect(GC.MaxGeneration, GCCollectionMode.Forced);
                base.OnTrimMemory(level);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public override void OnLowMemory()
        {
            try
            {
                GC.Collect(GC.MaxGeneration);
                base.OnLowMemory();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        protected override void OnDestroy()
        {
            try
            {
                VideoActionsController.ReleaseVideo();

                YoutubePlayer?.Release();

                TabbedMainActivity.GetInstance()?.SetOffWakeLock();

                MAdView?.Destroy();

                DestroyBasic();
                base.OnDestroy();
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        public override void OnConfigurationChanged(Configuration newConfig)
        {
            try
            {
                base.OnConfigurationChanged(newConfig);

                var currentNightMode = newConfig.UiMode & UiMode.NightMask;
                AppSettings.SetTabDarkTheme = currentNightMode switch
                {
                    UiMode.NightNo =>
                        // Night mode is not active, we're using the light theme
                        false,
                    UiMode.NightYes =>
                        // Night mode is active, we're using dark theme
                        true,
                    _ => AppSettings.SetTabDarkTheme
                };

                SetTheme(AppSettings.SetTabDarkTheme ? Resource.Style.MyTheme_Dark_Base : Resource.Style.MyTheme_Base);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
         
        #endregion

        #region Menu

        public override bool OnOptionsItemSelected(IMenuItem item)
        {
            switch (item.ItemId)
            {
                case Android.Resource.Id.Home:
                    Finish();
                    return true;
            }
            return base.OnOptionsItemSelected(item);
        }

        #endregion

        #region Functions

        public void InitComponent()
        {
            try
            {
                TxtVideoName = FindViewById<TextView>(Resource.Id.Title);
                TxtName = FindViewById<TextView>(Resource.Id.tv_subname);
                
                TxtViewCount = FindViewById<TextView>(Resource.Id.Views_Count);
                TxtCreateTime = FindViewById<TextView>(Resource.Id.tv_time);
                VideoVideoDescription = FindViewById<AutoLinkTextView>(Resource.Id.videoDescriptionTextview);
                TxtCategory = FindViewById<TextView>(Resource.Id.videoCategorytextview);

                VideoStars = FindViewById<TextView>(Resource.Id.videoStartextview);
                TxtTags = FindViewById<TextView>(Resource.Id.videoTagtextview);

                TextSanitizerAutoLink = new TextSanitizer(VideoVideoDescription, this);

                MAdView = FindViewById<AdView>(Resource.Id.adView);
                AdsGoogle.InitAdView(MAdView, null);
                 
                MRecycler = FindViewById<RecyclerView>(Resource.Id.recyler);
                TxtComment = FindViewById<AXEmojiEditText>(Resource.Id.commenttext);
                EmojisView = FindViewById<ImageView>(Resource.Id.Emojiicon);
                ImgSent = FindViewById<ImageView>(Resource.Id.send);

                ImgAvatar = FindViewById<ImageView>(Resource.Id.avatar);
                
                Methods.SetColorEditText(TxtComment, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);

                if (AppSettings.SetTabDarkTheme)
                    EmojisViewTools.LoadDarkTheme();
                else
                    EmojisViewTools.LoadTheme(AppSettings.MainColor);

                EmojisViewTools.MStickerView = true;
                AXEmojiPager emojiPager = EmojisViewTools.LoadView(this, TxtComment, "");
                AXEmojiPopup popup = new AXEmojiPopup(emojiPager);
                var EmojisViewActions = new EmojisViewActions(this, "", popup, TxtComment, EmojisView);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public void SetRecyclerViewAdapters()
        {
            try
            {
                MAdapter = new MoviesCommentAdapter(this, "Comment")
                {
                    CommentList = new ObservableCollection<CommentsMoviesObject>()
                };

                LayoutManager = new LinearLayoutManager(this);
                MRecycler.SetLayoutManager(LayoutManager);
                MRecycler.HasFixedSize = true;
                MRecycler.SetItemViewCacheSize(10);
                MRecycler.GetLayoutManager().ItemPrefetchEnabled = true;
                var sizeProvider = new Bumptech.Glide.Util.FixedPreloadSizeProvider(10, 10);
                var preLoader = new RecyclerViewPreloader<CommentsMoviesObject>(this, MAdapter, sizeProvider, 10);
                MRecycler.AddOnScrollListener(preLoader);
                MRecycler.SetAdapter(MAdapter);

                RecyclerViewOnScrollListener xamarinRecyclerViewOnScrollListener = new RecyclerViewOnScrollListener(LayoutManager);
                MainScrollEvent = xamarinRecyclerViewOnScrollListener;
                MainScrollEvent.LoadMoreEvent += MainScrollEventOnLoadMoreEvent;
                MRecycler.AddOnScrollListener(xamarinRecyclerViewOnScrollListener);
                MainScrollEvent.IsLoading = false;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }


        public void AddOrRemoveEvent(bool addEvent)
        {
            try
            {
                switch (addEvent)
                {
                    // true +=  // false -=
                    case true:
                        ImgSent.Click += ImgSentOnClick; 
                        break;
                    default:
                        ImgSent.Click -= ImgSentOnClick;
                        break;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
         
        public static VideoViewerActivity GetInstance()
        {
            try
            {
                return Instance;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                return null!;
            }
        }


        private void DestroyBasic()
        {
            try
            {
                
                
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
        
        #endregion
         
        #region Back Pressed

        public override void OnBackPressed()
        {
            try
            {
                VideoActionsController.SetStopVideo();
                base.OnBackPressed();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        #endregion

        #region Result

        //Result
        protected override void OnActivityResult(int requestCode, Result resultCode, Intent data)
        {
            try
            {
                base.OnActivityResult(requestCode, resultCode, data);
                switch (requestCode)
                {
                    case 2000:
                    {
                        switch (resultCode)
                        {
                            case Result.Ok:
                                VideoActionsController.RestartPlayAfterShrinkScreen();
                                break;
                        }

                        break;
                    }
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        #endregion

        #region YouTube Player

        public void OnInitializationFailure(IYouTubePlayerProvider p0, YouTubeInitializationResult p1)
        {
            try
            {
                switch (p1.IsUserRecoverableError)
                {
                    case true:
                        p1.GetErrorDialog(this, 1).Show();
                        break;
                    default:
                        ToastUtils.ShowToast(this, p1.ToString(), ToastLength.Short);
                        break;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public void OnInitializationSuccess(IYouTubePlayerProvider p0, IYouTubePlayer player, bool wasRestored)
        {
            try
            {
                YoutubePlayer = YoutubePlayer switch
                {
                    null => player,
                    _ => YoutubePlayer
                };

                switch (wasRestored)
                {
                    case false:
                        YoutubePlayer.LoadVideo(VideoIdYoutube);
                        //YoutubePlayer.AddFullscreenControlFlag(YouTubePlayer.FullscreenFlagControlOrientation  | YouTubePlayer.FullscreenFlagControlSystemUi  | YouTubePlayer.FullscreenFlagCustomLayout); 
                        break;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        #endregion

        #region Event
          
        //Api sent Comment
        private async void ImgSentOnClick(object sender, EventArgs e)
        {
            try
            {
                if (string.IsNullOrEmpty(TxtComment.Text))
                    return;

                if (Methods.CheckConnectivity())
                {
                    var dataUser = ListUtils.MyProfileList?.FirstOrDefault();
                    //Comment Code 

                    var unixTimestamp = DateTimeOffset.UtcNow.ToUnixTimeSeconds();
                    var time = unixTimestamp.ToString();

                    CommentsMoviesObject comment = new CommentsMoviesObject
                    {
                        Id = unixTimestamp.ToString(),
                        MovieId = MoviesId,
                        UserId = UserDetails.UserId,
                        Text = TxtComment.Text,
                        Likes = "0",
                        Posted = time,
                        UserData = dataUser,
                        IsOwner = true,
                        Dislikes = "0",
                        IsCommentLiked = false,
                        Replies = new List<CommentsMoviesObject>()
                    };

                    MAdapter.CommentList.Add(comment);

                    var index = MAdapter.CommentList.IndexOf(comment);
                    switch (index)
                    {
                        case > -1:
                            MAdapter.NotifyItemInserted(index);
                            break;
                    }

                    MRecycler.Visibility = ViewStates.Visible;

                    var dd = MAdapter.CommentList.FirstOrDefault();
                    if (dd?.Text == MAdapter.EmptyState)
                    {
                        MAdapter.CommentList.Remove(dd);
                        MAdapter.NotifyItemRemoved(MAdapter.CommentList.IndexOf(dd));
                    }

                    var text = TxtComment.Text;

                    //Hide keyboard
                    TxtComment.Text = "";

                    var (apiStatus, respond) = await RequestsAsync.Movies.CreateCommentsAsync(MoviesId, text);
                    switch (apiStatus)
                    {
                        case 200:
                        {
                            switch (respond)
                            {
                                case GetCommentsMoviesObject result:
                                {
                                    var date = MAdapter.CommentList.FirstOrDefault(a => a.Id == comment.Id) ?? MAdapter.CommentList.FirstOrDefault(x => x.Id == result.Data[0]?.Id);
                                    if (date != null)
                                    {
                                        date = result.Data[0];
                                        date.Id = result.Data[0].Id;

                                        index = MAdapter.CommentList.IndexOf(MAdapter.CommentList.FirstOrDefault(a => a.Id == unixTimestamp.ToString()));
                                        switch (index)
                                        {
                                            case > -1:
                                                MAdapter.CommentList[index] = result.Data[0];

                                                //MAdapter.NotifyItemChanged(index);
                                                MRecycler.ScrollToPosition(index);
                                                break;
                                        }
                                    }

                                    break;
                                }
                            }

                            break;
                        }
                        default:
                            Methods.DisplayReportResult(this, respond);
                            break;
                    }

                    //Hide keyboard
                    TxtComment.Text = "";
                }
                else
                {
                    ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        private void MainScrollEventOnLoadMoreEvent(object sender, EventArgs e)
        {
            try
            {
                //Code get last id where LoadMore >>
                var item = MAdapter.CommentList.LastOrDefault();
                if (item != null && !string.IsNullOrEmpty(item.Id) && !MainScrollEvent.IsLoading)
                    StartApiService(item.Id);
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        #endregion
         
        #region Load Video & Comment 
         
        public async void GetDataVideo()
        {
            try
            {
                if (!string.IsNullOrEmpty(Intent?.GetStringExtra("Viewer_Video")))
                {
                    Video = JsonConvert.DeserializeObject<GetMoviesObject.Movie>(Intent?.GetStringExtra("Viewer_Video") ?? "");
                    LoadDataVideo();
                }
                else
                {
                    if (!Methods.CheckConnectivity())
                    {
                        ToastUtils.ShowToast(this, GetString(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                        return;
                    }

                    var (apiStatus, respond) = await RequestsAsync.Movies.GetMoviesAsync("", "", MoviesId);
                    switch (apiStatus)
                    {
                        case 200:
                        {
                            switch (respond)
                            {
                                case GetMoviesObject result:
                                {
                                    var respondList = result.Movies.Count;
                                    switch (respondList)
                                    {
                                        case > 0:
                                            Video = result.Movies.FirstOrDefault(w => w.Id == MoviesId);
                                            LoadDataVideo();
                                            break;
                                    }

                                    break;
                                }
                            }

                            break;
                        }
                        default:
                            Methods.DisplayReportResult(this, respond);
                            break;
                    }
                } 
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private void LoadDataVideo()
        {
            try
            {
                switch (Video)
                {
                    case null:
                        return;
                }

                LoadVideo_Data(Video);
                switch (string.IsNullOrEmpty(Video.Iframe))
                {
                    case false:
                    {
                        if (Video.Iframe.Contains("Youtube") || Video.Iframe.Contains("youtu"))
                        { 
                            VideoIdYoutube = Video.Iframe.Split(new[] { "v=", "/" }, StringSplitOptions.None).LastOrDefault();

                            YouTubePlayerView youTubeView = new YouTubePlayerView(this);

                            var youtubeView = FindViewById<FrameLayout>(Resource.Id.root);
                            youtubeView.RemoveAllViews();
                            youtubeView.AddView(youTubeView);

                            youTubeView.Initialize(GetText(Resource.String.google_key), this);

                            VideoActionsController.SimpleExoPlayerView.Visibility = ViewStates.Gone;
                            VideoActionsController.ReleaseVideo();

                            YoutubePlayer?.LoadVideo(VideoIdYoutube);
                        }

                        break;
                    }
                    default:
                    {
                            //VideoPlayer(Android.Net.Uri.Parse(Video.Url));
                        var dbDatabase = new SqLiteDatabase();
                        var dataVideos = dbDatabase.Get_WatchOfflineVideos_ById(Video.Id);
                        if (dataVideos != null)
                            VideoActionsController.PlayVideo(dataVideos.Source, dataVideos);
                        else
                            VideoActionsController.PlayVideo(Video.Source, Video);
                        break;
                    }
                }

                StartApiService(); 
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public void LoadVideo_Data(GetMoviesObject.Movie videoObject)
        {
            try
            {
                if (videoObject != null)
                {
                    TxtVideoName.Text = Methods.FunString.DecodeString(videoObject.Name);
                    TxtName.Text = AppSettings.ApplicationName;
                    //VideoQualityTextView.Text = videoObject.Quality.ToUpperInvariant();
                    TxtViewCount.Text = videoObject.Views + " " + GetText(Resource.String.Lbl_Views);
                    TxtCreateTime.Text = videoObject.Release;

                    TxtCategory.Text = videoObject.Genre;
                    VideoStars.Text = videoObject.Stars;
                    TxtTags.Text = videoObject.Producer;

                    GlideImageLoader.LoadImage(this, UserDetails.Avatar, ImgAvatar, ImageStyle.CircleCrop, ImagePlaceholders.Drawable);

                    TextSanitizerAutoLink.Load(Methods.FunString.DecodeString(videoObject.Description));
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }
          
        private void StartApiService(string offset = "0")
        {
            if (!Methods.CheckConnectivity())
                ToastUtils.ShowToast(this, GetString(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
            else
                PollyController.RunRetryPolicyFunction(new List<Func<Task>> { () => LoadDataComment(offset) });
        }

        private async Task LoadDataComment(string offset)
        {
            switch (MainScrollEvent.IsLoading)
            {
                case true:
                    return;
            }

            if (Methods.CheckConnectivity())
            {
                MainScrollEvent.IsLoading = true;
                var countList = MAdapter.CommentList.Count;
                var (apiStatus, respond) = await RequestsAsync.Movies.GetCommentsAsync(MoviesId, "25", offset);
                if (apiStatus != 200 || respond is not GetCommentsMoviesObject result || result.Data == null)
                {
                    MainScrollEvent.IsLoading = false;
                    Methods.DisplayReportResult(this, respond);
                }
                else
                {
                    var respondList = result.Data?.Count;
                    switch (respondList)
                    {
                        case > 0 when countList > 0:
                        {
                            foreach (var item in from item in result.Data let check = MAdapter.CommentList.FirstOrDefault(a => a.Id == item.Id) where check == null select item)
                            {
                                MAdapter.CommentList.Add(item);
                            }

                            RunOnUiThread(() => { MAdapter.NotifyItemRangeInserted(countList, MAdapter.CommentList.Count - countList); });
                            break;
                        }
                        case > 0:
                            MAdapter.CommentList = new ObservableCollection<CommentsMoviesObject>(result.Data);
                            RunOnUiThread(() => { MAdapter.NotifyDataSetChanged(); });
                            break;
                    }
                }

                RunOnUiThread(ShowEmptyPage);
            }
        }

        private void ShowEmptyPage()
        {
            try
            {
                MainScrollEvent.IsLoading = false;

                switch (MAdapter.CommentList.Count)
                {
                    case > 0:
                    {
                        var emptyStateChecker = MAdapter.CommentList.FirstOrDefault(a => a.Text == MAdapter.EmptyState);
                        if (emptyStateChecker != null && MAdapter.CommentList.Count > 1)
                        {
                            MAdapter.CommentList.Remove(emptyStateChecker);
                            MAdapter.NotifyDataSetChanged();
                        }

                        break;
                    }
                    default:
                    {
                        MAdapter.CommentList.Clear();
                        var d = new CommentsMoviesObject { Text = MAdapter.EmptyState };
                        MAdapter.CommentList.Add(d);
                        MAdapter.NotifyDataSetChanged();
                        break;
                    }
                }
            }
            catch (Exception e)
            {
                MainScrollEvent.IsLoading = false;
                Methods.DisplayReportResultTrack(e);
            }
        }
         
        #endregion 
    }
}