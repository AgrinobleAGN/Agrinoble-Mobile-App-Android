package io.supercharge.shimmerlayout;


public class ShimmerLayout
	extends android.widget.FrameLayout
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onDetachedFromWindow:()V:GetOnDetachedFromWindowHandler\n" +
			"n_dispatchDraw:(Landroid/graphics/Canvas;)V:GetDispatchDraw_Landroid_graphics_Canvas_Handler\n" +
			"n_getVisibility:()I:GetGetVisibilityHandler\n" +
			"n_setVisibility:(I)V:GetSetVisibility_IHandler\n" +
			"";
		mono.android.Runtime.register ("IO.SuperCharge.ShimmerLayoutLib.ShimmerLayout, ShimmerLayout", ShimmerLayout.class, __md_methods);
	}


	public ShimmerLayout (android.content.Context p0)
	{
		super (p0);
		if (getClass () == ShimmerLayout.class)
			mono.android.TypeManager.Activate ("IO.SuperCharge.ShimmerLayoutLib.ShimmerLayout, ShimmerLayout", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public ShimmerLayout (android.content.Context p0, android.util.AttributeSet p1)
	{
		super (p0, p1);
		if (getClass () == ShimmerLayout.class)
			mono.android.TypeManager.Activate ("IO.SuperCharge.ShimmerLayoutLib.ShimmerLayout, ShimmerLayout", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public ShimmerLayout (android.content.Context p0, android.util.AttributeSet p1, int p2)
	{
		super (p0, p1, p2);
		if (getClass () == ShimmerLayout.class)
			mono.android.TypeManager.Activate ("IO.SuperCharge.ShimmerLayoutLib.ShimmerLayout, ShimmerLayout", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public ShimmerLayout (android.content.Context p0, android.util.AttributeSet p1, int p2, int p3)
	{
		super (p0, p1, p2, p3);
		if (getClass () == ShimmerLayout.class)
			mono.android.TypeManager.Activate ("IO.SuperCharge.ShimmerLayoutLib.ShimmerLayout, ShimmerLayout", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public void onDetachedFromWindow ()
	{
		n_onDetachedFromWindow ();
	}

	private native void n_onDetachedFromWindow ();


	public void dispatchDraw (android.graphics.Canvas p0)
	{
		n_dispatchDraw (p0);
	}

	private native void n_dispatchDraw (android.graphics.Canvas p0);


	public int getVisibility ()
	{
		return n_getVisibility ();
	}

	private native int n_getVisibility ();


	public void setVisibility (int p0)
	{
		n_setVisibility (p0);
	}

	private native void n_setVisibility (int p0);

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
