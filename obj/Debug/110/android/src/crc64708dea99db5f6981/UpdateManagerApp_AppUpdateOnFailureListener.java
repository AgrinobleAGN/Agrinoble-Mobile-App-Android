package crc64708dea99db5f6981;


public class UpdateManagerApp_AppUpdateOnFailureListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.google.android.play.core.tasks.OnFailureListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onFailure:(Ljava/lang/Exception;)V:GetOnFailure_Ljava_lang_Exception_Handler:Com.Google.Android.Play.Core.Tasks.IOnFailureListenerInvoker, PlayCore\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Utils.UpdateManagerApp+AppUpdateOnFailureListener, WoWonder", UpdateManagerApp_AppUpdateOnFailureListener.class, __md_methods);
	}


	public UpdateManagerApp_AppUpdateOnFailureListener ()
	{
		super ();
		if (getClass () == UpdateManagerApp_AppUpdateOnFailureListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.UpdateManagerApp+AppUpdateOnFailureListener, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void onFailure (java.lang.Exception p0)
	{
		n_onFailure (p0);
	}

	private native void n_onFailure (java.lang.Exception p0);

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
