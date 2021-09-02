package crc6466aa6d4bc5664840;


public class AdsColony_MyAdColonyRewardListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.adcolony.sdk.AdColonyRewardListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onReward:(Lcom/adcolony/sdk/AdColonyReward;)V:GetOnReward_Lcom_adcolony_sdk_AdColonyReward_Handler:Com.Adcolony.Sdk.IAdColonyRewardListenerInvoker, AdColonySdk\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsColony+MyAdColonyRewardListener, WoWonder", AdsColony_MyAdColonyRewardListener.class, __md_methods);
	}


	public AdsColony_MyAdColonyRewardListener ()
	{
		super ();
		if (getClass () == AdsColony_MyAdColonyRewardListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsColony+MyAdColonyRewardListener, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void onReward (com.adcolony.sdk.AdColonyReward p0)
	{
		n_onReward (p0);
	}

	private native void n_onReward (com.adcolony.sdk.AdColonyReward p0);

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
