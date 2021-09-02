using Android.Views;
using Android.Widget;
using System;
using System.Collections.ObjectModel;
using Android.App;
using Android.Content.Res;
using Android.Graphics;
using AndroidX.RecyclerView.Widget;
using WoWonder.Helpers.Utils;

namespace WoWonder.Library.Anjo.EmojiView.StickersView
{
    public class ShopAdapter : RecyclerView.Adapter
    {
        public event EventHandler<ShopAdapterClickEventArgs> ItemClick;
        public event EventHandler<ShopAdapterClickEventArgs> ItemLongClick;

        public ObservableCollection<ShopSticker> StickerList = new ObservableCollection<ShopSticker>();

        public ShopAdapter(ShopStickers shopStickers)
        {
            try
            {
                shopStickers.GetStickers(); 
                StickerList = new ObservableCollection<ShopSticker>(ShopStickers.ShopStickersList);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public override int ItemCount => StickerList?.Count ?? 0;

        // Create new views (invoked by the layout manager)
        public override RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType)
        {
            try
            {
                //Setup your layout here >> Style_Categories_View
                var itemView = LayoutInflater.From(parent.Context)?.Inflate(Resource.Layout.Style_ShopStickersView, parent, false);
                var vh = new ShopAdapterViewHolder(itemView, Click);
                return vh;
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
                return null!;
            }
        }
         
        // Replace the contents of a view (invoked by the layout manager)
        public override void OnBindViewHolder(RecyclerView.ViewHolder viewHolder, int position)
        {
            try
            {
                if (viewHolder is ShopAdapterViewHolder holder)
                {
                    var item = StickerList[position];
                    if (item == null) return;

                    holder.Title.Text = item.Title;
                    holder.SubTitle.Text = item.Count + " Sticker";

                    if (item.Added)
                    {
                        holder.Add.Text = Application.Context.GetText(Resource.String.Lbl_Remove);
                        holder.Add.BackgroundTintList = ColorStateList.ValueOf(Color.ParseColor("#888888"));
                    }
                    else
                    {
                        holder.Add.Text = Application.Context.GetText(Resource.String.Lbl_Add);
                        holder.Add.BackgroundTintList = ColorStateList.ValueOf(Color.ParseColor(AppSettings.MainColor));
                    }

                    if (item.ListSticker.Count > 0)
                    {
                        holder.Stickers.SetAdapter(new IconAdapter(item.ListSticker));
                    }
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        public ShopSticker GetItem(int position)
        {
            return StickerList[position];
        }

        public override long GetItemId(int position)
        {
            try
            {
                return position;
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
                return 0;
            }
        }

        public override int GetItemViewType(int position)
        {
            try
            {
                return position;
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
                return 0;
            }
        }

        private void Click(ShopAdapterClickEventArgs args)
        {
            ItemClick?.Invoke(this, args);
        }

        private void LongClick(ShopAdapterClickEventArgs args)
        {
            ItemLongClick?.Invoke(this, args);
        }
    }

    public class ShopAdapterViewHolder : RecyclerView.ViewHolder  
    {
        #region Variables Basic

        public View MainView { get; private set; }

        public TextView Title { get; private set; }
        public TextView SubTitle { get; private set; }
        public Button Add { get; private set; }
        public RecyclerView Stickers { get; private set; }

        #endregion
        public ShopAdapterViewHolder(View itemView, Action<ShopAdapterClickEventArgs> clickListener) : base(itemView)
        {
            try
            {
                MainView = itemView;

                Title = itemView.FindViewById<TextView>(Resource.Id.title);
                SubTitle = itemView.FindViewById<TextView>(Resource.Id.subtitle);
                Add = itemView.FindViewById<Button>(Resource.Id.add);
                Stickers = itemView.FindViewById<RecyclerView>(Resource.Id.rv);
                Stickers?.SetLayoutManager(new GridLayoutManager(itemView.Context, 4));

                //Create an Event 
                Add.Click += (sender, e) => clickListener(new ShopAdapterClickEventArgs { View = itemView, Position = BindingAdapterPosition });
                //itemView.LongClick += (sender, e) => longClickListener(new ShopAdapterClickEventArgs { View = itemView, Position = BindingAdapterPosition }); 
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        } 
    }

    public class ShopAdapterClickEventArgs : EventArgs
    {
        public View View { get; set; }
        public int Position { get; set; }
    }
}