package crc649b1df4326cf61085;


public class StReadMoreOption_StRunnable
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
		mono.android.Runtime.register ("WoWonder.Library.Anjo.SuperTextLibrary.StReadMoreOption+StRunnable, WoWonder", StReadMoreOption_StRunnable.class, __md_methods);
	}


	public StReadMoreOption_StRunnable ()
	{
		super ();
		if (getClass () == StReadMoreOption_StRunnable.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.SuperTextLibrary.StReadMoreOption+StRunnable, WoWonder", "", this, new java.lang.Object[] {  });
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
