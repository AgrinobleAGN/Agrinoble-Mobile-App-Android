package crc6466aa6d4bc5664840;


public class AdsGoogle_MyAdListener
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
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsGoogle+MyAdListener, WoWonder", AdsGoogle_MyAdListener.class, __md_methods);
	}


	public AdsGoogle_MyAdListener ()
	{
		super ();
		if (getClass () == AdsGoogle_MyAdListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+MyAdListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AdsGoogle_MyAdListener (com.google.android.gms.ads.AdView p0, androidx.recyclerview.widget.RecyclerView p1)
	{
		super ();
		if (getClass () == AdsGoogle_MyAdListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+MyAdListener, WoWonder", "Android.Gms.Ads.AdView, Xamarin.GooglePlayServices.Ads.Lite:AndroidX.RecyclerView.Widget.RecyclerView, Xamarin.AndroidX.RecyclerView", this, new java.lang.Object[] { p0, p1 });
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
