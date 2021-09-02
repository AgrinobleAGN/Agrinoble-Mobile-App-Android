package crc649b68de9003883575;


public class MyVtoPreDrawListener
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
		mono.android.Runtime.register ("IO.SuperCharge.ShimmerLayoutLib.MyVtoPreDrawListener, ShimmerLayout", MyVtoPreDrawListener.class, __md_methods);
	}


	public MyVtoPreDrawListener ()
	{
		super ();
		if (getClass () == MyVtoPreDrawListener.class)
			mono.android.TypeManager.Activate ("IO.SuperCharge.ShimmerLayoutLib.MyVtoPreDrawListener, ShimmerLayout", "", this, new java.lang.Object[] {  });
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
