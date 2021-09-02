package crc6466aa6d4bc5664840;


public class MyNativeAdsManagerListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.facebook.ads.NativeAdsManager.Listener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onAdError:(Lcom/facebook/ads/AdError;)V:GetOnAdError_Lcom_facebook_ads_AdError_Handler:Xamarin.Facebook.Ads.NativeAdsManager/IListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onAdsLoaded:()V:GetOnAdsLoadedHandler:Xamarin.Facebook.Ads.NativeAdsManager/IListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.MyNativeAdsManagerListener, WoWonder", MyNativeAdsManagerListener.class, __md_methods);
	}


	public MyNativeAdsManagerListener ()
	{
		super ();
		if (getClass () == MyNativeAdsManagerListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.MyNativeAdsManagerListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public MyNativeAdsManagerListener (crc64297040596eefa26a.NativePostAdapter p0)
	{
		super ();
		if (getClass () == MyNativeAdsManagerListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.MyNativeAdsManagerListener, WoWonder", "WoWonder.Activities.NativePost.Post.NativePostAdapter, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void onAdError (com.facebook.ads.AdError p0)
	{
		n_onAdError (p0);
	}

	private native void n_onAdError (com.facebook.ads.AdError p0);


	public void onAdsLoaded ()
	{
		n_onAdsLoaded ();
	}

	private native void n_onAdsLoaded ();

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
