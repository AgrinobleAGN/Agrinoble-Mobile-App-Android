//##############################################
//Cᴏᴘʏʀɪɢʜᴛ 2020 DᴏᴜɢʜᴏᴜᴢLɪɢʜᴛ Codecanyon Item 19703216
//Elin Doughouz >> https://www.facebook.com/Elindoughouz
//====================================================

//For the accuracy of the icon and logo, please use this website " https://appicon.co " and add images according to size in folders " mipmap " 

using System.Collections.Generic;
using WoWonder.Activities.NativePost.Extra;
using WoWonder.Helpers.Model;
using WoWonderClient;

namespace WoWonder
{
    internal static class AppSettings
    {
        /// <summary>
        /// Deep Links To App Content
        /// you should add your website without http in the analytic.xml file >> ../values/analytic.xml .. line 5
        /// <string name="ApplicationUrlWeb">demo.wowonder.com</string>
        /// </summary>
        /// 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
        public static string TripleDesAppServiceProvider = "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";

        //Main Settings >>>>>
        //*********************************************************
        public static string Version = "3.0";
        public static string ApplicationName = "Agrinoble";
        public static string DatabaseName = "agrinoble_db"; 

        // Friend system = 0 , follow system = 1
        public static int ConnectivitySystem = 1;
         
        //Main Colors >>
        //*********************************************************
        public static string MainColor = "#006633";
         
        //Language Settings >> http://www.lingoes.net/en/translator/langcode.htm
        //*********************************************************
        public static bool FlowDirectionRightToLeft = false;
        public static string Lang = ""; //Default language ar

        //Set Language User on site from phone 
        public static bool SetLangUser = true; 

        //Notification Settings >>
        //*********************************************************
        public static bool ShowNotification = true;
        public static string OneSignalAppId = "64974c58-9993-40ed-b782-0814edc401ea";
        public static string MsgOneSignalAppId = "64974c58-9993-40ed-b782-0814edc401ea";

        // WalkThrough Settings >>
        //*********************************************************
        public static bool ShowWalkTroutPage = true;

        //Main Messenger settings
        //*********************************************************
        public static bool MessengerIntegration = true;
        public static bool ShowDialogAskOpenMessenger = false; 
        public static string MessengerPackageName = "com.sarl.agrinoble.agrinoble"; //APK name on Google Play

        //AdMob >> Please add the code ad in the Here and analytic.xml 
        //*********************************************************
        public static bool ShowAdMobBanner = false;
        public static bool ShowAdMobInterstitial = false;
        public static bool ShowAdMobRewardVideo = false;
        public static bool ShowAdMobNative = false;
        public static bool ShowAdMobNativePost = false;
        public static bool ShowAdMobAppOpen = false;  
        public static bool ShowAdMobRewardedInterstitial = false;  

        public static string AdInterstitialKey = "ca-app-pub-5135691635931982/3584502890";
        public static string AdRewardVideoKey = "ca-app-pub-5135691635931982/2518408206";
        public static string AdAdMobNativeKey = "ca-app-pub-5135691635931982/2280543246";
        public static string AdAdMobAppOpenKey = "ca-app-pub-5135691635931982/2813560515";  
        public static string AdRewardedInterstitialKey = "ca-app-pub-5135691635931982/7842669101";  

        //Three times after entering the ad is displayed
        public static int ShowAdMobInterstitialCount = 3;
        public static int ShowAdMobRewardedVideoCount = 3;
        public static int ShowAdMobNativeCount = 40;
        public static int ShowAdMobAppOpenCount = 2;  
        public static int ShowAdMobRewardedInterstitialCount = 3;  

        //FaceBook Ads >> Please add the code ad in the Here and analytic.xml 
        //*********************************************************
        public static bool ShowFbBannerAds = false; 
        public static bool ShowFbInterstitialAds = false;  
        public static bool ShowFbRewardVideoAds = false; 
        public static bool ShowFbNativeAds = false; 
         
        //YOUR_PLACEMENT_ID
        public static string AdsFbBannerKey = "250485588986218_554026418632132"; 
        public static string AdsFbInterstitialKey = "250485588986218_554026125298828";  
        public static string AdsFbRewardVideoKey = "250485588986218_554072818627492"; 
        public static string AdsFbNativeKey = "250485588986218_554706301897477"; 

        //Three times after entering the ad is displayed
        public static int ShowFbNativeAdsCount = 40;

        //Colony Ads >> Please add the code ad in the Here 
        //*********************************************************  
        public static bool ShowColonyBannerAds = false; //#New
        public static bool ShowColonyInterstitialAds = false; //#New
        public static bool ShowColonyRewardAds = false; //#New

        public static string AdsColonyAppId = "appff22269a7a0a4be8aa"; //#New
        public static string AdsColonyBannerId = "vz85ed7ae2d631414fbd"; //#New
        public static string AdsColonyInterstitialId = "vz39712462b8634df4a8"; //#New
        public static string AdsColonyRewardedId = "vz32ceec7a84aa4d719a"; //#New 
        //********************************************************* 

        public static bool EnableRegisterSystem = true;
        /// <summary>
        /// true => Only over 18 years old
        /// false => all 
        /// </summary>
        public static bool IsUserYearsOld = true; //#New

        //Set Theme Full Screen App
        //*********************************************************
        public static bool EnableFullScreenApp = false;
            
        //Code Time Zone (true => Get from Internet , false => Get From #CodeTimeZone )
        //*********************************************************
        public static bool AutoCodeTimeZone = true;
        public static string CodeTimeZone = "UTC";

        //Error Report Mode
        //*********************************************************
        public static bool SetApisReportMode = false;

        //Social Logins >>
        //If you want login with facebook or google you should change id key in the analytic.xml file 
        //Facebook >> ../values/analytic.xml .. line 10-11 
        //Google >> ../values/analytic.xml .. line 15 
        //*********************************************************
        public static bool ShowFacebookLogin = true;
        public static bool ShowGoogleLogin = true;

        public static readonly string ClientId = "212666549038-e6bfab882a8l6uqifht425op7u194rkb.apps.googleusercontent.com";

        //########################### 

        //Main Slider settings
        //*********************************************************
        public static PostButtonSystem PostButton = PostButtonSystem.ReactionDefault;
        public static ToastTheme ToastTheme = ToastTheme.Custom;//#New 

        public static BottomNavigationSystem NavigationBottom = BottomNavigationSystem.Default;//#New 

        public static bool ShowBottomAddOnTab = true; //New 
         
        public static bool ShowAlbum = true;
        public static bool ShowArticles = true;
        public static bool ShowPokes = false;
        public static bool ShowCommunitiesGroups = true;
        public static bool ShowCommunitiesPages = true;
        public static bool ShowMarket = true;
        public static bool ShowPopularPosts = true;
        public static bool ShowBoostedPosts = true; //New 
        public static bool ShowBoostedPages = true; //New 
        public static bool ShowMovies = false;
        public static bool ShowNearBy = true;
        public static bool ShowStory = true;
        public static bool ShowSavedPost = true;
        public static bool ShowUserContacts = true; 
        public static bool ShowJobs = true; 
        public static bool ShowCommonThings = true; 
        public static bool ShowFundings = true;
        public static bool ShowMyPhoto = true; 
        public static bool ShowMyVideo = true; 
        public static bool ShowGames = false;
        public static bool ShowMemories = true;  
        public static bool ShowOffers = true;  
        public static bool ShowNearbyShops = true;   

        public static bool ShowSuggestedPage = true;//New 
        public static bool ShowSuggestedGroup = true;
        public static bool ShowSuggestedUser = true;
         
        //count times after entering the Suggestion is displayed
        public static int ShowSuggestedPageCount = 90; //New 
        public static int ShowSuggestedGroupCount = 70; 
        public static int ShowSuggestedUserCount = 50;

        //allow download or not when share
        public static bool AllowDownloadMedia = true; 

        public static bool ShowAdvertise = true; //New  
         
        /// <summary>
        /// https://rapidapi.com/api-sports/api/covid-193
        /// you can get api key and host from here https://prnt.sc/wngxfc 
        /// </summary>
        public static bool ShowInfoCoronaVirus = true;  
        public static string KeyCoronaVirus = "164300ef98msh0911b69bed3814bp131c76jsneaca9364e61f"; 
        public static string HostCoronaVirus = "covid-193.p.rapidapi.com"; 
         
        public static bool ShowLive = true;  
        public static string AppIdAgoraLive = "c55b9bda665042809b61dfeb3f3832e0"; 

        //Events settings
        //*********************************************************  
        public static bool ShowEvents = true; 
        public static bool ShowEventGoing = true; 
        public static bool ShowEventInvited = true;  
        public static bool ShowEventInterested = true;  
        public static bool ShowEventPast = true;

        // Story >>
        //*********************************************************
        //Set a story duration >> 10 Sec
        public static long StoryDuration = 10000L;
        public static bool EnableStorySeenList = true; //#New 
        public static bool EnableReplyStory = true; //#New  

        //*********************************************************

        /// <summary>
        ///  Currency
        /// CurrencyStatic = true : get currency from app not api 
        /// CurrencyStatic = false : get currency from api (default)
        /// </summary>
        public static readonly bool CurrencyStatic = false;
        public static readonly string CurrencyIconStatic = "$";
        public static readonly string CurrencyCodeStatic = "USD";
        public static readonly string CurrencyFundingPriceStatic = "$";

        //Profile settings
        //*********************************************************
        public static bool ShowGift = true;
        public static bool ShowWallet = true; 
        public static bool ShowGoPro = true;  
        public static bool ShowAddToFamily = true;

        public static bool ShowUserGroup = false; //#New
        public static bool ShowUserPage = false; //#New
        public static bool ShowUserImage = true; //#New
        public static bool ShowUserSocialLinks = false; //#New

        public static CoverImageStyle CoverImageStyle = CoverImageStyle.CenterCrop; //#New

        /// <summary>
        /// The default value comes from the site .. in case it is not available, it is taken from these values
        /// </summary>
        public static string WeeklyPrice = "3"; 
        public static string MonthlyPrice = "8"; 
        public static string YearlyPrice = "89"; 
        public static string LifetimePrice = "259";

        //Native Post settings
        //********************************************************* 
        public static bool ShowTextWithSpace = true;//#New

        public static ImagePostStyle ImagePostStyle = ImagePostStyle.FullWidth; //#New

        public static bool ShowTextShareButton = false;
        public static bool ShowShareButton = true;
         
        public static int AvatarPostSize = 60;
        public static int ImagePostSize = 200;
        public static string PostApiLimitOnScroll = "22";

        //Get post in background >> 1 Min = 30 Sec
        public static long RefreshPostSeconds = 30000;  
        public static string PostApiLimitOnBackground = "12"; 

        public static bool AutoPlayVideo = true;
         
        public static bool EmbedPlayTubePostType = true;
        public static bool EmbedDeepSoundPostType = true;
        public static VideoPostTypeSystem EmbedFacebookVideoPostType = VideoPostTypeSystem.EmbedVideo; 
        public static VideoPostTypeSystem EmbedVimeoVideoPostType = VideoPostTypeSystem.EmbedVideo; 
        public static VideoPostTypeSystem EmbedPlayTubeVideoPostType = VideoPostTypeSystem.Link; 
        public static VideoPostTypeSystem EmbedTikTokVideoPostType = VideoPostTypeSystem.Link; 
        public static VideoPostTypeSystem EmbedTwitterPostType = VideoPostTypeSystem.Link; //New >> The next update it's will support EmbedVideo
        public static bool ShowSearchForPosts = true; 
        public static bool EmbedLivePostType = true;
         
        //new posts users have to scroll back to top
        public static bool ShowNewPostOnNewsFeed = true; 
        public static bool ShowAddPostOnNewsFeed = false; 
        public static bool ShowCountSharePost = true;

        public static WRecyclerView.VolumeState DefaultVolumeVideoPost = WRecyclerView.VolumeState.Off;//#New 

        /// <summary>
        /// Post Privacy
        /// ShowPostPrivacyForAllUser = true : all posts user have icon Privacy 
        /// ShowPostPrivacyForAllUser = false : just my posts have icon Privacy (default)
        /// </summary>
        public static bool ShowPostPrivacyForAllUser = false; 

        public static bool ShowFullScreenVideoPost = true;

        public static bool EnableVideoCompress = false; 
         
        //Trending page
        //*********************************************************   
        public static bool ShowTrendingPage = true;
         
        public static bool ShowProUsersMembers = true;
        public static bool ShowPromotedPages = true;
        public static bool ShowTrendingHashTags = true;
        public static bool ShowLastActivities = true;
        public static bool ShowShortcuts = true; 
        public static bool ShowFriendsBirthday = true;//#New
        public static bool ShowAnnouncement = true;//#New

        /// <summary>
        /// https://www.weatherapi.com
        /// </summary>
        public static bool ShowWeather = true;  
        public static string KeyWeatherApi = "e7cffc4d6a9a4a149a1113143201711";

        /// <summary>
        /// https://openexchangerates.org
        /// #Currency >> Your currency
        /// #Currencies >> you can use just 3 from those : USD,EUR,DKK,GBP,SEK,NOK,CAD,JPY,TRY,EGP,SAR,JOD,KWD,IQD,BHD,DZD,LYD,AED,QAR,LBP,OMR,AFN,ALL,ARS,AMD,AUD,BYN,BRL,BGN,CLP,CNY,MYR,MAD,ILS,TND,YER
        /// </summary>
        public static bool ShowExchangeCurrency = false; 
        public static string KeyCurrencyApi = "644761ef2ba94ea5aa84767109d6cf7b"; 
        public static string ExCurrency = "USD";  
        public static string ExCurrencies = "EUR,GBP,TRY"; 
        public static readonly List<string> ExCurrenciesIcons = new List<string> {"€", "£", "₺"}; 

        //********************************************************* 

        public static bool ShowUserPoint = true;

        //Add Post
        public static bool ShowGalleryImage = true;
        public static bool ShowGalleryVideo = true;
        public static bool ShowMention = true;
        public static bool ShowLocation = true;
        public static bool ShowFeelingActivity = true;
        public static bool ShowFeeling = true;
        public static bool ShowListening = true;
        public static bool ShowPlaying = true;
        public static bool ShowWatching = true;
        public static bool ShowTraveling = true;
        public static bool ShowGif = true;
        public static bool ShowFile = true;
        public static bool ShowMusic = true;
        public static bool ShowPolls = true;
        public static bool ShowColor = true;
        public static bool ShowVoiceRecord = true;//#New

        public static bool ShowAnonymousPrivacyPost = true;

        //Advertising 
        public static bool ShowAdvertisingPost = true;  

        //Settings Page >> General Account
        public static bool ShowSettingsGeneralAccount = true;
        public static bool ShowSettingsAccount = true;
        public static bool ShowSettingsSocialLinks = true;
        public static bool ShowSettingsPassword = true;
        public static bool ShowSettingsBlockedUsers = true;
        public static bool ShowSettingsDeleteAccount = true;
        public static bool ShowSettingsTwoFactor = true; 
        public static bool ShowSettingsManageSessions = true;  
        public static bool ShowSettingsVerification = true;
         
        public static bool ShowSettingsSocialLinksFacebook = true; 
        public static bool ShowSettingsSocialLinksTwitter = true; 
        public static bool ShowSettingsSocialLinksGoogle = true; 
        public static bool ShowSettingsSocialLinksVkontakte = true;  
        public static bool ShowSettingsSocialLinksLinkedin = true;  
        public static bool ShowSettingsSocialLinksInstagram = true;  
        public static bool ShowSettingsSocialLinksYouTube = true;  

        //Settings Page >> Privacy
        public static bool ShowSettingsPrivacy = true;
        public static bool ShowSettingsNotification = true;

        //Settings Page >> Tell a Friends (Earnings)
        public static bool ShowSettingsInviteFriends = true;

        public static bool ShowSettingsShare = true;
        public static bool ShowSettingsMyAffiliates = true;
        public static bool ShowWithdrawals = true;

        /// <summary>
        /// if you want this feature enabled go to Properties -> AndroidManefist.xml and remove comments from below code
        /// Just replace it with this 5 lines of code
        /// <uses-permission android:name="android.permission.READ_CONTACTS" />
        /// <uses-permission android:name="android.permission.READ_PHONE_NUMBERS" />
        /// </summary>
        public static bool InvitationSystem = true; 

        //Settings Page >> Help && Support
        public static bool ShowSettingsHelpSupport = true;

        public static bool ShowSettingsHelp = true;
        public static bool ShowSettingsReportProblem = true;
        public static bool ShowSettingsAbout = true;
        public static bool ShowSettingsPrivacyPolicy = true;
        public static bool ShowSettingsTermsOfUse = true;

        public static bool ShowSettingsRateApp = true; 
        public static int ShowRateAppCount = 5; 
         
        public static bool ShowSettingsUpdateManagerApp = false; 

        public static bool ShowSettingsInvitationLinks = true; 
        public static bool ShowSettingsMyInformation = true; 

        public static bool ShowSuggestedUsersOnRegister = true;

        //Set Theme Tab
        //*********************************************************
        public static bool SetTabDarkTheme = false;
        public static MoreTheme MoreTheme = MoreTheme.Card;//#New 

        //Bypass Web Errors  
        //*********************************************************
        public static bool TurnTrustFailureOnWebException = true;
        public static bool TurnSecurityProtocolType3072On = true;

        //*********************************************************
        public static bool RenderPriorityFastPostLoad = false;

        /// <summary>
        /// if you want this feature enabled go to Properties -> AndroidManefist.xml and remove comments from below code
        /// <uses-permission android:name="com.android.vending.BILLING" />
        /// </summary>
        public static bool ShowInAppBilling = false; 

        public static bool ShowPaypal = true; 
        public static bool ShowBankTransfer = true; 
        public static bool ShowCreditCard = true;

        //********************************************************* 
        public static bool ShowCashFree = true;  

        /// <summary>
        /// Currencies : http://prntscr.com/u600ok
        /// </summary>
        public static string CashFreeCurrency = "INR";  

        //********************************************************* 

        /// <summary>
        /// If you want RazorPay you should change id key in the analytic.xml file
        /// razorpay_api_Key >> .. line 24 
        /// </summary>
        public static bool ShowRazorPay = true; 

        /// <summary>
        /// Currencies : https://razorpay.com/accept-international-payments
        /// </summary>
        public static string RazorPayCurrency = "USD";  
         
        public static bool ShowPayStack = true;  
        public static bool ShowPaySera = false;  //#Next Version   

        //********************************************************* 

        //Chat
        //*********************************************************  
        public static SystemGetLastChat LastChatSystem = SystemGetLastChat.Default;
        public static InitializeWoWonder.ConnectionType ConnectionTypeChat = InitializeWoWonder.ConnectionType.RestApi; //#New
        public static string PortSocketServer = "449"; //#New
        public static ColorMessageTheme ColorMessageTheme = ColorMessageTheme.Gradient;//#New 

        //Chat Window Activity >>
        //*********************************************************
        //if you want this feature enabled go to Properties -> AndroidManefist.xml and remove comments from below code
        //Just replace it with this 5 lines of code
        /*
         <uses-permission android:name="android.permission.READ_CONTACTS" />
         <uses-permission android:name="android.permission.READ_PHONE_NUMBERS" /> 
         */
        public static bool ShowButtonContact = true;
        /////////////////////////////////////

        public static bool ShowButtonCamera = true;
        public static bool ShowButtonImage = true;
        public static bool ShowButtonVideo = true;
        public static bool ShowButtonAttachFile = true;
        public static bool ShowButtonColor = true;
        public static bool ShowButtonStickers = true;
        public static bool ShowButtonMusic = true;
        public static bool ShowButtonGif = true;
        public static bool ShowButtonLocation = true;

        public static bool ShowMusicBar = false;

        public static bool OpenVideoFromApp = true;
        public static bool OpenImageFromApp = true;

        // Stickers Packs Settings >> 
        public static int StickersOnEachRow = 3;
        public static string StickersBarColor = "#efefef";
        public static string StickersBarColorDark = "#282828";

        public static bool ShowStickerStack0 = true;
        public static bool ShowStickerStack1 = true;
        public static bool ShowStickerStack2 = true;
        public static bool ShowStickerStack3 = true;
        public static bool ShowStickerStack4 = true;
        public static bool ShowStickerStack5 = true;
        public static bool ShowStickerStack6 = true;

        //Record Sound Style & Text 
        public static bool ShowButtonRecordSound = true;

        // Options List Message
        public static bool EnableReplyMessageSystem = true; //#New  
        public static bool EnableForwardMessageSystem = true; //#New 
        public static bool EnableFavoriteMessageSystem = true; //#New 
        public static bool EnableReactionMessageSystem = true; //#New 
        public static bool EnablePinMessageSystem = false; //#New 

        //List Chat >>
        //*********************************************************
        public static bool EnableChatPage = true;
        public static bool EnableChatGroup = true;

        // Options List Chat
        public static bool EnableChatArchive = true; //#New
        public static bool EnableChatPin = true; //#New
        public static bool EnableChatMute = true; //#New
        public static bool EnableChatMakeAsRead = false; //#New 

        public static bool ShowNotificationWithUpload = true; //#New 

        // Video/Audio Call Settings >>
        //*********************************************************
        public static bool EnableAudioVideoCall = true;

        public static bool EnableAudioCall = true;
        public static bool EnableVideoCall = true;

        public static SystemCall UseLibrary = SystemCall.Twilio;

        //Last_Messages Page >>
        ///*********************************************************
        public static bool ShowOnlineOfflineMessage = false;

        public static int RefreshChatActivitiesSeconds = 6000; // 6 Seconds
        public static int MessageRequestSpeed = 3000; // 3 Seconds

        //Options chat heads (Bubbles) 
        //*********************************************************
        //Always , Hide , FullScreen
        public static string DisplayModeSettings = "Always";

        //Default , Left  , Right , Nearest , Fix , Thrown
        public static string MoveDirectionSettings = "Right";

        //Circle , Rectangle
        public static string ShapeSettings = "Circle";

        // Last position
        public static bool IsUseLastPosition = true;


        public static bool ShowSettingsWallpaper = true; //#New

    }
}