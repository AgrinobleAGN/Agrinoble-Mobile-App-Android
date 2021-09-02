package crc64ebe0947fbd861d63;


public class SharePageActivity
	extends crc64dcf039a48c5f8fc0.BaseActivity
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.NativePost.Share.SharePageActivity, WoWonder", SharePageActivity.class, __md_methods);
	}


	public SharePageActivity ()
	{
		super ();
		if (getClass () == SharePageActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Share.SharePageActivity, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public SharePageActivity (int p0)
	{
		super (p0);
		if (getClass () == SharePageActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Share.SharePageActivity, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);

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
