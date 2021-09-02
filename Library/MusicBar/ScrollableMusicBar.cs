using System;
using Android.Content;
using Android.Content.Res;
using Android.Graphics;
using Android.Runtime;
using Android.Util;
using Android.Views;
using AndroidX.Core.Content;
using WoWonder.Helpers.Utils;

namespace WoWonder.Library.MusicBar
{
    public class ScrollableMusicBar : MusicBar
    {
        private float StartY, StopY, StartX;
        private bool IsDivided;
        private float MDividerSize = 2;
        private Paint MLoadedBarSecondaryPaint, MBackgroundBarSecondaryPaint;
        private int TopBar, BottomBar;
        private readonly Context Maincontext;

        protected ScrollableMusicBar(IntPtr javaReference, JniHandleOwnership transfer) : base(javaReference, transfer)
        {
        }

        public ScrollableMusicBar(Context context) : base(context)
        {
            Maincontext = context;
            Init();
        }

        public ScrollableMusicBar(Context context, IAttributeSet attrs) : base(context, attrs)
        {
            Maincontext = context;
            Init();
            LoadAttribute(context, attrs);
        }

        public ScrollableMusicBar(Context context, IAttributeSet attrs, int defStyleAttr) : base(context, attrs,
            defStyleAttr)
        {
            Maincontext = context;
            Init();
            LoadAttribute(context, attrs);
        }

        public ScrollableMusicBar(Context context, IAttributeSet attrs, int defStyleAttr, int defStyleRes) : base(
            context, attrs, defStyleAttr, defStyleRes)
        {
            Maincontext = context;
            Init();
            LoadAttribute(context, attrs);
        }

        private void Init()
        {
            try
            {
                MBackgroundBarSecondaryPaint = new Paint
                {
                    Color = new Color(ContextCompat.GetColor(Maincontext, Resource.Color.BackgroundBarSecondaryColor)),
                    StrokeCap = Paint.Cap.Square,
                    StrokeWidth = MBarWidth
                };

                MLoadedBarSecondaryPaint = new Paint
                {
                    Color = new Color(ContextCompat.GetColor(Maincontext, Resource.Color.LoadedBarSecondaryColor)),
                    StrokeCap = Paint.Cap.Square,
                    StrokeWidth = MBarWidth
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

                MLoadedBarSecondaryPaint.Color = typedArray.GetColor(
                    Resource.Styleable.MusicBar_LoadedBarSecondaryColor,
                    ContextCompat.GetColor(context, Resource.Color.LoadedBarSecondaryColor));
                MBackgroundBarSecondaryPaint.Color = typedArray.GetColor(
                    Resource.Styleable.MusicBar_backgroundBarSecondaryColor,
                    ContextCompat.GetColor(context, Resource.Color.BackgroundBarSecondaryColor));
                IsDivided = typedArray.GetBoolean(Resource.Styleable.MusicBar_divided, false);
                MDividerSize = typedArray.GetFloat(Resource.Styleable.MusicBar_dividerSize, 2);

                MBarWidth = typedArray.GetFloat(Resource.Styleable.MusicBar_barWidth, 3);

                MLoadedBarPrimeColor.StrokeWidth = MBarWidth;
                MBackgroundBarPrimeColor.StrokeWidth = MBarWidth;
                MLoadedBarSecondaryPaint.StrokeWidth = MBarWidth;
                MBackgroundBarSecondaryPaint.StrokeWidth = MBarWidth;

                MDividerSize = MBarWidth + MDividerSize;
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

        protected override void OnDraw(Canvas canvas)
        {
            try
            {
                if (IsNewLoad && MStream != null && MStreamLength > 0)
                {
                    MBarHeight = GetBarHeight(FixData(GetBitPerSec()));
                    IsNewLoad = false;
                }

                if (MMaxNumOfBar == 0)
                    MMaxNumOfBar = (int) (Width / (MBarWidth + MSpaceBetweenBar));

                if (MBarHeight != null && MBarHeight.Length > 0)
                {

                    int baseLine = GetBaseLine();

                    int startBar = MSeekToPosition - MMaxNumOfBar / 2;
                    if (startBar < 0) startBar = 0;
                    int endBar = startBar + MMaxNumOfBar;
                    if (endBar > MBarHeight.Length) endBar = MBarHeight.Length;

                    int height;
                    for (int i = startBar; i < endBar; i++)
                    {
                        height = MBarHeight[i];

                        if (IsAnimated)
                        {
                            height = height - MAnimatedValue;
                            if (height <= 0) height = MMinBarHeight;
                        }

                        if (MSeekToPosition < MMaxNumOfBar / 2)
                            StartX = 2 + Width / 2 - MSeekToPosition * (MBarWidth + MSpaceBetweenBar)
                                     + (i - startBar) * (MBarWidth + MSpaceBetweenBar);
                        else
                            StartX = 2 + (i - startBar) * (MBarWidth + MSpaceBetweenBar);

                        if (IsDivided)
                        {
                            DrawDividedBar(canvas, height, baseLine);
                        }
                        else
                        {
                            DrawStraightBar(canvas, height, baseLine);
                        }
                    }
                }

                base.OnDraw(canvas);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }


        private void DrawDividedBar(Canvas canvas, int height, int baseLine)
        {

            try
            {
                BottomBar = height / 8 * 3;
                if (BottomBar < MMinBarHeight) BottomBar = MMinBarHeight;
                StartY = baseLine + MDividerSize / 2 + BottomBar;

                TopBar = height / 8 * 5;
                if (TopBar < MMinBarHeight) TopBar = MMinBarHeight;
                StopY = baseLine - MDividerSize / 2 - TopBar;

                if (StartX < Width / 2)
                {
                    canvas.DrawLine(StartX, StartY, StartX, baseLine + MDividerSize / 2, MLoadedBarSecondaryPaint);
                    canvas.DrawLine(StartX, baseLine - MDividerSize / 2, StartX, StopY, MLoadedBarPrimeColor);
                }
                else
                {
                    canvas.DrawLine(StartX, StartY, StartX, baseLine + MDividerSize / 2,
                        MBackgroundBarSecondaryPaint);
                    canvas.DrawLine(StartX, baseLine - MDividerSize / 2, StartX, StopY, MBackgroundBarPrimeColor);
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private void DrawStraightBar(Canvas canvas, int height, int baseLine)
        {
            try
            {
                StartY = baseLine + height / 2;
                StopY = StartY - height;
                if (StartX < Width / 2)
                {
                    canvas.DrawLine(StartX, StartY, StartX, StopY, MLoadedBarPrimeColor);
                }
                else
                {
                    canvas.DrawLine(StartX, StartY, StartX, StopY, MBackgroundBarPrimeColor);
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private int GetBaseLine()
        {
            if (IsDivided)
            {
                return Height / 8 * 5;
            }
            else
            {
                return Height / 2;
            }
        }

        public override bool OnTouchEvent(MotionEvent e)
        {
            try
            {
                Parent.RequestDisallowInterceptTouchEvent(true);
                switch (e.Action)
                {
                    case MotionEventActions.Down:
                        OnStartTrackingTouch();
                        Pressed = true;
                        MFirstTouchX = e.GetX();
                        break;
                    case MotionEventActions.Move:
                        Pressed = true;
                        UpdateView(e, MFirstTouchX);
                        MFirstTouchX = e.GetX();
                        break;
                    case MotionEventActions.Up:
                        OnStopTrackingTouch();
                        Parent.RequestDisallowInterceptTouchEvent(false);
                        Pressed = false;
                        break;
                    case MotionEventActions.Cancel:
                        OnStopTrackingTouch();
                        Parent.RequestDisallowInterceptTouchEvent(false);
                        Pressed = false;
                        break;
                }

                return true;
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
                return base.OnTouchEvent(e);
            }
        }

        private void UpdateView(MotionEvent e, float firstTouchX)
        {
            try
            {
                //Log.i(TAG, "updateView: " + mSeekToPosition);

                float secondTouch = e.GetX();
                int distance = (int) ((secondTouch - firstTouchX) / (MBarWidth + MSpaceBetweenBar));

                MSeekToPosition -= distance;
                if (MSeekToPosition < 0)
                {
                    MSeekToPosition = 0;
                }
                else if (MSeekToPosition > MBarHeight.Length)
                {
                    MSeekToPosition = MBarHeight.Length;
                }
                else
                {
                    if (MMusicBarChangeListener != null)
                    {
                        MMusicBarChangeListener.OnProgressChanged(this, MSeekToPosition, true);
                        IsTracking = true;
                    }
                }

                Invalidate();
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }


        /// <summary>
        /// Set if music bar divided or not.
        /// default value false.
        /// </summary>
        /// <param name="divided">the divided</param>
        public void SetDivided(bool divided)
        {
            IsDivided = divided;
        }

        /// <summary>
        /// Set divider size in px.
        /// </summary>
        /// <param name="size">the size in px</param>
        public void SetDividerSize(float size)
        {
            MDividerSize = size;
        }

        /// <summary> Set Secondary loaded color .
        /// Default Value #eca277. 
        /// </summary>
        /// <param name="color">the color</param>
        public void SetLoadedBarSecondaryColor(Color color)
        {
            MLoadedBarSecondaryPaint.Color = color;
        }

        /// <summary>
        /// Sets Secondary background color.
        /// Default Value #c4bbbb
        /// </summary>
        /// <param name="color">the color</param>
        public void SetBackgroundBarSecondaryColor(Color color)
        {
            MBackgroundBarSecondaryPaint.Color = color;
        }

        /// <summary>
        /// Set bar width.
        /// for ScrollableMusicBar Default Value 3
        /// Recommend to make barWidth equal spaceBetweenBar
        /// </summary>
        /// <param name="barWidth">the bar width</param>
        public override void SetBarWidth(float barWidth)
        {
            base.SetBarWidth(barWidth);

            if (barWidth > 0)
            {
                MBackgroundBarSecondaryPaint.StrokeWidth = barWidth;
                MLoadedBarSecondaryPaint.StrokeWidth = barWidth;
            }
        }

    }
}