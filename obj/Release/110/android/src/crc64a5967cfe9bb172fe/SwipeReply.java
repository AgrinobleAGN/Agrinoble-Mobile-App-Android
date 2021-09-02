package crc64a5967cfe9bb172fe;


public class SwipeReply
	extends androidx.recyclerview.widget.ItemTouchHelper.Callback
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_getMovementFlags:(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)I:GetGetMovementFlags_Landroidx_recyclerview_widget_RecyclerView_Landroidx_recyclerview_widget_RecyclerView_ViewHolder_Handler\n" +
			"n_onMove:(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z:GetOnMove_Landroidx_recyclerview_widget_RecyclerView_Landroidx_recyclerview_widget_RecyclerView_ViewHolder_Landroidx_recyclerview_widget_RecyclerView_ViewHolder_Handler\n" +
			"n_onSwiped:(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V:GetOnSwiped_Landroidx_recyclerview_widget_RecyclerView_ViewHolder_IHandler\n" +
			"n_convertToAbsoluteDirection:(II)I:GetConvertToAbsoluteDirection_IIHandler\n" +
			"n_onChildDraw:(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;FFIZ)V:GetOnChildDraw_Landroid_graphics_Canvas_Landroidx_recyclerview_widget_RecyclerView_Landroidx_recyclerview_widget_RecyclerView_ViewHolder_FFIZHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.SwipeReply, WoWonder", SwipeReply.class, __md_methods);
	}


	public SwipeReply ()
	{
		super ();
		if (getClass () == SwipeReply.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.SwipeReply, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public int getMovementFlags (androidx.recyclerview.widget.RecyclerView p0, androidx.recyclerview.widget.RecyclerView.ViewHolder p1)
	{
		return n_getMovementFlags (p0, p1);
	}

	private native int n_getMovementFlags (androidx.recyclerview.widget.RecyclerView p0, androidx.recyclerview.widget.RecyclerView.ViewHolder p1);


	public boolean onMove (androidx.recyclerview.widget.RecyclerView p0, androidx.recyclerview.widget.RecyclerView.ViewHolder p1, androidx.recyclerview.widget.RecyclerView.ViewHolder p2)
	{
		return n_onMove (p0, p1, p2);
	}

	private native boolean n_onMove (androidx.recyclerview.widget.RecyclerView p0, androidx.recyclerview.widget.RecyclerView.ViewHolder p1, androidx.recyclerview.widget.RecyclerView.ViewHolder p2);


	public void onSwiped (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1)
	{
		n_onSwiped (p0, p1);
	}

	private native void n_onSwiped (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1);


	public int convertToAbsoluteDirection (int p0, int p1)
	{
		return n_convertToAbsoluteDirection (p0, p1);
	}

	private native int n_convertToAbsoluteDirection (int p0, int p1);


	public void onChildDraw (android.graphics.Canvas p0, androidx.recyclerview.widget.RecyclerView p1, androidx.recyclerview.widget.RecyclerView.ViewHolder p2, float p3, float p4, int p5, boolean p6)
	{
		n_onChildDraw (p0, p1, p2, p3, p4, p5, p6);
	}

	private native void n_onChildDraw (android.graphics.Canvas p0, androidx.recyclerview.widget.RecyclerView p1, androidx.recyclerview.widget.RecyclerView.ViewHolder p2, float p3, float p4, int p5, boolean p6);

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
