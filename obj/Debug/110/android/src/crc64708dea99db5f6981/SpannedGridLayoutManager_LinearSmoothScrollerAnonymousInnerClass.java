package crc64708dea99db5f6981;


public class SpannedGridLayoutManager_LinearSmoothScrollerAnonymousInnerClass
	extends androidx.recyclerview.widget.LinearSmoothScroller
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_computeScrollVectorForPosition:(I)Landroid/graphics/PointF;:GetComputeScrollVectorForPosition_IHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Utils.SpannedGridLayoutManager+LinearSmoothScrollerAnonymousInnerClass, WoWonder", SpannedGridLayoutManager_LinearSmoothScrollerAnonymousInnerClass.class, __md_methods);
	}


	public SpannedGridLayoutManager_LinearSmoothScrollerAnonymousInnerClass (android.content.Context p0)
	{
		super (p0);
		if (getClass () == SpannedGridLayoutManager_LinearSmoothScrollerAnonymousInnerClass.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.SpannedGridLayoutManager+LinearSmoothScrollerAnonymousInnerClass, WoWonder", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public android.graphics.PointF computeScrollVectorForPosition (int p0)
	{
		return n_computeScrollVectorForPosition (p0);
	}

	private native android.graphics.PointF n_computeScrollVectorForPosition (int p0);

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
