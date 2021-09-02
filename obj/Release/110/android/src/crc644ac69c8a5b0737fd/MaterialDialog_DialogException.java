package crc644ac69c8a5b0737fd;


public class MaterialDialog_DialogException
	extends android.view.WindowManager.BadTokenException
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("MaterialDialogsCore.MaterialDialog+DialogException, MaterialDialogsCore", MaterialDialog_DialogException.class, __md_methods);
	}


	public MaterialDialog_DialogException (java.lang.String p0)
	{
		super (p0);
		if (getClass () == MaterialDialog_DialogException.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.MaterialDialog+DialogException, MaterialDialogsCore", "System.String, mscorlib", this, new java.lang.Object[] { p0 });
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
