package crc648ea9895ffbc9b6c0;


public class GroupRequestActivity
	extends crc64dcf039a48c5f8fc0.BaseActivity
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"n_onResume:()V:GetOnResumeHandler\n" +
			"n_onPause:()V:GetOnPauseHandler\n" +
			"n_onDestroy:()V:GetOnDestroyHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.GroupChat.GroupRequestActivity, WoWonder", GroupRequestActivity.class, __md_methods);
	}


	public GroupRequestActivity ()
	{
		super ();
		if (getClass () == GroupRequestActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.GroupChat.GroupRequestActivity, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public GroupRequestActivity (int p0)
	{
		super (p0);
		if (getClass () == GroupRequestActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.GroupChat.GroupRequestActivity, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);


	public void onResume ()
	{
		n_onResume ();
	}

	private native void n_onResume ();


	public void onPause ()
	{
		n_onPause ();
	}

	private native void n_onPause ();


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
