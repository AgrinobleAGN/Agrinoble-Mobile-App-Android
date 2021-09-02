package crc64708dea99db5f6981;


public class UpdateManagerApp_AppUpdateSuccessListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.google.android.play.core.tasks.OnSuccessListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onSuccess:(Ljava/lang/Object;)V:GetOnSuccess_Ljava_lang_Object_Handler:Com.Google.Android.Play.Core.Tasks.IOnSuccessListenerInvoker, PlayCore\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Utils.UpdateManagerApp+AppUpdateSuccessListener, WoWonder", UpdateManagerApp_AppUpdateSuccessListener.class, __md_methods);
	}


	public UpdateManagerApp_AppUpdateSuccessListener ()
	{
		super ();
		if (getClass () == UpdateManagerApp_AppUpdateSuccessListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.UpdateManagerApp+AppUpdateSuccessListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public UpdateManagerApp_AppUpdateSuccessListener (com.google.android.play.core.appupdate.AppUpdateManager p0, android.app.Activity p1, int p2, android.content.Intent p3)
	{
		super ();
		if (getClass () == UpdateManagerApp_AppUpdateSuccessListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.UpdateManagerApp+AppUpdateSuccessListener, WoWonder", "Com.Google.Android.Play.Core.Appupdate.IAppUpdateManager, PlayCore:Android.App.Activity, Mono.Android:System.Int32, mscorlib:Android.Content.Intent, Mono.Android", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public void onSuccess (java.lang.Object p0)
	{
		n_onSuccess (p0);
	}

	private native void n_onSuccess (java.lang.Object p0);

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
