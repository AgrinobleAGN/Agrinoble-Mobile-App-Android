package crc6466aa6d4bc5664840;


public class AdsGoogle_AdMobRewardedVideo
	extends com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onRewardedAdLoaded:()V:GetOnRewardedAdLoadedHandler\n" +
			"n_onRewardedAdFailedToLoad:(Lcom/google/android/gms/ads/LoadAdError;)V:GetOnRewardedAdFailedToLoad_Lcom_google_android_gms_ads_LoadAdError_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsGoogle+AdMobRewardedVideo, WoWonder", AdsGoogle_AdMobRewardedVideo.class, __md_methods);
	}


	public AdsGoogle_AdMobRewardedVideo ()
	{
		super ();
		if (getClass () == AdsGoogle_AdMobRewardedVideo.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+AdMobRewardedVideo, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void onRewardedAdLoaded ()
	{
		n_onRewardedAdLoaded ();
	}

	private native void n_onRewardedAdLoaded ();


	public void onRewardedAdFailedToLoad (com.google.android.gms.ads.LoadAdError p0)
	{
		n_onRewardedAdFailedToLoad (p0);
	}

	private native void n_onRewardedAdFailedToLoad (com.google.android.gms.ads.LoadAdError p0);

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
