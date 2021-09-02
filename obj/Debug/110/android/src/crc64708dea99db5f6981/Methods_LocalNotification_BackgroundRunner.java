package crc64708dea99db5f6981;


public class Methods_LocalNotification_BackgroundRunner
	extends android.app.Service
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onBind:(Landroid/content/Intent;)Landroid/os/IBinder;:GetOnBind_Landroid_content_Intent_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Utils.Methods+LocalNotification+BackgroundRunner, WoWonder", Methods_LocalNotification_BackgroundRunner.class, __md_methods);
	}


	public Methods_LocalNotification_BackgroundRunner ()
	{
		super ();
		if (getClass () == Methods_LocalNotification_BackgroundRunner.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.Methods+LocalNotification+BackgroundRunner, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public android.os.IBinder onBind (android.content.Intent p0)
	{
		return n_onBind (p0);
	}

	private native android.os.IBinder n_onBind (android.content.Intent p0);

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
