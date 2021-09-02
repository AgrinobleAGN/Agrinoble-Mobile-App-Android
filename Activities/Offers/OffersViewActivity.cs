﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MaterialDialogsCore;
using Android.App;
using Android.Content;
using Android.Content.PM;
using Android.Graphics;
using Android.OS;
using Android.Util;
using Android.Views;
using Android.Widget;
using AndroidX.AppCompat.Content.Res;
using Newtonsoft.Json;
using WoWonder.Activities.Base;
using WoWonder.Activities.NativePost.Extra;
using WoWonder.Activities.Tabbes;
using WoWonder.Helpers.CacheLoaders;
using WoWonder.Helpers.Controller;
using WoWonder.Helpers.Fonts;
using WoWonder.Helpers.Model;
using WoWonder.Helpers.Utils;
using WoWonder.Library.Anjo.SuperTextLibrary;
using WoWonderClient.Classes.Offers;
using WoWonderClient.Requests; 
using Exception = System.Exception;
using String = Java.Lang.String;
using Toolbar = AndroidX.AppCompat.Widget.Toolbar;

namespace WoWonder.Activities.Offers
{
    [Activity(Icon = "@mipmap/icon", Theme = "@style/MyTheme", ConfigurationChanges = ConfigChanges.Locale | ConfigChanges.UiMode | ConfigChanges.ScreenSize | ConfigChanges.Orientation | ConfigChanges.ScreenLayout | ConfigChanges.SmallestScreenSize)]
    public class OffersViewActivity : BaseActivity, MaterialDialog.IListCallback, MaterialDialog.ISingleButtonCallback
    {
        #region Variables Basic

        private ImageView OfferCoverImage;
        private ImageButton IconBack;
        private ImageView OfferAvatar;
        private TextView Name, Subname, PageTitle, DiscountNumber, DateNumber, TxtMore;
        private SuperTextView Description;
        private OffersDataObject DataInfoObject;
        private string DialogType;
        private StReadMoreOption ReadMoreOption;

        #endregion

        #region General

        protected override void OnCreate(Bundle savedInstanceState)
        {
            try
            {
                base.OnCreate(savedInstanceState);
                SetTheme(AppSettings.SetTabDarkTheme ? Resource.Style.Overlap_Dark : Resource.Style.Overlap_Light);

                Methods.App.FullScreenApp(this);

                Overlap();

                // Create your application here
                SetContentView(Resource.Layout.OffersViewLayout);
                  
                //Get Value And Set Toolbar
                InitComponent();
                InitToolbar();

                var dataObject = Intent?.GetStringExtra("OffersObject");
                DataInfoObject = string.IsNullOrEmpty(dataObject) switch
                {
                    false => JsonConvert.DeserializeObject<OffersDataObject>(dataObject),
                    _ => DataInfoObject
                };

                BindOfferPost();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private void Overlap()
        {
            /*View mContentView = Window?.DecorView;

            Window?.ClearFlags(WindowManagerFlags.TranslucentStatus);
            Window?.AddFlags(WindowManagerFlags.DrawsSystemBarBackgrounds);
            mContentView.SystemUiVisibility = (StatusBarVisibility)(SystemUiFlags.LightStatusBar);
            Window?.SetStatusBarColor(Color.Transparent);*/
            if (Build.VERSION.SdkInt >= BuildVersionCodes.Lollipop)
            {
                Window?.SetFlags(WindowManagerFlags.LayoutNoLimits, WindowManagerFlags.LayoutNoLimits);
            }

        }
        protected override void OnResume()
        {
            try
            {
                base.OnResume();
                AddOrRemoveEvent(true);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        protected override void OnPause()
        {
            try
            {
                base.OnPause();
                AddOrRemoveEvent(false);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public override void OnTrimMemory(TrimMemory level)
        {
            try
            {
                GC.Collect(GC.MaxGeneration, GCCollectionMode.Forced);
                base.OnTrimMemory(level);
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
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
        protected override void OnDestroy()
        {
            try
            {
                DestroyBasic();
                base.OnDestroy();
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }
        #endregion

        #region Menu

        public override bool OnOptionsItemSelected(IMenuItem item)
        {
            switch (item.ItemId)
            {
                case Android.Resource.Id.Home:
                    Finish();
                    return true;
            }
            return base.OnOptionsItemSelected(item);
        }

        #endregion

        #region Functions

        private void InitComponent()
        {
            try
            {
                IconBack = FindViewById<ImageButton>(Resource.Id.iv_back);

                OfferCoverImage = FindViewById<ImageView>(Resource.Id.offerCoverImage);
                OfferAvatar = FindViewById<ImageView>(Resource.Id.offerAvatar);

                Name = FindViewById<TextView>(Resource.Id.tv_name);
                Subname = FindViewById<TextView>(Resource.Id.tv_subname);
                PageTitle = FindViewById<TextView>(Resource.Id.tv_page_title);

                DateNumber = FindViewById<TextView>(Resource.Id.tv_enddate);
                DiscountNumber = FindViewById<TextView>(Resource.Id.tv_discount_number);

                Description = FindViewById<SuperTextView>(Resource.Id.description);

                TxtMore = FindViewById<TextView>(Resource.Id.toolbar_title);
                FontUtils.SetTextViewIcon(FontsIconFrameWork.IonIcons, TxtMore, IonIconsFonts.More);
                TxtMore.SetTextSize(ComplexUnitType.Sp, 20f);
                TxtMore.Visibility = ViewStates.Gone;

                ReadMoreOption = new StReadMoreOption.Builder()
                    .TextLength(400, StReadMoreOption.TypeCharacter)
                    .MoreLabel(GetText(Resource.String.Lbl_ReadMore))
                    .LessLabel(GetText(Resource.String.Lbl_ReadLess))
                    .MoreLabelColor(Color.ParseColor(AppSettings.MainColor))
                    .LessLabelColor(Color.ParseColor(AppSettings.MainColor))
                    .LabelUnderLine(true)
                    .Build();
               
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private void InitToolbar()
        {
            try
            {
                var toolBar = FindViewById<Toolbar>(Resource.Id.toolbar);
                if (toolBar != null)
                {
                    toolBar.Title = "";
                    toolBar.SetTitleTextColor(Color.ParseColor(AppSettings.MainColor));
                    SetSupportActionBar(toolBar);
                    SupportActionBar.SetDisplayShowCustomEnabled(true);
                    SupportActionBar.SetDisplayHomeAsUpEnabled(true);
                    SupportActionBar.SetHomeButtonEnabled(true);
                    SupportActionBar.SetDisplayShowHomeEnabled(true);
                    SupportActionBar.SetHomeAsUpIndicator(AppCompatResources.GetDrawable(this, AppSettings.FlowDirectionRightToLeft ? Resource.Drawable.ic_action_right_arrow_color : Resource.Drawable.ic_action_left_arrow_color));

                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private void AddOrRemoveEvent(bool addEvent)
        {
            try
            {
                switch (addEvent)
                {
                    // true +=  // false -=
                    case true:
                        TxtMore.Click += TxtMoreOnClick;
                        IconBack.Click += IconBackOnClick;
                        Description.LongClick += DescriptionOnLongClick;
                        break;
                    default:
                        TxtMore.Click -= TxtMoreOnClick;
                        IconBack.Click -= IconBackOnClick;
                        Description.LongClick -= DescriptionOnLongClick;
                        break;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
        private void DestroyBasic()
        {
            try
            {
                IconBack = null!;
                OfferCoverImage = null!;
                OfferAvatar = null!;
                Name = null!;
                Subname = null!;
                PageTitle = null!;
                DateNumber = null!;
                DiscountNumber = null!;
                Description = null!;
                TxtMore = null!;
                DataInfoObject = null!;
                DialogType = null!;
                ReadMoreOption = null!;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
        #endregion

        #region Events

        private void DescriptionOnLongClick(object sender, View.LongClickEventArgs e)
        {
            try
            {
                if (Methods.FunString.StringNullRemover(DataInfoObject.Description) != "Empty")
                {
                    Methods.CopyToClipboard(this, DataInfoObject.Description); 
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        private void IconBackOnClick(object sender, EventArgs e)
        {
            try
            {
                Finish();
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        private void TxtMoreOnClick(object sender, EventArgs e)
        {
            try
            {
                DialogType = "More";

                var arrayAdapter = new List<string>();
                var dialogList = new MaterialDialog.Builder(this).Theme(AppSettings.SetTabDarkTheme ? MaterialDialogsCore.Theme.Dark : MaterialDialogsCore.Theme.Light);

                arrayAdapter.Add(GetText(Resource.String.Lbl_Edit));
                arrayAdapter.Add(GetText(Resource.String.Lbl_Delete));

                dialogList.Title(GetText(Resource.String.Lbl_More)).TitleColorRes(Resource.Color.primary);
                dialogList.Items(arrayAdapter);
                dialogList.NegativeText(GetText(Resource.String.Lbl_Close)).OnNegative(this);
                dialogList.AlwaysCallSingleChoiceCallback();
                dialogList.ItemsCallback(this).Build().Show();
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }
         
        #endregion

        #region MaterialDialog

        public void OnSelection(MaterialDialog dialog, View itemView, int position, string itemString)
        {
            try
            {
                string text = itemString;
                if (text == GetText(Resource.String.Lbl_Edit))
                {
                    //Open Edit offer
                    var intent = new Intent(this, typeof(EditOffersActivity));
                    intent.PutExtra("OfferId", DataInfoObject.Id);
                    intent.PutExtra("OfferItem", JsonConvert.SerializeObject(DataInfoObject));
                    StartActivityForResult(intent, 246);
                }
                else if (text == GetText(Resource.String.Lbl_Delete))
                {
                    DialogType = "Delete";

                    var dialogBuilder = new MaterialDialog.Builder(this).Theme(AppSettings.SetTabDarkTheme ? MaterialDialogsCore.Theme.Dark : MaterialDialogsCore.Theme.Light);
                    dialogBuilder.Title(Resource.String.Lbl_Warning).TitleColorRes(Resource.Color.primary);
                    dialogBuilder.Content(GetText(Resource.String.Lbl_DeleteOffers));
                    dialogBuilder.PositiveText(GetText(Resource.String.Lbl_Yes)).OnPositive(this);
                    dialogBuilder.NegativeText(GetText(Resource.String.Lbl_No)).OnNegative(this);
                    dialogBuilder.AlwaysCallSingleChoiceCallback();
                    dialogBuilder.ItemsCallback(this).Build().Show();
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
                switch (DialogType)
                {
                    case "Delete" when p1 == DialogAction.Positive:
                    {
                        // Send Api delete  
                        if (Methods.CheckConnectivity())
                        {
                            var adapterGlobal = WRecyclerView.GetInstance()?.NativeFeedAdapter;
                            var diff = adapterGlobal?.ListDiffer;
                            var dataGlobal = diff?.Where(a => a.PostData?.OfferId == DataInfoObject?.Id).ToList();
                            if (dataGlobal != null)
                            {
                                foreach (var postData in dataGlobal)
                                {
                                    WRecyclerView.GetInstance()?.RemoveByRowIndex(postData);
                                }
                            }

                            var recycler = TabbedMainActivity.GetInstance()?.NewsFeedTab?.MainRecyclerView;
                            var dataGlobal2 = recycler?.NativeFeedAdapter.ListDiffer?.Where(a => a.PostData?.OfferId == DataInfoObject?.Id).ToList();
                            if (dataGlobal2 != null)
                            {
                                foreach (var postData in dataGlobal2)
                                {
                                    recycler.RemoveByRowIndex(postData);
                                }
                            }
                              
                            ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_postSuccessfullyDeleted), ToastLength.Short);
                            PollyController.RunRetryPolicyFunction(new List<Func<Task>> { () => RequestsAsync.Offers.DeleteOfferAsync(DataInfoObject.Id) });
                        }
                        else
                        {
                            ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                        }

                        break;
                    }
                    case "Delete":
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

        #region  Result

        //Result
        protected override void OnActivityResult(int requestCode, Result resultCode, Intent data)
        {
            try
            {
                base.OnActivityResult(requestCode, resultCode, data);
                switch (requestCode)
                {
                    case 246 when resultCode == Result.Ok:
                    {
                        var offersItem = data.GetStringExtra("OffersItem") ?? "";
                        if (string.IsNullOrEmpty(offersItem)) return;
                        var dataObject = JsonConvert.DeserializeObject<OffersDataObject>(offersItem);
                        if (dataObject != null)
                        {
                            DataInfoObject.DiscountType = dataObject.DiscountType;
                            DataInfoObject.Currency = dataObject.Currency;
                            DataInfoObject.ExpireDate = dataObject.ExpireDate;
                            DataInfoObject.Time = dataObject.Time;
                            DataInfoObject.Description = dataObject.Description;
                            DataInfoObject.DiscountedItems = dataObject.DiscountedItems;
                            DataInfoObject.Description = dataObject.Description;
                            DataInfoObject.DiscountPercent = dataObject.DiscountPercent;
                            DataInfoObject.DiscountAmount = dataObject.DiscountAmount;
                            DataInfoObject.DiscountPercent = dataObject.DiscountPercent;
                            DataInfoObject.Buy = dataObject.Buy;
                            DataInfoObject.GetPrice = dataObject.GetPrice;
                            DataInfoObject.Spend = dataObject.Spend;
                            DataInfoObject.AmountOff = dataObject.AmountOff;

                            BindOfferPost();
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

        private void BindOfferPost()
        {
            try
            {
                if (DataInfoObject != null)
                {
                    DataInfoObject.IsOwner = DataInfoObject.UserId == UserDetails.UserId;

                    GlideImageLoader.LoadImage(this, DataInfoObject.Page.Avatar, OfferAvatar, ImageStyle.RoundedCrop, ImagePlaceholders.Drawable);
                    GlideImageLoader.LoadImage(this, DataInfoObject.Image, OfferCoverImage, ImageStyle.FitCenter, ImagePlaceholders.Drawable);

                    TxtMore.Visibility = DataInfoObject.IsOwner switch
                    {
                        true => ViewStates.Visible,
                        _ => TxtMore.Visibility
                    };

                    if (DataInfoObject.Page != null)
                    {
                        Name.Text = Methods.FunString.DecodeString(DataInfoObject.Page.Name);
                        Subname.Text = "@" + Methods.FunString.DecodeString(DataInfoObject.Page.PageName);
                    }
                     
                    //Set Description
                    var description = Methods.FunString.DecodeString(DataInfoObject.Description);
                    Description.Text = description;
                    ReadMoreOption.AddReadMoreTo(Description, new String(description));

                    PageTitle.Text = Methods.FunString.DecodeString(DataInfoObject.OfferText) + " " + Methods.FunString.DecodeString(DataInfoObject.DiscountedItems);
                    DiscountNumber.Text = Methods.FunString.DecodeString(DataInfoObject.OfferText);
                    DateNumber.Text =  DataInfoObject.ExpireDate;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

    }
}