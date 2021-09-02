package crc64205d15e144792056;


public class ReactionPostTabbedActivity_MyOnPageChangeCallback
	extends androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onPageScrolled:(IFI)V:GetOnPageScrolled_IFIHandler\n" +
			"n_onPageSelected:(I)V:GetOnPageSelected_IHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.PostData.ReactionPostTabbedActivity+MyOnPageChangeCallback, WoWonder", ReactionPostTabbedActivity_MyOnPageChangeCallback.class, __md_methods);
	}


	public ReactionPostTabbedActivity_MyOnPageChangeCallback ()
	{
		super ();
		if (getClass () == ReactionPostTabbedActivity_MyOnPageChangeCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.PostData.ReactionPostTabbedActivity+MyOnPageChangeCallback, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public ReactionPostTabbedActivity_MyOnPageChangeCallback (crc64205d15e144792056.ReactionPostTabbedActivity p0)
	{
		super ();
		if (getClass () == ReactionPostTabbedActivity_MyOnPageChangeCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.PostData.ReactionPostTabbedActivity+MyOnPageChangeCallback, WoWonder", "WoWonder.Activities.PostData.ReactionPostTabbedActivity, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void onPageScrolled (int p0, float p1, int p2)
	{
		n_onPageScrolled (p0, p1, p2);
	}

	private native void n_onPageScrolled (int p0, float p1, int p2);


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
