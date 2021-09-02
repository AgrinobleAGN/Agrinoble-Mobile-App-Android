package crc64708dea99db5f6981;


public class Methods_AppLifecycleObserver
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		androidx.lifecycle.GenericLifecycleObserver,
		androidx.lifecycle.LifecycleEventObserver,
		androidx.lifecycle.LifecycleObserver
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onStateChanged:(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V:GetOnStateChanged_Landroidx_lifecycle_LifecycleOwner_Landroidx_lifecycle_Lifecycle_Event_Handler:AndroidX.Lifecycle.ILifecycleEventObserverInvoker, Xamarin.AndroidX.Lifecycle.Common\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Utils.Methods+AppLifecycleObserver, WoWonder", Methods_AppLifecycleObserver.class, __md_methods);
	}


	public Methods_AppLifecycleObserver ()
	{
		super ();
		if (getClass () == Methods_AppLifecycleObserver.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.Methods+AppLifecycleObserver, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void onStateChanged (androidx.lifecycle.LifecycleOwner p0, androidx.lifecycle.Lifecycle.Event p1)
	{
		n_onStateChanged (p0, p1);
	}

	private native void n_onStateChanged (androidx.lifecycle.LifecycleOwner p0, androidx.lifecycle.Lifecycle.Event p1);

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
