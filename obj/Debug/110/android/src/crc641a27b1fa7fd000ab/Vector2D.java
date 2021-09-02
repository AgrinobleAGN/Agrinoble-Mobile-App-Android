package crc641a27b1fa7fd000ab;


public class Vector2D
	extends android.graphics.PointF
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.NiceArt.Vector2D, WoWonder", Vector2D.class, __md_methods);
	}


	public Vector2D ()
	{
		super ();
		if (getClass () == Vector2D.class)
			mono.android.TypeManager.Activate ("WoWonder.NiceArt.Vector2D, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public Vector2D (float p0, float p1)
	{
		super (p0, p1);
		if (getClass () == Vector2D.class)
			mono.android.TypeManager.Activate ("WoWonder.NiceArt.Vector2D, WoWonder", "System.Single, mscorlib:System.Single, mscorlib", this, new java.lang.Object[] { p0, p1 });
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
