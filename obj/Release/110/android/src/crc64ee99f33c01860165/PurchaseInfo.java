package crc64ee99f33c01860165;


public class PurchaseInfo
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.os.Parcelable
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_describeContents:()I:GetDescribeContentsHandler:Android.OS.IParcelableInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"n_writeToParcel:(Landroid/os/Parcel;I)V:GetWriteToParcel_Landroid_os_Parcel_IHandler:Android.OS.IParcelableInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("InAppBilling.Lib.PurchaseInfo, InAppBilling", PurchaseInfo.class, __md_methods);
	}


	public PurchaseInfo ()
	{
		super ();
		if (getClass () == PurchaseInfo.class)
			mono.android.TypeManager.Activate ("InAppBilling.Lib.PurchaseInfo, InAppBilling", "", this, new java.lang.Object[] {  });
	}

	public PurchaseInfo (java.lang.String p0, java.lang.String p1)
	{
		super ();
		if (getClass () == PurchaseInfo.class)
			mono.android.TypeManager.Activate ("InAppBilling.Lib.PurchaseInfo, InAppBilling", "System.String, mscorlib:System.String, mscorlib", this, new java.lang.Object[] { p0, p1 });
	}

	public PurchaseInfo (android.os.Parcel p0)
	{
		super ();
		if (getClass () == PurchaseInfo.class)
			mono.android.TypeManager.Activate ("InAppBilling.Lib.PurchaseInfo, InAppBilling", "Android.OS.Parcel, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public int describeContents ()
	{
		return n_describeContents ();
	}

	private native int n_describeContents ();


	public void writeToParcel (android.os.Parcel p0, int p1)
	{
		n_writeToParcel (p0, p1);
	}

	private native void n_writeToParcel (android.os.Parcel p0, int p1);

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
