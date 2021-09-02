package crc649126ca5a318be7b3;


public class TabbedMainActivity_MyOnPageChangeCallback
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
		mono.android.Runtime.register ("WoWonder.Activities.Tabbes.TabbedMainActivity+MyOnPageChangeCallback, WoWonder", TabbedMainActivity_MyOnPageChangeCallback.class, __md_methods);
	}


	public TabbedMainActivity_MyOnPageChangeCallback ()
	{
		super ();
		if (getClass () == TabbedMainActivity_MyOnPageChangeCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Tabbes.TabbedMainActivity+MyOnPageChangeCallback, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public TabbedMainActivity_MyOnPageChangeCallback (crc649126ca5a318be7b3.TabbedMainActivity p0)
	{
		super ();
		if (getClass () == TabbedMainActivity_MyOnPageChangeCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Tabbes.TabbedMainActivity+MyOnPageChangeCallback, WoWonder", "WoWonder.Activities.Tabbes.TabbedMainActivity, WoWonder", this, new java.lang.Object[] { p0 });
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
