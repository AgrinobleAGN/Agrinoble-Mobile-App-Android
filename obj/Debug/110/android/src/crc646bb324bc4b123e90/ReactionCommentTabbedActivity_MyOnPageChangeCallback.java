package crc646bb324bc4b123e90;


public class ReactionCommentTabbedActivity_MyOnPageChangeCallback
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
		mono.android.Runtime.register ("WoWonder.Activities.Comment.ReactionCommentTabbedActivity+MyOnPageChangeCallback, WoWonder", ReactionCommentTabbedActivity_MyOnPageChangeCallback.class, __md_methods);
	}


	public ReactionCommentTabbedActivity_MyOnPageChangeCallback ()
	{
		super ();
		if (getClass () == ReactionCommentTabbedActivity_MyOnPageChangeCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Comment.ReactionCommentTabbedActivity+MyOnPageChangeCallback, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public ReactionCommentTabbedActivity_MyOnPageChangeCallback (crc646bb324bc4b123e90.ReactionCommentTabbedActivity p0)
	{
		super ();
		if (getClass () == ReactionCommentTabbedActivity_MyOnPageChangeCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Comment.ReactionCommentTabbedActivity+MyOnPageChangeCallback, WoWonder", "WoWonder.Activities.Comment.ReactionCommentTabbedActivity, WoWonder", this, new java.lang.Object[] { p0 });
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
