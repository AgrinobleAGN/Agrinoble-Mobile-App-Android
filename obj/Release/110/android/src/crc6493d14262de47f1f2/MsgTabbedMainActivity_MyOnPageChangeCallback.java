package crc6493d14262de47f1f2;


public class MsgTabbedMainActivity_MyOnPageChangeCallback
	extends androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onPageSelected:(I)V:GetOnPageSelected_IHandler\n" +
			"n_onPageScrolled:(IFI)V:GetOnPageScrolled_IFIHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.MsgTabbes.MsgTabbedMainActivity+MyOnPageChangeCallback, WoWonder", MsgTabbedMainActivity_MyOnPageChangeCallback.class, __md_methods);
	}


	public MsgTabbedMainActivity_MyOnPageChangeCallback ()
	{
		super ();
		if (getClass () == MsgTabbedMainActivity_MyOnPageChangeCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.MsgTabbes.MsgTabbedMainActivity+MyOnPageChangeCallback, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public MsgTabbedMainActivity_MyOnPageChangeCallback (crc6493d14262de47f1f2.MsgTabbedMainActivity p0)
	{
		super ();
		if (getClass () == MsgTabbedMainActivity_MyOnPageChangeCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.MsgTabbes.MsgTabbedMainActivity+MyOnPageChangeCallback, WoWonder", "WoWonder.Activities.Chat.MsgTabbes.MsgTabbedMainActivity, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void onPageSelected (int p0)
	{
		n_onPageSelected (p0);
	}

	private native void n_onPageSelected (int p0);


	public void onPageScrolled (int p0, float p1, int p2)
	{
		n_onPageScrolled (p0, p1, p2);
	}

	private native void n_onPageScrolled (int p0, float p1, int p2);

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
