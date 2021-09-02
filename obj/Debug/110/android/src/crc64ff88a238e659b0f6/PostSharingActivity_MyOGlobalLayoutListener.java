package crc64ff88a238e659b0f6;


public class PostSharingActivity_MyOGlobalLayoutListener
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
		mono.android.Runtime.register ("WoWonder.Activities.AddPost.Service.PostSharingActivity+MyOGlobalLayoutListener, WoWonder", PostSharingActivity_MyOGlobalLayoutListener.class, __md_methods);
	}


	public PostSharingActivity_MyOGlobalLayoutListener ()
	{
		super ();
		if (getClass () == PostSharingActivity_MyOGlobalLayoutListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.AddPost.Service.PostSharingActivity+MyOGlobalLayoutListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public PostSharingActivity_MyOGlobalLayoutListener (crc64ff88a238e659b0f6.PostSharingActivity p0)
	{
		super ();
		if (getClass () == PostSharingActivity_MyOGlobalLayoutListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.AddPost.Service.PostSharingActivity+MyOGlobalLayoutListener, WoWonder", "WoWonder.Activities.AddPost.Service.PostSharingActivity, WoWonder", this, new java.lang.Object[] { p0 });
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
