package crc646a68b2ab5ad4beb9;


public class RtcBaseActivity
	extends androidx.appcompat.app.AppCompatActivity
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"n_onDestroy:()V:GetOnDestroyHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Live.Page.RtcBaseActivity, WoWonder", RtcBaseActivity.class, __md_methods);
	}


	public RtcBaseActivity ()
	{
		super ();
		if (getClass () == RtcBaseActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Live.Page.RtcBaseActivity, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public RtcBaseActivity (int p0)
	{
		super (p0);
		if (getClass () == RtcBaseActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Live.Page.RtcBaseActivity, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);


	public void onDestroy ()
	{
		n_onDestroy ();
	}

	private native void n_onDestroy ();

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
