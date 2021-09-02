package crc6466aa6d4bc5664840;


public class AdsGoogle_AdMobRewardedInterstitial_MyFullScreenContentCallback
	extends com.google.android.gms.ads.FullScreenContentCallback
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onAdFailedToShowFullScreenContent:(Lcom/google/android/gms/ads/AdError;)V:GetOnAdFailedToShowFullScreenContent_Lcom_google_android_gms_ads_AdError_Handler\n" +
			"n_onAdShowedFullScreenContent:()V:GetOnAdShowedFullScreenContentHandler\n" +
			"n_onAdDismissedFullScreenContent:()V:GetOnAdDismissedFullScreenContentHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsGoogle+AdMobRewardedInterstitial+MyFullScreenContentCallback, WoWonder", AdsGoogle_AdMobRewardedInterstitial_MyFullScreenContentCallback.class, __md_methods);
	}


	public AdsGoogle_AdMobRewardedInterstitial_MyFullScreenContentCallback ()
	{
		super ();
		if (getClass () == AdsGoogle_AdMobRewardedInterstitial_MyFullScreenContentCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+AdMobRewardedInterstitial+MyFullScreenContentCallback, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AdsGoogle_AdMobRewardedInterstitial_MyFullScreenContentCallback (com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd p0)
	{
		super ();
		if (getClass () == AdsGoogle_AdMobRewardedInterstitial_MyFullScreenContentCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+AdMobRewardedInterstitial+MyFullScreenContentCallback, WoWonder", "Android.Gms.Ads.RewardedInterstitial.RewardedInterstitialAd, Xamarin.GooglePlayServices.Ads.Lite", this, new java.lang.Object[] { p0 });
	}


	public void onAdFailedToShowFullScreenContent (com.google.android.gms.ads.AdError p0)
	{
		n_onAdFailedToShowFullScreenContent (p0);
	}

	private native void n_onAdFailedToShowFullScreenContent (com.google.android.gms.ads.AdError p0);


	public void onAdShowedFullScreenContent ()
	{
		n_onAdShowedFullScreenContent ();
	}

	private native void n_onAdShowedFullScreenContent ();


	public void onAdDismissedFullScreenContent ()
	{
		n_onAdDismissedFullScreenContent ();
	}

	private native void n_onAdDismissedFullScreenContent ();

	private java.util.ArrayList refList;
	public void monodroidAddReference (java.lang.Object obj)
	{
		if (refList == null)
			refList = new java.util.ArrayList ();
		refList.add (obj);
	}

	public void monodroidClearReferences ()
	{
		if (refList != null)
			refList.clear ();
	}
}
