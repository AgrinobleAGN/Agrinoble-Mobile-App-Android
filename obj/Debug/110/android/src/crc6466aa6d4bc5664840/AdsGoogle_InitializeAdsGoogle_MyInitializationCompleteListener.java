package crc6466aa6d4bc5664840;


public class AdsGoogle_InitializeAdsGoogle_MyInitializationCompleteListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.google.android.gms.ads.initialization.OnInitializationCompleteListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onInitializationComplete:(Lcom/google/android/gms/ads/initialization/InitializationStatus;)V:GetOnInitializationComplete_Lcom_google_android_gms_ads_initialization_InitializationStatus_Handler:Android.Gms.Ads.Initialization.IOnInitializationCompleteListenerInvoker, Xamarin.GooglePlayServices.Ads.Lite\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsGoogle+InitializeAdsGoogle+MyInitializationCompleteListener, WoWonder", AdsGoogle_InitializeAdsGoogle_MyInitializationCompleteListener.class, __md_methods);
	}


	public AdsGoogle_InitializeAdsGoogle_MyInitializationCompleteListener ()
	{
		super ();
		if (getClass () == AdsGoogle_InitializeAdsGoogle_MyInitializationCompleteListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+InitializeAdsGoogle+MyInitializationCompleteListener, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void onInitializationComplete (com.google.android.gms.ads.initialization.InitializationStatus p0)
	{
		n_onInitializationComplete (p0);
	}

	private native void n_onInitializationComplete (com.google.android.gms.ads.initialization.InitializationStatus p0);

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
