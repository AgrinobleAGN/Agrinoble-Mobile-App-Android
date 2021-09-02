package crc640923f7cee4b90fbc;


public class StartedMessagesActivity
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
		mono.android.Runtime.register ("WoWonder.Activities.Chat.ChatWindow.StartedMessagesActivity, WoWonder", StartedMessagesActivity.class, __md_methods);
	}


	public StartedMessagesActivity ()
	{
		super ();
		if (getClass () == StartedMessagesActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.ChatWindow.StartedMessagesActivity, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public StartedMessagesActivity (int p0)
	{
		super (p0);
		if (getClass () == StartedMessagesActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.ChatWindow.StartedMessagesActivity, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
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
