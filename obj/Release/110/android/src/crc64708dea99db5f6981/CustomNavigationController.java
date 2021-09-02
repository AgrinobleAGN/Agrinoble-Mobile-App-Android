package crc64708dea99db5f6981;


public class CustomNavigationController
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Utils.CustomNavigationController, WoWonder", CustomNavigationController.class, __md_methods);
	}


	public CustomNavigationController ()
	{
		super ();
		if (getClass () == CustomNavigationController.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.CustomNavigationController, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public CustomNavigationController (android.app.Activity p0, crc6407815878d8bfa477.MeowBottomNavigation p1)
	{
		super ();
		if (getClass () == CustomNavigationController.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.CustomNavigationController, WoWonder", "Android.App.Activity, Mono.Android:MeoNavLib.Com.MeowBottomNavigation, MeoNavLib", this, new java.lang.Object[] { p0, p1 });
	}

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
