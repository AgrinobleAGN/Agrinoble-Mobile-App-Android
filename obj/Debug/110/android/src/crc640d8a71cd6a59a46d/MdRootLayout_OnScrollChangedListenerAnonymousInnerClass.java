package crc640d8a71cd6a59a46d;


public class MdRootLayout_OnScrollChangedListenerAnonymousInnerClass
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.view.ViewTreeObserver.OnScrollChangedListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onScrollChanged:()V:GetOnScrollChangedHandler:Android.Views.ViewTreeObserver/IOnScrollChangedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("MaterialDialogsCore.internal.MdRootLayout+OnScrollChangedListenerAnonymousInnerClass, MaterialDialogsCore", MdRootLayout_OnScrollChangedListenerAnonymousInnerClass.class, __md_methods);
	}


	public MdRootLayout_OnScrollChangedListenerAnonymousInnerClass ()
	{
		super ();
		if (getClass () == MdRootLayout_OnScrollChangedListenerAnonymousInnerClass.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.internal.MdRootLayout+OnScrollChangedListenerAnonymousInnerClass, MaterialDialogsCore", "", this, new java.lang.Object[] {  });
	}

	public MdRootLayout_OnScrollChangedListenerAnonymousInnerClass (crc640d8a71cd6a59a46d.MdRootLayout p0, android.view.ViewGroup p1, boolean p2, boolean p3)
	{
		super ();
		if (getClass () == MdRootLayout_OnScrollChangedListenerAnonymousInnerClass.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.internal.MdRootLayout+OnScrollChangedListenerAnonymousInnerClass, MaterialDialogsCore", "MaterialDialogsCore.internal.MdRootLayout, MaterialDialogsCore:Android.Views.ViewGroup, Mono.Android:System.Boolean, mscorlib:System.Boolean, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public void onScrollChanged ()
	{
		n_onScrollChanged ();
	}

	private native void n_onScrollChanged ();

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
