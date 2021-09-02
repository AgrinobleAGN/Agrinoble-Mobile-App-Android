package crc640d8a71cd6a59a46d;


public class MdRootLayout_OnPreDrawListenerAnonymousInnerClass
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.view.ViewTreeObserver.OnPreDrawListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onPreDraw:()Z:GetOnPreDrawHandler:Android.Views.ViewTreeObserver/IOnPreDrawListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("MaterialDialogsCore.internal.MdRootLayout+OnPreDrawListenerAnonymousInnerClass, MaterialDialogsCore", MdRootLayout_OnPreDrawListenerAnonymousInnerClass.class, __md_methods);
	}


	public MdRootLayout_OnPreDrawListenerAnonymousInnerClass ()
	{
		super ();
		if (getClass () == MdRootLayout_OnPreDrawListenerAnonymousInnerClass.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.internal.MdRootLayout+OnPreDrawListenerAnonymousInnerClass, MaterialDialogsCore", "", this, new java.lang.Object[] {  });
	}

	public MdRootLayout_OnPreDrawListenerAnonymousInnerClass (crc640d8a71cd6a59a46d.MdRootLayout p0, android.view.View p1, boolean p2, boolean p3)
	{
		super ();
		if (getClass () == MdRootLayout_OnPreDrawListenerAnonymousInnerClass.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.internal.MdRootLayout+OnPreDrawListenerAnonymousInnerClass, MaterialDialogsCore", "MaterialDialogsCore.internal.MdRootLayout, MaterialDialogsCore:Android.Views.View, Mono.Android:System.Boolean, mscorlib:System.Boolean, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public boolean onPreDraw ()
	{
		return n_onPreDraw ();
	}

	private native boolean n_onPreDraw ();

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
