package crc64ec8b2cf061d19ddf;


public class NewsFeedNative_ApiPostUpdaterHelper
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
		mono.android.Runtime.register ("WoWonder.Activities.Tabbes.Fragment.NewsFeedNative+ApiPostUpdaterHelper, WoWonder", NewsFeedNative_ApiPostUpdaterHelper.class, __md_methods);
	}


	public NewsFeedNative_ApiPostUpdaterHelper ()
	{
		super ();
		if (getClass () == NewsFeedNative_ApiPostUpdaterHelper.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Tabbes.Fragment.NewsFeedNative+ApiPostUpdaterHelper, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public NewsFeedNative_ApiPostUpdaterHelper (android.app.Activity p0, android.os.Handler p1)
	{
		super ();
		if (getClass () == NewsFeedNative_ApiPostUpdaterHelper.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Tabbes.Fragment.NewsFeedNative+ApiPostUpdaterHelper, WoWonder", "Android.App.Activity, Mono.Android:Android.OS.Handler, Mono.Android", this, new java.lang.Object[] { p0, p1 });
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
