using System;
using Android.Graphics;
using Android.OS;
using Android.Views;
using AndroidX.ViewPager2.Widget;
using Google.Android.Material.Tabs;
using WoWonder.Activities.Chat.ChatWindow.Adapters;
using WoWonder.Activities.Chat.StickersFragments;
using WoWonder.Helpers.Utils;

namespace WoWonder.Activities.Chat.PageChat.Fragment
{
    public class PageChatStickersTabFragment : AndroidX.Fragment.App.Fragment, TabLayoutMediator.ITabConfigurationStrategy
    {
        private TabLayout Tabs;

        public override View OnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            try
            {
                View view = inflater.Inflate(Resource.Layout.ChatStickersTabFragment, container, false);
                return view;
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

                Tabs = view.FindViewById<TabLayout>(Resource.Id.tabsSticker);
                ViewPager2 viewPager = view.FindViewById<ViewPager2>(Resource.Id.viewpagerSticker);
                //AppBarLayout appBarLayoutview = view.FindViewById<AppBarLayout>(Resource.Id.appbarSticker);

                SetUpViewPager(viewPager);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private void SetUpViewPager(ViewPager2 viewPager)
        {
            try
            {
                StickersTabAdapter adapter = new StickersTabAdapter(this);
                if (AppSettings.ShowStickerStack0)
                    adapter.AddFragment(new StickerFragment1("PageChatWindowActivity"), "0");

                if (AppSettings.ShowStickerStack1)
                    adapter.AddFragment(new StickerFragment2("PageChatWindowActivity"), "1");

                if (AppSettings.ShowStickerStack2)
                    adapter.AddFragment(new StickerFragment3("PageChatWindowActivity"), "2");

                if (AppSettings.ShowStickerStack3)
                    adapter.AddFragment(new StickerFragment4("PageChatWindowActivity"), "3");

                if (AppSettings.ShowStickerStack4)
                    adapter.AddFragment(new StickerFragment5("PageChatWindowActivity"), "4");

                if (AppSettings.ShowStickerStack5)
                    adapter.AddFragment(new StickerFragment6("PageChatWindowActivity"), "5");

                if (AppSettings.ShowStickerStack6)
                    adapter.AddFragment(new StickerFragment7("PageChatWindowActivity"), "6");

                viewPager.Adapter = adapter;
                new TabLayoutMediator(Tabs, viewPager, this).Attach();
                Tabs.SetBackgroundColor(!AppSettings.SetTabDarkTheme ? Color.ParseColor(AppSettings.StickersBarColor) : Color.ParseColor(AppSettings.StickersBarColorDark));

                if (Tabs.TabCount > 0)
                {
                    for (int i = 0; i <= Tabs.TabCount; i++)
                    {
                        var stickerReplacer = Tabs.GetTabAt(i);
                        if (stickerReplacer != null)
                        {
                            if (stickerReplacer.Text == "0")
                                stickerReplacer.SetIcon(Resource.Drawable.Sticker1).SetText("");

                            if (stickerReplacer.Text == "1")
                                stickerReplacer.SetIcon(Resource.Drawable.sticker2).SetText("");

                            if (stickerReplacer.Text == "2")
                                stickerReplacer.SetIcon(Resource.Drawable.Sticker3).SetText("");

                            if (stickerReplacer.Text == "3")
                                stickerReplacer.SetIcon(Resource.Drawable.Sticker4).SetText("");

                            if (stickerReplacer.Text == "4")
                                stickerReplacer.SetIcon(Resource.Drawable.Sticker5).SetText("");

                            if (stickerReplacer.Text == "5")
                                stickerReplacer.SetIcon(Resource.Drawable.Sticker6).SetText("");

                            if (stickerReplacer.Text == "6")
                                stickerReplacer.SetIcon(Resource.Drawable.Sticker7).SetText("");
                        }
                    }
                }
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

        public void OnConfigureTab(TabLayout.Tab p0, int p1)
        {

        }
    }
}