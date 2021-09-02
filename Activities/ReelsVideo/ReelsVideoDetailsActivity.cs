using Android.App;
using Android.Content;
using Android.OS;
using Android.Views;
using System;
using System.Collections.ObjectModel;
using Android.Content.PM;
using AndroidX.AppCompat.App;
using AndroidX.ViewPager2.Widget;
using Newtonsoft.Json;
using WoWonder.Activities.ReelsVideo.Adapters;
using WoWonder.Activities.Tabbes;
using WoWonder.Helpers.Utils; 
using WoWonderClient.Classes.Posts;

namespace WoWonder.Activities.ReelsVideo
{
    [Activity(Icon = "@mipmap/icon", Theme = "@style/DragTransparentBlack", ConfigurationChanges = ConfigChanges.Locale | ConfigChanges.UiMode | ConfigChanges.ScreenSize | ConfigChanges.Orientation | ConfigChanges.ScreenLayout | ConfigChanges.SmallestScreenSize)]
    public class ReelsVideoDetailsActivity : AppCompatActivity
    {
        #region Variables Basic

        private readonly string KeySelectedPage = "KEY_SELECTED_PAGE_REELS";

        private ViewPager2 Pager;
     
        private ReelsVideoPagerAdapter MAdapter;
        private int SelectedPage, VideosCount;
        private ObservableCollection<PostDataObject> DataVideos;
        
        #endregion

        #region General

        protected override void OnCreate(Bundle savedInstanceState)
        {
            try
            {
                base.OnCreate(savedInstanceState);
               
                SetTheme(Resource.Style.Overlap_Dark);

                Methods.App.FullScreenApp(this);

                Overlap();

                if (savedInstanceState != null)
                {
                    SelectedPage = savedInstanceState.GetInt(KeySelectedPage);
                }

                // Create your application here
                SetContentView(Resource.Layout.StoryDetailsLayout);

                TabbedMainActivity.GetInstance()?.SetOnWakeLock();

                if (Intent != null)
                {
                    VideosCount = Intent.GetIntExtra("VideosCount", 0);
                    DataVideos = JsonConvert.DeserializeObject<ObservableCollection<PostDataObject>>(Intent?.GetStringExtra("DataItem") ?? "");
                }

                //Get Value And Set Toolbar
                InitComponent();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        protected override void OnSaveInstanceState(Bundle outState)
        {
            try
            {
                base.OnSaveInstanceState(outState);
                outState.PutInt(KeySelectedPage, Pager.CurrentItem);
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
                TabbedMainActivity.GetInstance()?.SetOffWakeLock();
                GC.Collect(GC.MaxGeneration, GCCollectionMode.Forced);
                DestroyBasic();

                base.OnDestroy();
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

        private void Overlap()
        {
            try
            {
                if (Build.VERSION.SdkInt >= BuildVersionCodes.Lollipop)
                {
                    Window?.SetFlags(WindowManagerFlags.LayoutNoLimits, WindowManagerFlags.LayoutNoLimits);
                } 
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private void InitComponent()
        {
            try
            {
                Pager = FindViewById<ViewPager2>(Resource.Id.viewpager);

                 MAdapter = new ReelsVideoPagerAdapter(this, VideosCount, DataVideos);

                //Pager.CurrentItem = MAdapter.ItemCount;
                //Pager.OffscreenPageLimit = 0;

                Pager.Orientation = ViewPager2.OrientationVertical;
                //Pager.SetPageTransformer(new CustomViewPageTransformer(TransformType.Flow));
                Pager.RegisterOnPageChangeCallback(new MyOnPageChangeCallback(this));
                Pager.Adapter = MAdapter;
                Pager.Adapter.NotifyDataSetChanged();

                Pager.SetCurrentItem(SelectedPage, false);

            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private void DestroyBasic()
        {
            try
            {
                Pager = null!; 
                MAdapter = null!;
                SelectedPage = 0; 
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        #endregion

        #region Result

        protected override void OnActivityResult(int requestCode, Result resultCode, Intent data)
        {
            try
            {
                base.OnActivityResult(requestCode, resultCode, data);
                //var instance = ViewStoryFragment.GetInstance();
                //switch (requestCode)
                //{
                //    case 5326 when resultCode == Result.Ok:
                //        instance?.StoriesProgress?.Resume();
                //        instance?.StoryStateListener?.OnResume();
                //        break;
                //    case 5320 when resultCode == Result.Ok:
                //        {
                //            var isDelete = data.GetBooleanExtra("isDelete", false);
                //            if (isDelete)
                //            {
                //                Finish();
                //            }
                //            else
                //            {
                //                instance?.StoriesProgress?.Resume();
                //                instance?.StoryStateListener?.OnResume();
                //            }

                //            break;
                //        }
                //}
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        #endregion

        private class MyOnPageChangeCallback : ViewPager2.OnPageChangeCallback
        {
            private readonly ReelsVideoDetailsActivity Activity;

            public MyOnPageChangeCallback(ReelsVideoDetailsActivity activity)
            {
                try
                {
                    Activity = activity;
                }
                catch (Exception exception)
                {
                    Methods.DisplayReportResultTrack(exception);
                }
            }

            public override void OnPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
                try
                {
                    base.OnPageScrolled(position, positionOffset, positionOffsetPixels);

                    //var instance = ViewStoryFragment.GetInstance();
                    //instance?.StoryStateListener?.OnPause();
                }
                catch (Exception exception)
                {
                    Methods.DisplayReportResultTrack(exception);
                }
            }
        }
    }
}