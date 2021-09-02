package crc64c51607effc384a79;


public class AddPostActivity_MyOGlobalLayoutListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.view.ViewTreeObserver.OnGlobalLayoutListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onGlobalLayout:()V:GetOnGlobalLayoutHandler:Android.Views.ViewTreeObserver/IOnGlobalLayoutListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.AddPost.AddPostActivity+MyOGlobalLayoutListener, WoWonder", AddPostActivity_MyOGlobalLayoutListener.class, __md_methods);
	}


	public AddPostActivity_MyOGlobalLayoutListener ()
	{
		super ();
		if (getClass () == AddPostActivity_MyOGlobalLayoutListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.AddPost.AddPostActivity+MyOGlobalLayoutListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AddPostActivity_MyOGlobalLayoutListener (crc64c51607effc384a79.AddPostActivity p0)
	{
		super ();
		if (getClass () == AddPostActivity_MyOGlobalLayoutListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.AddPost.AddPostActivity+MyOGlobalLayoutListener, WoWonder", "WoWonder.Activities.AddPost.AddPostActivity, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void onGlobalLayout ()
	{
		n_onGlobalLayout ();
	}

	private native void n_onGlobalLayout ();

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
