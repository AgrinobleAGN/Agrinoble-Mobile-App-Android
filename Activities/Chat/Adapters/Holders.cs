using System;
using System.Linq;
using System.Timers;
using Android.Animation;
using Android.App;
using Android.Content;
using Android.Media;
using Android.Views;
using Android.Views.Animations;
using Android.Widget;
using AndroidX.Core.Content;
using AndroidX.RecyclerView.Widget;
using AT.Markushi.UI;
using Com.Airbnb.Lottie;
using Com.Luseen.Autolinklibrary;
using Java.IO;
using Java.Lang;
using Refractored.Controls;
using WoWonder.Activities.Chat.ChatWindow.Adapters;
using WoWonder.Helpers.Fonts;
using WoWonder.Helpers.Model;
using WoWonder.Helpers.Utils;
using WoWonder.Library.MusicBar;
using WoWonderClient;
using WoWonderClient.Classes.Message;
using Exception = System.Exception;
using Uri = Android.Net.Uri;

namespace WoWonder.Activities.Chat.Adapters
{
    public class Holders
    {
        public enum TypeClick
        {
            Text, Image, Sound, Contact, Video, Sticker, File, Product, Map
        }

        public static MessageModelType GetTypeModel(MessageData item)
        {
            try
            {
                MessageModelType modelType;

                if (item.FromId == UserDetails.UserId) // right
                {
                    item.Position = "right";
                }
                else if (item.ToId == UserDetails.UserId) // left
                {
                    item.Position = "left";
                }

                string imageUrl = "", text = "";
                if (!string.IsNullOrEmpty(item.Stickers))
                {
                    item.Stickers = item.Stickers.Replace(".mp4", ".gif");
                    imageUrl = item.Stickers;
                }

                if (!string.IsNullOrEmpty(item.Media))
                    imageUrl = item.Media;

                if (!string.IsNullOrEmpty(item.Text))
                    text = ChatUtils.GetMessage(item.Text, item.Time);

                if (!string.IsNullOrEmpty(text))
                    modelType = item.TypeTwo == "contact" ? item.Position == "left" ? MessageModelType.LeftContact : MessageModelType.RightContact : item.Position == "left" ? MessageModelType.LeftText : MessageModelType.RightText;
                else if (item.Product?.ProductClass != null && !string.IsNullOrEmpty(item.ProductId) && item.ProductId != "0")
                    modelType = item.Position == "left" ? MessageModelType.LeftProduct : MessageModelType.RightProduct;
                else if (!string.IsNullOrEmpty(item.Lat) && !string.IsNullOrEmpty(item.Lng) && item.Lat != "0" && item.Lng != "0")
                    modelType = item.Position == "left" ? MessageModelType.LeftMap : MessageModelType.RightMap;
                else if (!string.IsNullOrEmpty(imageUrl))
                {
                    var type = Methods.AttachmentFiles.Check_FileExtension(imageUrl);
                    switch (type)
                    {
                        case "Audio":
                            modelType = item.Position == "left" ? MessageModelType.LeftAudio : MessageModelType.RightAudio;
                            break;
                        case "Video":
                            modelType = item.Position == "left" ? MessageModelType.LeftVideo : MessageModelType.RightVideo;
                            break;
                        case "Image" when !string.IsNullOrEmpty(item.Media) && !item.Media.Contains(".gif"):
                            modelType = item.Media.Contains("sticker") ? item.Position == "left" ? MessageModelType.LeftSticker : MessageModelType.RightSticker : item.Position == "left" ? MessageModelType.LeftImage : MessageModelType.RightImage;
                            break;
                        case "File" when !string.IsNullOrEmpty(item.Stickers) && item.Stickers.Contains(".gif"):
                        case "File" when !string.IsNullOrEmpty(item.Media) && item.Media.Contains(".gif"):
                        case "Image" when !string.IsNullOrEmpty(item.Stickers) && item.Stickers.Contains(".gif"):
                        case "Image" when !string.IsNullOrEmpty(item.Media) && item.Media.Contains(".gif"):
                            modelType = item.Position == "left" ? MessageModelType.LeftGif : MessageModelType.RightGif;
                            break;
                        case "File":
                            modelType = item.Position == "left" ? MessageModelType.LeftFile : MessageModelType.RightFile;
                            break;
                        default:
                            modelType = MessageModelType.None;
                            break;
                    }
                }
                else
                {
                    modelType = MessageModelType.None;
                }

                return modelType;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                return MessageModelType.None;
            }
        }

        public class MesClickEventArgs : EventArgs
        {
            public View View { get; set; }
            public int Position { get; set; }
            public TypeClick Type { get; set; }
        }

        public class TextViewHolder : RecyclerView.ViewHolder
        {
            #region Variables Basic

            public RelativeLayout LytParent { get; private set; }
            public LinearLayout BubbleLayout { get; private set; }
            public TextView Time { get; private set; }
            public View MainView { get; private set; }
            public AutoLinkTextView AutoLinkTextView { get; private set; }
            public TextView Seen { get; private set; }
            public TextView UserName { get; private set; }
            public LottieAnimationView StarIcon { get; private set; }
            public ImageView StarImage { get; private set; }

            public RepliedMessageView RepliedMessageView { get; private set; }
            public ReactionMessageView ReactionMessageView { get; private set; }
            public LinearLayout ForwardLayout { get; private set; }

            #endregion

            public TextViewHolder(View itemView, Action<MesClickEventArgs> clickListener, Action<MesClickEventArgs> longClickListener, bool showName) : base(itemView)
            {
                try
                {
                    MainView = itemView;

                    RepliedMessageView = new RepliedMessageView(itemView, "text");
                    ReactionMessageView = new ReactionMessageView(itemView);

                    LytParent = itemView.FindViewById<RelativeLayout>(Resource.Id.main);
                    BubbleLayout = itemView.FindViewById<LinearLayout>(Resource.Id.bubble_layout);
                    AutoLinkTextView = itemView.FindViewById<AutoLinkTextView>(Resource.Id.active);
                    Time = itemView.FindViewById<TextView>(Resource.Id.time);
                    Seen = itemView.FindViewById<TextView>(Resource.Id.seen);
                    StarImage = itemView.FindViewById<ImageView>(Resource.Id.fav);
                    StarImage.Visibility = ViewStates.Gone;
                    StarIcon = itemView.FindViewById<LottieAnimationView>(Resource.Id.starIcon);
                    StarIcon.Progress = 0;
                    StarIcon.CancelAnimation();
                    StarIcon.Visibility = ViewStates.Gone;

                    ForwardLayout = itemView.FindViewById<LinearLayout>(Resource.Id.ForwardLayout);
                    ForwardLayout.Visibility = ViewStates.Gone;

                    UserName = itemView.FindViewById<TextView>(Resource.Id.name);
                    if (UserName != null) UserName.Visibility = showName ? ViewStates.Visible : ViewStates.Gone;

                    itemView.Click += (sender, args) => clickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Text });
                    AutoLinkTextView.Click += (sender, args) => clickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Text });
                    AutoLinkTextView.LongClick += (sender, args) => longClickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Text });
                    itemView.LongClick += (sender, args) => longClickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Text });
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }

        public class ImageViewHolder : RecyclerView.ViewHolder
        {
            #region Variables Basic

            public RelativeLayout LytParent { get; private set; }
            public LinearLayout BubbleLayout { get; private set; }
            public View MainView { get; private set; }
            public ImageView ImageView { get; private set; }
            public ProgressBar LoadingProgressview { get; private set; }
            public TextView Time { get; private set; }
            public TextView Seen { get; private set; }
            public TextView UserName { get; private set; }
            public TextView TxtErrorLoading { get; private set; }
            public ImageView StarImage { get; private set; }
            public LottieAnimationView StarIcon { get; private set; }
            public RepliedMessageView RepliedMessageView { get; private set; }
            public ReactionMessageView ReactionMessageView { get; private set; }
            public LinearLayout ForwardLayout { get; private set; }

            #endregion

            public ImageViewHolder(View itemView, Action<MesClickEventArgs> clickListener, Action<MesClickEventArgs> errorLoadingClickListener, Action<MesClickEventArgs> longClickListener, bool showName, TypeClick typeClick) : base(itemView)
            {
                try
                {
                    MainView = itemView;

                    RepliedMessageView = new RepliedMessageView(itemView, "file");
                    ReactionMessageView = new ReactionMessageView(itemView);

                    LytParent = itemView.FindViewById<RelativeLayout>(Resource.Id.main);
                    BubbleLayout = itemView.FindViewById<LinearLayout>(Resource.Id.bubble_layout);
                    ImageView = itemView.FindViewById<ImageView>(Resource.Id.imgDisplay);
                    LoadingProgressview = itemView.FindViewById<ProgressBar>(Resource.Id.loadingProgressview);
                    Time = itemView.FindViewById<TextView>(Resource.Id.time);
                    Seen = itemView.FindViewById<TextView>(Resource.Id.seen);
                    StarImage = itemView.FindViewById<ImageView>(Resource.Id.fav);
                    StarImage.Visibility = ViewStates.Gone;
                    StarIcon = itemView.FindViewById<LottieAnimationView>(Resource.Id.starIcon);
                    StarIcon.Progress = 0;
                    StarIcon.CancelAnimation();
                    StarIcon.Visibility = ViewStates.Gone;

                    TxtErrorLoading = itemView.FindViewById<TextView>(Resource.Id.textErrorLoading);

                    ForwardLayout = itemView.FindViewById<LinearLayout>(Resource.Id.ForwardLayout);
                    ForwardLayout.Visibility = ViewStates.Gone;

                    UserName = itemView.FindViewById<TextView>(Resource.Id.name);
                    if (UserName != null) UserName.Visibility = showName ? ViewStates.Visible : ViewStates.Gone;

                    if (TxtErrorLoading != null)
                        TxtErrorLoading.Click += (sender, args) => errorLoadingClickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = typeClick });

                    ImageView.Click += (sender, args) => clickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = typeClick });
                    itemView.LongClick += (sender, args) => longClickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = typeClick });
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }

        public class SoundViewHolder : RecyclerView.ViewHolder, View.IOnClickListener
        {
            #region Variables Basic

            private readonly MessageAdapter MessageAdapter;

            public RelativeLayout LytParent { get; private set; }
            public LinearLayout BubbleLayout { get; private set; }
            public View MainView { get; private set; }
            public TextView DurationTextView { get; private set; }
            public TextView MsgTimeTextView { get; private set; }
            public CircleButton PlayButton { get; private set; }
            public ProgressBar LoadingProgressview { get; private set; }
            public TextView UserName { get; private set; }
            public TextView Seen { get; private set; }
            public ImageView StarImage { get; private set; }
            public LottieAnimationView StarIcon { get; private set; }

            public RepliedMessageView RepliedMessageView { get; private set; }
            public ReactionMessageView ReactionMessageView { get; private set; }
            public LinearLayout ForwardLayout { get; private set; }

            #endregion

            public SoundViewHolder(View itemView, Action<MesClickEventArgs> clickListener, Action<MesClickEventArgs> longClickListener, MessageAdapter messageAdapter, bool showName) : base(itemView)
            {
                try
                {
                    MessageAdapter = messageAdapter;

                    MainView = itemView;

                    RepliedMessageView = new RepliedMessageView(itemView, "file");
                    ReactionMessageView = new ReactionMessageView(itemView);

                    LytParent = itemView.FindViewById<RelativeLayout>(Resource.Id.main);
                    BubbleLayout = itemView.FindViewById<LinearLayout>(Resource.Id.bubble_layout);
                    DurationTextView = itemView.FindViewById<TextView>(Resource.Id.Duration);
                    PlayButton = itemView.FindViewById<CircleButton>(Resource.Id.playButton);
                    MsgTimeTextView = itemView.FindViewById<TextView>(Resource.Id.time);
                    LoadingProgressview = itemView.FindViewById<ProgressBar>(Resource.Id.loadingProgressview);
                    Seen = itemView.FindViewById<TextView>(Resource.Id.seen);
                    StarImage = itemView.FindViewById<ImageView>(Resource.Id.fav);
                    StarImage.Visibility = ViewStates.Gone;
                    StarIcon = itemView.FindViewById<LottieAnimationView>(Resource.Id.starIcon);
                    StarIcon.Progress = 0;
                    StarIcon.CancelAnimation();
                    StarIcon.Visibility = ViewStates.Gone;

                    ForwardLayout = itemView.FindViewById<LinearLayout>(Resource.Id.ForwardLayout);
                    ForwardLayout.Visibility = ViewStates.Gone;

                    UserName = itemView.FindViewById<TextView>(Resource.Id.name);
                    if (UserName != null) UserName.Visibility = showName ? ViewStates.Visible : ViewStates.Gone;

                    PlayButton.SetOnClickListener(this);

                    itemView.Click += (sender, args) => clickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Sound });
                    itemView.LongClick += (sender, args) => longClickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Sound });
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            public void OnClick(View v)
            {
                try
                {
                    if (BindingAdapterPosition != RecyclerView.NoPosition)
                    {
                        var item = MessageAdapter.DifferList[BindingAdapterPosition]?.MesData;
                        if (v.Id == PlayButton.Id && item != null)
                        {
                            PlaySound(BindingAdapterPosition, item);
                        }
                    }
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            private void PlaySound(int position, MessageDataExtra message)
            {
                try
                {
                    if (MessageAdapter.PositionSound != position)
                    {
                        var list = MessageAdapter.DifferList.Where(a => a.TypeView == MessageModelType.LeftAudio || a.TypeView == MessageModelType.RightAudio && a.MesData.MediaPlayer != null).ToList();
                        if (list.Count > 0)
                        {
                            foreach (var item in list)
                            {
                                item.MesData.MediaIsPlaying = false;

                                if (item.MesData.MediaPlayer != null)
                                {
                                    item.MesData.MediaPlayer.Stop();
                                    item.MesData.MediaPlayer.Reset();
                                }
                                item.MesData.MediaPlayer = null!;
                                item.MesData.MediaTimer = null!;

                                item.MesData.MediaPlayer?.Release();
                                item.MesData.MediaPlayer = null!;
                            }

                            MessageAdapter.NotifyItemChanged(MessageAdapter.PositionSound, "WithoutBlobAudio");
                        }
                    }

                    var fileName = message.Media.Split('/').Last();

                    var mediaFile = WoWonderTools.GetFile(MessageAdapter.Id, Methods.Path.FolderDcimSound, fileName, message.Media);
                    if (string.IsNullOrEmpty(message.MediaDuration) || message.MediaDuration == "00:00")
                    {
                        var duration = WoWonderTools.GetDuration(mediaFile);
                        DurationTextView.Text = Methods.AudioRecorderAndPlayer.GetTimeString(duration);
                    }
                    else
                        DurationTextView.Text = message.MediaDuration;

                    if (mediaFile.Contains("http"))
                        mediaFile = WoWonderTools.GetFile(MessageAdapter.Id, Methods.Path.FolderDcimSound, fileName, message.Media);

                    if (message.MediaPlayer == null)
                    {
                        DurationTextView.Text = "00:00";
                        MessageAdapter.PositionSound = position;
                        message.MediaPlayer = new MediaPlayer();
                        message.MediaPlayer.SetAudioAttributes(new AudioAttributes.Builder()?.SetUsage(AudioUsageKind.Media)?.SetContentType(AudioContentType.Music)?.Build());

                        message.MediaPlayer.Completion += (sender, e) =>
                        {
                            try
                            {
                                PlayButton.Tag = "Play";
                                PlayButton.SetImageResource(message.ModelType == MessageModelType.LeftAudio ? Resource.Drawable.ic_play_dark_arrow : Resource.Drawable.ic_play_arrow);

                                message.MediaIsPlaying = false;

                                if (message.MediaPlayer != null)
                                {
                                    message.MediaPlayer.Stop();
                                    message.MediaPlayer.Reset();
                                    message.MediaPlayer = null!;
                                }

                                if (message.MediaTimer != null)
                                {
                                    message.MediaTimer.Enabled = false;
                                    message.MediaTimer.Stop();
                                    message.MediaTimer = null!;
                                }

                            }
                            catch (Exception exception)
                            {
                                Methods.DisplayReportResultTrack(exception);
                            }
                        };

                        message.MediaPlayer.Prepared += (s, ee) =>
                        {
                            try
                            {
                                message.MediaIsPlaying = true;
                                PlayButton.Tag = "Pause";
                                if (message.ModelType == MessageModelType.LeftAudio)
                                    PlayButton.SetImageResource(AppSettings.SetTabDarkTheme ? Resource.Drawable.ic_media_pause_light : Resource.Drawable.ic_media_pause_dark);
                                else
                                    PlayButton.SetImageResource(Resource.Drawable.ic_media_pause_light);

                                message.MediaTimer ??= new Timer { Interval = 1000 };

                                message.MediaPlayer?.Start();

                                //var durationOfSound = message.MediaPlayer.Duration;

                                message.MediaTimer.Elapsed += (sender, eventArgs) =>
                                {
                                    MessageAdapter.MainActivity?.RunOnUiThread(() =>
                                    {
                                        try
                                        {
                                            if (message.MediaTimer != null && message.MediaTimer.Enabled)
                                            {
                                                if (message.MediaPlayer.CurrentPosition <= message.MediaPlayer.Duration)
                                                {
                                                    DurationTextView.Text = Methods.AudioRecorderAndPlayer.GetTimeString(message.MediaPlayer.CurrentPosition.ToString());
                                                }
                                                else
                                                {
                                                    DurationTextView.Text = Methods.AudioRecorderAndPlayer.GetTimeString(message.MediaPlayer.Duration.ToString());

                                                    PlayButton.Tag = "Play";
                                                    PlayButton.SetImageResource(message.ModelType == MessageModelType.LeftAudio ? Resource.Drawable.ic_play_dark_arrow : Resource.Drawable.ic_play_arrow);
                                                }
                                            }
                                        }
                                        catch (Exception e)
                                        {
                                            Methods.DisplayReportResultTrack(e);
                                            PlayButton.Tag = "Play";
                                        }
                                    });
                                };
                                message.MediaTimer.Start();
                            }
                            catch (Exception e)
                            {
                                Methods.DisplayReportResultTrack(e);
                            }
                        };

                        if (mediaFile.Contains("http"))
                        {
                            message.MediaPlayer.SetDataSource(MessageAdapter.MainActivity, Uri.Parse(mediaFile));
                            message.MediaPlayer.PrepareAsync();
                        }
                        else
                        {
                            File file2 = new File(mediaFile);
                            var photoUri = FileProvider.GetUriForFile(MessageAdapter.MainActivity, MessageAdapter.MainActivity.PackageName + ".fileprovider", file2);

                            message.MediaPlayer.SetDataSource(MessageAdapter.MainActivity, photoUri);
                            message.MediaPlayer.PrepareAsync();
                        }

                        //message.SoundViewHolder = soundViewHolder;
                    }
                    else
                    {
                        switch (PlayButton?.Tag?.ToString())
                        {
                            case "Play":
                                {
                                    PlayButton.Tag = "Pause";
                                    if (message.ModelType == MessageModelType.LeftAudio)
                                        PlayButton.SetImageResource(AppSettings.SetTabDarkTheme ? Resource.Drawable.ic_media_pause_light : Resource.Drawable.ic_media_pause_dark);
                                    else
                                        PlayButton.SetImageResource(Resource.Drawable.ic_media_pause_light);

                                    message.MediaIsPlaying = true;
                                    message.MediaPlayer?.Start();

                                    if (message.MediaTimer != null)
                                    {
                                        message.MediaTimer.Enabled = true;
                                        message.MediaTimer.Start();
                                    }

                                    break;
                                }
                            case "Pause":
                                {
                                    PlayButton.Tag = "Play";
                                    PlayButton.SetImageResource(message.ModelType == MessageModelType.LeftAudio ? Resource.Drawable.ic_play_dark_arrow : Resource.Drawable.ic_play_arrow);

                                    message.MediaIsPlaying = false;
                                    message.MediaPlayer?.Pause();

                                    if (message.MediaTimer != null)
                                    {
                                        message.MediaTimer.Enabled = false;
                                        message.MediaTimer.Stop();
                                    }

                                    break;
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

        public class MusicBarViewHolder : RecyclerView.ViewHolder, View.IOnClickListener, MusicBar.IOnMusicBarAnimationChangeListener, MusicBar.IOnMusicBarProgressChangeListener, ValueAnimator.IAnimatorUpdateListener
        {
            #region Variables Basic
            private readonly MessageAdapter MessageAdapter;
            public RelativeLayout LytParent { get; private set; }
            public LinearLayout BubbleLayout { get; private set; }
            public View MainView { get; private set; }
            public TextView DurationTextView { get; private set; }
            public TextView MsgTimeTextView { get; private set; }
            public CircleButton PlayButton { get; private set; }
            public ProgressBar LoadingProgressview { get; private set; }
            public FixedMusicBar FixedMusicBar { get; private set; }
            public TextView UserName { get; private set; }
            public TextView Seen { get; private set; }
            public ImageView StarImage { get; private set; }
            public LottieAnimationView StarIcon { get; private set; }
            public RepliedMessageView RepliedMessageView { get; private set; }
            public ReactionMessageView ReactionMessageView { get; private set; }
            public LinearLayout ForwardLayout { get; private set; }

            #endregion

            public MusicBarViewHolder(View itemView, Action<MesClickEventArgs> clickListener, Action<MesClickEventArgs> longClickListener, MessageAdapter messageAdapter, bool showName) : base(itemView)
            {
                try
                {
                    MessageAdapter = messageAdapter;

                    MainView = itemView;

                    RepliedMessageView = new RepliedMessageView(itemView, "file");
                    ReactionMessageView = new ReactionMessageView(itemView);

                    LytParent = itemView.FindViewById<RelativeLayout>(Resource.Id.main);
                    BubbleLayout = itemView.FindViewById<LinearLayout>(Resource.Id.bubble_layout);
                    DurationTextView = itemView.FindViewById<TextView>(Resource.Id.Duration);
                    PlayButton = itemView.FindViewById<CircleButton>(Resource.Id.playButton);
                    MsgTimeTextView = itemView.FindViewById<TextView>(Resource.Id.time);
                    LoadingProgressview = itemView.FindViewById<ProgressBar>(Resource.Id.loadingProgressview);
                    FixedMusicBar = itemView.FindViewById<FixedMusicBar>(Resource.Id.miniMusicBar);
                    Seen = itemView.FindViewById<TextView>(Resource.Id.seen);
                    StarImage = itemView.FindViewById<ImageView>(Resource.Id.fav);
                    StarImage.Visibility = ViewStates.Gone;
                    StarIcon = itemView.FindViewById<LottieAnimationView>(Resource.Id.starIcon);
                    StarIcon.Progress = 0;
                    StarIcon.CancelAnimation();
                    StarIcon.Visibility = ViewStates.Gone;

                    ForwardLayout = itemView.FindViewById<LinearLayout>(Resource.Id.ForwardLayout);
                    ForwardLayout.Visibility = ViewStates.Gone;

                    UserName = itemView.FindViewById<TextView>(Resource.Id.name);
                    if (UserName != null) UserName.Visibility = showName ? ViewStates.Visible : ViewStates.Gone;

                    itemView.Click += (sender, args) => clickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Sound });
                    itemView.LongClick += (sender, args) => longClickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Sound });
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            public void OnClick(View v)
            {
                try
                {
                    if (BindingAdapterPosition != RecyclerView.NoPosition)
                    {
                        MessageAdapter.MusicBarMessageData = MessageAdapter.DifferList[BindingAdapterPosition]?.MesData;
                        if (v.Id == PlayButton.Id && MessageAdapter.MusicBarMessageData != null)
                        {
                            PlaySound(BindingAdapterPosition, MessageAdapter.MusicBarMessageData);
                        }
                    }
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            private void PlaySound(int position, MessageDataExtra message)
            {
                try
                {
                    if (MessageAdapter.PositionSound != position)
                    {
                        var list = MessageAdapter.DifferList.Where(a => a.TypeView == MessageModelType.LeftAudio || a.TypeView == MessageModelType.RightAudio && a.MesData.MediaPlayer != null).ToList();
                        if (list.Count > 0)
                        {
                            foreach (var item in list)
                            {
                                item.MesData.MediaIsPlaying = false;

                                if (item.MesData.MediaPlayer != null)
                                {
                                    item.MesData.MediaPlayer.Stop();
                                    item.MesData.MediaPlayer.Reset();
                                }
                                item.MesData.MediaPlayer = null!;
                                item.MesData.MediaTimer = null!;

                                item.MesData.MediaPlayer?.Release();
                                item.MesData.MediaPlayer = null!;
                            }
                        }
                    }

                    var fileName = message.Media.Split('/').Last();

                    var mediaFile = WoWonderTools.GetFile(MessageAdapter.Id, Methods.Path.FolderDcimSound, fileName, message.Media);
                    if (string.IsNullOrEmpty(message.MediaDuration) || message.MediaDuration == "00:00")
                    {
                        var duration = WoWonderTools.GetDuration(mediaFile);
                        DurationTextView.Text = message.MediaDuration = Methods.AudioRecorderAndPlayer.GetTimeString(duration);
                    }
                    else
                        DurationTextView.Text = message.MediaDuration;

                    if (message.MediaPlayer == null)
                    {
                        MessageAdapter.PositionSound = position;
                        message.MediaPlayer = new MediaPlayer();
                        message.MediaPlayer.SetAudioAttributes(new AudioAttributes.Builder().SetUsage(AudioUsageKind.Media)?.SetContentType(AudioContentType.Music)?.Build());

                        message.MediaPlayer.Completion += (sender, e) =>
                        {
                            try
                            {
                                PlayButton.Tag = "Play";
                                PlayButton.SetImageResource(message.ModelType == MessageModelType.LeftAudio ? Resource.Drawable.ic_play_dark_arrow : Resource.Drawable.ic_play_arrow);

                                message.MediaIsPlaying = false;

                                if (message.MediaPlayer != null)
                                {
                                    message.MediaPlayer.Stop();
                                    message.MediaPlayer.Reset();
                                    message.MediaPlayer = null!;
                                }

                                if (message.MediaTimer != null)
                                {
                                    message.MediaTimer.Enabled = false;
                                    message.MediaTimer.Stop();
                                    message.MediaTimer = null!;
                                }

                                FixedMusicBar.StopAutoProgress();
                            }
                            catch (Exception exception)
                            {
                                Methods.DisplayReportResultTrack(exception);
                            }
                        };

                        message.MediaPlayer.Prepared += (s, ee) =>
                        {
                            try
                            {
                                message.MediaIsPlaying = true;
                                PlayButton.Tag = "Pause";
                                PlayButton.SetImageResource(message.ModelType == MessageModelType.LeftAudio ? Resource.Drawable.ic_media_pause_dark : Resource.Drawable.ic_media_pause_light);

                                if (message.MediaTimer == null)
                                    message.MediaTimer = new Timer { Interval = 1000 };

                                message.MediaPlayer.Start();

                                var mediaPlayerDuration = message.MediaPlayer.Duration;

                                //change bar width
                                FixedMusicBar.SetBarWidth(2);

                                //change Space Between Bars
                                FixedMusicBar.SetSpaceBetweenBar(2);

                                if (mediaFile.Contains("http"))
                                    mediaFile = WoWonderTools.GetFile(MessageAdapter.Id, Methods.Path.FolderDcimSound, fileName, message.Media);

                                FixedMusicBar.LoadFrom(mediaFile, mediaPlayerDuration);

                                FixedMusicBar.SetAnimationChangeListener(this);
                                FixedMusicBar.SetProgressChangeListener(this);
                                InitValueAnimator(1.0f, 0, mediaPlayerDuration);
                                FixedMusicBar.Show();

                                message.MediaTimer.Elapsed += (sender, eventArgs) =>
                                {
                                    MessageAdapter.MainActivity?.RunOnUiThread(() =>
                                    {
                                        try
                                        {
                                            if (message.MediaTimer.Enabled)
                                            {
                                                if (message.MediaPlayer.CurrentPosition <= message.MediaPlayer.Duration)
                                                {
                                                    DurationTextView.Text = Methods.AudioRecorderAndPlayer.GetTimeString(message.MediaPlayer.CurrentPosition.ToString());
                                                }
                                                else
                                                {
                                                    DurationTextView.Text = Methods.AudioRecorderAndPlayer.GetTimeString(message.MediaPlayer.Duration.ToString());

                                                    PlayButton.Tag = "Play";
                                                    PlayButton.SetImageResource(message.ModelType == MessageModelType.LeftAudio ? Resource.Drawable.ic_play_dark_arrow : Resource.Drawable.ic_play_arrow);
                                                }
                                            }
                                        }
                                        catch (Exception e)
                                        {
                                            Methods.DisplayReportResultTrack(e);
                                            PlayButton.Tag = "Play";
                                        }
                                    });
                                };
                                message.MediaTimer?.Start();
                            }
                            catch (Exception e)
                            {
                                Methods.DisplayReportResultTrack(e);
                            }
                        };

                        if (mediaFile.Contains("http"))
                        {
                            message.MediaPlayer.SetDataSource(MessageAdapter.MainActivity, Uri.Parse(mediaFile));
                            message.MediaPlayer.PrepareAsync();
                        }
                        else
                        {
                            File file2 = new File(mediaFile);
                            var photoUri = FileProvider.GetUriForFile(MessageAdapter.MainActivity, MessageAdapter.MainActivity.PackageName + ".fileprovider", file2);

                            message.MediaPlayer.SetDataSource(MessageAdapter.MainActivity, photoUri);
                            message.MediaPlayer.PrepareAsync();
                        }

                        MessageAdapter.MusicBarMessageData = message;
                        //MusicBarMessageData.MusicBarViewHolder = musicBarViewHolder;
                        //message.MusicBarViewHolder = musicBarViewHolder;
                    }
                    else
                    {
                        switch (PlayButton?.Tag?.ToString())
                        {
                            case "Play":
                                {
                                    PlayButton.Tag = "Pause";
                                    PlayButton.SetImageResource(message.ModelType == MessageModelType.LeftAudio ? Resource.Drawable.ic_media_pause_dark : Resource.Drawable.ic_media_pause_light);

                                    message.MediaIsPlaying = true;
                                    message.MediaPlayer?.Start();

                                    FixedMusicBar.Show();

                                    InitValueAnimator(1.0f, FixedMusicBar.GetPosition(), message.MediaPlayer.Duration);

                                    if (message.MediaTimer != null)
                                    {
                                        message.MediaTimer.Enabled = true;
                                        message.MediaTimer.Start();
                                    }

                                    break;
                                }
                            case "Pause":
                                {
                                    PlayButton.Tag = "Play";
                                    PlayButton.SetImageResource(message.ModelType == MessageModelType.LeftAudio ? Resource.Drawable.ic_play_dark_arrow : Resource.Drawable.ic_play_arrow);

                                    message.MediaIsPlaying = false;
                                    message.MediaPlayer?.Pause();

                                    //stop auto progress animation
                                    FixedMusicBar.StopAutoProgress();

                                    if (message.MediaTimer != null)
                                    {
                                        message.MediaTimer.Enabled = false;
                                        message.MediaTimer.Stop();
                                    }

                                    break;
                                }
                        }
                    }
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            #region MusicBar

            private void InitValueAnimator(float playbackSpeed, int progress, int max)
            {
                int timeToEnd = (int)((max - progress) / playbackSpeed);
                if (timeToEnd > 0)
                {
                    if (ValueAnimator.OfInt(progress, max).SetDuration(timeToEnd) is ValueAnimator value)
                    {
                        FixedMusicBar?.SetProgressAnimator(value);

                        MessageAdapter.MValueAnimator = value;
                        MessageAdapter.MValueAnimator.SetInterpolator(new LinearInterpolator());
                        MessageAdapter.MValueAnimator.AddUpdateListener(this);
                        MessageAdapter.MValueAnimator.Start();
                    }
                }
            }

            //====================== IOnMusicBarAnimationChangeListener ======================
            public void OnHideAnimationEnd()
            {

            }

            public void OnHideAnimationStart()
            {

            }

            public void OnShowAnimationEnd()
            {

            }

            public void OnShowAnimationStart()
            {

            }

            //====================== IOnMusicBarProgressChangeListener ======================

            public void OnProgressChanged(MusicBar musicBarView, int progress, bool fromUser)
            {
                if (fromUser)
                    MessageAdapter.MSeekBarIsTracking = true;
            }

            public void OnStartTrackingTouch(MusicBar musicBarView)
            {
                MessageAdapter.MSeekBarIsTracking = true;
            }

            public void OnStopTrackingTouch(MusicBar musicBarView)
            {
                try
                {
                    MessageAdapter.MSeekBarIsTracking = false;
                    //MusicBarMessageData?.MusicBarViewHolder?.FixedMusicBar?.InitProgressAnimator(1.0f, musicBarView.GetPosition(), MusicBarMessageData.MediaPlayer.Duration);
                    InitValueAnimator(1.0f, musicBarView.GetPosition(), MessageAdapter.MusicBarMessageData.MediaPlayer.Duration);
                    MessageAdapter.MusicBarMessageData?.MediaPlayer?.SeekTo(musicBarView.GetPosition());
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            public void OnAnimationUpdate(ValueAnimator animation)
            {
                try
                {
                    if (MessageAdapter.MSeekBarIsTracking)
                    {
                        animation.Cancel();
                    }
                    else
                    {
                        FixedMusicBar.SetProgress((int)animation.AnimatedValue);
                    }
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }


            #endregion

        }

        public class ContactViewHolder : RecyclerView.ViewHolder, View.IOnClickListener
        {
            #region Variables Basic

            private readonly MessageAdapter MessageAdapter;

            public RelativeLayout LytParent { get; private set; }
            public LinearLayout BubbleLayout { get; private set; }
            public View MainView { get; private set; }
            public TextView UserContactNameTextView { get; private set; }
            public TextView UserNumberTextView { get; private set; }
            public TextView MsgTimeTextView { get; private set; }
            public CircleImageView ProfileImage { get; private set; }
            public TextView Seen { get; private set; }
            public TextView UserName { get; private set; }
            public ImageView StarImage { get; private set; }
            public LottieAnimationView StarIcon { get; private set; }
            public RepliedMessageView RepliedMessageView { get; private set; }
            public ReactionMessageView ReactionMessageView { get; private set; }
            public LinearLayout ForwardLayout { get; private set; }

            #endregion

            public ContactViewHolder(View itemView, Action<MesClickEventArgs> clickListener, Action<MesClickEventArgs> longClickListener, MessageAdapter messageAdapter, bool showName) : base(itemView)
            {
                try
                {
                    MessageAdapter = messageAdapter;

                    MainView = itemView;

                    RepliedMessageView = new RepliedMessageView(itemView, "file");
                    ReactionMessageView = new ReactionMessageView(itemView);

                    LytParent = itemView.FindViewById<RelativeLayout>(Resource.Id.main);
                    BubbleLayout = itemView.FindViewById<LinearLayout>(Resource.Id.bubble_layout);
                    UserContactNameTextView = itemView.FindViewById<TextView>(Resource.Id.contactName);
                    UserNumberTextView = itemView.FindViewById<TextView>(Resource.Id.numberText);
                    MsgTimeTextView = itemView.FindViewById<TextView>(Resource.Id.time);
                    ProfileImage = itemView.FindViewById<CircleImageView>(Resource.Id.profile_image);
                    Seen = itemView.FindViewById<TextView>(Resource.Id.seen);
                    StarImage = itemView.FindViewById<ImageView>(Resource.Id.fav);
                    StarImage.Visibility = ViewStates.Gone;
                    StarIcon = itemView.FindViewById<LottieAnimationView>(Resource.Id.starIcon);
                    StarIcon.Progress = 0;
                    StarIcon.CancelAnimation();
                    StarIcon.Visibility = ViewStates.Gone;

                    ForwardLayout = itemView.FindViewById<LinearLayout>(Resource.Id.ForwardLayout);
                    ForwardLayout.Visibility = ViewStates.Gone;

                    UserName = itemView.FindViewById<TextView>(Resource.Id.name);
                    if (UserName != null) UserName.Visibility = showName ? ViewStates.Visible : ViewStates.Gone;

                    BubbleLayout.SetOnClickListener(this);

                    itemView.Click += (sender, args) => clickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Contact });
                    itemView.LongClick += (sender, args) => longClickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Contact });
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            public void OnClick(View v)
            {
                try
                {
                    if (BindingAdapterPosition != RecyclerView.NoPosition)
                    {
                        var item = MessageAdapter.DifferList[BindingAdapterPosition]?.MesData;
                        if (v.Id == BubbleLayout.Id && item != null)
                        {
                            Methods.App.SaveContacts(MessageAdapter.MainActivity, item.ContactNumber, item.ContactName, "2");
                        }
                    }
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }

        public class VideoViewHolder : RecyclerView.ViewHolder
        {
            #region Variables Basic

            public RelativeLayout LytParent { get; private set; }
            public LinearLayout BubbleLayout { get; private set; }
            public View MainView { get; private set; }
            public ImageView ImageView { get; private set; }
            public ProgressBar LoadingProgressview { get; private set; }
            public TextView MsgTimeTextView { get; private set; }
            public TextView IconView { get; private set; }
            public TextView FilenameTextView { get; private set; }
            public CircleButton PlayButton { get; private set; }
            public TextView UserName { get; private set; }
            public TextView Seen { get; private set; }
            public TextView TxtErrorLoading { get; private set; }
            public ImageView StarImage { get; private set; }
            public LottieAnimationView StarIcon { get; private set; }
            public RepliedMessageView RepliedMessageView { get; private set; }
            public ReactionMessageView ReactionMessageView { get; private set; }
            public LinearLayout ForwardLayout { get; private set; }
            #endregion

            public VideoViewHolder(View itemView, Action<MesClickEventArgs> clickListener, Action<MesClickEventArgs> errorLoadingClickListener, Action<MesClickEventArgs> longClickListener, bool showName) : base(itemView)
            {
                try
                {
                    MainView = itemView;

                    RepliedMessageView = new RepliedMessageView(itemView, "file");
                    ReactionMessageView = new ReactionMessageView(itemView);

                    LytParent = itemView.FindViewById<RelativeLayout>(Resource.Id.main);
                    BubbleLayout = itemView.FindViewById<LinearLayout>(Resource.Id.bubble_layout);
                    ImageView = itemView.FindViewById<ImageView>(Resource.Id.imgDisplay);
                    LoadingProgressview = itemView.FindViewById<ProgressBar>(Resource.Id.loadingProgressview);
                    MsgTimeTextView = itemView.FindViewById<TextView>(Resource.Id.time);
                    IconView = itemView.FindViewById<TextView>(Resource.Id.icon);
                    FilenameTextView = itemView.FindViewById<TextView>(Resource.Id.fileName);
                    PlayButton = itemView.FindViewById<CircleButton>(Resource.Id.playButton);
                    Seen = itemView.FindViewById<TextView>(Resource.Id.seen);
                    StarImage = itemView.FindViewById<ImageView>(Resource.Id.fav);
                    StarImage.Visibility = ViewStates.Gone;
                    StarIcon = itemView.FindViewById<LottieAnimationView>(Resource.Id.starIcon);
                    StarIcon.Progress = 0;
                    StarIcon.CancelAnimation();
                    StarIcon.Visibility = ViewStates.Gone;

                    TxtErrorLoading = itemView.FindViewById<TextView>(Resource.Id.textErrorLoading);

                    ForwardLayout = itemView.FindViewById<LinearLayout>(Resource.Id.ForwardLayout);
                    ForwardLayout.Visibility = ViewStates.Gone;

                    UserName = itemView.FindViewById<TextView>(Resource.Id.name);
                    if (UserName != null) UserName.Visibility = showName ? ViewStates.Visible : ViewStates.Gone;

                    FontUtils.SetTextViewIcon(FontsIconFrameWork.IonIcons, IconView, IonIconsFonts.Camera);

                    if (TxtErrorLoading != null)
                        TxtErrorLoading.Click += (sender, args) => errorLoadingClickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Video });

                    PlayButton.Click += (sender, args) => clickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Video });
                    //itemView.Click += (sender, args) => clickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Video });
                    itemView.LongClick += (sender, args) => longClickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Video });
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }

        public class StickerViewHolder : RecyclerView.ViewHolder
        {
            #region Variables Basic

            public RelativeLayout LytParent { get; private set; }
            public View MainView { get; private set; }
            public ImageView ImageView { get; private set; }
            public ProgressBar LoadingProgressview { get; private set; }
            public TextView Time { get; private set; }
            public TextView UserName { get; private set; }
            public TextView Seen { get; private set; }
            public ImageView StarImage { get; private set; }
            public LottieAnimationView StarIcon { get; private set; }
            public RepliedMessageView RepliedMessageView { get; private set; }
            public ReactionMessageView ReactionMessageView { get; private set; }
            public LinearLayout ForwardLayout { get; private set; }

            #endregion

            public StickerViewHolder(View itemView, Action<MesClickEventArgs> clickListener, Action<MesClickEventArgs> longClickListener, bool showName) : base(itemView)
            {
                try
                {
                    MainView = itemView;

                    RepliedMessageView = new RepliedMessageView(itemView, "file");
                    ReactionMessageView = new ReactionMessageView(itemView);

                    LytParent = itemView.FindViewById<RelativeLayout>(Resource.Id.main);
                    ImageView = itemView.FindViewById<ImageView>(Resource.Id.imgDisplay);
                    LoadingProgressview = itemView.FindViewById<ProgressBar>(Resource.Id.loadingProgressview);
                    Time = itemView.FindViewById<TextView>(Resource.Id.time);
                    Seen = itemView.FindViewById<TextView>(Resource.Id.seen);
                    StarImage = itemView.FindViewById<ImageView>(Resource.Id.fav);
                    StarImage.Visibility = ViewStates.Gone;
                    StarIcon = itemView.FindViewById<LottieAnimationView>(Resource.Id.starIcon);
                    StarIcon.Progress = 0;
                    StarIcon.CancelAnimation();
                    StarIcon.Visibility = ViewStates.Gone;

                    ForwardLayout = itemView.FindViewById<LinearLayout>(Resource.Id.ForwardLayout);
                    ForwardLayout.Visibility = ViewStates.Gone;

                    UserName = itemView.FindViewById<TextView>(Resource.Id.name);
                    if (UserName != null) UserName.Visibility = showName ? ViewStates.Visible : ViewStates.Gone;

                    itemView.Click += (sender, args) => clickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Sticker });
                    itemView.LongClick += (sender, args) => longClickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Sticker });
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }

        public class NotSupportedViewHolder : RecyclerView.ViewHolder
        {
            #region Variables Basic

            public RelativeLayout LytParent { get; private set; }
            public View MainView { get; private set; }
            public AutoLinkTextView AutoLinkNotsupportedView { get; private set; }
            public LinearLayout ForwardLayout { get; private set; }

            #endregion

            public NotSupportedViewHolder(View itemView) : base(itemView)
            {
                try
                {
                    MainView = itemView;
                    LytParent = itemView.FindViewById<RelativeLayout>(Resource.Id.main);
                    AutoLinkNotsupportedView = itemView.FindViewById<AutoLinkTextView>(Resource.Id.active);
                    var time = itemView.FindViewById<TextView>(Resource.Id.time);

                    time.Visibility = ViewStates.Gone;

                    var userName = itemView.FindViewById<TextView>(Resource.Id.name);
                    if (userName != null) userName.Visibility = ViewStates.Gone;
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }

        public class FileViewHolder : RecyclerView.ViewHolder
        {
            #region Variables Basic

            public RelativeLayout LytParent { get; private set; }
            public LinearLayout BubbleLayout { get; private set; }
            public View MainView { get; private set; }
            public TextView FileNameTextView { get; private set; }
            public TextView SizeFileTextView { get; private set; }
            public TextView MsgTimeTextView { get; private set; }
            public TextView IconTypefile { get; private set; }
            public TextView UserName { get; private set; }
            public TextView Seen { get; private set; }
            public ImageView StarImage { get; private set; }
            public LottieAnimationView StarIcon { get; private set; }
            public RepliedMessageView RepliedMessageView { get; private set; }
            public ReactionMessageView ReactionMessageView { get; private set; }
            public LinearLayout ForwardLayout { get; private set; }

            #endregion

            public FileViewHolder(View itemView, Action<MesClickEventArgs> clickListener, Action<MesClickEventArgs> longClickListener, bool showName) : base(itemView)
            {
                try
                {
                    MainView = itemView;

                    RepliedMessageView = new RepliedMessageView(itemView, "file");
                    ReactionMessageView = new ReactionMessageView(itemView);

                    LytParent = itemView.FindViewById<RelativeLayout>(Resource.Id.main);
                    BubbleLayout = itemView.FindViewById<LinearLayout>(Resource.Id.bubble_layout);
                    FileNameTextView = itemView.FindViewById<TextView>(Resource.Id.fileName);
                    SizeFileTextView = itemView.FindViewById<TextView>(Resource.Id.sizefileText);
                    MsgTimeTextView = itemView.FindViewById<TextView>(Resource.Id.time);
                    IconTypefile = itemView.FindViewById<TextView>(Resource.Id.Icontypefile);
                    Seen = itemView.FindViewById<TextView>(Resource.Id.seen);
                    StarImage = itemView.FindViewById<ImageView>(Resource.Id.fav);
                    StarImage.Visibility = ViewStates.Gone;
                    StarIcon = itemView.FindViewById<LottieAnimationView>(Resource.Id.starIcon);
                    StarIcon.Progress = 0;
                    StarIcon.CancelAnimation();
                    StarIcon.Visibility = ViewStates.Gone;

                    ForwardLayout = itemView.FindViewById<LinearLayout>(Resource.Id.ForwardLayout);
                    ForwardLayout.Visibility = ViewStates.Gone;

                    UserName = itemView.FindViewById<TextView>(Resource.Id.name);
                    if (UserName != null) UserName.Visibility = showName ? ViewStates.Visible : ViewStates.Gone;

                    itemView.Click += (sender, args) => clickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.File });
                    itemView.LongClick += (sender, args) => longClickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.File });
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }

        public class ProductViewHolder : RecyclerView.ViewHolder
        {
            #region Variables Basic

            public RelativeLayout LytParent { get; private set; }
            public LinearLayout BubbleLayout { get; private set; }
            public View MainView { get; private set; }
            public ImageView ImageView { get; private set; }
            public TextView Time { get; private set; }
            public TextView Seen { get; private set; }
            public TextView Title { get; private set; }
            public TextView Cat { get; private set; }
            public TextView Price { get; private set; }
            public TextView UserName { get; private set; }
            public ImageView StarImage { get; private set; }
            public LottieAnimationView StarIcon { get; private set; }
            public RepliedMessageView RepliedMessageView { get; private set; }
            public ReactionMessageView ReactionMessageView { get; private set; }
            public LinearLayout ForwardLayout { get; private set; }

            #endregion

            public ProductViewHolder(View itemView, Action<MesClickEventArgs> clickListener, Action<MesClickEventArgs> longClickListener, bool showName) : base(itemView)
            {
                try
                {
                    MainView = itemView;

                    RepliedMessageView = new RepliedMessageView(itemView, "file");
                    ReactionMessageView = new ReactionMessageView(itemView);

                    LytParent = itemView.FindViewById<RelativeLayout>(Resource.Id.main);
                    BubbleLayout = itemView.FindViewById<LinearLayout>(Resource.Id.bubble_layout);
                    ImageView = itemView.FindViewById<ImageView>(Resource.Id.imgDisplay);
                    Time = itemView.FindViewById<TextView>(Resource.Id.time);
                    Seen = itemView.FindViewById<TextView>(Resource.Id.seen);
                    StarImage = itemView.FindViewById<ImageView>(Resource.Id.fav);
                    StarImage.Visibility = ViewStates.Gone;
                    StarIcon = itemView.FindViewById<LottieAnimationView>(Resource.Id.starIcon);
                    StarIcon.Progress = 0;
                    StarIcon.CancelAnimation();
                    StarIcon.Visibility = ViewStates.Gone;

                    Title = itemView.FindViewById<TextView>(Resource.Id.title);
                    Cat = itemView.FindViewById<TextView>(Resource.Id.cat);
                    Price = itemView.FindViewById<TextView>(Resource.Id.price);

                    ForwardLayout = itemView.FindViewById<LinearLayout>(Resource.Id.ForwardLayout);
                    ForwardLayout.Visibility = ViewStates.Gone;

                    UserName = itemView.FindViewById<TextView>(Resource.Id.name);
                    if (UserName != null) UserName.Visibility = showName ? ViewStates.Visible : ViewStates.Gone;

                    itemView.Click += (sender, args) => clickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Product });
                    itemView.LongClick += (sender, args) => longClickListener(new MesClickEventArgs { View = itemView, Position = BindingAdapterPosition, Type = TypeClick.Product });
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }


        public class RepliedMessageView : Java.Lang.Object
        {
            #region Variables Basic

            public View MainView { get; private set; }
            public LinearLayout ColorView { get; private set; }
            public LinearLayout RepliedMessageLayout { get; private set; }
            public TextView TxtOwnerName { get; private set; }
            public TextView TxtMessageType { get; private set; }
            public TextView TxtShortMessage { get; private set; }
            public ImageView MessageFileThumbnail { get; private set; }
            public ImageView BtnCloseReply { get; private set; }

            #endregion

            /// <summary>
            /// 
            /// </summary>
            /// <param name="itemView"></param>
            /// <param name="type">input ,file , text </param>
            public RepliedMessageView(View itemView, string type)
            {
                try
                {
                    MainView = itemView;

                    RepliedMessageLayout = itemView.FindViewById<LinearLayout>(Resource.Id.replied_message_view);
                    ColorView = itemView.FindViewById<LinearLayout>(Resource.Id.color_view);
                    TxtOwnerName = itemView.FindViewById<TextView>(Resource.Id.owner_name);
                    TxtMessageType = itemView.FindViewById<TextView>(Resource.Id.message_type);
                    TxtShortMessage = itemView.FindViewById<TextView>(Resource.Id.short_message);
                    MessageFileThumbnail = itemView.FindViewById<ImageView>(Resource.Id.message_file_thumbnail);
                    BtnCloseReply = itemView.FindViewById<ImageView>(Resource.Id.clear_btn_reply_view);

                    RepliedMessageLayout.Visibility = ViewStates.Gone;
                    BtnCloseReply.Visibility = ViewStates.Gone;
                    MessageFileThumbnail.Visibility = type == "file" ? ViewStates.Visible : ViewStates.Gone;
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }

        public class ReactionMessageView : Java.Lang.Object
        {
            #region Variables Basic

            public View MainView { get; private set; }
            public LinearLayout CountLikeSection { get; private set; }
            public ImageView ImageCountLike { get; private set; }

            #endregion

            public ReactionMessageView(View itemView)
            {
                try
                {
                    MainView = itemView;

                    CountLikeSection = MainView.FindViewById<LinearLayout>(Resource.Id.countLikeSection);
                    ImageCountLike = MainView.FindViewById<ImageView>(Resource.Id.ImagecountLike);
                    CountLikeSection.Visibility = ViewStates.Gone;
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }

        public sealed class MsgPreCachingLayoutManager : LinearLayoutManager
        {
            private readonly Context Context;
            private int ExtraLayoutSpace = -1;
            private readonly int DefaultExtraLayoutSpace = 600;
            private OrientationHelper MOrientationHelper;
            private int MAdditionalAdjacentPrefetchItemCount;

            public MsgPreCachingLayoutManager(Activity context) : base(context)
            {
                try
                {
                    Context = context;
                    Init();
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            private void Init()
            {
                try
                {
                    MOrientationHelper = OrientationHelper.CreateOrientationHelper(this, Orientation);
                    ItemPrefetchEnabled = true;
                    InitialPrefetchItemCount = 30;
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            public void SetExtraLayoutSpace(int space)
            {
                ExtraLayoutSpace = space;
            }

            [Obsolete("deprecated")]
            protected override int GetExtraLayoutSpace(RecyclerView.State state)
            {
                return ExtraLayoutSpace switch
                {
                    > 0 => ExtraLayoutSpace,
                    _ => DefaultExtraLayoutSpace
                };
            }

            public void SetPreloadItemCount(int preloadItemCount)
            {
                MAdditionalAdjacentPrefetchItemCount = preloadItemCount switch
                {
                    < 1 => throw new IllegalArgumentException("adjacentPrefetchItemCount must not smaller than 1!"),
                    _ => preloadItemCount - 1
                };
            }

            public override void OnLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state)
            {
                try
                {
                    base.OnLayoutChildren(recycler, state);
                }
                catch
                {
                    // Console.WriteLine(e); 
                }
            }

            //public override bool SupportsPredictiveItemAnimations()
            //{
            //    try
            //    {
            //        base.SupportsPredictiveItemAnimations();
            //        return false;
            //    }
            //    catch (Exception e)
            //    {
            //        Console.WriteLine(e); 
            //        return base.SupportsPredictiveItemAnimations();
            //    }
            //}

            public override void CollectAdjacentPrefetchPositions(int dx, int dy, RecyclerView.State state, ILayoutPrefetchRegistry layoutPrefetchRegistry)
            {
                try
                {
                    base.CollectAdjacentPrefetchPositions(dx, dy, state, layoutPrefetchRegistry);

                    var delta = Orientation == Horizontal ? dx : dy;
                    if (ChildCount == 0 || delta == 0)
                        return;

                    var layoutDirection = delta > 0 ? 1 : -1;
                    var child = GetChildClosest(layoutDirection);
                    var currentPosition = GetPosition(child) + layoutDirection;

                    if (layoutDirection != 1)
                        return;

                    var scrollingOffset = MOrientationHelper.GetDecoratedEnd(child) - MOrientationHelper.EndAfterPadding;
                    for (var i = currentPosition + 1; i < currentPosition + MAdditionalAdjacentPrefetchItemCount + 1; i++)
                    {
                        switch (i)
                        {
                            case >= 0 when i < state.ItemCount:
                                layoutPrefetchRegistry.AddPosition(i, Java.Lang.Math.Max(0, scrollingOffset));
                                break;
                        }
                    }
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            private View GetChildClosest(int layoutDirection)
            {
                return GetChildAt(layoutDirection == -1 ? 0 : ChildCount - 1);
            }
        }
    }
}