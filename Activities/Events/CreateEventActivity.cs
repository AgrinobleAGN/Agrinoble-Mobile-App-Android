﻿using System;
using System.Linq;
using Android;
using Android.App;
using Android.Content;
using Android.Content.PM;
using Android.Gms.Ads.DoubleClick;
using Android.Graphics;
using Android.OS;
using Android.Views;
using Android.Widget;
using AndroidHUD;
using AndroidX.AppCompat.Content.Res;
using AndroidX.Core.Content;
using Bumptech.Glide;
using Bumptech.Glide.Request;
using ImageViews.Rounded;
using TheArtOfDev.Edmodo.Cropper;
using WoWonder.Activities.Base;
using WoWonder.Helpers.Ads;
using WoWonder.Helpers.Controller;
using WoWonder.Helpers.Utils;
using WoWonderClient.Classes.Event;
using WoWonderClient.Requests;
using File = Java.IO.File;
using Toolbar = AndroidX.AppCompat.Widget.Toolbar;
using Uri = Android.Net.Uri;

namespace WoWonder.Activities.Events
{
    [Activity(Icon = "@mipmap/icon", Theme = "@style/MyTheme", ConfigurationChanges = ConfigChanges.Locale | ConfigChanges.UiMode | ConfigChanges.ScreenSize | ConfigChanges.Orientation | ConfigChanges.ScreenLayout | ConfigChanges.SmallestScreenSize)]
    public class CreateEventActivity : BaseActivity, View.IOnClickListener, View.IOnFocusChangeListener
    {
        #region Variables Basic

        private EditText TxtEventName, TxtStartDate, TxtStartTime, TxtEndDate, TxtEndTime, TxtLocation, TxtDescription;
        private string EventPathImage = "";
        private PublisherAdView PublisherAdView;
        private LinearLayout llStep1, llStep2, llStep3, llStep5, llStep6;
        private RelativeLayout rlStep4;
        private Button BtnSave;
        private ImageView ImgSelect;
        private RoundedImageView RivImageEvent;
        private View ViewStep1, ViewStep2, ViewStep3, ViewStep4, ViewStep5, ViewStep6;
        private TextView TxtStep;
        private int nStep = 1;
        private readonly int nMaxStep = 6;

        #endregion

        #region General

        protected override void OnCreate(Bundle savedInstanceState)
        {
            try
            {
                base.OnCreate(savedInstanceState);
                SetTheme(AppSettings.SetTabDarkTheme ? Resource.Style.MyTheme_Dark_Base : Resource.Style.MyTheme_Base);

                Methods.App.FullScreenApp(this);

                // Create your application here
                SetContentView(Resource.Layout.CreateEvent_Layout);

                //Get Value And Set Toolbar
                InitComponent();
                InitToolbar();

                SetStep();
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        protected override void OnResume()
        {
            try
            {
                base.OnResume();
                AddOrRemoveEvent(true);
                PublisherAdView?.Resume();
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
                PublisherAdView?.Pause();
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
                ViewStep1 = FindViewById<View>(Resource.Id.view_step1);
                ViewStep2 = FindViewById<View>(Resource.Id.view_step2);
                ViewStep3 = FindViewById<View>(Resource.Id.view_step3);
                ViewStep4 = FindViewById<View>(Resource.Id.view_step4);
                ViewStep5 = FindViewById<View>(Resource.Id.view_step5);
                ViewStep6 = FindViewById<View>(Resource.Id.view_step6);

                TxtStep = FindViewById<TextView>(Resource.Id.tv_step);

                llStep1 = FindViewById<LinearLayout>(Resource.Id.ll_step1);
                llStep2 = FindViewById<LinearLayout>(Resource.Id.ll_step2);
                llStep3 = FindViewById<LinearLayout>(Resource.Id.ll_step3);
                llStep5 = FindViewById<LinearLayout>(Resource.Id.ll_step5);
                llStep6 = FindViewById<LinearLayout>(Resource.Id.ll_step6);
                rlStep4 = FindViewById<RelativeLayout>(Resource.Id.rl_step4);

                BtnSave = FindViewById<Button>(Resource.Id.btn_next);

                TxtEventName = FindViewById<EditText>(Resource.Id.eventname);
                TxtStartDate = FindViewById<EditText>(Resource.Id.StartDateTextview);
                TxtStartTime = FindViewById<EditText>(Resource.Id.StartTimeTextview);
                TxtEndDate = FindViewById<EditText>(Resource.Id.EndDateTextview);
                TxtEndTime = FindViewById<EditText>(Resource.Id.EndTimeTextview);
                TxtLocation = FindViewById<EditText>(Resource.Id.LocationTextview);
                TxtDescription = FindViewById<EditText>(Resource.Id.description);

                RivImageEvent = FindViewById<RoundedImageView>(Resource.Id.fundingCover);
                ImgSelect = FindViewById<ImageView>(Resource.Id.btn_selectimage);

                Methods.SetColorEditText(TxtEventName, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtStartTime, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtStartDate, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtEndDate, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtEndTime, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtLocation, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtDescription, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);

                Methods.SetFocusable(TxtStartTime);
                Methods.SetFocusable(TxtEndTime);
                Methods.SetFocusable(TxtStartDate);
                Methods.SetFocusable(TxtEndDate);

                TxtStartTime.SetOnClickListener(this);
                TxtEndTime.SetOnClickListener(this);
                TxtStartDate.SetOnClickListener(this);
                TxtEndDate.SetOnClickListener(this);
                TxtLocation.ClearFocus();

                PublisherAdView = FindViewById<PublisherAdView>(Resource.Id.multiple_ad_sizes_view);
                AdsGoogle.InitPublisherAdView(PublisherAdView);
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
                    toolBar.Title = GetText(Resource.String.Lbl_Create_Events);
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
                        BtnSave.Click += TxtAddOnClick;
                        TxtLocation.OnFocusChangeListener = this;
                        ImgSelect.Click += BtnImageOnClick;
                        break;
                    default:
                        BtnSave.Click -= TxtAddOnClick;
                        TxtLocation.OnFocusChangeListener = null!;
                        ImgSelect.Click -= BtnImageOnClick;
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
                PublisherAdView?.Destroy();

                TxtEventName = null!;
                TxtStartDate = null!;
                TxtStartTime = null!;
                TxtEndDate = null!;
                TxtEndTime = null!;
                TxtLocation = null!;
                TxtDescription = null!;
                RivImageEvent = null!;
                ImgSelect = null!;
                BtnSave = null!;
                EventPathImage = null!;

                PublisherAdView = null!;

                llStep1 = null!;
                llStep2 = null!;
                llStep3 = null!;
                llStep5 = null!;
                llStep6 = null!;
                rlStep4 = null!;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
        #endregion

        #region Events

        private void BtnImageOnClick(object sender, EventArgs e)
        {
            try
            {
                OpenDialogGallery();
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        private void TxtLocationOnFocusChange()
        {
            try
            {
                switch ((int)Build.VERSION.SdkInt)
                {
                    // Check if we're running on Android 5.0 or higher
                    case < 23:
                        //Open intent Location when the request code of result is 502
                        new IntentController(this).OpenIntentLocation();
                        break;
                    default:
                        {
                            if (CheckSelfPermission(Manifest.Permission.AccessFineLocation) == Permission.Granted && CheckSelfPermission(Manifest.Permission.AccessCoarseLocation) == Permission.Granted)
                            {
                                //Open intent Location when the request code of result is 502
                                new IntentController(this).OpenIntentLocation();
                            }
                            else
                            {
                                new PermissionsController(this).RequestPermission(105);
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

        private async void CreateEventFromSave()
        {
            try
            {
                if (!Methods.CheckConnectivity())
                {
                    ToastUtils.ShowToast(this, GetString(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                }
                else
                {
                    if (string.IsNullOrEmpty(TxtEventName.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_enter_name), ToastLength.Short);
                        return;
                    }

                    if (string.IsNullOrEmpty(TxtStartDate.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_select_start_date), ToastLength.Short);
                        return;
                    }

                    if (string.IsNullOrEmpty(TxtEndDate.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_select_end_date), ToastLength.Short);
                        return;
                    }

                    if (string.IsNullOrEmpty(TxtLocation.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_select_Location), ToastLength.Short);
                        return;
                    }

                    if (string.IsNullOrEmpty(TxtStartTime.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_select_start_time), ToastLength.Short);
                        return;
                    }

                    if (string.IsNullOrEmpty(TxtEndTime.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_select_end_time), ToastLength.Short);
                        return;
                    }

                    if (string.IsNullOrEmpty(TxtDescription.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_enter_Description), ToastLength.Short);
                        return;
                    }

                    if (string.IsNullOrEmpty(EventPathImage))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_select_Image), ToastLength.Short);
                    }
                    else
                    {
                        //Show a progress
                        AndHUD.Shared.Show(this, GetText(Resource.String.Lbl_Loading) + "...");

                        var (apiStatus, respond) = await RequestsAsync.Event.CreateEventAsync(TxtEventName.Text, TxtLocation.Text, TxtDescription.Text, TxtStartDate.Text.Replace("/", "-"), TxtEndDate.Text.Replace("/", ""), TxtStartTime.Text.Replace("AM", "").Replace("PM", "").Replace(" ", ""), TxtEndTime.Text.Replace(" ", "-").Replace("AM", "").Replace("PM", ""), EventPathImage);
                        switch (apiStatus)
                        {
                            case 200:
                                {
                                    switch (respond)
                                    {
                                        case CreateEvent result:
                                            {
                                                AndHUD.Shared.Dismiss(this);
                                                ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_CreatedSuccessfully), ToastLength.Short);

                                                var instance = EventMainActivity.GetInstance();
                                                //Add new item to my Event list
                                                if (result.Data != null)
                                                {
                                                    if (instance?.MyEventTab?.MAdapter?.EventList != null)
                                                    {
                                                        instance?.MyEventTab.MAdapter?.EventList?.Insert(0, result.Data);
                                                        instance?.MyEventTab.MAdapter?.NotifyItemInserted(0);
                                                    }

                                                    if (instance?.EventTab?.MAdapter?.EventList != null)
                                                    {
                                                        instance?.EventTab.MAdapter?.EventList?.Insert(0, result.Data);
                                                        instance?.EventTab.MAdapter?.NotifyItemInserted(0);
                                                    }
                                                }
                                                else
                                                {
                                                    var user = ListUtils.MyProfileList?.FirstOrDefault();
                                                    EventDataObject data = new EventDataObject
                                                    {
                                                        Id = result.EventId.ToString(),
                                                        Description = TxtDescription.Text,
                                                        Cover = EventPathImage,
                                                        EndDate = TxtEndDate.Text,
                                                        EndTime = TxtEndTime.Text,
                                                        IsOwner = true,
                                                        Location = TxtLocation.Text,
                                                        Name = TxtEventName.Text,
                                                        StartDate = TxtStartDate.Text,
                                                        StartTime = TxtStartTime.Text,
                                                        UserData = user,
                                                    };

                                                    if (instance?.MyEventTab?.MAdapter?.EventList != null)
                                                    {
                                                        instance?.MyEventTab.MAdapter?.EventList?.Insert(0, data);
                                                        instance?.MyEventTab.MAdapter?.NotifyItemInserted(0);
                                                    }

                                                    if (instance?.EventTab?.MAdapter?.EventList != null)
                                                    {
                                                        instance?.EventTab.MAdapter?.EventList?.Insert(0, data);
                                                        instance?.EventTab.MAdapter?.NotifyItemInserted(0);
                                                    }
                                                }

                                                Finish();
                                                break;
                                            }
                                    }

                                    break;
                                }
                            default:
                                Methods.DisplayAndHudErrorResult(this, respond);
                                break;
                        }
                    }
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
                AndHUD.Shared.Dismiss(this);
            }
        }

        private void TxtAddOnClick(object sender, EventArgs e)
        {
            switch (nStep)
            {
                case 1: // Event name
                    if (string.IsNullOrEmpty(TxtEventName.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_enter_name), ToastLength.Short);
                        return;
                    }
                    break;
                case 2: // Event start date and time
                    if (string.IsNullOrEmpty(TxtStartDate.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_select_start_date), ToastLength.Short);
                        return;
                    }
                    if (string.IsNullOrEmpty(TxtStartTime.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_select_start_time), ToastLength.Short);
                        return;
                    }
                    break;
                case 3: // Event end date and time
                    if (string.IsNullOrEmpty(TxtEndDate.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_select_end_date), ToastLength.Short);
                        return;
                    }
                    if (string.IsNullOrEmpty(TxtEndTime.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_select_end_time), ToastLength.Short);
                        return;
                    }
                    break;
                case 4: // Event Photo
                    if (string.IsNullOrEmpty(EventPathImage))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_select_Image), ToastLength.Short);
                    }
                    break;
                case 5:
                    if (string.IsNullOrEmpty(TxtLocation.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_select_Location), ToastLength.Short);
                        return;
                    }
                    break;
                case 6:
                    if (string.IsNullOrEmpty(TxtDescription.Text))
                    {
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_enter_Description), ToastLength.Short);
                        return;
                    }
                    break;
                default:
                    CreateEventFromSave();
                    return;
            }
            nStep += 1;
            SetStep();
        }

        #endregion

        #region Permissions && Result

        //Result
        protected override void OnActivityResult(int requestCode, Result resultCode, Intent data)
        {
            try
            {
                base.OnActivityResult(requestCode, resultCode, data);
                switch (requestCode)
                {
                    //If its from Camera or Gallery
                    case CropImage.CropImageActivityRequestCode:
                        {
                            var result = CropImage.GetActivityResult(data);

                            switch (resultCode)
                            {
                                case Result.Ok when result.IsSuccessful:
                                    {
                                        var resultUri = result.Uri;

                                        switch (string.IsNullOrEmpty(resultUri.Path))
                                        {
                                            case false:
                                                {
                                                    EventPathImage = resultUri.Path;

                                                    File file2 = new File(resultUri.Path);
                                                    var photoUri = FileProvider.GetUriForFile(this, PackageName + ".fileprovider", file2);
                                                    Glide.With(this).Load(photoUri).Apply(new RequestOptions()).Into(RivImageEvent);
                                                    break;
                                                }
                                            default:
                                                ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_something_went_wrong), ToastLength.Long);
                                                break;
                                        }

                                        break;
                                    }
                                case Result.Ok:
                                    ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_something_went_wrong), ToastLength.Long);
                                    break;
                            }

                            break;
                        }
                    // Location
                    case 502 when resultCode == Result.Ok:
                        {
                            var placeAddress = data.GetStringExtra("Address") ?? "";
                            TxtLocation.Text = string.IsNullOrEmpty(placeAddress) switch
                            {
                                //var placeLatLng = data.GetStringExtra("latLng") ?? "";
                                false => placeAddress,
                                _ => TxtLocation.Text
                            };

                            break;
                        }
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        //Permissions
        public override void OnRequestPermissionsResult(int requestCode, string[] permissions, Permission[] grantResults)
        {
            try
            {
                base.OnRequestPermissionsResult(requestCode, permissions, grantResults);

                switch (requestCode)
                {
                    case 108 when grantResults.Length > 0 && grantResults[0] == Permission.Granted:
                        OpenDialogGallery();
                        break;
                    case 108:
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Permission_is_denied), ToastLength.Long);
                        break;
                    //Open intent Location when the request code of result is 502
                    case 105 when grantResults.Length > 0 && grantResults[0] == Permission.Granted:
                        new IntentController(this).OpenIntentLocation();
                        break;
                    case 105:
                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Permission_is_denied), ToastLength.Long);
                        break;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        #endregion

        public void OnClick(View v)
        {
            try
            {
                if (v.Id == TxtStartTime.Id)
                {
                    var frag = PopupDialogController.TimePickerFragment.NewInstance(delegate (DateTime time)
                    {
                        TxtStartTime.Text = time.ToShortTimeString();
                    });

                    frag.Show(SupportFragmentManager, PopupDialogController.TimePickerFragment.Tag);
                }
                else if (v.Id == TxtEndTime.Id)
                {
                    var frag = PopupDialogController.TimePickerFragment.NewInstance(delegate (DateTime time)
                    {
                        TxtEndTime.Text = time.ToShortTimeString();
                    });

                    frag.Show(SupportFragmentManager, PopupDialogController.TimePickerFragment.Tag);
                }
                else if (v.Id == TxtStartDate.Id)
                {
                    var frag = PopupDialogController.DatePickerFragment.NewInstance(delegate (DateTime time)
                    {
                        TxtStartDate.Text = time.Date.ToString("yy-MM-dd");
                    });

                    frag.Show(SupportFragmentManager, PopupDialogController.DatePickerFragment.Tag);
                }
                else if (v.Id == TxtEndDate.Id)
                {
                    var frag = PopupDialogController.DatePickerFragment.NewInstance(delegate (DateTime time)
                    {
                        TxtEndDate.Text = time.Date.ToString("yy-MM-dd");
                    });
                    frag.Show(SupportFragmentManager, PopupDialogController.DatePickerFragment.Tag);
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        private void OpenDialogGallery()
        {
            try
            {
                if (!WoWonderTools.CheckAllowedFileUpload())
                {
                    Methods.DialogPopup.InvokeAndShowDialog(this, GetText(Resource.String.Lbl_Security), GetText(Resource.String.Lbl_Error_AllowedFileUpload), GetText(Resource.String.Lbl_Ok));
                    return;
                }

                switch ((int)Build.VERSION.SdkInt)
                {
                    // Check if we're running on Android 5.0 or higher
                    case < 23:
                        {
                            Methods.Path.Chack_MyFolder();

                            //Open Image 
                            var myUri = Uri.FromFile(new File(Methods.Path.FolderDiskImage, Methods.GetTimestamp(DateTime.Now) + ".jpeg"));
                            CropImage.Activity()
                                .SetInitialCropWindowPaddingRatio(0)
                                .SetAutoZoomEnabled(true)
                                .SetMaxZoom(4)
                                .SetGuidelines(CropImageView.Guidelines.On)
                                .SetCropMenuCropButtonTitle(GetText(Resource.String.Lbl_Crop))
                                .SetOutputUri(myUri).Start(this);
                            break;
                        }
                    default:
                        {
                            if (!CropImage.IsExplicitCameraPermissionRequired(this) && CheckSelfPermission(Manifest.Permission.ReadExternalStorage) == Permission.Granted &&
                                CheckSelfPermission(Manifest.Permission.WriteExternalStorage) == Permission.Granted && CheckSelfPermission(Manifest.Permission.Camera) == Permission.Granted)
                            {
                                Methods.Path.Chack_MyFolder();

                                //Open Image 
                                var myUri = Uri.FromFile(new File(Methods.Path.FolderDiskImage, Methods.GetTimestamp(DateTime.Now) + ".jpeg"));
                                CropImage.Activity()
                                    .SetInitialCropWindowPaddingRatio(0)
                                    .SetAutoZoomEnabled(true)
                                    .SetMaxZoom(4)
                                    .SetGuidelines(CropImageView.Guidelines.On)
                                    .SetCropMenuCropButtonTitle(GetText(Resource.String.Lbl_Crop))
                                    .SetOutputUri(myUri).Start(this);
                            }
                            else
                            {
                                new PermissionsController(this).RequestPermission(108);
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

        public void OnFocusChange(View v, bool hasFocus)
        {
            if (v?.Id == TxtLocation.Id && hasFocus)
            {
                TxtLocationOnFocusChange();
            }
        }

        public void SetStep()
        {
            TxtStep.Text = nStep + "/" + nMaxStep;

            switch (nStep)
            {
                case 1:
                    llStep1.Visibility = ViewStates.Visible;
                    llStep2.Visibility = ViewStates.Gone;
                    llStep3.Visibility = ViewStates.Gone;
                    rlStep4.Visibility = ViewStates.Gone;
                    llStep5.Visibility = ViewStates.Gone;
                    llStep6.Visibility = ViewStates.Gone;
                    ViewStep1.Background.SetTint(Color.ParseColor("#4E586E"));
                    ViewStep2.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    ViewStep3.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    ViewStep4.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    ViewStep5.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    ViewStep6.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    break;
                case 2:
                    llStep1.Visibility = ViewStates.Gone;
                    llStep2.Visibility = ViewStates.Visible;
                    llStep3.Visibility = ViewStates.Gone;
                    rlStep4.Visibility = ViewStates.Gone;
                    llStep5.Visibility = ViewStates.Gone;
                    llStep6.Visibility = ViewStates.Gone;
                    ViewStep1.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep2.Background.SetTint(Color.ParseColor("#4E586E"));
                    ViewStep3.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    ViewStep4.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    ViewStep5.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    ViewStep6.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    break;
                case 3:
                    llStep1.Visibility = ViewStates.Gone;
                    llStep2.Visibility = ViewStates.Gone;
                    llStep3.Visibility = ViewStates.Visible;
                    rlStep4.Visibility = ViewStates.Gone;
                    llStep5.Visibility = ViewStates.Gone;
                    llStep6.Visibility = ViewStates.Gone;
                    ViewStep1.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep2.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep3.Background.SetTint(Color.ParseColor("#4E586E"));
                    ViewStep4.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    ViewStep5.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    ViewStep6.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    break;
                case 4:
                    llStep1.Visibility = ViewStates.Gone;
                    llStep2.Visibility = ViewStates.Gone;
                    llStep3.Visibility = ViewStates.Gone;
                    rlStep4.Visibility = ViewStates.Visible;
                    llStep5.Visibility = ViewStates.Gone;
                    llStep6.Visibility = ViewStates.Gone;
                    ViewStep1.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep2.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep3.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep4.Background.SetTint(Color.ParseColor("#4E586E"));
                    ViewStep5.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    ViewStep6.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    break;
                case 5:
                    llStep1.Visibility = ViewStates.Gone;
                    llStep2.Visibility = ViewStates.Gone;
                    llStep3.Visibility = ViewStates.Gone;
                    rlStep4.Visibility = ViewStates.Gone;
                    llStep5.Visibility = ViewStates.Visible;
                    llStep6.Visibility = ViewStates.Gone;
                    ViewStep1.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep2.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep3.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep4.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep5.Background.SetTint(Color.ParseColor("#4E586E"));
                    ViewStep6.Background.SetTint(Color.ParseColor("#C6CBC7"));
                    break;
                case 6:
                    llStep1.Visibility = ViewStates.Gone;
                    llStep2.Visibility = ViewStates.Gone;
                    llStep3.Visibility = ViewStates.Gone;
                    rlStep4.Visibility = ViewStates.Gone;
                    llStep5.Visibility = ViewStates.Gone;
                    llStep6.Visibility = ViewStates.Visible;
                    ViewStep1.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep2.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep3.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep4.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep5.Background.SetTint(Color.ParseColor("#00E711"));
                    ViewStep6.Background.SetTint(Color.ParseColor("#4E586E"));
                    break;
                default:
                    break;
            }
        }

        public override void OnBackPressed()
        {
            if (nStep > 1)
            {
                nStep -= 1;
                SetStep();
                return;
            }
            base.OnBackPressed();
        }

    }
}