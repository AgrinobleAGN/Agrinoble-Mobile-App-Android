package crc6466aa6d4bc5664840;


public class AdsColony_MyAdColonyAdViewListener
	extends com.adcolony.sdk.AdColonyAdViewListener
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onRequestFilled:(Lcom/adcolony/sdk/AdColonyAdView;)V:GetOnRequestFilled_Lcom_adcolony_sdk_AdColonyAdView_Handler\n" +
			"n_onRequestNotFilled:(Lcom/adcolony/sdk/AdColonyZone;)V:GetOnRequestNotFilled_Lcom_adcolony_sdk_AdColonyZone_Handler\n" +
			"n_onOpened:(Lcom/adcolony/sdk/AdColonyAdView;)V:GetOnOpened_Lcom_adcolony_sdk_AdColonyAdView_Handler\n" +
			"n_onClosed:(Lcom/adcolony/sdk/AdColonyAdView;)V:GetOnClosed_Lcom_adcolony_sdk_AdColonyAdView_Handler\n" +
			"n_onClicked:(Lcom/adcolony/sdk/AdColonyAdView;)V:GetOnClicked_Lcom_adcolony_sdk_AdColonyAdView_Handler\n" +
			"n_onLeftApplication:(Lcom/adcolony/sdk/AdColonyAdView;)V:GetOnLeftApplication_Lcom_adcolony_sdk_AdColonyAdView_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsColony+MyAdColonyAdViewListener, WoWonder", AdsColony_MyAdColonyAdViewListener.class, __md_methods);
	}


	public AdsColony_MyAdColonyAdViewListener ()
	{
		super ();
		if (getClass () == AdsColony_MyAdColonyAdViewListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsColony+MyAdColonyAdViewListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AdsColony_MyAdColonyAdViewListener (android.widget.LinearLayout p0, androidx.recyclerview.widget.RecyclerView p1)
	{
		super ();
		if (getClass () == AdsColony_MyAdColonyAdViewListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsColony+MyAdColonyAdViewListener, WoWonder", "Android.Widget.LinearLayout, Mono.Android:AndroidX.RecyclerView.Widget.RecyclerView, Xamarin.AndroidX.RecyclerView", this, new java.lang.Object[] { p0, p1 });
	}


	public void onRequestFilled (com.adcolony.sdk.AdColonyAdView p0)
	{
		n_onRequestFilled (p0);
	}

	private native void n_onRequestFilled (com.adcolony.sdk.AdColonyAdView p0);


	public void onRequestNotFilled (com.adcolony.sdk.AdColonyZone p0)
	{
		n_onRequestNotFilled (p0);
	}

	private native void n_onRequestNotFilled (com.adcolony.sdk.AdColonyZone p0);


	public void onOpened (com.adcolony.sdk.AdColonyAdView p0)
	{
		n_onOpened (p0);
	}

	private native void n_onOpened (com.adcolony.sdk.AdColonyAdView p0);


	public void onClosed (com.adcolony.sdk.AdColonyAdView p0)
	{
		n_onClosed (p0);
	}

	private native void n_onClosed (com.adcolony.sdk.AdColonyAdView p0);


	public void onClicked (com.adcolony.sdk.AdColonyAdView p0)
	{
		n_onClicked (p0);
	}

	private native void n_onClicked (com.adcolony.sdk.AdColonyAdView p0);


	public void onLeftApplication (com.adcolony.sdk.AdColonyAdView p0)
	{
		n_onLeftApplication (p0);
	}

	private native void n_onLeftApplication (com.adcolony.sdk.AdColonyAdView p0);

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
