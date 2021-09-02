using System.Linq;
using Android.App;
using Android.Content;
using Android.Content.PM;
using Android.OS;
using AndroidX.AppCompat.App;
using Java.Lang;
using WoWonder.Activities.Default;
using WoWonder.Activities.NativePost.Pages;
using WoWonder.Activities.Tabbes;
using WoWonder.Helpers.Controller;
using WoWonder.Helpers.Model;
using WoWonder.Helpers.Utils;
using Exception = System.Exception;

namespace WoWonder.Activities
{
    [Activity(Icon = "@mipmap/icon", Theme = "@style/SplashScreenTheme", NoHistory = true, MainLauncher = true, ConfigurationChanges = ConfigChanges.Locale | ConfigChanges.UiMode | ConfigChanges.ScreenSize | ConfigChanges.Orientation | ConfigChanges.ScreenLayout | ConfigChanges.SmallestScreenSize)]
    [IntentFilter(new[] { Intent.ActionView }, Categories = new[] { Intent.CategoryBrowsable, Intent.CategoryDefault }, DataSchemes = new[] { "http", "https" }, DataHost = "@string/ApplicationUrlWeb", AutoVerify = false)]
    [IntentFilter(new[] { Intent.ActionView }, Categories = new[] { Intent.CategoryBrowsable, Intent.CategoryDefault }, DataSchemes = new[] { "http", "https" }, DataHost = "@string/ApplicationUrlWeb", DataPathPrefixes = new[] { "/register", "/post/", "/index.php?link1=reset-password", "/index.php?link1=activate" }, AutoVerify = false)]
    public class SplashScreenActivity : AppCompatActivity
    { 
        protected override void OnCreate(Bundle savedInstanceState)
        {
            try
            {
                base.OnCreate(savedInstanceState);
                new Handler(Looper.MainLooper).Post(new Runnable(FirstRunExcite));
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        private void FirstRunExcite()
        {
            try
            {
                switch (string.IsNullOrEmpty(AppSettings.Lang))
                {
                    case false:
                        LangController.SetApplicationLang(this, AppSettings.Lang);
                        break;
                    default:
                        #pragma warning disable 618 
                        UserDetails.LangName = (int)Build.VERSION.SdkInt < 25 ? Resources?.Configuration?.Locale?.Language.ToLower() : Resources?.Configuration?.Locales.Get(0)?.Language.ToLower() ?? Resources?.Configuration?.Locale?.Language.ToLower();
                        #pragma warning restore 618
                        LangController.SetApplicationLang(this, UserDetails.LangName);
                        break;
                }

                if (string.IsNullOrEmpty(UserDetails.AccessToken) && Intent?.Data != null)
                {
                    if (Intent.Data.ToString()!.Contains("register") && UserDetails.Status != "Active" && UserDetails.Status != "Pending")
                    {
                        //https://demo.wowonder.com/register?ref=waelanjo
                        var referral = Intent.Data.ToString()!.Split("?ref=")?.Last() ?? "";

                        var intent = new Intent(Application.Context, typeof(RegisterActivity));
                        intent.PutExtra("Referral", referral);
                        StartActivity(intent);
                    }
                    else if (Intent.Data.ToString()!.Contains("index.php?link1=reset-password"))
                    {
                        //https://demo.wowonder.com/index.php?link1=reset-password&code=15801_c034152d790b951f7d30d8f389c502a7
                        var code = Intent.Data.ToString()!.Split("code=").Last();

                        var intent = new Intent(Application.Context, typeof(ResetPasswordActivity));
                        intent.PutExtra("Code", code);
                        StartActivity(intent);
                    }
                    else if (Intent.Data.ToString()!.Contains("index.php?link1=activate"))
                    {
                        //https://demo.wowonder.com/index.php?link1=activate&email=wael.dev1994@gmail.com&code=7833d88964191faac34b5780e3ffe78a
                        var email = Intent.Data.ToString()!.Split("&email=").Last().Split("&code=").First();
                        var code = Intent.Data.ToString()!.Split("&code=").Last();

                        var intent = new Intent(Application.Context, typeof(ValidationUserActivity));
                        intent.PutExtra("Code", code);
                        intent.PutExtra("Email", email);
                        StartActivity(intent);
                    } 
                    else
                    {
                        switch (UserDetails.Status)
                        {
                            case "Active":
                            case "Pending":
                                StartActivity(new Intent(Application.Context, typeof(TabbedMainActivity)));
                                break;
                            default:
                                StartActivity(new Intent(Application.Context, typeof(LoginActivity)));
                                break;
                        }
                    }
                }
                else  
                {
                    if (Intent?.Data != null && Intent.Data.ToString()!.Contains("post"))
                    {
                        //https://beta.wowonder.com/post/230744_.html
                        var postId = Intent.Data.ToString()!.Split("/").Last().Replace("/", "").Split("_").First();

                        var intent = new Intent(Application.Context, typeof(ViewFullPostActivity));
                        intent.PutExtra("Id", postId);
                        StartActivity(intent);
                    }
                    else
                    {
                        switch (UserDetails.Status)
                        {
                            case "Active":
                            case "Pending":
                                StartActivity(new Intent(Application.Context, typeof(TabbedMainActivity)));
                                break;
                            default:
                                StartActivity(new Intent(Application.Context, typeof(LoginActivity)));
                                break;
                        }
                    }
                   
                } 

                OverridePendingTransition(Resource.Animation.abc_fade_in, Resource.Animation.abc_fade_out);
                Finish();
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }
    }
}