package crc646a68b2ab5ad4beb9;


public class LiveStreamingActivity_MyRunnable
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
		mono.android.Runtime.register ("WoWonder.Activities.Live.Page.LiveStreamingActivity+MyRunnable, WoWonder", LiveStreamingActivity_MyRunnable.class, __md_methods);
	}


	public LiveStreamingActivity_MyRunnable ()
	{
		super ();
		if (getClass () == LiveStreamingActivity_MyRunnable.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Live.Page.LiveStreamingActivity+MyRunnable, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public LiveStreamingActivity_MyRunnable (crc646a68b2ab5ad4beb9.LiveStreamingActivity p0)
	{
		super ();
		if (getClass () == LiveStreamingActivity_MyRunnable.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Live.Page.LiveStreamingActivity+MyRunnable, WoWonder", "WoWonder.Activities.Live.Page.LiveStreamingActivity, WoWonder", this, new java.lang.Object[] { p0 });
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
