﻿using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using Android.App;

using Android.Views;
using Android.Widget;
using AndroidX.RecyclerView.Widget;
using Bumptech.Glide;
using Java.Util;
using WoWonder.Helpers.CacheLoaders;
using WoWonder.Helpers.Utils;
using WoWonderClient.Classes.Games;
using IList = System.Collections.IList;

namespace WoWonder.Activities.Games.Adapters
{
    public class MyGamesAdapter : RecyclerView.Adapter, ListPreloader.IPreloadModelProvider
    {
        public event EventHandler<MyGamesAdapterViewHolderClickEventArgs> ItemClick;
        public event EventHandler<MyGamesAdapterViewHolderClickEventArgs> ItemLongClick;

        private readonly Activity ActivityContext;

        public ObservableCollection<GamesDataObject> GamesList = new ObservableCollection<GamesDataObject>();

        public MyGamesAdapter(Activity context)
        {
            try
            {
                ActivityContext = context;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        // Create new views (invoked by the layout manager)
        public override RecyclerView.ViewHolder OnCreateViewHolder(ViewGroup parent, int viewType)
        {
            try
            {
                //Setup your layout here >> Style_LastActivities_View
                View itemView = LayoutInflater.From(parent.Context)
                    .Inflate(Resource.Layout.Style_GamesView, parent, false);
                var vh = new MyGamesAdapterViewHolder(itemView, Click, LongClick);
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
                switch (viewHolder)
                {
                    case MyGamesAdapterViewHolder holder:
                    {
                        var item = GamesList[position];
                        if (item != null)
                        {
                            GlideImageLoader.LoadImage(ActivityContext, item.GameAvatar, holder.Image,ImageStyle.CenterCrop, ImagePlaceholders.Drawable);
                            holder.Title.Text = Methods.FunString.DecodeString(item.GameName);
                        }

                        break;
                    }
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }
        public override void OnViewRecycled(Java.Lang.Object holder)
        {
            try
            {
                if (ActivityContext?.IsDestroyed != false)
                        return;

                switch (holder)
                {
                    case MyGamesAdapterViewHolder viewHolder:
                        Glide.With(ActivityContext).Clear(viewHolder.Image);
                        break;
                }
                base.OnViewRecycled(holder);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
        public override int ItemCount => GamesList?.Count ?? 0;

        public GamesDataObject GetItem(int position)
        {
            return GamesList[position];
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

        void Click(MyGamesAdapterViewHolderClickEventArgs args) => ItemClick?.Invoke(this, args);
        void LongClick(MyGamesAdapterViewHolderClickEventArgs args) => ItemLongClick?.Invoke(this, args);

        public IList GetPreloadItems(int p0)
        {
            try
            {
                var d = new List<string>();
                var item = GamesList[p0];
                switch (item)
                {
                    case null:
                        return d;
                    default:
                    {
                        switch (string.IsNullOrEmpty(item.GameAvatar))
                        {
                            case false:
                                d.Add(item.GameAvatar);
                                break;
                        }

                        return d;
                    }
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                return Collections.SingletonList(p0);
            }
        }

        public RequestBuilder GetPreloadRequestBuilder(Java.Lang.Object p0)
        {
            return GlideImageLoader.GetPreLoadRequestBuilder(ActivityContext, p0.ToString(), ImageStyle.CenterCrop);
        }
    }

    public class MyGamesAdapterViewHolder : RecyclerView.ViewHolder
    {
        #region Variables Basic

        public View MainView { get; private set; }

        public ImageView Image { get; private set; }
        public TextView Title { get; private set; }

        #endregion

        public MyGamesAdapterViewHolder(View itemView, Action<MyGamesAdapterViewHolderClickEventArgs> clickListener, Action<MyGamesAdapterViewHolderClickEventArgs> longClickListener) : base(itemView)
        {
            try
            {
                MainView = itemView;
                Image = (ImageView)MainView.FindViewById(Resource.Id.image);
                Title = (TextView)MainView.FindViewById(Resource.Id.title);

                //Create an Event
                itemView.Click += (sender, e) => clickListener(new MyGamesAdapterViewHolderClickEventArgs { View = itemView, Position = BindingAdapterPosition });
                itemView.LongClick += (sender, e) => longClickListener(new MyGamesAdapterViewHolderClickEventArgs { View = itemView, Position = BindingAdapterPosition });
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
    }

    public class MyGamesAdapterViewHolderClickEventArgs : EventArgs
    {
        public View View { get; set; }
        public int Position { get; set; }
    }
}