package crc645d531d68d1ea7905;


public class WRecyclerView_ChildAttachStateChangeListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onChildViewAttachedToWindow:(Landroid/view/View;)V:GetOnChildViewAttachedToWindow_Landroid_view_View_Handler:AndroidX.RecyclerView.Widget.RecyclerView/IOnChildAttachStateChangeListenerInvoker, Xamarin.AndroidX.RecyclerView\n" +
			"n_onChildViewDetachedFromWindow:(Landroid/view/View;)V:GetOnChildViewDetachedFromWindow_Landroid_view_View_Handler:AndroidX.RecyclerView.Widget.RecyclerView/IOnChildAttachStateChangeListenerInvoker, Xamarin.AndroidX.RecyclerView\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.NativePost.Extra.WRecyclerView+ChildAttachStateChangeListener, WoWonder", WRecyclerView_ChildAttachStateChangeListener.class, __md_methods);
	}


	public WRecyclerView_ChildAttachStateChangeListener ()
	{
		super ();
		if (getClass () == WRecyclerView_ChildAttachStateChangeListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Extra.WRecyclerView+ChildAttachStateChangeListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public WRecyclerView_ChildAttachStateChangeListener (crc645d531d68d1ea7905.WRecyclerView p0)
	{
		super ();
		if (getClass () == WRecyclerView_ChildAttachStateChangeListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Extra.WRecyclerView+ChildAttachStateChangeListener, WoWonder", "WoWonder.Activities.NativePost.Extra.WRecyclerView, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void onChildViewAttachedToWindow (android.view.View p0)
	{
		n_onChildViewAttachedToWindow (p0);
	}

	private native void n_onChildViewAttachedToWindow (android.view.View p0);


	public void onChildViewDetachedFromWindow (android.view.View p0)
	{
		n_onChildViewDetachedFromWindow (p0);
	}

	private native void n_onChildViewDetachedFromWindow (android.view.View p0);

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
