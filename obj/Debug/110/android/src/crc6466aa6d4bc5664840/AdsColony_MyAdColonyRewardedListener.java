package crc6466aa6d4bc5664840;


public class AdsColony_MyAdColonyRewardedListener
	extends com.adcolony.sdk.AdColonyInterstitialListener
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onRequestFilled:(Lcom/adcolony/sdk/AdColonyInterstitial;)V:GetOnRequestFilled_Lcom_adcolony_sdk_AdColonyInterstitial_Handler\n" +
			"n_onRequestNotFilled:(Lcom/adcolony/sdk/AdColonyZone;)V:GetOnRequestNotFilled_Lcom_adcolony_sdk_AdColonyZone_Handler\n" +
			"n_onOpened:(Lcom/adcolony/sdk/AdColonyInterstitial;)V:GetOnOpened_Lcom_adcolony_sdk_AdColonyInterstitial_Handler\n" +
			"n_onExpiring:(Lcom/adcolony/sdk/AdColonyInterstitial;)V:GetOnExpiring_Lcom_adcolony_sdk_AdColonyInterstitial_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsColony+MyAdColonyRewardedListener, WoWonder", AdsColony_MyAdColonyRewardedListener.class, __md_methods);
	}


	public AdsColony_MyAdColonyRewardedListener ()
	{
		super ();
		if (getClass () == AdsColony_MyAdColonyRewardedListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsColony+MyAdColonyRewardedListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AdsColony_MyAdColonyRewardedListener (com.adcolony.sdk.AdColonyAdOptions p0)
	{
		super ();
		if (getClass () == AdsColony_MyAdColonyRewardedListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsColony+MyAdColonyRewardedListener, WoWonder", "Com.Adcolony.Sdk.AdColonyAdOptions, AdColonySdk", this, new java.lang.Object[] { p0 });
	}


	public void onRequestFilled (com.adcolony.sdk.AdColonyInterstitial p0)
	{
		n_onRequestFilled (p0);
	}

	private native void n_onRequestFilled (com.adcolony.sdk.AdColonyInterstitial p0);


	public void onRequestNotFilled (com.adcolony.sdk.AdColonyZone p0)
	{
		n_onRequestNotFilled (p0);
	}

	private native void n_onRequestNotFilled (com.adcolony.sdk.AdColonyZone p0);


	public void onOpened (com.adcolony.sdk.AdColonyInterstitial p0)
	{
		n_onOpened (p0);
	}

	private native void n_onOpened (com.adcolony.sdk.AdColonyInterstitial p0);


	public void onExpiring (com.adcolony.sdk.AdColonyInterstitial p0)
	{
		n_onExpiring (p0);
	}

	private native void n_onExpiring (com.adcolony.sdk.AdColonyInterstitial p0);

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
