using Android.Views;
using Android.Widget;
using System;
using Aghajari.EmojiView.Listeners;
using Aghajari.EmojiView.Views;
using Android.App;
using Android.Graphics;
using Android.Graphics.Drawables;
using AndroidX.AppCompat.Content.Res;
using AndroidX.Core.Graphics.Drawable;
using WoWonder.Activities.Chat.ChatWindow;
using WoWonder.Activities.Chat.GroupChat;
using WoWonder.Activities.Chat.PageChat;
using WoWonder.Activities.Story;
using WoWonder.Helpers.Utils;

namespace WoWonder.Library.Anjo.EmojiView
{
    public class EmojisViewActions : SimplePopupAdapter, View.IOnClickListener  
    { 
        private readonly Activity ActivityContext;

        private readonly ChatWindowActivity ChatWindow;
        private readonly GroupChatWindowActivity GroupActivityView;
        private readonly PageChatWindowActivity PageActivityView;
        private readonly StoryReplyActivity StoryReplyActivity;

        private readonly AXEmojiPopup Popup;
        private readonly AXEmojiEditText AXEmojiEditText;
        private readonly ImageView EmojisViewImage;

        private readonly string TypePage;

        private bool IsShowing = false;

        public EmojisViewActions(Activity activity, string typePage, AXEmojiPopup popup, AXEmojiEditText editText, ImageView image)
        {
            try
            {
                ActivityContext = activity;
                TypePage = typePage;

                switch (typePage)
                {
                    // Create your fragment here
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

                Popup = popup;
                AXEmojiEditText = editText;
                EmojisViewImage = image;

                EmojisViewImage.SetColorFilter(AppSettings.SetTabDarkTheme ? Color.White : Color.ParseColor("#444444"));

                AXEmojiEditText.SetOnClickListener(this);
                EmojisViewImage.SetOnClickListener(this);
                popup.SetPopupListener(this);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private void UpdateButton(bool emoji)
        {
            try
            {
                if (IsShowing == emoji) return;
                IsShowing = emoji;

                if (emoji)
                {
                    Drawable dr = AppCompatResources.GetDrawable(ActivityContext, Resource.Drawable.ic_action_keyboard);
                    DrawableCompat.SetTint(DrawableCompat.Wrap(dr), Color.Black);
                    EmojisViewImage.SetImageDrawable(dr);
                }
                else
                {
                    Drawable dr = AppCompatResources.GetDrawable(ActivityContext, Resource.Drawable.ic_action_sentiment_satisfied_alt);
                    DrawableCompat.SetTint(DrawableCompat.Wrap(dr), Color.Black);
                    EmojisViewImage.SetImageDrawable(dr);
                }
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
                if (v?.Id == AXEmojiEditText?.Id)
                {
                    if (Popup.IsShowing)
                    {
                        Popup.Toggle();

                        switch (TypePage)
                        {
                            // Create your fragment here
                            case "ChatWindowActivity":
                                ChatWindow?.RemoveButtonFragment();
                                break;
                            case "PageChatWindowActivity":
                                PageActivityView?.RemoveButtonFragment();
                                break;
                            case "GroupChatWindowActivity":
                                GroupActivityView?.RemoveButtonFragment();
                                break;
                            case "StoryReplyActivity":
                                StoryReplyActivity?.RemoveButtonFragment();
                                break;
                        }
                    }
                }
                else if (v?.Id == EmojisViewImage?.Id)
                {
                    Popup.Toggle();
                    switch (TypePage)
                    {
                        // Create your fragment here
                        case "ChatWindowActivity":
                            ChatWindow?.RemoveButtonFragment();
                            break;
                        case "PageChatWindowActivity":
                            PageActivityView?.RemoveButtonFragment();
                            break;
                        case "GroupChatWindowActivity":
                            GroupActivityView?.RemoveButtonFragment();
                            break;
                        case "StoryReplyActivity":
                            StoryReplyActivity?.RemoveButtonFragment();
                            break;
                    }
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public override void OnShow()
        {
            try
            {
                base.OnShow();
                UpdateButton(true);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public override void OnDismiss()
        {
            try
            {
                base.OnDismiss();
                UpdateButton(false);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
    }
}