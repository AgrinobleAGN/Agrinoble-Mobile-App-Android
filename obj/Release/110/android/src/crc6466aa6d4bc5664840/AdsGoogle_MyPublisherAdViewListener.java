package crc6466aa6d4bc5664840;


public class AdsGoogle_MyPublisherAdViewListener
	extends com.google.android.gms.ads.AdListener
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onAdFailedToLoad:(Lcom/google/android/gms/ads/LoadAdError;)V:GetOnAdFailedToLoad_Lcom_google_android_gms_ads_LoadAdError_Handler\n" +
			"n_onAdLoaded:()V:GetOnAdLoadedHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsGoogle+MyPublisherAdViewListener, WoWonder", AdsGoogle_MyPublisherAdViewListener.class, __md_methods);
	}


	public AdsGoogle_MyPublisherAdViewListener ()
	{
		super ();
		if (getClass () == AdsGoogle_MyPublisherAdViewListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+MyPublisherAdViewListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AdsGoogle_MyPublisherAdViewListener (com.google.android.gms.ads.doubleclick.PublisherAdView p0)
	{
		super ();
		if (getClass () == AdsGoogle_MyPublisherAdViewListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+MyPublisherAdViewListener, WoWonder", "Android.Gms.Ads.DoubleClick.PublisherAdView, Xamarin.GooglePlayServices.Ads.Lite", this, new java.lang.Object[] { p0 });
	}


	public void onAdFailedToLoad (com.google.android.gms.ads.LoadAdError p0)
	{
		n_onAdFailedToLoad (p0);
	}

	private native void n_onAdFailedToLoad (com.google.android.gms.ads.LoadAdError p0);


	public void onAdLoaded ()
	{
		n_onAdLoaded ();
	}

	private native void n_onAdLoaded ();

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
