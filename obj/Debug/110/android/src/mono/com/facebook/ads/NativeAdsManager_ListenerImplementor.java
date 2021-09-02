package mono.com.facebook.ads;


public class NativeAdsManager_ListenerImplementor
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
		mono.android.Runtime.register ("Xamarin.Facebook.Ads.NativeAdsManager+IListenerImplementor, Xamarin.Facebook.AudienceNetwork.Android", NativeAdsManager_ListenerImplementor.class, __md_methods);
	}


	public NativeAdsManager_ListenerImplementor ()
	{
		super ();
		if (getClass () == NativeAdsManager_ListenerImplementor.class)
			mono.android.TypeManager.Activate ("Xamarin.Facebook.Ads.NativeAdsManager+IListenerImplementor, Xamarin.Facebook.AudienceNetwork.Android", "", this, new java.lang.Object[] {  });
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
