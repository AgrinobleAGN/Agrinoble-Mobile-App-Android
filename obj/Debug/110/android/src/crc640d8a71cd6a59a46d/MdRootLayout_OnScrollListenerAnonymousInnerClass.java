package crc640d8a71cd6a59a46d;


public class MdRootLayout_OnScrollListenerAnonymousInnerClass
	extends androidx.recyclerview.widget.RecyclerView.OnScrollListener
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onScrolled:(Landroidx/recyclerview/widget/RecyclerView;II)V:GetOnScrolled_Landroidx_recyclerview_widget_RecyclerView_IIHandler\n" +
			"";
		mono.android.Runtime.register ("MaterialDialogsCore.internal.MdRootLayout+OnScrollListenerAnonymousInnerClass, MaterialDialogsCore", MdRootLayout_OnScrollListenerAnonymousInnerClass.class, __md_methods);
	}


	public MdRootLayout_OnScrollListenerAnonymousInnerClass ()
	{
		super ();
		if (getClass () == MdRootLayout_OnScrollListenerAnonymousInnerClass.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.internal.MdRootLayout+OnScrollListenerAnonymousInnerClass, MaterialDialogsCore", "", this, new java.lang.Object[] {  });
	}

	public MdRootLayout_OnScrollListenerAnonymousInnerClass (crc640d8a71cd6a59a46d.MdRootLayout p0, android.view.ViewGroup p1, boolean p2, boolean p3)
	{
		super ();
		if (getClass () == MdRootLayout_OnScrollListenerAnonymousInnerClass.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.internal.MdRootLayout+OnScrollListenerAnonymousInnerClass, MaterialDialogsCore", "MaterialDialogsCore.internal.MdRootLayout, MaterialDialogsCore:Android.Views.ViewGroup, Mono.Android:System.Boolean, mscorlib:System.Boolean, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


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
