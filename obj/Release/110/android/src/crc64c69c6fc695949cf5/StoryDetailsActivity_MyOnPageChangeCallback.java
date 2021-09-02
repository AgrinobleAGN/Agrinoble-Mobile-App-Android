package crc64c69c6fc695949cf5;


public class StoryDetailsActivity_MyOnPageChangeCallback
	extends androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onPageScrolled:(IFI)V:GetOnPageScrolled_IFIHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Story.StoryDetailsActivity+MyOnPageChangeCallback, WoWonder", StoryDetailsActivity_MyOnPageChangeCallback.class, __md_methods);
	}


	public StoryDetailsActivity_MyOnPageChangeCallback ()
	{
		super ();
		if (getClass () == StoryDetailsActivity_MyOnPageChangeCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Story.StoryDetailsActivity+MyOnPageChangeCallback, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public StoryDetailsActivity_MyOnPageChangeCallback (crc64c69c6fc695949cf5.StoryDetailsActivity p0)
	{
		super ();
		if (getClass () == StoryDetailsActivity_MyOnPageChangeCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Story.StoryDetailsActivity+MyOnPageChangeCallback, WoWonder", "WoWonder.Activities.Story.StoryDetailsActivity, WoWonder", this, new java.lang.Object[] { p0 });
	}


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
