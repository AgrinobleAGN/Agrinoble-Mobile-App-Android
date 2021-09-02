package crc6466aa6d4bc5664840;


public class AdsGoogle_InterstitialAdListener
	extends com.google.android.gms.ads.AdListener
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onAdLoaded:()V:GetOnAdLoadedHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsGoogle+InterstitialAdListener, WoWonder", AdsGoogle_InterstitialAdListener.class, __md_methods);
	}


	public AdsGoogle_InterstitialAdListener ()
	{
		super ();
		if (getClass () == AdsGoogle_InterstitialAdListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+InterstitialAdListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AdsGoogle_InterstitialAdListener (com.google.android.gms.ads.InterstitialAd p0)
	{
		super ();
		if (getClass () == AdsGoogle_InterstitialAdListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsGoogle+InterstitialAdListener, WoWonder", "Android.Gms.Ads.InterstitialAd, Xamarin.GooglePlayServices.Ads.Lite", this, new java.lang.Object[] { p0 });
	}


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
