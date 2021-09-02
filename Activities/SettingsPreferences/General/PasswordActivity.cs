﻿using System;
using System.Collections.Generic;
using System.Linq;
using Android.App;
using Android.Content;
using Android.Content.PM;
using Android.Graphics;
using Android.OS;
using Android.Views;
using Android.Widget;
using AndroidHUD;
using AndroidX.AppCompat.Content.Res;
using WoWonder.Activities.Base;
using WoWonder.Activities.Default;
using WoWonder.Helpers.Ads;
using WoWonder.Helpers.Model;
using WoWonder.Helpers.Utils;
using WoWonderClient.Classes.Global;
using WoWonderClient.Requests;
using Exception = System.Exception;
using Toolbar = AndroidX.AppCompat.Widget.Toolbar;

namespace WoWonder.Activities.SettingsPreferences.General
{
    [Activity(Icon = "@mipmap/icon", Theme = "@style/MyTheme", ConfigurationChanges = ConfigChanges.Locale | ConfigChanges.UiMode | ConfigChanges.ScreenSize | ConfigChanges.Orientation | ConfigChanges.ScreenLayout | ConfigChanges.SmallestScreenSize)]
    public class PasswordActivity : BaseActivity 
    {
        #region Variables Basic

        private EditText TxtCurrentPassword, TxtNewPassword, TxtRepeatPassword;
        private TextView TxtLinkForget;
        private Button BtnSave;

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
                SetContentView(Resource.Layout.Settings_Password_Layout);

                //Get Value And Set Toolbar
                InitComponent();
                InitToolbar(); 
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
                BtnSave = FindViewById<Button>(Resource.Id.SaveButton);

                TxtCurrentPassword = FindViewById<EditText>(Resource.Id.CurrentPasswordEditText);
                 
                TxtNewPassword = FindViewById<EditText>(Resource.Id.NewPasswordEditText);
                 
                TxtRepeatPassword = (EditText)FindViewById(Resource.Id.RepeatPasswordEditText);

                TxtLinkForget = FindViewById<TextView>(Resource.Id.linkText);
                 
                Methods.SetColorEditText(TxtCurrentPassword, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtNewPassword, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtRepeatPassword, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);

                AdsGoogle.Ad_AdMobNative(this); 
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
                    toolBar.Title = GetText(Resource.String.Lbl_Change_Password);
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
                        TxtLinkForget.Click += TxtLinkForget_OnClick;
                        BtnSave.Click += SaveData_OnClick;
                        break;
                    default:
                        TxtLinkForget.Click -= TxtLinkForget_OnClick;
                        BtnSave.Click -= SaveData_OnClick;
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
                BtnSave = null!;
                TxtCurrentPassword = null!;
                TxtNewPassword = null!;
                TxtRepeatPassword = null!;
                TxtLinkForget = null!;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
        #endregion

        #region Events

        private void TxtLinkForget_OnClick(object sender, EventArgs e)
        {
            try
            {
                StartActivity(typeof(ForgetPasswordActivity));
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        //Save data 
        private async void SaveData_OnClick(object sender, EventArgs eventArgs)
        {
            try
            {
                if (!Methods.CheckConnectivity())
                {
                    ToastUtils.ShowToast(this, GetString(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                    return;
                }

                if (string.IsNullOrEmpty(TxtCurrentPassword.Text) || string.IsNullOrEmpty(TxtNewPassword.Text) || string.IsNullOrEmpty(TxtRepeatPassword.Text))
                {
                    ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Please_check_your_details), ToastLength.Long);
                    return;
                }

                if (TxtNewPassword.Text != TxtRepeatPassword.Text)
                {
                    ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Your_password_dont_match), ToastLength.Long);
                    return;
                }

                //Show a progress
                AndHUD.Shared.Show(this, GetText(Resource.String.Lbl_Loading));
                var dataUser = ListUtils.MyProfileList?.FirstOrDefault();

                var dataPrivacy = new Dictionary<string, string>
                {
                    {"new_password", TxtNewPassword.Text},
                    {"current_password", TxtCurrentPassword.Text},

                    {"e_memory", dataUser?.ApiNotificationSettings.NotificationSettingsClass?.EMemory ?? "1"},
                    {"e_profile_wall_post", dataUser?.ApiNotificationSettings.NotificationSettingsClass?.EProfileWallPost ?? "1"},
                    {"e_accepted", dataUser?.ApiNotificationSettings.NotificationSettingsClass?.EAccepted ?? "1"},
                    {"e_joined_group", dataUser?.ApiNotificationSettings.NotificationSettingsClass?.EJoinedGroup ?? "1"},
                    {"e_mentioned", dataUser?.ApiNotificationSettings.NotificationSettingsClass?.EMentioned ?? "1"},
                    {"e_visited", dataUser?.ApiNotificationSettings.NotificationSettingsClass?.EVisited ?? "1"},
                    {"e_liked_page", dataUser?.ApiNotificationSettings.NotificationSettingsClass?.ELikedPage ?? "1"},
                    {"e_followed", dataUser?.ApiNotificationSettings.NotificationSettingsClass?.EFollowed ?? "1"},
                    {"e_shared", dataUser?.ApiNotificationSettings.NotificationSettingsClass?.EShared ?? "1"},
                    {"e_commented", dataUser?.ApiNotificationSettings.NotificationSettingsClass?.ECommented ?? "1"},
                    {"e_liked", dataUser?.ApiNotificationSettings.NotificationSettingsClass?.ELiked ?? "1"},
                };

                var (apiStatus, respond) = await RequestsAsync.Global.UpdateUserDataAsync(dataPrivacy);
                switch (apiStatus)
                {
                    case 200:
                    {
                        switch (respond)
                        {
                            case MessageObject result when result.Message.Contains("updated"):
                                UserDetails.Password = TxtNewPassword.Text;

                                ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_YourDetailsWasUpdated), ToastLength.Short);
                                AndHUD.Shared.Dismiss(this);
                                break;
                            case MessageObject result:
                                //Show a Error image with a message
                                AndHUD.Shared.ShowError(this, result.Message, MaskType.Clear, TimeSpan.FromSeconds(1));
                                break;
                        }

                        break;
                    }
                    default:
                        Methods.DisplayAndHudErrorResult(this, respond);
                        break;
                } 
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                //Show a Error image with a message
                AndHUD.Shared.ShowError(this, e.Message, MaskType.Clear, TimeSpan.FromSeconds(1));
            }
        }

        #endregion

    }
}