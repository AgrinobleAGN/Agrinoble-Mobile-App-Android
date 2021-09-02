package crc64a5967cfe9bb172fe;


public class ReactButton
	extends android.widget.TextView
	implements
		mono.android.IGCUserPeer,
		android.widget.PopupWindow.OnDismissListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onDismiss:()V:GetOnDismissHandler:Android.Widget.PopupWindow/IOnDismissListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.ReactButton, WoWonder", ReactButton.class, __md_methods);
	}


	public ReactButton (android.content.Context p0)
	{
		super (p0);
		if (getClass () == ReactButton.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.ReactButton, WoWonder", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public ReactButton (android.content.Context p0, android.util.AttributeSet p1)
	{
		super (p0, p1);
		if (getClass () == ReactButton.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.ReactButton, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public ReactButton (android.content.Context p0, android.util.AttributeSet p1, int p2)
	{
		super (p0, p1, p2);
		if (getClass () == ReactButton.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.ReactButton, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public ReactButton (android.content.Context p0, android.util.AttributeSet p1, int p2, int p3)
	{
		super (p0, p1, p2, p3);
		if (getClass () == ReactButton.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.ReactButton, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public void onDismiss ()
	{
		n_onDismiss ();
	}

	private native void n_onDismiss ();

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
