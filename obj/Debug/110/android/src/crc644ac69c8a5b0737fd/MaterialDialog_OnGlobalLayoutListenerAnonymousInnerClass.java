package crc644ac69c8a5b0737fd;


public class MaterialDialog_OnGlobalLayoutListenerAnonymousInnerClass
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.view.ViewTreeObserver.OnGlobalLayoutListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onGlobalLayout:()V:GetOnGlobalLayoutHandler:Android.Views.ViewTreeObserver/IOnGlobalLayoutListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("MaterialDialogsCore.MaterialDialog+OnGlobalLayoutListenerAnonymousInnerClass, MaterialDialogsCore", MaterialDialog_OnGlobalLayoutListenerAnonymousInnerClass.class, __md_methods);
	}


	public MaterialDialog_OnGlobalLayoutListenerAnonymousInnerClass ()
	{
		super ();
		if (getClass () == MaterialDialog_OnGlobalLayoutListenerAnonymousInnerClass.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.MaterialDialog+OnGlobalLayoutListenerAnonymousInnerClass, MaterialDialogsCore", "", this, new java.lang.Object[] {  });
	}

	public MaterialDialog_OnGlobalLayoutListenerAnonymousInnerClass (crc644ac69c8a5b0737fd.MaterialDialog p0)
	{
		super ();
		if (getClass () == MaterialDialog_OnGlobalLayoutListenerAnonymousInnerClass.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.MaterialDialog+OnGlobalLayoutListenerAnonymousInnerClass, MaterialDialogsCore", "MaterialDialogsCore.MaterialDialog, MaterialDialogsCore", this, new java.lang.Object[] { p0 });
	}


	public void onGlobalLayout ()
	{
		n_onGlobalLayout ();
	}

	private native void n_onGlobalLayout ();

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
