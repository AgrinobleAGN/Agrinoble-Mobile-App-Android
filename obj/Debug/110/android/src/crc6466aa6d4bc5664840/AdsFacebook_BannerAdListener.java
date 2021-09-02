package crc6466aa6d4bc5664840;


public class AdsFacebook_BannerAdListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.facebook.ads.AdListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onAdClicked:(Lcom/facebook/ads/Ad;)V:GetOnAdClicked_Lcom_facebook_ads_Ad_Handler:Xamarin.Facebook.Ads.IAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onAdLoaded:(Lcom/facebook/ads/Ad;)V:GetOnAdLoaded_Lcom_facebook_ads_Ad_Handler:Xamarin.Facebook.Ads.IAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onError:(Lcom/facebook/ads/Ad;Lcom/facebook/ads/AdError;)V:GetOnError_Lcom_facebook_ads_Ad_Lcom_facebook_ads_AdError_Handler:Xamarin.Facebook.Ads.IAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onLoggingImpression:(Lcom/facebook/ads/Ad;)V:GetOnLoggingImpression_Lcom_facebook_ads_Ad_Handler:Xamarin.Facebook.Ads.IAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsFacebook+BannerAdListener, WoWonder", AdsFacebook_BannerAdListener.class, __md_methods);
	}


	public AdsFacebook_BannerAdListener ()
	{
		super ();
		if (getClass () == AdsFacebook_BannerAdListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsFacebook+BannerAdListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AdsFacebook_BannerAdListener (androidx.recyclerview.widget.RecyclerView p0)
	{
		super ();
		if (getClass () == AdsFacebook_BannerAdListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsFacebook+BannerAdListener, WoWonder", "AndroidX.RecyclerView.Widget.RecyclerView, Xamarin.AndroidX.RecyclerView", this, new java.lang.Object[] { p0 });
	}


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
