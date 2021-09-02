using Android.Runtime;
using System;
using System.Collections.Generic;
using Aghajari.EmojiView.Stickers;
using WoWonder.Helpers.Utils;
using Object = Java.Lang.Object;

namespace WoWonder.Library.Anjo.EmojiView.StickersView
{
    public class ShopSticker : Sticker
    { 
        public string Title { get; private set; }
        public int Count { get; private set; }
        public List<Sticker> ListSticker { get; private set; }
        public bool Added { get; set; }

        protected ShopSticker(IntPtr javaReference, JniHandleOwnership transfer) : base(javaReference, transfer)
        {
        }

        public ShopSticker(Object data) : base(data)
        {
        }

        public ShopSticker(Sticker[] data, string title, int stickersSize , List<Sticker> list , bool added) : base(data)
        {
            try
            {
                Title = title;
                Count = stickersSize;
                ListSticker = list;
                Added = added;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e); 
            }
        }

    }
}