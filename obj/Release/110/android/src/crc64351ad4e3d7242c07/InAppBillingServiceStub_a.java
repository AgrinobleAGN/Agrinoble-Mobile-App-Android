package crc64351ad4e3d7242c07;


public class InAppBillingServiceStub_a
	extends java.lang.Object
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
		mono.android.Runtime.register ("InAppBilling.Lib.Vending.InAppBillingServiceStub+a, InAppBilling", InAppBillingServiceStub_a.class, __md_methods);
	}


	public InAppBillingServiceStub_a ()
	{
		super ();
		if (getClass () == InAppBillingServiceStub_a.class)
			mono.android.TypeManager.Activate ("InAppBilling.Lib.Vending.InAppBillingServiceStub+a, InAppBilling", "", this, new java.lang.Object[] {  });
	}

	public InAppBillingServiceStub_a (android.os.IBinder p0)
	{
		super ();
		if (getClass () == InAppBillingServiceStub_a.class)
			mono.android.TypeManager.Activate ("InAppBilling.Lib.Vending.InAppBillingServiceStub+a, InAppBilling", "Android.OS.IBinder, Mono.Android", this, new java.lang.Object[] { p0 });
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
