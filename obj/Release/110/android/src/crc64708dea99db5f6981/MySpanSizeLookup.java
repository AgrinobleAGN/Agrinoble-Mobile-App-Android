package crc64708dea99db5f6981;


public class MySpanSizeLookup
	extends androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_getSpanSize:(I)I:GetGetSpanSize_IHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Utils.MySpanSizeLookup, WoWonder", MySpanSizeLookup.class, __md_methods);
	}


	public MySpanSizeLookup ()
	{
		super ();
		if (getClass () == MySpanSizeLookup.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.MySpanSizeLookup, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public MySpanSizeLookup (int p0, int p1, int p2)
	{
		super ();
		if (getClass () == MySpanSizeLookup.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.MySpanSizeLookup, WoWonder", "System.Int32, mscorlib:System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public int getSpanSize (int p0)
	{
		return n_getSpanSize (p0);
	}

	private native int n_getSpanSize (int p0);

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
