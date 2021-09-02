package crc645d531d68d1ea7905;


public class WRecyclerView_NewClicker
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.view.View.OnClickListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onClick:(Landroid/view/View;)V:GetOnClick_Landroid_view_View_Handler:Android.Views.View/IOnClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.NativePost.Extra.WRecyclerView+NewClicker, WoWonder", WRecyclerView_NewClicker.class, __md_methods);
	}


	public WRecyclerView_NewClicker ()
	{
		super ();
		if (getClass () == WRecyclerView_NewClicker.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Extra.WRecyclerView+NewClicker, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public WRecyclerView_NewClicker (android.widget.FrameLayout p0, java.lang.String p1, crc645d531d68d1ea7905.WRecyclerView p2)
	{
		super ();
		if (getClass () == WRecyclerView_NewClicker.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Extra.WRecyclerView+NewClicker, WoWonder", "Android.Widget.FrameLayout, Mono.Android:System.String, mscorlib:WoWonder.Activities.NativePost.Extra.WRecyclerView, WoWonder", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public void onClick (android.view.View p0)
	{
		n_onClick (p0);
	}

	private native void n_onClick (android.view.View p0);

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
