package crc6466aa6d4bc5664840;


public class AdsFacebook_MyInterstitialAdListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.facebook.ads.InterstitialAdListener,
		com.facebook.ads.AdListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onInterstitialDismissed:(Lcom/facebook/ads/Ad;)V:GetOnInterstitialDismissed_Lcom_facebook_ads_Ad_Handler:Xamarin.Facebook.Ads.IInterstitialAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onInterstitialDisplayed:(Lcom/facebook/ads/Ad;)V:GetOnInterstitialDisplayed_Lcom_facebook_ads_Ad_Handler:Xamarin.Facebook.Ads.IInterstitialAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onAdClicked:(Lcom/facebook/ads/Ad;)V:GetOnAdClicked_Lcom_facebook_ads_Ad_Handler:Xamarin.Facebook.Ads.IAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onAdLoaded:(Lcom/facebook/ads/Ad;)V:GetOnAdLoaded_Lcom_facebook_ads_Ad_Handler:Xamarin.Facebook.Ads.IAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onError:(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V:GetOnError_Lcom_facebook_ads_Ad_Lcom_facebook_ads_AdError_Handler:Xamarin.Facebook.Ads.IAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onLoggingImpression:(Lcom/facebook/ads/Ad;)V:GetOnLoggingImpression_Lcom_facebook_ads_Ad_Handler:Xamarin.Facebook.Ads.IAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsFacebook+MyInterstitialAdListener, WoWonder", AdsFacebook_MyInterstitialAdListener.class, __md_methods);
	}


	public AdsFacebook_MyInterstitialAdListener ()
	{
		super ();
		if (getClass () == AdsFacebook_MyInterstitialAdListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsFacebook+MyInterstitialAdListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AdsFacebook_MyInterstitialAdListener (android.app.Activity p0, com.facebook.ads.InterstitialAd p1)
	{
		super ();
		if (getClass () == AdsFacebook_MyInterstitialAdListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsFacebook+MyInterstitialAdListener, WoWonder", "Android.App.Activity, Mono.Android:Xamarin.Facebook.Ads.InterstitialAd, Xamarin.Facebook.AudienceNetwork.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public void onInterstitialDismissed (com.facebook.ads.Ad p0)
	{
		n_onInterstitialDismissed (p0);
	}

	private native void n_onInterstitialDismissed (com.facebook.ads.Ad p0);


	public void onInterstitialDisplayed (com.facebook.ads.Ad p0)
	{
		n_onInterstitialDisplayed (p0);
	}

	private native void n_onInterstitialDisplayed (com.facebook.ads.Ad p0);


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


	public void onLoggingImpression (com.facebook.ads.Ad p0)
	{
		n_onLoggingImpression (p0);
	}

	private native void n_onLoggingImpression (com.facebook.ads.Ad p0);

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
