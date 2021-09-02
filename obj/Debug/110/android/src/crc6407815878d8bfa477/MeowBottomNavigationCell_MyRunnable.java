package crc6407815878d8bfa477;


public class MeowBottomNavigationCell_MyRunnable
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
		mono.android.Runtime.register ("MeoNavLib.Com.MeowBottomNavigationCell+MyRunnable, MeoNavLib", MeowBottomNavigationCell_MyRunnable.class, __md_methods);
	}


	public MeowBottomNavigationCell_MyRunnable ()
	{
		super ();
		if (getClass () == MeowBottomNavigationCell_MyRunnable.class)
			mono.android.TypeManager.Activate ("MeoNavLib.Com.MeowBottomNavigationCell+MyRunnable, MeoNavLib", "", this, new java.lang.Object[] {  });
	}

	public MeowBottomNavigationCell_MyRunnable (crc6407815878d8bfa477.MeowBottomNavigationCell p0)
	{
		super ();
		if (getClass () == MeowBottomNavigationCell_MyRunnable.class)
			mono.android.TypeManager.Activate ("MeoNavLib.Com.MeowBottomNavigationCell+MyRunnable, MeoNavLib", "MeoNavLib.Com.MeowBottomNavigationCell, MeoNavLib", this, new java.lang.Object[] { p0 });
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
