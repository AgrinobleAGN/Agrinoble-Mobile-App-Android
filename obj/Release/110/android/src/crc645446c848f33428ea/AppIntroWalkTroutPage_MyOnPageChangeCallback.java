package crc645446c848f33428ea;


public class AppIntroWalkTroutPage_MyOnPageChangeCallback
	extends androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onPageSelected:(I)V:GetOnPageSelected_IHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.WalkTroutPage.AppIntroWalkTroutPage+MyOnPageChangeCallback, WoWonder", AppIntroWalkTroutPage_MyOnPageChangeCallback.class, __md_methods);
	}


	public AppIntroWalkTroutPage_MyOnPageChangeCallback ()
	{
		super ();
		if (getClass () == AppIntroWalkTroutPage_MyOnPageChangeCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.WalkTroutPage.AppIntroWalkTroutPage+MyOnPageChangeCallback, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AppIntroWalkTroutPage_MyOnPageChangeCallback (crc645446c848f33428ea.AppIntroWalkTroutPage p0)
	{
		super ();
		if (getClass () == AppIntroWalkTroutPage_MyOnPageChangeCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.WalkTroutPage.AppIntroWalkTroutPage+MyOnPageChangeCallback, WoWonder", "WoWonder.Activities.WalkTroutPage.AppIntroWalkTroutPage, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void onPageSelected (int p0)
	{
		n_onPageSelected (p0);
	}

	private native void n_onPageSelected (int p0);

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
