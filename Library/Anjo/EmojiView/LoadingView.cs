using System;
using Aghajari.EmojiView.Utilities;
using Aghajari.EmojiView.Views;
using Android.Content;
using Android.Runtime;
using Android.Util;
using Android.Widget;
using WoWonder.Helpers.Utils;

namespace WoWonder.Library.Anjo.EmojiView
{
    public class LoadingView : AXEmojiLayout
    {
        private ProgressBar ProgressBar;
        protected LoadingView(IntPtr javaReference, JniHandleOwnership transfer) : base(javaReference, transfer)
        {
        }

        public LoadingView(Context context) : base(context)
        {
            Init(context);
        }

        public LoadingView(Context context, IAttributeSet attrs) : base(context, attrs)
        {
            Init(context);
        }

        public LoadingView(Context context, IAttributeSet attrs, int defStyleAttr) : base(context, attrs, defStyleAttr)
        {
            Init(context); 
        }

        private void Init(Context context)
        {
            try
            {
                ProgressBar = new ProgressBar(context);
                AddView(ProgressBar, new LayoutParams(0, 0, Utils.DpToPx(context, 44), Utils.DpToPx(context, 44)));
                ProgressBar.Indeterminate = true;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e); 
            }
        }

        protected override void OnSizeChanged(int w, int h, int oldw, int oldh)
        {
            try
            {
                base.OnSizeChanged(w, h, oldw, oldh);

                var layoutParams = (LayoutParams) ProgressBar.LayoutParameters; 
                if (layoutParams != null)
                {
                    layoutParams.Left = w / 2 - Utils.DpToPx(Context, 22);
                    layoutParams.Top = h / 2 - Utils.DpToPx(Context, 44);
                }

                RequestLayout();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e); 
            }

        }
    }
}