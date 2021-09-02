package crc64e6b06a3306180857;


public class PostUpdaterHelper
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		java.lang.Runnable
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_run:()V:GetRunHandler:Java.Lang.IRunnableInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.NativePost.Services.PostUpdaterHelper, WoWonder", PostUpdaterHelper.class, __md_methods);
	}


	public PostUpdaterHelper ()
	{
		super ();
		if (getClass () == PostUpdaterHelper.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Services.PostUpdaterHelper, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public PostUpdaterHelper (android.os.Handler p0)
	{
		super ();
		if (getClass () == PostUpdaterHelper.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Services.PostUpdaterHelper, WoWonder", "Android.OS.Handler, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public void run ()
	{
		n_run ();
	}

	private native void n_run ();

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
