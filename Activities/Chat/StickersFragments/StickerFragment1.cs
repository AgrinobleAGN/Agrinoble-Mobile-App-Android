using System;
using Android.OS;
using Android.Views;
using AndroidX.RecyclerView.Widget;
using WoWonder.Activities.Chat.ChatWindow.Adapters;
using WoWonder.Helpers.Model;
using WoWonder.Helpers.Utils;

namespace WoWonder.Activities.Chat.StickersFragments
{
    public class StickerFragment1 : AndroidX.Fragment.App.Fragment
    {

        private RecyclerView StickerRecyclerView;
        private GridLayoutManager MLayoutManager;
        private StickerRecylerAdapter.StickerAdapter StickerAdapter;
        private readonly string Type;
        public StickerFragment1(string type = "ChatWindowActivity")
        {
            Type = type;
        }

        public override View OnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            try
            {
                View view = inflater.Inflate(Resource.Layout.StickerFragment, container, false);
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

                StickerRecyclerView = (RecyclerView)view.FindViewById(Resource.Id.stickerRecyler1);

                MLayoutManager = new GridLayoutManager(Activity.ApplicationContext, AppSettings.StickersOnEachRow, LinearLayoutManager.Vertical, false);
                StickerRecyclerView.SetLayoutManager(MLayoutManager);
                StickerAdapter = new StickerRecylerAdapter.StickerAdapter(Activity, Stickers.StickerList1);
                StickerRecyclerView.SetAdapter(StickerAdapter);
                StickerItemClickListener clickListener = new StickerItemClickListener(Activity, Type, StickerAdapter);
                Console.WriteLine(clickListener);
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

    }
}