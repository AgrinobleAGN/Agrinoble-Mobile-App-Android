using System;
using System.Collections.Generic;
using System.Linq;
using Android.App;
using Android.Content;
using Android.Content.PM;
using Android.Graphics;
using Android.OS;
using Android.Text;
using Android.Views;
using Android.Widget;
using AndroidHUD;
using AndroidX.AppCompat.Content.Res;
using Com.Stripe.Android;
using Com.Stripe.Android.Model;
using Com.Stripe.Android.View;
using WoWonder.Activities.Base;
using WoWonder.Activities.Fundings;
using WoWonder.Activities.Wallet;
using WoWonder.Helpers.Utils;
using WoWonder.SQLite;
using WoWonderClient.Requests;
using Exception = System.Exception;
using Math = System.Math;
using Toolbar = AndroidX.AppCompat.Widget.Toolbar;

namespace WoWonder.Payment
{
    [Activity(Icon = "@mipmap/icon", Theme = "@style/MyTheme", ConfigurationChanges = ConfigChanges.Locale | ConfigChanges.UiMode | ConfigChanges.ScreenSize | ConfigChanges.Orientation | ConfigChanges.ScreenLayout | ConfigChanges.SmallestScreenSize)]
    public class PaymentCardDetailsActivity : BaseActivity, ITokenCallback
    {
        #region Variables Basic

        private TextView CardNumber, CardExpire, CardCvv, CardName;
        private EditText EtName;
        private Button BtnApply;
        private CardMultilineWidget MultilineWidget;

        private Stripe Stripe;
        private string Price, PayType, Id, TokenId;

        #endregion

        #region General

        protected override void OnCreate(Bundle savedInstanceState)
        {
            try
            {
                base.OnCreate(savedInstanceState);

                Methods.App.FullScreenApp(this);

                SetTheme(AppSettings.SetTabDarkTheme ? Resource.Style.MyTheme_Dark_Base : Resource.Style.MyTheme_Base);

                // Create your application here
                SetContentView(Resource.Layout.PaymentCardDetailsLayout);

                Id = Intent?.GetStringExtra("Id") ?? "";
                Price = Intent?.GetStringExtra("Price") ?? "";
                PayType = Intent?.GetStringExtra("payType") ?? "";

                //Get Value And Set Toolbar
                InitComponent();
                InitToolbar();
                InitWalletStripe();
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
                CardNumber = (TextView)FindViewById(Resource.Id.card_number);
                CardExpire = (TextView)FindViewById(Resource.Id.card_expire);
                CardCvv = (TextView)FindViewById(Resource.Id.card_cvv);
                CardName = (TextView)FindViewById(Resource.Id.card_name);

                MultilineWidget = (CardMultilineWidget)FindViewById(Resource.Id.card_multiline_widget);

                EtName = (EditText)FindViewById(Resource.Id.et_name);
                BtnApply = (Button)FindViewById(Resource.Id.ApplyButton);

                Methods.SetColorEditText(EtName, AppSettings.SetTabDarkTheme ? Color.White : Color.Black);
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
                    toolBar.Title = GetString(Resource.String.Lbl_CreditCard);
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
                // true +=  // false -=
                if (addEvent)
                {
                    MultilineWidget.CvcComplete += MultilineWidgetOnCvcComplete;
                    EtName.TextChanged += EtNameOnTextChanged;
                    BtnApply.Click += BtnApplyOnClick;
                }
                else
                {
                    MultilineWidget.CvcComplete -= MultilineWidgetOnCvcComplete;
                    EtName.TextChanged -= EtNameOnTextChanged;
                    BtnApply.Click -= BtnApplyOnClick;
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        #endregion

        #region Events

        private void MultilineWidgetOnCvcComplete(object sender, EventArgs e)
        {
            try
            {
                if (MultilineWidget.Card != null && MultilineWidget.Card.ValidateCard() && MultilineWidget.ValidateAllFields())
                {
                    if (MultilineWidget.Card.Number.Trim().Length == 0)
                    {
                        CardNumber.Text = "**** **** **** ****";
                    }
                    else
                    {
                        string number = InsertPeriodically(MultilineWidget.Card.Number.Trim(), " ", 4);
                        CardNumber.Text = number;
                    }

                    if (MultilineWidget.Card.ExpMonth.ToString().Trim().Length == 0 && MultilineWidget.Card.ExpYear.ToString().Trim().Length == 0)
                    {
                        CardExpire.Text = "MM/YY";
                    }
                    else
                    {
                        CardExpire.Text = MultilineWidget.Card.ExpMonth + "/" + MultilineWidget.Card.ExpYear;
                    }

                    CardCvv.Text = MultilineWidget.Card.CVC.Trim().Length == 0 ? "***" : MultilineWidget.Card.CVC.Trim();
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        private void EtNameOnTextChanged(object sender, TextChangedEventArgs e)
        {
            try
            {
                CardName.Text = e?.Text?.ToString().Trim().Length == 0 ? GetString(Resource.String.Lbl_YourName) : e?.Text?.ToString().Trim();
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        //Stripe
        private void BtnApplyOnClick(object sender, EventArgs e)
        {
            try
            {
                if (MultilineWidget.Card.ValidateCard() && !string.IsNullOrEmpty(EtName.Text))
                {
                    //Show a progress
                    AndHUD.Shared.Show(this, GetText(Resource.String.Lbl_Loading));

                    Card card = MultilineWidget.Card;
                    Stripe.CreateToken(card, PaymentConfiguration.Instance.PublishableKey, this);
                }
                else
                {
                    ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_PleaseVerifyDataCard), ToastLength.Long);
                }
            }
            catch (Exception exception)
            {
                AndHUD.Shared.Dismiss(this);
                Methods.DisplayReportResultTrack(exception);
            }
        }

        private string InsertPeriodically(string text, string insert, int period)
        {
            try
            {
                var parts = SplitInParts(text, period);
                string formatted = string.Join(insert, parts);
                return formatted;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
                return text;
            }
        }

        public static IEnumerable<string> SplitInParts(string s, int partLength)
        {
            if (s == null)
                throw new ArgumentNullException("s");
            if (partLength <= 0)
                throw new ArgumentException("Part length has to be positive.", "partLength");

            for (var i = 0; i < s.Length; i += partLength)
                yield return s.Substring(i, Math.Min(partLength, s.Length - i));
        }

        #endregion

        #region Stripe

        private void InitWalletStripe()
        {
            try
            {
                var stripePublishableKey = ListUtils.SettingsSiteList?.StripeId ?? "";
                if (!string.IsNullOrEmpty(stripePublishableKey))
                {
                    PaymentConfiguration.Init(stripePublishableKey);
                    Stripe = new Stripe(this, stripePublishableKey);
                }
                else
                {
                    ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_ErrorConnectionSystemStripe), ToastLength.Long);
                }
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public void OnError(Java.Lang.Exception error)
        {
            try
            {
                AndHUD.Shared.Dismiss(this);
                ToastUtils.ShowToast(this, error.Message, ToastLength.Long);
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public async void OnSuccess(Token token)
        {
            try
            {
                // Send token to your own web service
                //var stripeBankAccount = token.BankAccount;
                //var stripeCard = token.Card;
                //var stripeCreated = token.Created;
                TokenId = token.Id;
                //var stripeLiveMode = token.Livemode;
                //var stripeType = token.Type;
                //var stripeUsed = token.Used;

                if (Methods.CheckConnectivity())
                {
                    switch (PayType)
                    {
                        //send api  
                        case "Funding":
                            {
                                var (apiStatus, respond) = await RequestsAsync.Payments.StripeAsync(TokenId, "fund", Id);
                                switch (apiStatus)
                                {
                                    case 200:
                                        ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Donated), ToastLength.Long);
                                        FundingViewActivity.GetInstance()?.StartApiService();
                                        break;
                                    default:
                                        Methods.DisplayReportResult(this, respond);
                                        break;
                                }

                                break;
                            }
                        case "membership" when Methods.CheckConnectivity():
                        {
                            var (apiStatus, respond) = await RequestsAsync.Payments.StripeAsync(TokenId, "pro", Id);
                                switch (apiStatus)
                                {
                                    case 200:
                                        {
                                            var dataUser = ListUtils.MyProfileList?.FirstOrDefault();
                                            if (dataUser != null)
                                            {
                                                dataUser.IsPro = "1";

                                                var sqlEntity = new SqLiteDatabase();
                                                sqlEntity.Insert_Or_Update_To_MyProfileTable(dataUser);

                                            }

                                            ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Upgraded), ToastLength.Long);
                                            break;
                                        }
                                    default:
                                        Methods.DisplayReportResult(this, respond);
                                        break;
                                }

                                break;
                            }
                        case "membership":
                            ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Long);
                            break;
                        case "AddFunds":
                            {
                                var tabbedWallet = TabbedWalletActivity.GetInstance();
                                if (Methods.CheckConnectivity() && tabbedWallet != null)
                                {
                                    var (apiStatus, respond) = await RequestsAsync.Payments.StripeAsync(TokenId, "wallet", "");
                                    switch (apiStatus)
                                    {
                                        case 200:
                                            tabbedWallet.SendMoneyFragment.TxtAmount.Text = string.Empty;
                                            tabbedWallet.SendMoneyFragment.TxtEmail.Text = string.Empty;

                                            ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_Sent_successfully), ToastLength.Long);
                                            break;
                                        default:
                                            Methods.DisplayReportResult(this, respond);
                                            break;
                                    }
                                }
                                else
                                {
                                    ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Long);
                                }

                                break;
                            }
                    }

                    AndHUD.Shared.Dismiss(this);
                    Finish();
                }
                else
                {
                    ToastUtils.ShowToast(this, GetText(Resource.String.Lbl_CheckYourInternetConnection), ToastLength.Long);
                }
            }
            catch (Exception e)
            {
                AndHUD.Shared.Dismiss(this);
                Methods.DisplayReportResultTrack(e);
            }
        }

        #endregion  
    }
}