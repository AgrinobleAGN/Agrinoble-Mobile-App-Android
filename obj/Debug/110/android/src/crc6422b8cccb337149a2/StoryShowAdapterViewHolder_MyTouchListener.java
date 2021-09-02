package crc6422b8cccb337149a2;


public class StoryShowAdapterViewHolder_MyTouchListener
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
		mono.android.Runtime.register ("WoWonder.Activities.Story.Adapters.StoryShowAdapterViewHolder+MyTouchListener, WoWonder", StoryShowAdapterViewHolder_MyTouchListener.class, __md_methods);
	}


	public StoryShowAdapterViewHolder_MyTouchListener ()
	{
		super ();
		if (getClass () == StoryShowAdapterViewHolder_MyTouchListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Story.Adapters.StoryShowAdapterViewHolder+MyTouchListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public StoryShowAdapterViewHolder_MyTouchListener (crc6422b8cccb337149a2.StoryShowAdapterViewHolder p0)
	{
		super ();
		if (getClass () == StoryShowAdapterViewHolder_MyTouchListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Story.Adapters.StoryShowAdapterViewHolder+MyTouchListener, WoWonder", "WoWonder.Activities.Story.Adapters.StoryShowAdapterViewHolder, WoWonder", this, new java.lang.Object[] { p0 });
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
