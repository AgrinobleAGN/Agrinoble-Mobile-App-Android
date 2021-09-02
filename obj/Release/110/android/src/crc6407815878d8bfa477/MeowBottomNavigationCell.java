package crc6407815878d8bfa477;


public class MeowBottomNavigationCell
	extends android.widget.RelativeLayout
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onMeasure:(II)V:GetOnMeasure_IIHandler\n" +
			"";
		mono.android.Runtime.register ("MeoNavLib.Com.MeowBottomNavigationCell, MeoNavLib", MeowBottomNavigationCell.class, __md_methods);
	}


	public MeowBottomNavigationCell (android.content.Context p0)
	{
		super (p0);
		if (getClass () == MeowBottomNavigationCell.class)
			mono.android.TypeManager.Activate ("MeoNavLib.Com.MeowBottomNavigationCell, MeoNavLib", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public MeowBottomNavigationCell (android.content.Context p0, android.util.AttributeSet p1)
	{
		super (p0, p1);
		if (getClass () == MeowBottomNavigationCell.class)
			mono.android.TypeManager.Activate ("MeoNavLib.Com.MeowBottomNavigationCell, MeoNavLib", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public MeowBottomNavigationCell (android.content.Context p0, android.util.AttributeSet p1, int p2)
	{
		super (p0, p1, p2);
		if (getClass () == MeowBottomNavigationCell.class)
			mono.android.TypeManager.Activate ("MeoNavLib.Com.MeowBottomNavigationCell, MeoNavLib", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public MeowBottomNavigationCell (android.content.Context p0, android.util.AttributeSet p1, int p2, int p3)
	{
		super (p0, p1, p2, p3);
		if (getClass () == MeowBottomNavigationCell.class)
			mono.android.TypeManager.Activate ("MeoNavLib.Com.MeowBottomNavigationCell, MeoNavLib", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public void onMeasure (int p0, int p1)
	{
		n_onMeasure (p0, p1);
	}

	private native void n_onMeasure (int p0, int p1);

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
