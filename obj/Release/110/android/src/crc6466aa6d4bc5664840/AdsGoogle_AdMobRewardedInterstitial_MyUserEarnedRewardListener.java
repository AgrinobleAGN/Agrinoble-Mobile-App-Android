package crc6466aa6d4bc5664840;


public class AdsGoogle_AdMobRewardedInterstitial_MyUserEarnedRewardListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.google.android.gms.ads.OnUserEarnedRewardListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onUserEarnedReward:(Lcom/google/android/gms/ads/rewarded/RewardItem;)V:GetOnUserEarnedReward_Lcom_google_android_gms_ads_rewarded_RewardItem_Handler:Android.Gms.Ads.IOnUserEarnedRewardListenerInvoker, Xamarin.GooglePlayServices.Ads.Lite\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsGoogle+AdMobRewardedInterstitial+MyUserEarnedRewardListener, WoWonder", AdsGoogle_AdMobRewardedInterstitial_MyUserEarnedRewardListener.class, __md_methods);
	}


	public AdsGoogle_AdMobRewardedInterstitial_MyUserEarnedRewardListener ()
	{
		super ();
		if (getClass () == AdsGoogle_AdMobRewardedInterstitial_MyUserEarnedRewardListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+AdMobRewardedInterstitial+MyUserEarnedRewardListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AdsGoogle_AdMobRewardedInterstitial_MyUserEarnedRewardListener (com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd p0)
	{
		super ();
		if (getClass () == AdsGoogle_AdMobRewardedInterstitial_MyUserEarnedRewardListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+AdMobRewardedInterstitial+MyUserEarnedRewardListener, WoWonder", "Android.Gms.Ads.RewardedInterstitial.RewardedInterstitialAd, Xamarin.GooglePlayServices.Ads.Lite", this, new java.lang.Object[] { p0 });
	}


	public void onUserEarnedReward (com.google.android.gms.ads.rewarded.RewardItem p0)
	{
		n_onUserEarnedReward (p0);
	}

	private native void n_onUserEarnedReward (com.google.android.gms.ads.rewarded.RewardItem p0);

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
