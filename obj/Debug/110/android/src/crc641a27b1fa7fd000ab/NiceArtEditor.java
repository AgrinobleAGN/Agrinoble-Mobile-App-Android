package crc641a27b1fa7fd000ab;


public class NiceArtEditor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.NiceArt.NiceArtEditor, WoWonder", NiceArtEditor.class, __md_methods);
	}


	public NiceArtEditor ()
	{
		super ();
		if (getClass () == NiceArtEditor.class)
			mono.android.TypeManager.Activate ("WoWonder.NiceArt.NiceArtEditor, WoWonder", "", this, new java.lang.Object[] {  });
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
