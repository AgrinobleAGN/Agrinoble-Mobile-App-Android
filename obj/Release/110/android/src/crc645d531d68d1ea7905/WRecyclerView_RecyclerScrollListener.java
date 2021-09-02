package crc645d531d68d1ea7905;


public class WRecyclerView_RecyclerScrollListener
	extends androidx.recyclerview.widget.RecyclerView.OnScrollListener
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onScrollStateChanged:(Landroidx/recyclerview/widget/RecyclerView;I)V:GetOnScrollStateChanged_Landroidx_recyclerview_widget_RecyclerView_IHandler\n" +
			"n_onScrolled:(Landroidx/recyclerview/widget/RecyclerView;II)V:GetOnScrolled_Landroidx_recyclerview_widget_RecyclerView_IIHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.NativePost.Extra.WRecyclerView+RecyclerScrollListener, WoWonder", WRecyclerView_RecyclerScrollListener.class, __md_methods);
	}


	public WRecyclerView_RecyclerScrollListener ()
	{
		super ();
		if (getClass () == WRecyclerView_RecyclerScrollListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Extra.WRecyclerView+RecyclerScrollListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public WRecyclerView_RecyclerScrollListener (crc645d531d68d1ea7905.WRecyclerView p0)
	{
		super ();
		if (getClass () == WRecyclerView_RecyclerScrollListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Extra.WRecyclerView+RecyclerScrollListener, WoWonder", "WoWonder.Activities.NativePost.Extra.WRecyclerView, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void onScrollStateChanged (androidx.recyclerview.widget.RecyclerView p0, int p1)
	{
		n_onScrollStateChanged (p0, p1);
	}

	private native void n_onScrollStateChanged (androidx.recyclerview.widget.RecyclerView p0, int p1);


	public void onScrolled (androidx.recyclerview.widget.RecyclerView p0, int p1, int p2)
	{
		n_onScrolled (p0, p1, p2);
	}

	private native void n_onScrolled (androidx.recyclerview.widget.RecyclerView p0, int p1, int p2);

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
