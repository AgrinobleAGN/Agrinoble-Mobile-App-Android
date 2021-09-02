using System;
using Android.App;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using AndroidX.RecyclerView.Widget;
using WoWonder.Helpers.CacheLoaders;
using WoWonder.Helpers.Utils;

namespace WoWonder.Activities.Chat.ChatWindow.Adapters
{
    public class StickerRecylerAdapter
    {
        public class StickerViewHolder : RecyclerView.ViewHolder
        {

            public View MainView { get; private set; }
            public ImageView ImageAsync { get; private set; }

            public StickerViewHolder(View itemView, Action<AdapterClickEvents> listener) : base(itemView)
            {
                try
                {
                    MainView = itemView;
                    ImageAsync = itemView.FindViewById<ImageView>(Resource.Id.stickerImage);
                    itemView.Click += (sender, e) => listener(new AdapterClickEvents
                    {
                        View = itemView,
                        Position = BindingAdapterPosition
                    });

                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);

                }
            }
        }

        public class AdapterClickEvents : EventArgs
        {
            public View View { get; set; }
            public int Position { get; set; }
        }

        public class StickerAdapter : RecyclerView.Adapter
        {
            public event EventHandler<AdapterClickEvents> OnItemClick;
            public static RecyclerView Recylercontrol;
            private readonly JavaList<string> StickerRecylerList;
            private readonly Activity ActivityContext;

            public StickerAdapter(Activity context, JavaList<string> stickerList)
            {
                ActivityContext = context;
                StickerRecylerList = stickerList;
            }

            // Create new views (invoked by the layout manager)
            public override RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType)
            {
                //Setup your layout here //  First RUN

                View row = LayoutInflater.From(parent.Context)?.Inflate(Resource.Layout.Style_StickerView, parent, false);

                var vh = new StickerViewHolder(row, OnClick);
                return vh;
            }

            // Replace the contents of a view (invoked by the layout manager)
            public override void OnBindViewHolder(RecyclerView.ViewHolder viewHolder, int position)
            {
                try
                {
                    // Replace the contents of the view with that element
                    if (viewHolder is StickerViewHolder holder)
                    {
                        var item = StickerRecylerList[position];
                        if (item != null)
                        {
                            if (!string.IsNullOrEmpty(item))
                            {
                                //Set image 
                                GlideImageLoader.LoadImage(ActivityContext, item, holder.ImageAsync, ImageStyle.CenterCrop, ImagePlaceholders.Drawable);
                                Methods.MultiMedia.DownloadMediaTo_DiskAsync(Methods.Path.FolderDiskSticker, item);


                            }
                            else
                            {
                                GlideImageLoader.LoadImage(ActivityContext, "ImagePlacholder_circel", holder.ImageAsync, ImageStyle.CenterCrop, ImagePlaceholders.Drawable);

                            }
                        }
                    }
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            private void OnClick(AdapterClickEvents args)
            {
                OnItemClick?.Invoke(this, args);
            }

            public override int ItemCount => StickerRecylerList?.Count ?? 0;

            public string GetItem(int position)
            {
                return StickerRecylerList[position];
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

        }
    }
}