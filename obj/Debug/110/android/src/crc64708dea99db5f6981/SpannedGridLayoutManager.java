package crc64708dea99db5f6981;


public class SpannedGridLayoutManager
	extends androidx.recyclerview.widget.RecyclerView.LayoutManager
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onLayoutChildren:(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)V:GetOnLayoutChildren_Landroidx_recyclerview_widget_RecyclerView_Recycler_Landroidx_recyclerview_widget_RecyclerView_State_Handler\n" +
			"n_generateDefaultLayoutParams:()Landroidx/recyclerview/widget/RecyclerView$LayoutParams;:GetGenerateDefaultLayoutParamsHandler\n" +
			"n_generateLayoutParams:(Landroid/content/Context;Landroid/util/AttributeSet;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;:GetGenerateLayoutParams_Landroid_content_Context_Landroid_util_AttributeSet_Handler\n" +
			"n_generateLayoutParams:(Landroid/view/ViewGroup$LayoutParams;)Landroidx/recyclerview/widget/RecyclerView$LayoutParams;:GetGenerateLayoutParams_Landroid_view_ViewGroup_LayoutParams_Handler\n" +
			"n_checkLayoutParams:(Landroidx/recyclerview/widget/RecyclerView$LayoutParams;)Z:GetCheckLayoutParams_Landroidx_recyclerview_widget_RecyclerView_LayoutParams_Handler\n" +
			"n_onAdapterChanged:(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V:GetOnAdapterChanged_Landroidx_recyclerview_widget_RecyclerView_Adapter_Landroidx_recyclerview_widget_RecyclerView_Adapter_Handler\n" +
			"n_supportsPredictiveItemAnimations:()Z:GetSupportsPredictiveItemAnimationsHandler\n" +
			"n_canScrollVertically:()Z:GetCanScrollVerticallyHandler\n" +
			"n_scrollVerticallyBy:(ILandroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)I:GetScrollVerticallyBy_ILandroidx_recyclerview_widget_RecyclerView_Recycler_Landroidx_recyclerview_widget_RecyclerView_State_Handler\n" +
			"n_scrollToPosition:(I)V:GetScrollToPosition_IHandler\n" +
			"n_smoothScrollToPosition:(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;I)V:GetSmoothScrollToPosition_Landroidx_recyclerview_widget_RecyclerView_Landroidx_recyclerview_widget_RecyclerView_State_IHandler\n" +
			"n_computeVerticalScrollRange:(Landroidx/recyclerview/widget/RecyclerView$State;)I:GetComputeVerticalScrollRange_Landroidx_recyclerview_widget_RecyclerView_State_Handler\n" +
			"n_computeVerticalScrollExtent:(Landroidx/recyclerview/widget/RecyclerView$State;)I:GetComputeVerticalScrollExtent_Landroidx_recyclerview_widget_RecyclerView_State_Handler\n" +
			"n_computeVerticalScrollOffset:(Landroidx/recyclerview/widget/RecyclerView$State;)I:GetComputeVerticalScrollOffset_Landroidx_recyclerview_widget_RecyclerView_State_Handler\n" +
			"n_findViewByPosition:(I)Landroid/view/View;:GetFindViewByPosition_IHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Utils.SpannedGridLayoutManager, WoWonder", SpannedGridLayoutManager.class, __md_methods);
	}


	public SpannedGridLayoutManager ()
	{
		super ();
		if (getClass () == SpannedGridLayoutManager.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.SpannedGridLayoutManager, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public SpannedGridLayoutManager (android.content.Context p0, android.util.AttributeSet p1, int p2, int p3)
	{
		super ();
		if (getClass () == SpannedGridLayoutManager.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.SpannedGridLayoutManager, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public void onLayoutChildren (androidx.recyclerview.widget.RecyclerView.Recycler p0, androidx.recyclerview.widget.RecyclerView.State p1)
	{
		n_onLayoutChildren (p0, p1);
	}

	private native void n_onLayoutChildren (androidx.recyclerview.widget.RecyclerView.Recycler p0, androidx.recyclerview.widget.RecyclerView.State p1);


	public androidx.recyclerview.widget.RecyclerView.LayoutParams generateDefaultLayoutParams ()
	{
		return n_generateDefaultLayoutParams ();
	}

	private native androidx.recyclerview.widget.RecyclerView.LayoutParams n_generateDefaultLayoutParams ();


	public androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams (android.content.Context p0, android.util.AttributeSet p1)
	{
		return n_generateLayoutParams (p0, p1);
	}

	private native androidx.recyclerview.widget.RecyclerView.LayoutParams n_generateLayoutParams (android.content.Context p0, android.util.AttributeSet p1);


	public androidx.recyclerview.widget.RecyclerView.LayoutParams generateLayoutParams (android.view.ViewGroup.LayoutParams p0)
	{
		return n_generateLayoutParams (p0);
	}

	private native androidx.recyclerview.widget.RecyclerView.LayoutParams n_generateLayoutParams (android.view.ViewGroup.LayoutParams p0);


	public boolean checkLayoutParams (androidx.recyclerview.widget.RecyclerView.LayoutParams p0)
	{
		return n_checkLayoutParams (p0);
	}

	private native boolean n_checkLayoutParams (androidx.recyclerview.widget.RecyclerView.LayoutParams p0);


	public void onAdapterChanged (androidx.recyclerview.widget.RecyclerView.Adapter p0, androidx.recyclerview.widget.RecyclerView.Adapter p1)
	{
		n_onAdapterChanged (p0, p1);
	}

	private native void n_onAdapterChanged (androidx.recyclerview.widget.RecyclerView.Adapter p0, androidx.recyclerview.widget.RecyclerView.Adapter p1);


	public boolean supportsPredictiveItemAnimations ()
	{
		return n_supportsPredictiveItemAnimations ();
	}

	private native boolean n_supportsPredictiveItemAnimations ();


	public boolean canScrollVertically ()
	{
		return n_canScrollVertically ();
	}

	private native boolean n_canScrollVertically ();


	public int scrollVerticallyBy (int p0, androidx.recyclerview.widget.RecyclerView.Recycler p1, androidx.recyclerview.widget.RecyclerView.State p2)
	{
		return n_scrollVerticallyBy (p0, p1, p2);
	}

	private native int n_scrollVerticallyBy (int p0, androidx.recyclerview.widget.RecyclerView.Recycler p1, androidx.recyclerview.widget.RecyclerView.State p2);


	public void scrollToPosition (int p0)
	{
		n_scrollToPosition (p0);
	}

	private native void n_scrollToPosition (int p0);


	public void smoothScrollToPosition (androidx.recyclerview.widget.RecyclerView p0, androidx.recyclerview.widget.RecyclerView.State p1, int p2)
	{
		n_smoothScrollToPosition (p0, p1, p2);
	}

	private native void n_smoothScrollToPosition (androidx.recyclerview.widget.RecyclerView p0, androidx.recyclerview.widget.RecyclerView.State p1, int p2);


	public int computeVerticalScrollRange (androidx.recyclerview.widget.RecyclerView.State p0)
	{
		return n_computeVerticalScrollRange (p0);
	}

	private native int n_computeVerticalScrollRange (androidx.recyclerview.widget.RecyclerView.State p0);


	public int computeVerticalScrollExtent (androidx.recyclerview.widget.RecyclerView.State p0)
	{
		return n_computeVerticalScrollExtent (p0);
	}

	private native int n_computeVerticalScrollExtent (androidx.recyclerview.widget.RecyclerView.State p0);


	public int computeVerticalScrollOffset (androidx.recyclerview.widget.RecyclerView.State p0)
	{
		return n_computeVerticalScrollOffset (p0);
	}

	private native int n_computeVerticalScrollOffset (androidx.recyclerview.widget.RecyclerView.State p0);


	public android.view.View findViewByPosition (int p0)
	{
		return n_findViewByPosition (p0);
	}

	private native android.view.View n_findViewByPosition (int p0);

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
