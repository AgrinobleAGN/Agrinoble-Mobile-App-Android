package crc64ee99f33c01860165;


public class BillingHistoryRecord
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.os.Parcelable
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_toString:()Ljava/lang/String;:GetToStringHandler\n" +
			"n_describeContents:()I:GetDescribeContentsHandler:Android.OS.IParcelableInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"n_writeToParcel:(Landroid/os/Parcel;I)V:GetWriteToParcel_Landroid_os_Parcel_IHandler:Android.OS.IParcelableInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("InAppBilling.Lib.BillingHistoryRecord, InAppBilling", BillingHistoryRecord.class, __md_methods);
	}


	public BillingHistoryRecord ()
	{
		super ();
		if (getClass () == BillingHistoryRecord.class)
			mono.android.TypeManager.Activate ("InAppBilling.Lib.BillingHistoryRecord, InAppBilling", "", this, new java.lang.Object[] {  });
	}

	public BillingHistoryRecord (java.lang.String p0, java.lang.String p1)
	{
		super ();
		if (getClass () == BillingHistoryRecord.class)
			mono.android.TypeManager.Activate ("InAppBilling.Lib.BillingHistoryRecord, InAppBilling", "System.String, mscorlib:System.String, mscorlib", this, new java.lang.Object[] { p0, p1 });
	}

	public BillingHistoryRecord (org.json.JSONObject p0, java.lang.String p1)
	{
		super ();
		if (getClass () == BillingHistoryRecord.class)
			mono.android.TypeManager.Activate ("InAppBilling.Lib.BillingHistoryRecord, InAppBilling", "Org.Json.JSONObject, Mono.Android:System.String, mscorlib", this, new java.lang.Object[] { p0, p1 });
	}

	public BillingHistoryRecord (java.lang.String p0, java.lang.String p1, long p2, java.lang.String p3, java.lang.String p4)
	{
		super ();
		if (getClass () == BillingHistoryRecord.class)
			mono.android.TypeManager.Activate ("InAppBilling.Lib.BillingHistoryRecord, InAppBilling", "System.String, mscorlib:System.String, mscorlib:System.Int64, mscorlib:System.String, mscorlib:System.String, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3, p4 });
	}

	public BillingHistoryRecord (android.os.Parcel p0)
	{
		super ();
		if (getClass () == BillingHistoryRecord.class)
			mono.android.TypeManager.Activate ("InAppBilling.Lib.BillingHistoryRecord, InAppBilling", "Android.OS.Parcel, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public java.lang.String toString ()
	{
		return n_toString ();
	}

	private native java.lang.String n_toString ();


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
