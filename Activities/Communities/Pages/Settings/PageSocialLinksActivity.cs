﻿using System;
using System.Collections.Generic;
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
using Newtonsoft.Json;
using WoWonder.Activities.Base;
using WoWonder.Helpers.Ads;
using WoWonder.Helpers.Fonts;
using WoWonder.Helpers.Utils;
using WoWonderClient.Classes.Global;
using WoWonderClient.Requests;
using Exception = System.Exception;
using Toolbar = AndroidX.AppCompat.Widget.Toolbar;

namespace WoWonder.Activities.Communities.Pages.Settings
{ 
    [Activity(Icon = "@mipmap/icon", Theme = "@style/MyTheme", ConfigurationChanges = ConfigChanges.Locale | ConfigChanges.UiMode | ConfigChanges.ScreenSize | ConfigChanges.Orientation | ConfigChanges.ScreenLayout | ConfigChanges.SmallestScreenSize)]
    public class PageSocialLinksActivity : BaseActivity 
    {
        #region Variables Basic

        private TextView TxtSave, IconFacebook, IconTwitter, IconInstagram, IconVk, IconLinkedin, IconYouTube;
        private EditText TxtFacebook, TxtTwitter, TxtInstagram, TxtVk, TxtLinkedin, TxtYouTube;
        private string PagesId = "";
        private PageClass PageData;
        
        private PublisherAdView PublisherAdView;

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
                SetContentView(Resource.Layout.PageSocialLinksLayout);

                var id = Intent?.GetStringExtra("PageId") ?? "Data not available";
                if (id != "Data not available" && !string.IsNullOrEmpty(id)) PagesId = id;

                //Get Value And Set Toolbar
                InitComponent();
                InitToolbar();

                Get_Data_Page();
                AdsGoogle.Ad_RewardedVideo(this);
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
                TxtSave = FindViewById<TextView>(Resource.Id.toolbar_title);

                IconFacebook = FindViewById<TextView>(Resource.Id.IconFacebook);
                TxtFacebook = FindViewById<EditText>(Resource.Id.FacebookEditText);

                IconTwitter = FindViewById<TextView>(Resource.Id.IconTwitter);
                TxtTwitter = FindViewById<EditText>(Resource.Id.TwitterEditText);

                IconInstagram = FindViewById<TextView>(Resource.Id.IconInstagram);
                TxtInstagram = FindViewById<EditText>(Resource.Id.InstagramEditText);

                IconVk = FindViewById<TextView>(Resource.Id.IconVk);
                TxtVk = FindViewById<EditText>(Resource.Id.VkEditText);

                IconLinkedin = FindViewById<TextView>(Resource.Id.IconLinkedin);
                TxtLinkedin = FindViewById<EditText>(Resource.Id.LinkedinEditText);

                IconYouTube = FindViewById<TextView>(Resource.Id.IconYouTube);
                TxtYouTube = FindViewById<EditText>(Resource.Id.YouTubeEditText);

                FontUtils.SetTextViewIcon(FontsIconFrameWork.IonIcons, IconFacebook, IonIconsFonts.LogoFacebook);
                FontUtils.SetTextViewIcon(FontsIconFrameWork.IonIcons, IconTwitter, IonIconsFonts.LogoTwitter);
                FontUtils.SetTextViewIcon(FontsIconFrameWork.IonIcons, IconInstagram, IonIconsFonts.Happy);
                FontUtils.SetTextViewIcon(FontsIconFrameWork.FontAwesomeBrands, IconVk, FontAwesomeIcon.Vk);
                FontUtils.SetTextViewIcon(FontsIconFrameWork.IonIcons, IconLinkedin, IonIconsFonts.LogoLinkedin);
                FontUtils.SetTextViewIcon(FontsIconFrameWork.IonIcons, IconYouTube, IonIconsFonts.LogoYoutube);

                Methods.SetColorEditText(TxtFacebook, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtTwitter, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtInstagram, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtVk, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtLinkedin, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
                Methods.SetColorEditText(TxtYouTube, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);

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
                    toolBar.Title = GetText(Resource.String.Lbl_SocialLinks);
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
                        TxtSave.Click += TxtSaveOnClick;
                        break;
                    default:
                        TxtSave.Click -= TxtSaveOnClick;
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
                
                TxtSave = null!;
                IconFacebook = null!;
                IconTwitter = null!;
                IconInstagram = null!;
                IconVk = null!;
                IconLinkedin = null!;
                IconYouTube = null!;
                TxtFacebook = null!;
                TxtTwitter = null!;
                TxtInstagram = null!;
                TxtVk = null!;
                TxtLinkedin = null!;
                TxtYouTube = null!;
                PagesId = null!;
                PageData = null!;
                
                PublisherAdView = null!;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
        #endregion

        #region Events

        private async void TxtSaveOnClick(object sender, EventArgs e)
        {
            try
            {
                if (!Methods.CheckConnectivity())
                {
                    ToastUtils.ShowToast(this, GetString(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Short);
                }
                else
                {
                    //Show a progress
                    AndHUD.Shared.Show(this, GetText(Resource.String.Lbl_Loading) + "...");

                    var dictionary = new Dictionary<string, string>
                    {
                        {"facebook", TxtFacebook.Text},
                        {"twitter", TxtTwitter.Text},
                        {"instgram", TxtInstagram.Text},
                        {"vk", TxtVk.Text},
                        {"linkedin", TxtLinkedin.Text},
                        {"youtube", TxtYouTube.Text},
                    };

                    var (apiStatus, respond) = await RequestsAsync.Page.UpdatePageDataAsync(PagesId, dictionary);
                    switch (apiStatus)
                    {
                        case 200:
                        {
                            switch (respond)
                            {
                                case MessageObject result:
                                {
                                    AndHUD.Shared.Dismiss(this);
                                    Console.WriteLine(result.Message);

                                    PageData.Facebook = TxtFacebook.Text;
                                    PageData.Twitter = TxtTwitter.Text;
                                    PageData.Instgram = TxtInstagram.Text;
                                    PageData.Vk = TxtVk.Text;
                                    PageData.Linkedin = TxtLinkedin.Text;
                                    PageData.Youtube = TxtYouTube.Text;

                                    PageProfileActivity.PageData = PageData;

                                    ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_YourPageWasUpdated), ToastLength.Short);

                                    Intent returnIntent = new Intent();
                                    returnIntent?.PutExtra("pageItem", JsonConvert.SerializeObject(PageData));
                                    SetResult(Result.Ok, returnIntent);
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
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
                AndHUD.Shared.Dismiss(this);
            }
        }

        #endregion

        //Get Data Page and set Categories
        private void Get_Data_Page()
        {
            try
            {
                PageData = JsonConvert.DeserializeObject<PageClass>(Intent?.GetStringExtra("PageData") ?? "");
                if (PageData != null)
                {
                    TxtFacebook.Text = PageData.Facebook;
                    TxtTwitter.Text = PageData.Twitter;
                    TxtInstagram.Text = PageData.Instgram;
                    TxtVk.Text = PageData.Vk;
                    TxtLinkedin.Text = PageData.Linkedin;
                    TxtYouTube.Text = PageData.Youtube;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
    }
}