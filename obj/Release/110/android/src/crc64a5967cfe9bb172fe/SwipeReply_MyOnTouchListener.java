package crc64a5967cfe9bb172fe;


public class SwipeReply_MyOnTouchListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.view.View.OnTouchListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onTouch:(Landroid/view/View;Landroid/view/MotionEvent;)Z:GetOnTouch_Landroid_view_View_Landroid_view_MotionEvent_Handler:Android.Views.View/IOnTouchListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.SwipeReply+MyOnTouchListener, WoWonder", SwipeReply_MyOnTouchListener.class, __md_methods);
	}


	public SwipeReply_MyOnTouchListener ()
	{
		super ();
		if (getClass () == SwipeReply_MyOnTouchListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.SwipeReply+MyOnTouchListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public SwipeReply_MyOnTouchListener (crc64a5967cfe9bb172fe.SwipeReply p0, androidx.recyclerview.widget.RecyclerView.ViewHolder p1)
	{
		super ();
		if (getClass () == SwipeReply_MyOnTouchListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.SwipeReply+MyOnTouchListener, WoWonder", "WoWonder.Library.Anjo.SwipeReply, WoWonder:AndroidX.RecyclerView.Widget.RecyclerView+ViewHolder, Xamarin.AndroidX.RecyclerView", this, new java.lang.Object[] { p0, p1 });
	}


	public boolean onTouch (android.view.View p0, android.view.MotionEvent p1)
	{
		return n_onTouch (p0, p1);
	}

	private native boolean n_onTouch (android.view.View p0, android.view.MotionEvent p1);

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
