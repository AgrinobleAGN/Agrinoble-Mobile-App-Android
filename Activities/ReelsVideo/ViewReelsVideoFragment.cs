using System;
using System.Collections.Generic;
using System.Linq;
using Android.Content;
using Android.Graphics;
using Android.OS; 
using Android.Views;
using Android.Widget;
using Com.Google.Android.Exoplayer2;
using Com.Google.Android.Exoplayer2.Drm;
using Com.Google.Android.Exoplayer2.Extractor.TS;
using Com.Google.Android.Exoplayer2.Source;
using Com.Google.Android.Exoplayer2.Source.Dash;
using Com.Google.Android.Exoplayer2.Source.Hls;
using Com.Google.Android.Exoplayer2.Source.Smoothstreaming;
using Com.Google.Android.Exoplayer2.Trackselection;
using Com.Google.Android.Exoplayer2.UI;
using Com.Google.Android.Exoplayer2.Upstream;
using Com.Google.Android.Youtube.Player;
using Newtonsoft.Json;
using WoWonder.Activities.MyProfile;
using WoWonder.Activities.NativePost.Pages;
using WoWonder.Activities.NativePost.Post;
using WoWonder.Activities.Tabbes;
using WoWonder.Activities.UserProfile;
using WoWonder.Helpers.CacheLoaders;
using WoWonder.Helpers.Controller;
using WoWonder.Helpers.Model;
using WoWonder.Helpers.Utils;
using WoWonder.Library.Anjo.SuperTextLibrary;
using WoWonder.SQLite;
using WoWonderClient.Classes.Posts;
using String = Java.Lang.String;
using Uri = Android.Net.Uri;
using Util = Com.Google.Android.Exoplayer2.Util.Util;

namespace WoWonder.Activities.ReelsVideo
{ 
    public class ViewReelsVideoFragment : AndroidX.Fragment.App.Fragment, IYouTubePlayerOnInitializedListener, IPlayerEventListener, StTools.IXAutoLinkOnClickListener
    {
        #region Variables Basic

        private ReelsVideoDetailsActivity GlobalContext;
        private static ViewReelsVideoFragment Instance;

        private StReadMoreOption ReadMoreOption;
        private PostDataObject DataVideos;
        private PostModelType PostFeedType;

        private View MainView;
        private FrameLayout Root;

        private SimpleExoPlayer VideoPlayer;
        private PlayerView PlayerView;
        private IYouTubePlayer YoutubePlayer { get; set; }
        private string VideoIdYoutube;
         
        private LinearLayout UserLayout , LikeLayout, CommentLayout, ShareLayout;
        private ImageView UserImageView , ImgSendGift, ImgLike, ImgComment, ImgShare;
        private TextView TxtUsername , TxtLikeCount, TxtCommentCount, TxtShareCount;

        private SuperTextView TxtDescription;

        private bool MIsVisibleToUser;
         
        #endregion

        #region General

        public override void OnCreate(Bundle savedInstanceState)
        {
            try
            {
                base.OnCreate(savedInstanceState);
                GlobalContext = (ReelsVideoDetailsActivity)Activity;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public override View OnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            try
            {
                MainView = inflater.Inflate(Resource.Layout.MainFragmentLayout, container, false);
                return MainView;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                return null!;
            }
        }

        public override void OnViewCreated(View view, Bundle savedInstanceState)
        {
            try
            { 
                base.OnViewCreated(view, savedInstanceState);
                MainView = view;
                 
                Instance = this;
                InitComponent(view);
                SetPlayer();

                ReadMoreOption = new StReadMoreOption.Builder()
                    .TextLength(200, StReadMoreOption.TypeCharacter)
                    .MoreLabel(Activity.GetText(Resource.String.Lbl_ReadMore))
                    .LessLabel(Activity.GetText(Resource.String.Lbl_ReadLess))
                    .MoreLabelColor(Color.ParseColor(AppSettings.MainColor))
                    .LessLabelColor(Color.ParseColor(AppSettings.MainColor))
                    .LabelUnderLine(true)
                    .Build();
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        public override void SetMenuVisibility(bool menuVisible)
        {
            try
            {
                base.SetMenuVisibility(menuVisible);
                MIsVisibleToUser = menuVisible;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public override void OnResume()
        {
            try
            {
                base.OnResume();
                AddOrRemoveEvent(true);
                  
                if (IsResumed && MIsVisibleToUser)
                {
                    //var position = Arguments.GetInt("position", 0); 
                    DataVideos = JsonConvert.DeserializeObject<PostDataObject>(Arguments.GetString("DataItem") ?? "");
                    if (DataVideos != null)
                    {
                        LoadData(DataVideos);
                    }
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public override void OnPause()
        {
            try
            {
                base.OnPause();
                AddOrRemoveEvent(false);
                StopVideo();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public override void OnStop()
        {
            try
            {
                base.OnStop();

                if (MIsVisibleToUser)
                    StopVideo();
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
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        public override void OnDestroyView()
        {
            try
            {
                ReleaseVideo();
                
                base.OnDestroyView();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public override void OnDestroy()
        {
            try
            {
                ReleaseVideo();

                GC.Collect(GC.MaxGeneration, GCCollectionMode.Forced);
                base.OnDestroy();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
         
        #endregion

        #region Functions

        private void InitComponent(View view)
        {
            try
            {
                Root = view.FindViewById<FrameLayout>(Resource.Id.root);
                PlayerView = view.FindViewById<PlayerView>(Resource.Id.player_view);
                  
                UserLayout = view.FindViewById<LinearLayout>(Resource.Id.userLayout);
                UserImageView = view.FindViewById<ImageView>(Resource.Id.imageAvatar);
                TxtUsername = view.FindViewById<TextView>(Resource.Id.username);
                 
                TxtDescription = view.FindViewById<SuperTextView>(Resource.Id.tv_descreption);

                ImgSendGift = view.FindViewById<ImageView>(Resource.Id.img_sendGift);

                LikeLayout = view.FindViewById<LinearLayout>(Resource.Id.likeLayout);
                ImgLike = view.FindViewById<ImageView>(Resource.Id.img_like);
                TxtLikeCount = view.FindViewById<TextView>(Resource.Id.tv_likeCount);
                
                CommentLayout = view.FindViewById<LinearLayout>(Resource.Id.commentLayout);
                ImgComment = view.FindViewById<ImageView>(Resource.Id.img_comment);
                TxtCommentCount = view.FindViewById<TextView>(Resource.Id.tv_comment_count);
                
                ShareLayout = view.FindViewById<LinearLayout>(Resource.Id.shareLayout);
                ImgShare = view.FindViewById<ImageView>(Resource.Id.img_share);
                TxtShareCount = view.FindViewById<TextView>(Resource.Id.tv_share_count);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
         
        private void AddOrRemoveEvent(bool addEvent)
        {
            try
            {
                // true +=  // false -=
                if (addEvent)
                {
                    UserLayout.Click += UserLayoutOnClick;
                    ImgSendGift.Click += ImgSendGiftOnClick;
                    LikeLayout.Click += LikeLayoutOnClick;
                    CommentLayout.Click += CommentLayoutOnClick;
                    ShareLayout.Click += ShareLayoutOnClick;
                }
                else
                {
                    UserLayout.Click -= UserLayoutOnClick;
                    ImgSendGift.Click -= ImgSendGiftOnClick;
                    LikeLayout.Click -= LikeLayoutOnClick;
                    CommentLayout.Click -= CommentLayoutOnClick;
                    ShareLayout.Click -= ShareLayoutOnClick;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public static ViewReelsVideoFragment GetInstance()
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
         
        #endregion

        #region Event


        private void ShareLayoutOnClick(object sender, EventArgs e)
        {
            try
            {

            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        private void CommentLayoutOnClick(object sender, EventArgs e)
        {
            try
            {

            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        private void LikeLayoutOnClick(object sender, EventArgs e)
        {
            try
            {

            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        private void ImgSendGiftOnClick(object sender, EventArgs e)
        {
            try
            {

            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        private void UserLayoutOnClick(object sender, EventArgs e)
        {
            try
            {

            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }


        public void AutoLinkTextClick(StTools.XAutoLinkMode p0, string p1, Dictionary<string, string> userData)
        {
            try
            {
                p1 = p1.Replace(" ", "").Replace("\n", "");
                var typeText = Methods.FunString.Check_Regex(p1);
                switch (typeText)
                {
                    case "Email":
                        Methods.App.SendEmail(Activity, p1);
                        break;
                    case "Website":
                        {
                            string url = p1.Contains("http") switch
                            {
                                false => "http://" + p1,
                                _ => p1
                            };

                            //var intent = new Intent(MainContext, typeof(LocalWebViewActivity));
                            //intent.PutExtra("URL", url);
                            //intent.PutExtra("Type", url);
                            //MainContext.StartActivity(intent);
                            new IntentController(Activity).OpenBrowserFromApp(url);
                            break;
                        }
                    case "Hashtag":
                        {
                            var intent = new Intent(Activity, typeof(HashTagPostsActivity));
                            intent.PutExtra("Id", p1);
                            intent.PutExtra("Tag", p1);
                            Activity.StartActivity(intent);
                            break;
                        }
                    case "Mention":
                        {
                            var dataUSer = ListUtils.MyProfileList?.FirstOrDefault();
                            string name = p1.Replace("@", "");

                            var sqlEntity = new SqLiteDatabase();
                            var user = sqlEntity.Get_DataOneUser(name);


                            if (user != null)
                            {
                                WoWonderTools.OpenProfile(Activity, user.UserId, user);
                            }
                            else switch (userData?.Count)
                            {
                                    case > 0:
                                        {
                                            var data = userData.FirstOrDefault(a => a.Value == name);
                                            if (data.Key != null && data.Key == UserDetails.UserId)
                                            {
                                                switch (PostClickListener.OpenMyProfile)
                                                {
                                                    case true:
                                                        return;
                                                    default:
                                                        {
                                                            var intent = new Intent(Activity, typeof(MyProfileActivity));
                                                            Activity.StartActivity(intent);
                                                            break;
                                                        }
                                                }
                                            }
                                            else if (data.Key != null)
                                            {
                                                var intent = new Intent(Activity, typeof(UserProfileActivity));
                                                //intent.PutExtra("UserObject", JsonConvert.SerializeObject(item));
                                                intent.PutExtra("UserId", data.Key);
                                                Activity.StartActivity(intent);
                                            }
                                            else
                                            {
                                                if (name == dataUSer?.Name || name == dataUSer?.Username)
                                                {
                                                    switch (PostClickListener.OpenMyProfile)
                                                    {
                                                        case true:
                                                            return;
                                                        default:
                                                            {
                                                                var intent = new Intent(Activity, typeof(MyProfileActivity));
                                                                Activity.StartActivity(intent);
                                                                break;
                                                            }
                                                    }
                                                }
                                                else
                                                {
                                                    var intent = new Intent(Activity, typeof(UserProfileActivity));
                                                    //intent.PutExtra("UserObject", JsonConvert.SerializeObject(item));
                                                    intent.PutExtra("name", name);
                                                    Activity.StartActivity(intent);
                                                }
                                            }

                                            break;
                                        }
                                    default:
                                        {
                                            if (name == dataUSer?.Name || name == dataUSer?.Username)
                                            {
                                                switch (PostClickListener.OpenMyProfile)
                                                {
                                                    case true:
                                                        return;
                                                    default:
                                                        {
                                                            var intent = new Intent(Activity, typeof(MyProfileActivity));
                                                            Activity.StartActivity(intent);
                                                            break;
                                                        }
                                                }
                                            }
                                            else
                                            {
                                                var intent = new Intent(Activity, typeof(UserProfileActivity));
                                                //intent.PutExtra("UserObject", JsonConvert.SerializeObject(item));
                                                intent.PutExtra("name", name);
                                                Activity.StartActivity(intent);
                                            }

                                            break;
                                        }
                            }

                            break;
                        }
                    case "Number":
                        Methods.App.SaveContacts(Activity, p1, "", "2");
                        break;
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
                        p1.GetErrorDialog(Activity, 1).Show();
                        break;
                    default:
                        ToastUtils.ShowToast(Activity, p1.ToString(), ToastLength.Short);
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

        #region Exo Player

        private void SetPlayer()
        {
            try
            {
                DefaultTrackSelector trackSelector = new DefaultTrackSelector(Context);
                trackSelector.SetParameters(new DefaultTrackSelector.ParametersBuilder(Context));

                VideoPlayer = new SimpleExoPlayer.Builder(Context).SetTrackSelector(trackSelector).Build();

                PlayerView.UseController = true;
                PlayerView.Player = VideoPlayer;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private IMediaSource GetMediaSourceFromUrl(Uri uri, string extension, string tag)
        {
            var bandwidthMeter = DefaultBandwidthMeter.GetSingletonInstance(Context);
            var buildHttpDataSourceFactory = new DefaultDataSourceFactory(Context, bandwidthMeter, new DefaultHttpDataSourceFactory(Util.GetUserAgent(Context, AppSettings.ApplicationName)));
            var buildHttpDataSourceFactoryNull = new DefaultDataSourceFactory(Context, bandwidthMeter, new DefaultHttpDataSourceFactory(Util.GetUserAgent(Context, AppSettings.ApplicationName)));
            int type = Util.InferContentType(uri, extension);
            try
            {

                IMediaSource src;
                switch (type)
                {
                    case C.TypeSs:
                        src = new SsMediaSource.Factory(new DefaultSsChunkSource.Factory(buildHttpDataSourceFactory), buildHttpDataSourceFactoryNull).SetTag(tag).SetDrmSessionManager(IDrmSessionManager.DummyDrmSessionManager).CreateMediaSource(uri);
                        break;
                    case C.TypeDash:
                        src = new DashMediaSource.Factory(new DefaultDashChunkSource.Factory(buildHttpDataSourceFactory), buildHttpDataSourceFactoryNull).SetTag(tag).SetDrmSessionManager(IDrmSessionManager.DummyDrmSessionManager).CreateMediaSource(uri);
                        break;
                    case C.TypeHls:
                        DefaultHlsExtractorFactory defaultHlsExtractorFactory = new DefaultHlsExtractorFactory(DefaultTsPayloadReaderFactory.FlagAllowNonIdrKeyframes, true);
                        src = new HlsMediaSource.Factory(buildHttpDataSourceFactory).SetTag(tag).SetExtractorFactory(defaultHlsExtractorFactory).CreateMediaSource(uri);
                        break;
                    case C.TypeOther:
                        src = new ProgressiveMediaSource.Factory(buildHttpDataSourceFactory).SetTag(tag).CreateMediaSource(uri);
                        break;
                    default:
                        src = new ProgressiveMediaSource.Factory(buildHttpDataSourceFactory).SetTag(tag).CreateMediaSource(uri);
                        break;
                }

                return src;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                try
                {
                    return new ProgressiveMediaSource.Factory(buildHttpDataSourceFactory).SetTag(tag).CreateMediaSource(uri);
                }
                catch (Exception exception)
                {
                    Methods.DisplayReportResultTrack(exception);
                    return null!;
                }
            }
        }

        public void StopVideo()
        {
            try
            {
                if (PostFeedType == PostModelType.YoutubePost)
                {
                    if (YoutubePlayer != null && YoutubePlayer.IsPlaying)
                        YoutubePlayer?.Pause();
                }
                else
                {
                    if (PlayerView.Player != null && PlayerView.Player.PlaybackState == IPlayer.StateReady)
                        PlayerView.Player.PlayWhenReady = false;
                }

                TabbedMainActivity.GetInstance()?.SetOffWakeLock();

                //GC Collect
                GC.Collect();
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        public void ReleaseVideo()
        {
            try
            {
                if (PostFeedType == PostModelType.YoutubePost)
                {
                    if (YoutubePlayer != null && YoutubePlayer.IsPlaying)
                        YoutubePlayer?.Release();
                }
                else
                {
                    StopVideo();
                    PlayerView?.Player?.Stop();

                    if (VideoPlayer != null)
                    {
                        VideoPlayer.Release();
                        VideoPlayer = null!;
                    }
                } 
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public void OnLoadingChanged(bool p0)
        {
        }

        public void OnPlaybackParametersChanged(PlaybackParameters p0)
        {
        }

        public void OnPlaybackSuppressionReasonChanged(int playbackSuppressionReason)
        {

        }

        public void OnPlayerError(ExoPlaybackException p0)
        {
        }

        public void OnPlayerStateChanged(bool playWhenReady, int playbackState)
        {
            try
            {
                switch (playbackState)
                {
                    case IPlayer.StateBuffering:
                        break;
                    case IPlayer.StateReady:
                        break;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public void OnIsPlayingChanged(bool p0)
        {

        }

        public void OnPositionDiscontinuity(int p0)
        {
        }

        public void OnRepeatModeChanged(int p0)
        {
        }

        public void OnSeekProcessed()
        {
        }

        public void OnShuffleModeEnabledChanged(bool p0)
        {
        }

        public void OnTimelineChanged(Timeline p0, int p2)
        {
        }

        public void OnTracksChanged(TrackGroupArray p0, TrackSelectionArray p1)
        {
        }


        #endregion

        private void LoadData(PostDataObject dataObject)
        {
            try
            { 
                PostFeedType = PostFunctions.GetAdapterType(dataObject);

                GlideImageLoader.LoadImage(Activity, dataObject.PostPrivacy == "4" ? "user_anonymous" : dataObject.Publisher.Avatar, UserImageView, ImageStyle.CircleCrop, ImagePlaceholders.Drawable);

                TxtUsername.Text = dataObject.PostPrivacy == "4" ? Activity.GetText(Resource.String.Lbl_Anonymous) : WoWonderTools.GetNameFinal(dataObject.Publisher);

                TxtLikeCount.Text = dataObject.PostLikes;
                TxtCommentCount.Text = dataObject.PostComments;

                if (AppSettings.ShowTextShareButton)
                {
                    TxtShareCount.Text = dataObject.PostShare;
                }
                else
                {
                    TxtShareCount.Visibility = ViewStates.Gone;
                }
                 
                if (string.IsNullOrEmpty(dataObject.Orginaltext) || string.IsNullOrWhiteSpace(dataObject.Orginaltext))
                {
                    TxtDescription.Visibility = ViewStates.Invisible;
                }
                else
                {
                    switch (dataObject.RegexFilterList != null & dataObject.RegexFilterList?.Count > 0)
                    {
                        case true:
                            TxtDescription.SetAutoLinkOnClickListener(this, dataObject.RegexFilterList);
                            break;
                        default:
                            TxtDescription.SetAutoLinkOnClickListener(this, new Dictionary<string, string>());
                            break;
                    }

                    ReadMoreOption.AddReadMoreTo(TxtDescription, new String(dataObject.Orginaltext)); 
                }

                if (PostFeedType == PostModelType.VideoPost)
                {
                    if (YoutubePlayer != null && YoutubePlayer.IsPlaying)
                        YoutubePlayer?.Release();

                    // Uri
                    Uri uri = Uri.Parse(dataObject.PostFileFull);
                    var videoSource = GetMediaSourceFromUrl(uri, uri?.Path?.Split('.').Last(), "normal");

                    VideoPlayer.Prepare(videoSource);
                    VideoPlayer.PlayWhenReady = true; 
                }
                else if (PostFeedType == PostModelType.YoutubePost)
                {
                    VideoIdYoutube = dataObject.PostYoutube;

                    YouTubePlayerView youTubeView = new YouTubePlayerView(Context);
                     
                    Root.RemoveAllViews();
                    Root.AddView(youTubeView);

                    youTubeView.Initialize(GetText(Resource.String.google_key), this);

                    PlayerView.Visibility = ViewStates.Gone;
                    ReleaseVideo();

                    YoutubePlayer?.LoadVideo(VideoIdYoutube);
                } 
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

    }
}