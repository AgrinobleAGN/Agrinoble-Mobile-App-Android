﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MaterialDialogsCore;
using Android.App;
using Android.Content;
using Android.Graphics;
using Android.Views;
using Android.Widget;
using Newtonsoft.Json;
using WoWonder.Activities.Articles.Fragment;
using WoWonder.Activities.Comment;
using WoWonder.Activities.NativePost.Post;
using WoWonder.Helpers.Controller;
using WoWonder.Helpers.Model;
using WoWonder.Helpers.Utils;
using WoWonderClient.Classes.Articles;
using WoWonderClient.Requests;
using Exception = System.Exception;

namespace WoWonder.Activities.Articles
{
    public class ArticlesCommentClickListener : Java.Lang.Object , MaterialDialog.IListCallback, MaterialDialog.ISingleButtonCallback
    {
        private readonly Activity MainContext;
        private CommentsArticlesObject CommentObject;
        private string TypeDialog;
        private readonly string TypeClass;

        public ArticlesCommentClickListener(Activity context, string typeClass)
        {
            MainContext = context;
            TypeClass = typeClass;
        }

        public void MoreCommentReplyPostClick(CommentReplyArticlesClickEventArgs e)
        {
            try
            {
                if (Methods.CheckConnectivity())
                {
                    TypeDialog = "MoreComment";
                    CommentObject = e.CommentObject;

                    var arrayAdapter = new List<string>();
                    var dialogList = new MaterialDialog.Builder(MainContext).Theme(AppSettings.SetTabDarkTheme ? Theme.Dark : Theme.Light);

                    arrayAdapter.Add(MainContext.GetString(Resource.String.Lbl_CopeText));

                    if (CommentObject?.IsOwner != null && (bool)CommentObject?.IsOwner || CommentObject?.UserData?.UserId == UserDetails.UserId)
                        arrayAdapter.Add(MainContext.GetString(Resource.String.Lbl_Delete));

                    dialogList.Title(MainContext.GetString(Resource.String.Lbl_More)).TitleColorRes(Resource.Color.primary);
                    dialogList.Items(arrayAdapter);
                    dialogList.PositiveText(MainContext.GetText(Resource.String.Lbl_Close)).OnNegative(this);
                    dialogList.AlwaysCallSingleChoiceCallback();
                    dialogList.ItemsCallback(this).Build().Show();
                }
                else
                {
                    ToastUtils.ShowToast(MainContext, MainContext.GetText(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        //Event Menu >> Delete Comment
        private void DeleteCommentEvent(CommentsArticlesObject item)
        {
            try
            {
                if (!Methods.CheckConnectivity())
                {
                    ToastUtils.ShowToast(MainContext, MainContext.GetText(Resource.String.Lbl_CheckYourInternetConnection),ToastLength.Short);
                    return; 
                }

                TypeDialog = "DeleteComment";
                CommentObject = item;

                var dialog = new MaterialDialog.Builder(MainContext).Theme(AppSettings.SetTabDarkTheme ? Theme.Dark : Theme.Light);
                dialog.Title(MainContext.GetText(Resource.String.Lbl_DeleteComment)).TitleColorRes(Resource.Color.primary);
                dialog.Content(MainContext.GetText(Resource.String.Lbl_AreYouSureDeleteComment));
                dialog.PositiveText(MainContext.GetText(Resource.String.Lbl_Yes)).OnPositive(this);
                dialog.NegativeText(MainContext.GetText(Resource.String.Lbl_No)).OnNegative(this);
                dialog.AlwaysCallSingleChoiceCallback();
                dialog.ItemsCallback(this).Build().Show();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public void ProfileClick(CommentReplyArticlesClickEventArgs e)
        {
            try
            {
                WoWonderTools.OpenProfile(MainContext, e.CommentObject.UserData.UserId, e.CommentObject.UserData);
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }
         
        public void LikeCommentReplyPostClick(CommentReplyArticlesClickEventArgs e)
        {
            try
            {
                if (!Methods.CheckConnectivity())
                {
                    ToastUtils.ShowToast(MainContext, MainContext.GetText(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                    return;
                }

                switch (e.Holder.LikeTextView?.Tag?.ToString())
                {
                    case "Liked":
                        {
                            e.Holder.LikeTextView.Text = MainContext.GetText(Resource.String.Btn_Like);
                            //e.Holder.LikeTextView.SetTextColor(AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                            e.Holder.LikeTextView.SetTextColor(AppSettings.SetTabDarkTheme ? Color.White : Color.ParseColor("#888888"));
                            e.Holder.LikeTextView.Tag = "Like";

                            switch (AppSettings.PostButton)
                            {
                                case PostButtonSystem.ReactionDefault:
                                case PostButtonSystem.ReactionSubShine:
                                    {
                                        var x = e.CommentObject.Reaction.Count;
                                        switch (x)
                                        {
                                            case > 0:
                                                e.CommentObject.Reaction.Count--;
                                                break;
                                            default:
                                                e.CommentObject.Reaction.Count = 0;
                                                break;
                                        }

                                        e.CommentObject.Reaction.IsReacted = false;
                                        e.CommentObject.Reaction.Type = "";

                                        if (e.Holder.CountLike != null && e.CommentObject.Reaction.Count > 0)
                                        {
                                            e.Holder.CountLikeSection.Visibility = ViewStates.Visible;
                                            e.Holder.CountLike.Text = Methods.FunString.FormatPriceValue(e.CommentObject.Reaction.Count);
                                        }
                                        else
                                        {
                                            e.Holder.CountLikeSection.Visibility = ViewStates.Gone;
                                        }

                                        PollyController.RunRetryPolicyFunction(TypeClass == "Reply" ? new List<Func<Task>> { () => RequestsAsync.Article.ReactionCommentAsync(e.CommentObject.BlogId, e.CommentObject.Id, "", "reply_like") } : new List<Func<Task>> { () => RequestsAsync.Article.ReactionCommentAsync(e.CommentObject.BlogId, e.CommentObject.Id, "") });
                                        break;
                                    }
                                default:
                                    e.CommentObject.IsCommentLiked = false;

                                    PollyController.RunRetryPolicyFunction(TypeClass == "Reply" ? new List<Func<Task>> { () => RequestsAsync.Article.LikeUnLikeCommentAsync(e.CommentObject.BlogId, e.CommentObject.Id, "reply_like") } : new List<Func<Task>> { () => RequestsAsync.Article.LikeUnLikeCommentAsync(e.CommentObject.BlogId, e.CommentObject.Id) });
                                    break;
                            }

                            break;
                        }
                    default:
                        {
                            switch (AppSettings.PostButton)
                            {
                                case PostButtonSystem.ReactionDefault:
                                case PostButtonSystem.ReactionSubShine:
                                    new ArticlesReactionComment(MainContext, TypeClass)?.ClickDialog(e);
                                    break;
                                default:
                                    e.CommentObject.IsCommentLiked = true;

                                    e.Holder.LikeTextView.Text = MainContext.GetText(Resource.String.Btn_Liked);
                                    e.Holder.LikeTextView.SetTextColor(Color.ParseColor(AppSettings.MainColor));
                                    e.Holder.LikeTextView.Tag = "Liked";

                                    //sent api like comment 
                                    switch (TypeClass)
                                    {
                                        case "Comment":
                                            PollyController.RunRetryPolicyFunction(new List<Func<Task>> { () => RequestsAsync.Article.LikeUnLikeCommentAsync(e.CommentObject.BlogId, e.CommentObject.Id) });
                                            break;
                                        case "Reply":
                                            PollyController.RunRetryPolicyFunction(new List<Func<Task>> { () => RequestsAsync.Article.LikeUnLikeCommentAsync(e.CommentObject.BlogId, e.CommentObject.Id, "reply_like") });
                                            break;
                                    }
                                    break;
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
         
        public void DislikeCommentReplyPostClick(CommentReplyArticlesClickEventArgs e)
        {
            try
            {
                if (!Methods.CheckConnectivity())
                {
                    ToastUtils.ShowToast(MainContext, MainContext.GetText(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                    return;
                }

                switch (e.Holder.LikeTextView?.Tag?.ToString())
                {
                    case "Liked":
                        e.CommentObject.IsCommentLiked = false;

                        e.Holder.LikeTextView.Text = MainContext.GetText(Resource.String.Btn_Like);
                        //e.Holder.LikeTextView.SetTextColor(AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                        e.Holder.LikeTextView.SetTextColor(AppSettings.SetTabDarkTheme ? Color.White : Color.ParseColor("#888888"));
                        e.Holder.LikeTextView.Tag = "Like";
                        break;
                    default:
                        e.CommentObject.IsCommentLiked = true;

                        e.Holder.LikeTextView.Text = MainContext.GetText(Resource.String.Btn_Liked);
                        e.Holder.LikeTextView.SetTextColor(Color.ParseColor(AppSettings.MainColor));
                        e.Holder.LikeTextView.Tag = "Liked";

                        //sent api dislike comment 
                        switch (TypeClass)
                        {
                            case "Comment":
                                PollyController.RunRetryPolicyFunction(new List<Func<Task>> { () => RequestsAsync.Article.DisLikeUnDisLikeCommentAsync(e.CommentObject.BlogId, e.CommentObject.Id) });
                                break;
                            case "Reply":
                                PollyController.RunRetryPolicyFunction(new List<Func<Task>> { () => RequestsAsync.Article.DisLikeUnDisLikeCommentAsync(e.CommentObject.BlogId, e.CommentObject.Id, "reply_dislike") });
                                break;
                        }

                        break;
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        public void CountLikeCommentReplyPostClick(CommentReplyArticlesClickEventArgs e)
        {
            try
            {
                //wael check this page
                var intent = new Intent(MainContext, typeof(ReactionCommentTabbedActivity));
                intent.PutExtra("TypeClass", TypeClass);
                intent.PutExtra("CommentObject", JsonConvert.SerializeObject(e.CommentObject));
                MainContext.StartActivity(intent);
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        //Event Menu >> Reply
        public void CommentReplyClick(CommentReplyArticlesClickEventArgs e)
        {
            try
            {
                // show dialog :
                var intent = new Intent(MainContext, typeof(ReplyCommentBottomSheet));
                intent.PutExtra("Type", "Article");
                intent.PutExtra("Id", e.CommentObject.Id);
                intent.PutExtra("Object", JsonConvert.SerializeObject(e.CommentObject));
                MainContext.StartActivity(intent);
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }
 
        #region MaterialDialog

        public void OnSelection(MaterialDialog dialog, View itemView, int position, string itemString)
        {
            try
            {
                string text = itemString;
                if (text == MainContext.GetString(Resource.String.Lbl_CopeText))
                {
                    Methods.CopyToClipboard(MainContext, Methods.FunString.DecodeString(CommentObject.Text));
                }
                else if (text == MainContext.GetString(Resource.String.Lbl_Delete))
                {
                    DeleteCommentEvent(CommentObject);
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public void OnClick(MaterialDialog p0, DialogAction p1)
        {
            try
            {
                switch (TypeDialog)
                {
                    case "DeleteComment" when p1 == DialogAction.Positive:
                        MainContext?.RunOnUiThread(() =>
                        {
                            try
                            {
                                switch (TypeClass)
                                {
                                    case "Comment":
                                    {
                                        //TypeClass
                                        var adapterGlobal = ArticlesViewActivity.GetInstance()?.MAdapter;
                                        var dataGlobal = adapterGlobal?.CommentList?.FirstOrDefault(a => a.Id == CommentObject?.Id);
                                        if (dataGlobal != null)
                                        {
                                            var index = adapterGlobal.CommentList.IndexOf(dataGlobal);
                                            switch (index)
                                            {
                                                case > -1:
                                                    adapterGlobal.CommentList.RemoveAt(index);
                                                    adapterGlobal.NotifyItemRemoved(index);
                                                    break;
                                            }
                                        }

                                        if (!Methods.CheckConnectivity())
                                            ToastUtils.ShowToast(MainContext, MainContext.GetString(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                                        else
                                            PollyController.RunRetryPolicyFunction(new List<Func<Task>> { () => RequestsAsync.Article.DeleteCommentAsync(CommentObject.BlogId, CommentObject.Id) });
                                        break;
                                    }
                                    case "Reply":
                                    {
                                        //TypeClass
                                        var adapterGlobal = ReplyCommentBottomSheet.GetInstance()?.MAdapterArticles;
                                        var dataGlobal = adapterGlobal?.CommentList?.FirstOrDefault(a => a.Id == CommentObject?.Id);
                                        if (dataGlobal != null)
                                        {
                                            var index = adapterGlobal.CommentList.IndexOf(dataGlobal);
                                            switch (index)
                                            {
                                                case > -1:
                                                    adapterGlobal.CommentList.RemoveAt(index);
                                                    adapterGlobal.NotifyItemRemoved(index);
                                                    break;
                                            }
                                        }

                                        if (!Methods.CheckConnectivity())
                                            ToastUtils.ShowToast(MainContext, MainContext.GetString(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                                        else
                                            PollyController.RunRetryPolicyFunction(new List<Func<Task>> { () => RequestsAsync.Article.DeleteCommentAsync(CommentObject.BlogId, CommentObject.Id, "reply_delete") });
                                        break;
                                    }
                                }

                                ToastUtils.ShowToast(MainContext, MainContext.GetText(Resource.String.Lbl_CommentSuccessfullyDeleted), ToastLength.Short);
                            }
                            catch (Exception e)
                            {
                                Methods.DisplayReportResultTrack(e);
                            }
                        });
                        break;
                    case "DeleteComment":
                    {
                        if (p1 == DialogAction.Negative)
                        {
                            p0.Dismiss();
                        }

                        break;
                    }
                    default:
                    {
                        if (p1 == DialogAction.Positive)
                        {

                        }
                        else if (p1 == DialogAction.Negative)
                        {
                            p0.Dismiss();
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

        #endregion

    }
}