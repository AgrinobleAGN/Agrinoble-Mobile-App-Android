package crc6466aa6d4bc5664840;


public class AdsGoogle_AdMobRewardedInterstitial
	extends com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onRewardedInterstitialAdFailedToLoad:(Lcom/google/android/gms/ads/LoadAdError;)V:GetOnRewardedInterstitialAdFailedToLoad_Lcom_google_android_gms_ads_LoadAdError_Handler\n" +
			"n_onRewardedInterstitialAdLoaded:(Lcom/google/android/gms/ads/rewardedinterstitial/RewardedInterstitialAd;)V:GetOnRewardedInterstitialAdLoaded_Lcom_google_android_gms_ads_rewardedinterstitial_RewardedInterstitialAd_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsGoogle+AdMobRewardedInterstitial, WoWonder", AdsGoogle_AdMobRewardedInterstitial.class, __md_methods);
	}


	public AdsGoogle_AdMobRewardedInterstitial ()
	{
		super ();
		if (getClass () == AdsGoogle_AdMobRewardedInterstitial.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+AdMobRewardedInterstitial, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void onRewardedInterstitialAdFailedToLoad (com.google.android.gms.ads.LoadAdError p0)
	{
		n_onRewardedInterstitialAdFailedToLoad (p0);
	}

	private native void n_onRewardedInterstitialAdFailedToLoad (com.google.android.gms.ads.LoadAdError p0);


	public void onRewardedInterstitialAdLoaded (com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd p0)
	{
		n_onRewardedInterstitialAdLoaded (p0);
	}

	private native void n_onRewardedInterstitialAdLoaded (com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd p0);

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
