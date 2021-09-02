package crc64351ad4e3d7242c07;


public abstract class InAppBillingServiceStub
	extends android.os.Binder
	implements
		mono.android.IGCUserPeer,
		android.os.IInterface
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_asBinder:()Landroid/os/IBinder;:GetAsBinderHandler:Android.OS.IInterfaceInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("InAppBilling.Lib.Vending.InAppBillingServiceStub, InAppBilling", InAppBillingServiceStub.class, __md_methods);
	}


	public InAppBillingServiceStub ()
	{
		super ();
		if (getClass () == InAppBillingServiceStub.class)
			mono.android.TypeManager.Activate ("InAppBilling.Lib.Vending.InAppBillingServiceStub, InAppBilling", "", this, new java.lang.Object[] {  });
	}


	public android.os.IBinder asBinder ()
	{
		return n_asBinder ();
	}

	private native android.os.IBinder n_asBinder ();

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
