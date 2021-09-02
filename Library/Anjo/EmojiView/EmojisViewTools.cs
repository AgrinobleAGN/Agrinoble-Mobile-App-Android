using System;
using System.Linq;
using Aghajari.EmojiView;
using Aghajari.EmojiView.Listeners;
using Aghajari.EmojiView.Stickers;
using Aghajari.EmojiView.Utilities;
using Aghajari.EmojiView.Views;
using Android.App;
using Android.Content;
using Android.Graphics;
using Android.Graphics.Drawables;
using Android.OS;
using Android.Views;
using Android.Widget;
using AndroidX.AppCompat.Content.Res;
using AndroidX.Core.Graphics.Drawable;
using Bumptech.Glide;
using Bumptech.Glide.Request;
using Java.Lang;
using WoWonder.Activities.Chat.ChatWindow;
using WoWonder.Activities.Chat.GroupChat;
using WoWonder.Activities.Chat.PageChat;
using WoWonder.Activities.Comment;
using WoWonder.Activities.Story;
using WoWonder.Helpers.Controller;
using WoWonder.Helpers.Model;
using WoWonder.Helpers.Utils;
using WoWonder.Library.Anjo.EmojiView.StickersView;
using WoWonderClient.Classes.Message;
using Exception = System.Exception;

namespace WoWonder.Library.Anjo.EmojiView
{
    public class EmojisViewTools
    {
        public static bool MEmojiView = true;
        public static bool MSingleEmojiView = false;
        public static bool MStickerView = true;
        public static bool MCustomView = false;
        public static bool MFooterView = true;
        public static bool MCustomFooter = false;
        public static bool MWhiteCategory = true;

        private static bool DarkMode = false;
        public static AXStickerView StickerView;

        public static void LoadTheme(string mainColor)
        {
            try
            {
                // release theme
                DarkMode = false;
                AXEmojiManager.ResetTheme();

                var color = Color.ParseColor(mainColor);

                // set EmojiView Theme
                AXEmojiManager.EmojiViewTheme.FooterEnabled = MFooterView && !MCustomFooter;
                AXEmojiManager.EmojiViewTheme.SelectionColor = color;
                AXEmojiManager.EmojiViewTheme.FooterSelectedItemColor = color;
                AXEmojiManager.StickerViewTheme.SelectionColor = color;

                if (MWhiteCategory)
                {
                    AXEmojiManager.EmojiViewTheme.SelectionColor = Color.Transparent;
                    AXEmojiManager.EmojiViewTheme.SelectedColor = color;
                    AXEmojiManager.EmojiViewTheme.CategoryColor = Color.White;
                    AXEmojiManager.EmojiViewTheme.FooterBackgroundColor = Color.White;
                    AXEmojiManager.EmojiViewTheme.SetAlwaysShowDivider(true);

                    AXEmojiManager.StickerViewTheme.SelectedColor = color;
                    AXEmojiManager.StickerViewTheme.CategoryColor = Color.White;
                    AXEmojiManager.StickerViewTheme.SetAlwaysShowDivider(true);
                }

                AXEmojiManager.BackspaceCategoryEnabled = !MCustomFooter;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public static void LoadDarkTheme()
        {
            try
            {
                // release theme
                DarkMode = true;
                AXEmojiManager.ResetTheme();

                // set EmojiView Theme
                AXEmojiManager.EmojiViewTheme.FooterEnabled = MFooterView && !MCustomFooter;
                AXEmojiManager.EmojiViewTheme.SelectionColor = Color.ParseColor("#82ADD9");
                AXEmojiManager.EmojiViewTheme.SelectedColor = Color.ParseColor("#82ADD9");
                AXEmojiManager.EmojiViewTheme.FooterSelectedItemColor = Color.ParseColor("#82ADD9");
                AXEmojiManager.EmojiViewTheme.BackgroundColor = Color.ParseColor("#1E2632");
                AXEmojiManager.EmojiViewTheme.CategoryColor = Color.ParseColor("#1E2632");
                AXEmojiManager.EmojiViewTheme.FooterBackgroundColor = Color.ParseColor("#1E2632");
                AXEmojiManager.EmojiViewTheme.VariantPopupBackgroundColor = Color.ParseColor("#232D3A");
                AXEmojiManager.EmojiViewTheme.VariantDividerEnabled = false;
                AXEmojiManager.EmojiViewTheme.DividerColor = Color.ParseColor("#1B242D");
                AXEmojiManager.EmojiViewTheme.DefaultColor = Color.ParseColor("#677382");
                AXEmojiManager.EmojiViewTheme.TitleColor = Color.ParseColor("#677382");

                AXEmojiManager.StickerViewTheme.SelectionColor = Color.ParseColor("#82ADD9");
                AXEmojiManager.StickerViewTheme.SelectedColor = Color.ParseColor("#82ADD9");
                AXEmojiManager.StickerViewTheme.BackgroundColor = Color.ParseColor("#1E2632");
                AXEmojiManager.StickerViewTheme.CategoryColor = Color.ParseColor("#1E2632");
                AXEmojiManager.StickerViewTheme.DividerColor = Color.ParseColor("#1B242D");
                AXEmojiManager.StickerViewTheme.DefaultColor = Color.ParseColor("#677382");

                if (MWhiteCategory)
                {
                    AXEmojiManager.EmojiViewTheme.SelectionColor = Color.Transparent;
                    AXEmojiManager.EmojiViewTheme.CategoryColor = Color.ParseColor("#232D3A");
                    AXEmojiManager.EmojiViewTheme.FooterBackgroundColor = Color.ParseColor("#232D3A");
                    AXEmojiManager.EmojiViewTheme.SetAlwaysShowDivider(true);

                    AXEmojiManager.StickerViewTheme.CategoryColor = Color.ParseColor("#232D3A");
                    AXEmojiManager.StickerViewTheme.SetAlwaysShowDivider(true);
                }
                AXEmojiManager.BackspaceCategoryEnabled = !MCustomFooter;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public static AXEmojiPager LoadView(Activity context, AXEmojiEditText editText, string typePage)
        {
            try
            {
                AXEmojiPager emojiPager = new AXEmojiPager(context);

                if (MSingleEmojiView)
                {
                    //add single emoji view
                    AXSingleEmojiView singleEmojiView = new AXSingleEmojiView(context);
                    emojiPager.AddPage(singleEmojiView, Resource.Drawable.ic_action_sentiment_satisfied_alt);
                }

                if (MEmojiView)
                {
                    // add emoji view (with viewpager)
                    AXEmojiView emojiView = new AXEmojiView(context);
                    emojiPager.AddPage(emojiView, Resource.Drawable.ic_action_sentiment_satisfied_alt);
                }

                if (MStickerView)
                {
                    //add Sticker View
                    StickerView = new AXStickerView(context, "stickers", new WoWonderProvider());
                    emojiPager.AddPage(StickerView, Resource.Drawable.ic_msg_panel_stickers);
                    StickerView.SetOnStickerActionsListener(new MyStickerActions(context, typePage));
                }

                if (MCustomView)
                {
                    emojiPager.AddPage(new LoadingView(context), Resource.Drawable.msg_round_load_m);
                }

                editText.SetEmojiSize(Utils.DpToPx(context, 23));
                // set target emoji edit text to emojiViewPager
                emojiPager.EditText = editText;

                emojiPager.SetSwipeWithFingerEnabled(true);

                if (MCustomFooter)
                {
                    InitCustomFooter(context, emojiPager);
                }
                else
                {
                    //wael remove icon search
                    //emojiPager.SetLeftIcon(Resource.Drawable.ic_action_search);
                    //emojiPager.SetOnFooterItemClicked(new MyFooterItemClicked()); 
                }

                return emojiPager;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                return null!;
            }

        }

        public static void InitCustomFooter(Context context, AXEmojiPager emojiPager)
        {
            try
            {
                FrameLayout footer = new FrameLayout(context);
                Drawable drawable = AppCompatResources.GetDrawable(context, Resource.Drawable.circle);
                if (DarkMode) DrawableCompat.SetTint(DrawableCompat.Wrap(drawable), Color.ParseColor("#1B242D"));
                footer.Background = drawable;
                if (Build.VERSION.SdkInt >= BuildVersionCodes.Lollipop)
                {
                    footer.Elevation = Utils.Dp(context, 4);
                }

                var lp = new AXEmojiLayout.LayoutParams(Utils.Dp(context, 48), Utils.Dp(context, 48))
                {
                    RightMargin = Utils.Dp(context, 12),
                    BottomMargin = Utils.Dp(context, 12)
                };
                footer.LayoutParameters = lp;
                emojiPager.SetCustomFooter(footer, true);

                ImageView img = new ImageView(context);
                var lp2 = new FrameLayout.LayoutParams(Utils.Dp(context, 22), Utils.Dp(context, 22))
                {
                    Gravity = GravityFlags.Center
                };
                footer.AddView(img, lp2);

                emojiPager.SetOnEmojiPageChangedListener(new MyEmojiPagerPageChanged(context, footer, img));
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private class MyEmojiPagerPageChanged : Java.Lang.Object, IOnEmojiPagerPageChanged, View.IOnClickListener
        {
            private readonly Context Context;
            private readonly FrameLayout Footer;
            private readonly ImageView Img;
            public MyEmojiPagerPageChanged(Context context, FrameLayout footer, ImageView img)
            {
                try
                {
                    Context = context;
                    Footer = footer;
                    Img = img;
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            public void OnPageChanged(AXEmojiPager emojiPager, AXEmojiBase @base, int position)
            {
                try
                {
                    Drawable drawable;
                    if (AXEmojiManager.IsAXEmojiView(@base))
                    {
                        drawable = AppCompatResources.GetDrawable(Context, Resource.Drawable.emoji_backspace);
                        Utils.EnableBackspaceTouch(Footer, emojiPager.EditText);
                        Footer.SetOnClickListener(null);
                    }
                    else
                    {
                        drawable = AppCompatResources.GetDrawable(Context, Resource.Drawable.ic_action_search);
                        Footer.SetOnTouchListener(null);
                        Footer.SetOnClickListener(this);
                    }
                    DrawableCompat.SetTint(DrawableCompat.Wrap(drawable), AXEmojiManager.EmojiViewTheme.FooterItemColor);
                    Img.SetImageDrawable(drawable);
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            public void OnClick(View v)
            {
                try
                {
                    ToastUtils.ShowToast(Application.Context, "Search Clicked", ToastLength.Short);
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }

        private class MyStickerActions : Java.Lang.Object, IOnStickerActions
        {
            private readonly CommentActivity CommentActivity;
            private readonly ChatWindowActivity ChatWindow;
            private readonly GroupChatWindowActivity GroupActivityView;
            private readonly PageChatWindowActivity PageActivityView;
            private readonly StoryReplyActivity StoryReplyActivity;
            private readonly string TimeNow = DateTime.Now.ToString("hh:mm");
            private readonly string TypePage;

            public MyStickerActions(Activity activity, string typePage)
            {
                try
                {
                    TypePage = typePage;

                    switch (typePage)
                    {
                        // Create your fragment here
                        case "CommentActivity":
                            CommentActivity = (CommentActivity)activity;
                            break;
                        case "ChatWindowActivity":
                            ChatWindow = (ChatWindowActivity)activity;
                            break;
                        case "PageChatWindowActivity":
                            PageActivityView = (PageChatWindowActivity)activity;
                            break;
                        case "GroupChatWindowActivity":
                            GroupActivityView = (GroupChatWindowActivity)activity;
                            break;
                        case "StoryReplyActivity":
                            StoryReplyActivity = (StoryReplyActivity)activity;
                            break;
                    }
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            public void OnClick(View view, Sticker sticker, bool fromRecent)
            {
                try
                {
                    //ToastUtils.ShowToast(Application.Context, sticker.ToString() + " clicked!", ToastLength.Short);
                    var stickerUrl = sticker.ToString();
                    var Position = "1";
                    var unixTimestamp = DateTimeOffset.UtcNow.ToUnixTimeSeconds();

                    switch (TypePage)
                    {
                        case "CommentActivity":
                        {
                            CommentActivity.ImageUrl = stickerUrl;
                            Glide.With(CommentActivity).Load(stickerUrl).Apply(new RequestOptions()).Into(CommentActivity.ImgGallery);
                            break;
                        }
                        case "ChatWindowActivity":
                            {
                                MessageDataExtra m1 = new MessageDataExtra
                                {
                                    Id = unixTimestamp.ToString(),
                                    FromId = UserDetails.UserId,
                                    ToId = ChatWindow.UserId,
                                    Media = stickerUrl,
                                    TimeText = TimeNow,
                                    Position = "right",
                                    ModelType = MessageModelType.RightSticker
                                };

                                ChatWindow.MAdapter.DifferList.Add(new AdapterModelsClassMessage
                                {
                                    TypeView = MessageModelType.RightSticker,
                                    Id = Long.ParseLong(m1.Id),
                                    MesData = m1
                                });

                                var indexMes = ChatWindow.MAdapter.DifferList.IndexOf(ChatWindow.MAdapter.DifferList.FirstOrDefault(a => a.MesData == m1));
                                if (indexMes > -1)
                                {
                                    ChatWindow.MAdapter.NotifyItemInserted(indexMes);
                                    ChatWindow.MRecycler.ScrollToPosition(ChatWindow.MAdapter.ItemCount - 1);
                                }

                                if (Methods.CheckConnectivity())
                                {
                                    //Sticker Send Function
                                    MessageController.SendMessageTask(ChatWindow, ChatWindow.UserId, unixTimestamp.ToString(), "", "", "", stickerUrl, "sticker" + Position).ConfigureAwait(false);
                                }
                                else
                                {
                                    ToastUtils.ShowToast(ChatWindow, ChatWindow.GetText(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                                }
                                break;
                            }
                        case "GroupChatWindowActivity":
                            {
                                MessageDataExtra m1 = new MessageDataExtra
                                {
                                    Id = unixTimestamp.ToString(),
                                    FromId = UserDetails.UserId,
                                    GroupId = GroupActivityView.GroupId,
                                    Media = stickerUrl,
                                    TimeText = TimeNow,
                                    Position = "right",
                                    ModelType = MessageModelType.RightSticker
                                };

                                GroupActivityView.MAdapter.DifferList.Add(new AdapterModelsClassMessage
                                {
                                    TypeView = MessageModelType.RightSticker,
                                    Id = Long.ParseLong(m1.Id),
                                    MesData = m1
                                });

                                var indexMes = GroupActivityView.MAdapter.DifferList.IndexOf(GroupActivityView.MAdapter.DifferList.FirstOrDefault(a => a.MesData == m1));
                                if (indexMes > -1)
                                {
                                    GroupActivityView.MAdapter.NotifyItemInserted(indexMes);
                                    GroupActivityView.MRecycler.ScrollToPosition(GroupActivityView.MAdapter.ItemCount - 1);
                                }

                                if (Methods.CheckConnectivity())
                                {
                                    //Sticker Send Function
                                    GroupMessageController.SendMessageTask(GroupActivityView, GroupActivityView.GroupId, unixTimestamp.ToString(), "", "", "", stickerUrl, "sticker" + Position).ConfigureAwait(false);
                                }
                                else
                                {
                                    ToastUtils.ShowToast(GroupActivityView, GroupActivityView.GetText(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                                }
                                break;
                            }
                        case "PageChatWindowActivity":
                            {
                                MessageDataExtra m1 = new MessageDataExtra
                                {
                                    Id = unixTimestamp.ToString(),
                                    FromId = UserDetails.UserId,
                                    PageId = PageActivityView.PageId,
                                    Media = stickerUrl,
                                    TimeText = TimeNow,
                                    Position = "right",
                                    ModelType = MessageModelType.RightSticker
                                };

                                PageActivityView.MAdapter.DifferList.Add(new AdapterModelsClassMessage
                                {
                                    TypeView = MessageModelType.RightSticker,
                                    Id = Long.ParseLong(m1.Id),
                                    MesData = m1
                                });

                                var indexMes = PageActivityView.MAdapter.DifferList.IndexOf(PageActivityView.MAdapter.DifferList.FirstOrDefault(a => a.MesData == m1));
                                if (indexMes > -1)
                                {
                                    PageActivityView.MAdapter.NotifyItemInserted(indexMes);
                                    PageActivityView.MRecycler.ScrollToPosition(PageActivityView.MAdapter.ItemCount - 1);
                                }

                                if (Methods.CheckConnectivity())
                                {
                                    //Sticker Send Function
                                    PageMessageController.SendMessageTask(PageActivityView, PageActivityView.PageId, PageActivityView.UserId, unixTimestamp.ToString(), "", "", "", stickerUrl, "sticker" + Position).ConfigureAwait(false);
                                }
                                else
                                {
                                    ToastUtils.ShowToast(PageActivityView, PageActivityView.GetText(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                                }
                                break;
                            }
                        case "StoryReplyActivity":
                            {
                                if (Methods.CheckConnectivity())
                                {
                                    //Sticker Send Function
                                    StoryReplyActivity.SendMess(StoryReplyActivity.UserId, "", "", "", stickerUrl, "sticker" + Position).ConfigureAwait(false);
                                }
                                else
                                {
                                    ToastUtils.ShowToast(StoryReplyActivity, StoryReplyActivity.GetText(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                                }
                                break;
                            }
                    }
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            public bool OnLongClick(View view, Sticker sticker, bool fromRecent)
            {
                return false;
            }
        }

        private class MyFooterItemClicked : Java.Lang.Object, AXEmojiPager.IOnFooterItemClicked
        {
            public MyFooterItemClicked()
            {
                try
                {

                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }

            public void OnClick(View view, bool leftIcon)
            {
                try
                {
                    if (leftIcon)
                        ToastUtils.ShowToast(Application.Context, "Search Clicked!", ToastLength.Short);
                }
                catch (Exception e)
                {
                    Methods.DisplayReportResultTrack(e);
                }
            }
        }
    }
}