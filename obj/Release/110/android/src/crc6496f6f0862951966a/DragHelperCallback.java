package crc6496f6f0862951966a;


public class DragHelperCallback
	extends androidx.customview.widget.ViewDragHelper.Callback
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onViewDragStateChanged:(I)V:GetOnViewDragStateChanged_IHandler\n" +
			"n_onViewPositionChanged:(Landroid/view/View;IIII)V:GetOnViewPositionChanged_Landroid_view_View_IIIIHandler\n" +
			"n_onViewReleased:(Landroid/view/View;FF)V:GetOnViewReleased_Landroid_view_View_FFHandler\n" +
			"n_getViewVerticalDragRange:(Landroid/view/View;)I:GetGetViewVerticalDragRange_Landroid_view_View_Handler\n" +
			"n_tryCaptureView:(Landroid/view/View;I)Z:GetTryCaptureView_Landroid_view_View_IHandler\n" +
			"n_clampViewPositionHorizontal:(Landroid/view/View;II)I:GetClampViewPositionHorizontal_Landroid_view_View_IIHandler\n" +
			"n_clampViewPositionVertical:(Landroid/view/View;II)I:GetClampViewPositionVertical_Landroid_view_View_IIHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.Stories.DragView.DragHelperCallback, WoWonder", DragHelperCallback.class, __md_methods);
	}


	public DragHelperCallback ()
	{
		super ();
		if (getClass () == DragHelperCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.Stories.DragView.DragHelperCallback, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public DragHelperCallback (crc6496f6f0862951966a.DragToClose p0, android.view.View p1)
	{
		super ();
		if (getClass () == DragHelperCallback.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.Stories.DragView.DragHelperCallback, WoWonder", "WoWonder.Library.Anjo.Stories.DragView.DragToClose, WoWonder:Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public void onViewDragStateChanged (int p0)
	{
		n_onViewDragStateChanged (p0);
	}

	private native void n_onViewDragStateChanged (int p0);


	public void onViewPositionChanged (android.view.View p0, int p1, int p2, int p3, int p4)
	{
		n_onViewPositionChanged (p0, p1, p2, p3, p4);
	}

	private native void n_onViewPositionChanged (android.view.View p0, int p1, int p2, int p3, int p4);


	public void onViewReleased (android.view.View p0, float p1, float p2)
	{
		n_onViewReleased (p0, p1, p2);
	}

	private native void n_onViewReleased (android.view.View p0, float p1, float p2);


	public int getViewVerticalDragRange (android.view.View p0)
	{
		return n_getViewVerticalDragRange (p0);
	}

	private native int n_getViewVerticalDragRange (android.view.View p0);


	public boolean tryCaptureView (android.view.View p0, int p1)
	{
		return n_tryCaptureView (p0, p1);
	}

	private native boolean n_tryCaptureView (android.view.View p0, int p1);


	public int clampViewPositionHorizontal (android.view.View p0, int p1, int p2)
	{
		return n_clampViewPositionHorizontal (p0, p1, p2);
	}

	private native int n_clampViewPositionHorizontal (android.view.View p0, int p1, int p2);


	public int clampViewPositionVertical (android.view.View p0, int p1, int p2)
	{
		return n_clampViewPositionVertical (p0, p1, p2);
	}

	private native int n_clampViewPositionVertical (android.view.View p0, int p1, int p2);

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
