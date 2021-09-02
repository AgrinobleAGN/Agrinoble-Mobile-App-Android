using System;
using Android.Views;
using System.Collections.Generic;
using System.Linq;
using Aghajari.EmojiView.Stickers;
using AndroidX.RecyclerView.Widget;
using WoWonder.Helpers.Utils;
using WoWonder.SQLite;
using Object = Java.Lang.Object;

namespace WoWonder.Library.Anjo.EmojiView.StickersView
{
    public class ShopStickers : Object, IStickerCategory
    {
        public static List<ShopSticker> ShopStickersList { private set; get; }
        private ShopAdapter MAdapter;
        public void BindView(View view)
        {
            try
            {
                if (view is RecyclerView recyclerView)
                {
                    MAdapter = new ShopAdapter(this);
                    MAdapter.ItemClick += MAdapterOnItemClick;
                    recyclerView.SetAdapter(MAdapter);
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e); 
            } 
        }

        private void MAdapterOnItemClick(object sender, ShopAdapterClickEventArgs e)
        {
            try
            {
                var item = MAdapter?.StickerList[e.Position];
                if (item != null)
                {
                    if (item.Added == false)
                    { 
                        item.Added = true;
                    }
                    else if (item.Added)
                    { 
                        item.Added = false;
                    } 
                    var sqLiteDatabase = new SqLiteDatabase();
                    sqLiteDatabase.Update_To_StickersTable(item.Title, item.Added);

                    EmojisViewTools.StickerView?.RefreshNow();
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception); 
            }
        }

        public View GetEmptyView(ViewGroup viewGroup)
        {
            return null!;
        }

        public Sticker[] GetStickers()
        { 
            try
            {
                ShopStickersList = new List<ShopSticker>();

                if (ListUtils.StickersList.Count > 0)
                {
                    foreach (var stickers in ListUtils.StickersList)
                    {
                        var listSticker = new WoWonderStickers(stickers.IdSticker).GetStickers();
                        ShopStickersList.Add(new ShopSticker(listSticker, stickers.Name, listSticker.Length, listSticker.ToList(), stickers.Visibility));
                    }
                }
                 
                return ShopStickersList?.ToArray();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                return new Sticker[] { };
            }
        }

        public View GetView(ViewGroup viewGroup)
        {
            try
            {
                RecyclerView recyclerView = new RecyclerView(viewGroup.Context);
                recyclerView.SetLayoutManager(new LinearLayoutManager(viewGroup.Context));
                recyclerView.OverScrollMode = OverScrollMode.Never;
                //recyclerView.HasFixedSize = true;
                //recyclerView.SetItemViewCacheSize(10);
                //recyclerView.GetLayoutManager().ItemPrefetchEnabled = true;

                return recyclerView;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                return null!;
            }
        }

        public bool UseCustomView()
        {
            return true;
        }

        public Object CategoryData => Resource.Drawable.ic_masks_msk; 
    }
}