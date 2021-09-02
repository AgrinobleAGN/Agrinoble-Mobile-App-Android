using System;
using System.Collections.Generic;
using System.Linq;
using Android.Animation;
using Android.Content;
using Android.Content.Res;
using Android.Graphics;
using Android.Runtime;
using Android.Util;
using Android.Views;
using Android.Views.Animations;
using AndroidX.Core.Content;
using Java.IO;
using WoWonder.Helpers.Utils;

namespace WoWonder.Library.MusicBar
{
    public class MusicBar : View 
    {
        protected int[] MBarHeight;
        protected int Position ,MTrackDurationInMilliSec, MMaxNumOfBar = 0, MBarDuration = 1000, MAnimatedValue = 0, MStreamLength = 0, MMaxDataPerBar = 0, MSpaceBetweenBar = 2, MSeekToPosition = -1, MMaxBarHeight = 0, MMinBarHeight;
        protected float MBarWidth = 2, MPlaybackSpeed = 1.0f, MFirstTouchX = 0;
        protected bool IsNewLoad, IsHide, IsShow = true, IsAnimated, IsTracking , IsAutoProgress;
        protected Paint MLoadedBarPrimeColor, MBackgroundBarPrimeColor;
        protected IOnMusicBarProgressChangeListener MMusicBarChangeListener;
        protected IOnMusicBarAnimationChangeListener MMusicBarAnimationChangeListener;
        protected ValueAnimator MBarAnimator;
        protected ValueAnimator MProgressAnimator;
        public readonly int AnimationTypeShow = 0, AnimationTypeHide = 1;
        protected InputStream MStream;
        private readonly Context Maincontext;

        protected MusicBar(IntPtr javaReference, JniHandleOwnership transfer) : base(javaReference, transfer)
        {
        }

        public MusicBar(Context context) : base(context)
        {
            Maincontext = context;
            Init();
        }

        public MusicBar(Context context, IAttributeSet attrs) : base(context, attrs)
        {
            Maincontext = context;
            Init();
            LoadAttribute(context, attrs);
        }

        public MusicBar(Context context, IAttributeSet attrs, int defStyleAttr) : base(context, attrs, defStyleAttr)
        {
            Maincontext = context;
            Init();
            LoadAttribute(context, attrs);
        }

        public MusicBar(Context context, IAttributeSet attrs, int defStyleAttr, int defStyleRes) : base(context, attrs, defStyleAttr, defStyleRes)
        {
            Maincontext = context;
            Init();
            LoadAttribute(context, attrs);
        }

        private void Init()
        {
            try
            {
                MBackgroundBarPrimeColor = new Paint
                {
                    Color = new Color(ContextCompat.GetColor(Maincontext, Resource.Color.BackgroundBarPrimeColor)),
                    StrokeCap = Paint.Cap.Square,
                    StrokeWidth = MBarWidth,
                    AntiAlias = true
                };

                MLoadedBarPrimeColor = new Paint
                {
                    Color = new Color(ContextCompat.GetColor(Maincontext, Resource.Color.LoadedBarPrimeColor)),
                    StrokeCap = Paint.Cap.Square,
                    StrokeWidth = MBarWidth, 
                    AntiAlias = true
                };
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private void LoadAttribute(Context context, IAttributeSet attrs)
        {
            TypedArray typedArray = context.Theme.ObtainStyledAttributes(attrs, Resource.Styleable.MusicBar, 0, 0);

            try
            {

                MSpaceBetweenBar = typedArray.GetInteger(Resource.Styleable.MusicBar_spaceBetweenBar, 2);

                MBarWidth = typedArray.GetFloat(Resource.Styleable.MusicBar_barWidth, 2);
                MLoadedBarPrimeColor.StrokeWidth = MBarWidth;
                MBackgroundBarPrimeColor.StrokeWidth = MBarWidth;

                MLoadedBarPrimeColor.Color = typedArray.GetColor(Resource.Styleable.MusicBar_LoadedBarPrimeColor, ContextCompat.GetColor(context, Resource.Color.LoadedBarPrimeColor));
                MBackgroundBarPrimeColor.Color = typedArray.GetColor(Resource.Styleable.MusicBar_backgroundBarPrimeColor, ContextCompat.GetColor(context, Resource.Color.BackgroundBarPrimeColor));
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
            finally
            {
                typedArray.Recycle();
            }
        }

        /// <summary>
        /// load the music file from file path and music duration in millisecond
        /// </summary>
        /// <param name="stream">music file path</param>
        /// <param name="duration">music duration in millisecond</param>
        public void LoadFrom(InputStream stream, int duration)
        {
            try
            {
                MStream = stream;
                MTrackDurationInMilliSec = duration;
                try
                {
                    MStreamLength = stream.Available();
                }
                catch (IOException e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
                IsNewLoad = true;
                MSeekToPosition = -1;
                IsAutoProgress = false;
                Invalidate(); 
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        /// <summary>
        /// load the music file from file path and music duration in millisecond
        /// </summary>
        /// <param name="pathname">music file path</param>
        /// <param name="duration">music duration in millisecond</param>
        public void LoadFrom(string pathname, int duration)
        {
            File file = new File(pathname);
            try
            {
                InputStream stream = new FileInputStream(file);
                LoadFrom(stream, duration);
            }
            catch (IOException e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        protected int[] GetBitPerSec()
        {
            var data = GetBitPer(MTrackDurationInMilliSec / 500);
            var dataPerSec = new int[MTrackDurationInMilliSec / 1000];
            for (var i = 0; i < MTrackDurationInMilliSec / 1000; i++)
            {
                dataPerSec[i] = (data[i * 2] + data[i * 2 + 1]) / 2;
            }

            return dataPerSec;
        }

        protected int[] GetBarHeight(int[] data)
        {
            try
            {
                int[] barHeight = new int[data.Length];
            
                MMaxBarHeight = Height - PaddingBottom - PaddingTop;
                MMinBarHeight = MMaxBarHeight / 100;
                if (MMinBarHeight == 0) MMinBarHeight = 1;
                if (MMaxDataPerBar == 0) MMaxDataPerBar = 1;
                for (int i = 0; i < data.Length; i++)
                {
                    barHeight[i] = data[i] * MMaxBarHeight / MMaxDataPerBar;
                }

                for (int i = 0; i < barHeight.Length; i++)
                {
                    if (barHeight[i] >= 110)
                        barHeight[i] = GetHeightRandom();

                    if (barHeight[i] == 0)
                    {
                        if (i == 0)
                            barHeight[i] = barHeight[i + 1] / 2;
                        else if (i == barHeight.Length - 1)
                            barHeight[i] = barHeight[i - 1] / 2;
                        else
                            barHeight[i] = barHeight[i - 1] + barHeight[i + 1];
                    }

                    if (barHeight[i] == 0)
                        barHeight[i] = MMinBarHeight;

                    if (barHeight[i] > MMaxBarHeight)
                        barHeight[i] = MMaxBarHeight;
                     
                    if (barHeight[i] % 2 != 0) barHeight[i] = barHeight[i] + 1; 
                }

                return barHeight;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                return data;
            }
        }

        private static readonly Random Random = new Random();

        private static int GetHeightRandom()
        {
            try
            {
                int h;
                int b = Random.Next(4);
                switch (b)
                {
                    case 2:
                        h = 67;
                        break;
                    case 1:
                        h = 80;
                        break;
                    case 0:
                        h = 90;
                        break;
                    default:
                        h = 70;
                        break;
                }

                return h;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                return 70;
            }
        }

        protected int[] GetBitPer(int numOfBar)
        {
            int[] data = new int[numOfBar];
            try
            {
                int bitRate = MStream.Available() / numOfBar;
                byte[] buffer = new byte[bitRate];
                for (int i = 0; i < data.Length; i++)
                {
                    int temp = 0;
                    MStream.Read(buffer, 0, bitRate);
                    for (int j = 0; j < buffer.Length; j++)
                    {
                        temp += buffer[j];
                    }
                    data[i] = Math.Abs(temp);
                }
                MStream.Close();
            }
            catch (IOException e)
            {
                Methods.DisplayReportResultTrack(e);
            }

            return data;
        }

        private int GetMedium(int[] data)
        {
            int total = data.Sum();
            return total / data.Length;
        }

        protected int[] FixData(int[] data)
        {
            try
            {
                int mid = GetMedium(data);
                List<int> test = new List<int>();

                MMaxDataPerBar = 0;
                for (int i = 0; i < data.Length; i++)
                {
                    if (data[i] >= mid * 2) data[i] = mid;
                    if (i + 1 < data.Length && data[i + 1] >= mid * 2) data[i + 1] = mid;

                    if (data[i] >= mid)
                    {
                        test.Add(data[i]);
                        if (i == data.Length - 1)
                        {
                            data[i] = data[i - 1] / 2;
                        }
                        else if (i == 0)
                        {
                            data[i] = data[i + 1] / 2;
                        }
                        else
                        {
                            data[i] = (data[i + 1] + data[i - 1]) / 2;
                        }
                    }

                    if (data[i] > mid * 1.0) data[i] = (int)(mid * 1.0);

                    if (MMaxDataPerBar < data[i]) MMaxDataPerBar = data[i];
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e); 
            }
            return data;
        }

        protected void OnStartTrackingTouch()
        {
            try
            {
                if (MMusicBarChangeListener != null)
                {
                    MMusicBarChangeListener.OnStartTrackingTouch(this);
                    IsTracking = true;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        protected void OnStopTrackingTouch()
        {
            try
            {
                if (MMusicBarChangeListener != null)
                {
                    MMusicBarChangeListener.OnStopTrackingTouch(this);
                    IsTracking = false;
                    if (IsAutoProgress)
                    {
                        InitProgressAnimator(MPlaybackSpeed, GetPosition(), MTrackDurationInMilliSec);
                    }
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private void InitBarAnimator(int start, int end, int animationType)
        {
            try
            {
                if (MBarAnimator == null)
                {
                    MBarAnimator = ValueAnimator.OfInt(start, end);
                    MBarAnimator.SetDuration(1000);
                    MBarAnimator.AddUpdateListener(new MyBarAnimatorUpdateListener(this));
                    MBarAnimator.AddListener(new MyBarAnimatorListener(this, animationType));

                    MBarAnimator.Start();
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public void ClearBarAnimator()
        {
            try
            {
                if (MBarAnimator != null)
                {
                    MBarAnimator.RemoveAllUpdateListeners();
                    MBarAnimator.RemoveAllListeners();
                    MBarAnimator.Cancel();
                    //MBarAnimator = null!;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public void InitProgressAnimator(float playbackSpeed, int progress, int max)
        {
            try
            {
                int timeToEnd = (int) ((max - progress) / playbackSpeed);
                if (timeToEnd > 0)
                {
                    if (ValueAnimator.OfInt(progress, max).SetDuration(timeToEnd) is ValueAnimator value)
                    {
                        MProgressAnimator = value;
                        MProgressAnimator.SetInterpolator(new LinearInterpolator());
                        MProgressAnimator.AddUpdateListener(new MyProgressAnimatorUpdateListener(this));
                        MProgressAnimator.AddListener(new MyProgressAnimatorListener(this));
                        MProgressAnimator.Start();
                    } 
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public void SetProgressAnimator(ValueAnimator progressAnimator)
        {
            MProgressAnimator = progressAnimator;
        }

        /// <summary>
        /// update view position when auto progress work
        /// </summary>
        /// <param name="position"></param>
        public void SetAutoProgressPosition(int position)
        {
            try
            {
                if (position >= 0 && position <= MTrackDurationInMilliSec)
                {
                    if (MSeekToPosition != position / MBarDuration)
                    {
                        MSeekToPosition = position / MBarDuration;
                        MMusicBarChangeListener?.OnProgressChanged(this, MSeekToPosition, false);

                        Invalidate();
                    }
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        /// <summary>
        /// clear auto progress animator
        /// </summary>
        private void ClearProgressAnimator()
        {
            try
            {
                if (MProgressAnimator != null)
                {
                    MProgressAnimator.RemoveAllUpdateListeners();
                    MProgressAnimator.RemoveAllListeners();
                    MProgressAnimator.Cancel();
                    //MProgressAnimator = null!;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
         
        /// <summary>
        /// start auto play animation should be called after
        /// loadFrom() and media player finished prepare
        /// if startAutoProgress() called before loadFrom()
        /// it will throw exception because duration is 0
        /// </summary>
        /// <param name="playbackSpeed">playback speed from media player default value 1.0F for MediaPlayer and ExoPlayer</param>
        public void StartAutoProgress(float playbackSpeed)
        {
            try
            {
                if (MTrackDurationInMilliSec > 0)
                {
                    IsAutoProgress = true;
                    MPlaybackSpeed = playbackSpeed;
                    InitProgressAnimator(playbackSpeed, 0, MTrackDurationInMilliSec);
                }
                else
                {
                    try
                    {
                        throw new Exception("track duration less than 0 note startAutoProgress() should be called after loadFrom()");
                    }
                    catch (Exception e)
                    {
                        Methods.DisplayReportResultTrack(e);
                    }
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        /// <summary>
        /// stop auto progress animation
        /// </summary>
        public void StopAutoProgress()
        {
            try
            {
                IsAutoProgress = false;
                ClearProgressAnimator();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
        /// <summary>
        /// Is auto progress.
        /// </summary>
        /// <returns></returns>
        public bool IsAutoProgressBar()
        {
            return IsAutoProgress;
        }

        public bool IsHideBar()
        {
            return IsHide;
        }

        /// <summary>
        /// Start Hide Animation. if view is hide nothing will happened
        /// </summary>
        public void Hide()
        {
            if (!IsHide && MMaxBarHeight != 0)
            {
                IsAnimated = true;
                InitBarAnimator(0, MMaxBarHeight, AnimationTypeHide);
            }
        }

        /// <summary>
        /// Start Show Animation. if view is Show nothing will happened
        /// </summary>
        public void Show()
        {
            try
            {
                if (!IsShow && MMaxBarHeight != 0)
                {
                    IsAnimated = true;
                    InitBarAnimator(MMaxBarHeight, 0, AnimationTypeShow);
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public bool IsShowBar()
        {
            return IsShow;
        }

        public void SetProgress(int position)
        {
            try
            {
                if (position >= 0 && position <= MTrackDurationInMilliSec)
                {
                    if (MSeekToPosition != position / MBarDuration)
                    {
                        MSeekToPosition = position / MBarDuration;
                        //Log.i(TAG, "setProgress: " + mSeekToPosition);
                        MMusicBarChangeListener?.OnProgressChanged(this, MSeekToPosition, false);

                        if (IsAutoProgress)
                        {
                            ClearProgressAnimator();
                            InitProgressAnimator(MPlaybackSpeed, position, MTrackDurationInMilliSec);
                        }

                        Invalidate();
                    }
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public int GetPosition()
        {
            Position = MSeekToPosition * MBarDuration;
            return Position;
        }


        public void SetProgressChangeListener(IOnMusicBarProgressChangeListener musicBarChangeListener)
        {
            MMusicBarChangeListener = musicBarChangeListener;
        }

        public void SetAnimationChangeListener(IOnMusicBarAnimationChangeListener musicBarAnimationChangeListener)
        {
            MMusicBarAnimationChangeListener = musicBarAnimationChangeListener;
        }


        /// <summary>
        /// Remove AnimationChangeListener and ProgressChangeListener
        /// </summary>
        public void RemoveAllListener()
        {
            MMusicBarAnimationChangeListener = null!;
            MMusicBarChangeListener = null!;
        }

        public void SetLoadedBarPrimeColor(Color color)
        {
            MLoadedBarPrimeColor.Color = color;
        }
         
        /// <summary>
        /// Set Prime background bar color. Default Value #dfd6d6
        /// </summary>
        /// <param name="color">color the color</param>
        public void SetBackgroundBarPrimeColor(Color color)
        {
            MBackgroundBarPrimeColor.Color = color;
        }
         
        /// <summary>
        /// Set space between bar. Default Value 2
        /// Recommend to make spaceBetweenBar equal barWidth
        /// </summary>
        /// <param name="spaceBetweenBar">spaceBetweenBar the space between bar</param>
        public void SetSpaceBetweenBar(int spaceBetweenBar)
        {
            try
            {
                if (spaceBetweenBar > 0)
                {
                    MSpaceBetweenBar = spaceBetweenBar;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        } 

        /// <summary>
        /// Set bar width.
        /// for FixedMusicBar Default Value 2
        /// for ScrollableMusicBar Default Value 3
        /// Recommend to make barWidth equal spaceBetweenBar
        /// </summary>
        /// <param name="barWidth">barWidth the bar width</param>
        public virtual void SetBarWidth(float barWidth)
        {
            if (barWidth > 0)
            {
                MBarWidth = barWidth;
                MBackgroundBarPrimeColor.StrokeWidth = barWidth;
                MLoadedBarPrimeColor.StrokeWidth = barWidth;
            }
        }

        protected override void OnDetachedFromWindow()
        {
            try
            {
                base.OnDetachedFromWindow();
                RemoveAllListener();
                if (MProgressAnimator != null)
                {
                    ClearProgressAnimator();
                }

                if (MBarAnimator != null)
                {
                    ClearBarAnimator();
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public interface IOnMusicBarProgressChangeListener
        {
            void OnProgressChanged(MusicBar musicBar, int progress, bool fromUser);
            void OnStartTrackingTouch(MusicBar musicBar);
            void OnStopTrackingTouch(MusicBar musicBar);
        }

        public interface IOnMusicBarAnimationChangeListener
        {
            /// <summary>
            /// Notification that Hide Animation Start
            /// </summary>
            void OnHideAnimationStart();

            /// <summary>
            /// Notification that Hide Animation Start
            /// </summary>
            void OnHideAnimationEnd();

            /// <summary>
            /// Notification that Show Animation Start
            /// </summary>
            void OnShowAnimationStart();

            /// <summary>
            /// Notification that Show Animation End
            /// </summary>
            void OnShowAnimationEnd();
        }

        #region Animator.IAnimatorListener

        private class MyProgressAnimatorListener : Java.Lang.Object, Animator.IAnimatorListener
        {
            private readonly MusicBar MusicBar;
            public MyProgressAnimatorListener(MusicBar musicBar)
            {
                MusicBar = musicBar;
            }

            public void OnAnimationCancel(Animator animation)
            {

            }

            public void OnAnimationEnd(Animator animation)
            {
                MusicBar.ClearProgressAnimator(); 
            }

            public void OnAnimationRepeat(Animator animation)
            {

            }

            public void OnAnimationStart(Animator animation)
            {

            }
        }

        private class MyBarAnimatorListener : Java.Lang.Object, Animator.IAnimatorListener
        {
            private readonly MusicBar MusicBar;
            private readonly int AnimationType;
            public MyBarAnimatorListener(MusicBar musicBar, int animationType)
            {
                MusicBar = musicBar;
                AnimationType = animationType;
            }

            public void OnAnimationCancel(Animator animation)
            {
                try
                {
                    if (AnimationType == MusicBar.AnimationTypeShow)
                    {
                        MusicBar.IsShow = true;
                        MusicBar.IsHide = false;
                        MusicBar.MMusicBarAnimationChangeListener?.OnShowAnimationEnd();
                    }
                    else
                    {
                        MusicBar.IsHide = true;
                        MusicBar.IsShow = false;
                        MusicBar.MMusicBarAnimationChangeListener?.OnHideAnimationEnd();
                    }

                    MusicBar.ClearBarAnimator();
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            public void OnAnimationEnd(Animator animation)
            {
                try
                {
                    if (AnimationType == MusicBar.AnimationTypeShow)
                    {
                        MusicBar.IsShow = true;
                        MusicBar.IsHide = false;
                        MusicBar.MMusicBarAnimationChangeListener?.OnShowAnimationEnd();
                    }
                    else
                    {
                        MusicBar.IsHide = true;
                        MusicBar.IsShow = false;
                        MusicBar.MMusicBarAnimationChangeListener?.OnHideAnimationEnd();
                    }

                    MusicBar.ClearBarAnimator(); 
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            public void OnAnimationRepeat(Animator animation)
            {

            }

            public void OnAnimationStart(Animator animation)
            {
                try
                {
                    if (AnimationType == MusicBar.AnimationTypeShow)
                    {
                        MusicBar.MMusicBarAnimationChangeListener?.OnShowAnimationStart();
                    }
                    else
                    {
                        MusicBar.MMusicBarAnimationChangeListener?.OnHideAnimationStart();
                    }
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }
         
        #endregion

        #region ValueAnimator.IAnimatorUpdateListener

        private class MyProgressAnimatorUpdateListener : Java.Lang.Object , ValueAnimator.IAnimatorUpdateListener
        {
            private readonly MusicBar MusicBar;
            public MyProgressAnimatorUpdateListener(MusicBar musicBar)
            {
                MusicBar = musicBar; 
            }
            public void OnAnimationUpdate(ValueAnimator animation)
            {
                if (MusicBar.IsTracking || !MusicBar.IsAutoProgress)
                {
                    MusicBar.ClearProgressAnimator();
                }
                else
                {
                    MusicBar.SetAutoProgressPosition((int)animation.AnimatedValue);
                }
            }
        }
         
        private class MyBarAnimatorUpdateListener : Java.Lang.Object , ValueAnimator.IAnimatorUpdateListener
        {
            private readonly MusicBar MusicBar;
            public MyBarAnimatorUpdateListener(MusicBar musicBar)
            {
                MusicBar = musicBar; 
            }

            public void OnAnimationUpdate(ValueAnimator animation)
            {
                MusicBar.MAnimatedValue = (int)animation.AnimatedValue;
                MusicBar.Invalidate();
            }
        }
         
        #endregion

    }
}