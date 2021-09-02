package mono.com.facebook.ads;


public class RewardedAdListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.facebook.ads.RewardedAdListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onRewardedAdCompleted:()V:GetOnRewardedAdCompletedHandler:Xamarin.Facebook.Ads.IRewardedAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onRewardedAdServerFailed:()V:GetOnRewardedAdServerFailedHandler:Xamarin.Facebook.Ads.IRewardedAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onRewardedAdServerSucceeded:()V:GetOnRewardedAdServerSucceededHandler:Xamarin.Facebook.Ads.IRewardedAdListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"";
		mono.android.Runtime.register ("Xamarin.Facebook.Ads.IRewardedAdListenerImplementor, Xamarin.Facebook.AudienceNetwork.Android", RewardedAdListenerImplementor.class, __md_methods);
	}


	public RewardedAdListenerImplementor ()
	{
		super ();
		if (getClass () == RewardedAdListenerImplementor.class)
			mono.android.TypeManager.Activate ("Xamarin.Facebook.Ads.IRewardedAdListenerImplementor, Xamarin.Facebook.AudienceNetwork.Android", "", this, new java.lang.Object[] {  });
	}


	public void onRewardedAdCompleted ()
	{
		n_onRewardedAdCompleted ();
	}

	private native void n_onRewardedAdCompleted ();


	public void onRewardedAdServerFailed ()
	{
		n_onRewardedAdServerFailed ();
	}

	private native void n_onRewardedAdServerFailed ();


	public void onRewardedAdServerSucceeded ()
	{
		n_onRewardedAdServerSucceeded ();
	}

	private native void n_onRewardedAdServerSucceeded ();

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
