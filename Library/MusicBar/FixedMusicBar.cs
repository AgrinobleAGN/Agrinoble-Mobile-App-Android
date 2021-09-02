using System;
using Android.Content;
using Android.Graphics;
using Android.Runtime;
using Android.Util;
using Android.Views;
using WoWonder.Helpers.Utils;

namespace WoWonder.Library.MusicBar
{
    public class FixedMusicBar : MusicBar
    {
        private float StartX;
        private float StartY;
        private new float Top;

        protected FixedMusicBar(IntPtr javaReference, JniHandleOwnership transfer) : base(javaReference, transfer)
        {
        }

        public FixedMusicBar(Context context) : base(context)
        {
        }

        public FixedMusicBar(Context context, IAttributeSet attrs) : base(context, attrs)
        {
        }

        public FixedMusicBar(Context context, IAttributeSet attrs, int defStyleAttr) : base(context, attrs, defStyleAttr)
        {
        }

        public FixedMusicBar(Context context, IAttributeSet attrs, int defStyleAttr, int defStyleRes) : base(context, attrs, defStyleAttr, defStyleRes)
        {
            
        }

        protected override void OnDraw(Canvas canvas)
        {
            if (MMaxNumOfBar == 0)
                MMaxNumOfBar = (int)((Width - PaddingLeft - PaddingRight) / (MBarWidth + MSpaceBetweenBar));

            if (IsNewLoad && MStream != null && MStreamLength > 0)
            {
                MBarHeight = GetBarHeight(FixData(GetBitPer(MMaxNumOfBar)));

                MBarDuration = MTrackDurationInMilliSec / MMaxNumOfBar;
                IsNewLoad = false;
            }

            if (MBarHeight != null && MBarHeight.Length > 0)
            { 
                int baseLine = Height / 2;
                for (int i = 0; i < MBarHeight.Length; i++)
                {
                    int height = MBarHeight[i];

                    if (IsAnimated)
                    {
                        height -= MAnimatedValue;
                        if (height <= 0) height = MMinBarHeight;
                    }

                    StartX = PaddingLeft + i * (MBarWidth + MSpaceBetweenBar);
                    StartY = baseLine + height / 2;
                    Top = StartY - height;

                    canvas.DrawLine(StartX, StartY, StartX, Top, i <= MSeekToPosition ? MLoadedBarPrimeColor : MBackgroundBarPrimeColor);
                }
            }

            base.OnDraw(canvas);
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
                        UpdateView(e);
                        Pressed = true;
                        break;
                    case MotionEventActions.Move:
                        Pressed = true;
                        UpdateView(e);
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

        private void UpdateView(MotionEvent e)
        {
            try
            {
                MSeekToPosition = (int) (e.GetX() / (MBarWidth + MSpaceBetweenBar));
                //Log.i(TAG, "updateView: " + mSeekToPosition);
                if (MSeekToPosition < 0)
                {
                    MSeekToPosition = 0;
                }
                else if (MSeekToPosition > MMaxNumOfBar)
                {
                    MSeekToPosition = MMaxNumOfBar;
                }
                else
                {
                    Invalidate();
                    if (MMusicBarChangeListener != null)
                    {
                        MMusicBarChangeListener.OnProgressChanged(this, MSeekToPosition, true);
                        IsTracking = true;
                    }
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }
    }
}