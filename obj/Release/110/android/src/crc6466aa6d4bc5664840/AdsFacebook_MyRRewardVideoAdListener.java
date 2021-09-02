package crc6466aa6d4bc5664840;


public class AdsFacebook_MyRRewardVideoAdListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.facebook.ads.S2SRewardedVideoAdListener,
		com.facebook.ads.RewardedVideoAdListener,
		com.facebook.ads.AdListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onRewardServerFailed:()V:GetOnRewardServerFailedHandler:Xamarin.Facebook.Ads.IS2SRewardedVideoAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onRewardServerSuccess:()V:GetOnRewardServerSuccessHandler:Xamarin.Facebook.Ads.IS2SRewardedVideoAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onLoggingImpression:(Lcom/facebook/ads/Ad;)V:GetOnLoggingImpression_Lcom_facebook_ads_Ad_Handler:Xamarin.Facebook.Ads.IRewardedVideoAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onRewardedVideoClosed:()V:GetOnRewardedVideoClosedHandler:Xamarin.Facebook.Ads.IRewardedVideoAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onRewardedVideoCompleted:()V:GetOnRewardedVideoCompletedHandler:Xamarin.Facebook.Ads.IRewardedVideoAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onAdClicked:(Lcom/facebook/ads/Ad;)V:GetOnAdClicked_Lcom_facebook_ads_Ad_Handler:Xamarin.Facebook.Ads.IAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onAdLoaded:(Lcom/facebook/ads/Ad;)V:GetOnAdLoaded_Lcom_facebook_ads_Ad_Handler:Xamarin.Facebook.Ads.IAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onError:(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V:GetOnError_Lcom_facebook_ads_Ad_Lcom_facebook_ads_AdError_Handler:Xamarin.Facebook.Ads.IAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsFacebook+MyRRewardVideoAdListener, WoWonder", AdsFacebook_MyRRewardVideoAdListener.class, __md_methods);
	}


	public AdsFacebook_MyRRewardVideoAdListener ()
	{
		super ();
		if (getClass () == AdsFacebook_MyRRewardVideoAdListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsFacebook+MyRRewardVideoAdListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AdsFacebook_MyRRewardVideoAdListener (android.app.Activity p0, com.facebook.ads.RewardedVideoAd p1)
	{
		super ();
		if (getClass () == AdsFacebook_MyRRewardVideoAdListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsFacebook+MyRRewardVideoAdListener, WoWonder", "Android.App.Activity, Mono.Android:Xamarin.Facebook.Ads.RewardedVideoAd, Xamarin.Facebook.AudienceNetwork.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public void onRewardServerFailed ()
	{
		n_onRewardServerFailed ();
	}

	private native void n_onRewardServerFailed ();


	public void onRewardServerSuccess ()
	{
		n_onRewardServerSuccess ();
	}

	private native void n_onRewardServerSuccess ();


	public void onLoggingImpression (com.facebook.ads.Ad p0)
	{
		n_onLoggingImpression (p0);
	}

	private native void n_onLoggingImpression (com.facebook.ads.Ad p0);


	public void onRewardedVideoClosed ()
	{
		n_onRewardedVideoClosed ();
	}

	private native void n_onRewardedVideoClosed ();


	public void onRewardedVideoCompleted ()
	{
		n_onRewardedVideoCompleted ();
	}

	private native void n_onRewardedVideoCompleted ();


	public void onAdClicked (com.facebook.ads.Ad p0)
	{
		n_onAdClicked (p0);
	}

	private native void n_onAdClicked (com.facebook.ads.Ad p0);


	public void onAdLoaded (com.facebook.ads.Ad p0)
	{
		n_onAdLoaded (p0);
	}

	private native void n_onAdLoaded (com.facebook.ads.Ad p0);


	public void onError (com.facebook.ads.Ad p0, com.facebook.ads.AdError p1)
	{
		n_onError (p0, p1);
	}

	private native void n_onError (com.facebook.ads.Ad p0, com.facebook.ads.AdError p1);

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
