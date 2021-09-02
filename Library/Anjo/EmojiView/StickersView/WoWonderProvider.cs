using System.Collections.Generic;
using System.Linq;
using Aghajari.EmojiView;
using Aghajari.EmojiView.Stickers;
using Android.Graphics.Drawables;
using Android.Views;
using Android.Widget;
using AndroidX.AppCompat.Content.Res;
using AndroidX.Core.Graphics.Drawable;
using Bumptech.Glide;
using Bumptech.Glide.Request;
using Java.Lang;
using WoWonder.Helpers.Utils;
using Exception = System.Exception;
using Object = Java.Lang.Object;

namespace WoWonder.Library.Anjo.EmojiView.StickersView
{
    public class WoWonderProvider : Object, IStickerProvider
    { 
        public IStickerCategory[] GetCategories()
        {
            try
            {
                List<IStickerCategory> stickerCategories = new List<IStickerCategory> {new ShopStickers()};

                if (ListUtils.StickersList.Count > 0)
                {
                    var list = ListUtils.StickersList.Where(a => a.Visibility).ToList();
                    if (list?.Count > 0)
                    {
                        stickerCategories.AddRange(list.Select(sticker => new WoWonderStickers(sticker.IdSticker)));
                    } 
                }

                return stickerCategories.ToArray();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                return new IStickerCategory[] { new ShopStickers() };
            } 
        }

        public bool IsRecentEnabled => true;

        public IStickerLoader Loader => new MyStickerLoader();
         
        private class MyStickerLoader : Object, IStickerLoader
        {
            public void OnLoadSticker(View view, Sticker sticker)
            {
                try
                {
                    var data = (string) sticker.Data;
                    if (data != null)
                    {
                        Glide.With(view).Load(data).Apply(RequestOptions.FitCenterTransform()).Into((ImageView)view);
                    }
                    else
                    {
                        Glide.With(view).Load(sticker.Data).Apply(RequestOptions.FitCenterTransform()).Into((ImageView)view);
                    } 
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e); 
                } 
            }

            public void OnLoadStickerCategory(View icon, IStickerCategory stickerCategory, bool selected)
            {
                try
                {
                    var image = (ImageView) icon;
                    if (image != null)
                    {
                        if (stickerCategory is ShopStickers shopStickers)
                        {
                            Drawable dr0 = AppCompatResources.GetDrawable(icon.Context, (int)shopStickers.CategoryData);
                            Drawable dr = dr0.GetConstantState()?.NewDrawable();
                            if (selected)
                            {
                                DrawableCompat.SetTint(DrawableCompat.Wrap(dr), AXEmojiManager.EmojiViewTheme.SelectedColor);
                            }
                            else
                            {
                                DrawableCompat.SetTint(DrawableCompat.Wrap(dr), AXEmojiManager.EmojiViewTheme.DefaultColor);
                            }

                            image?.SetImageDrawable(dr);
                        }
                        else
                        {
                            Glide.With(icon).Load(Integer.ValueOf(stickerCategory.CategoryData.ToString())).Apply(RequestOptions.FitCenterTransform()).Into(image);
                        }
                    } 
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }
    }
}