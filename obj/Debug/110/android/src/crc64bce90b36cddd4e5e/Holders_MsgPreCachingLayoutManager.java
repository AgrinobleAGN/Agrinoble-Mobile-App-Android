package crc64bce90b36cddd4e5e;


public class Holders_MsgPreCachingLayoutManager
	extends androidx.recyclerview.widget.LinearLayoutManager
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_getExtraLayoutSpace:(Landroidx/recyclerview/widget/RecyclerView$State;)I:GetGetExtraLayoutSpace_Landroidx_recyclerview_widget_RecyclerView_State_Handler\n" +
			"n_onLayoutChildren:(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)V:GetOnLayoutChildren_Landroidx_recyclerview_widget_RecyclerView_Recycler_Landroidx_recyclerview_widget_RecyclerView_State_Handler\n" +
			"n_collectAdjacentPrefetchPositions:(IILandroidx/recyclerview/widget/RecyclerView$State;Landroidx/recyclerview/widget/RecyclerView$LayoutManager$LayoutPrefetchRegistry;)V:GetCollectAdjacentPrefetchPositions_IILandroidx_recyclerview_widget_RecyclerView_State_Landroidx_recyclerview_widget_RecyclerView_LayoutManager_LayoutPrefetchRegistry_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.Adapters.Holders+MsgPreCachingLayoutManager, WoWonder", Holders_MsgPreCachingLayoutManager.class, __md_methods);
	}


	public Holders_MsgPreCachingLayoutManager (android.content.Context p0)
	{
		super (p0);
		if (getClass () == Holders_MsgPreCachingLayoutManager.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Adapters.Holders+MsgPreCachingLayoutManager, WoWonder", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public Holders_MsgPreCachingLayoutManager (android.content.Context p0, android.util.AttributeSet p1, int p2, int p3)
	{
		super (p0, p1, p2, p3);
		if (getClass () == Holders_MsgPreCachingLayoutManager.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Adapters.Holders+MsgPreCachingLayoutManager, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public Holders_MsgPreCachingLayoutManager (android.content.Context p0, int p1, boolean p2)
	{
		super (p0, p1, p2);
		if (getClass () == Holders_MsgPreCachingLayoutManager.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Adapters.Holders+MsgPreCachingLayoutManager, WoWonder", "Android.Content.Context, Mono.Android:System.Int32, mscorlib:System.Boolean, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public int getExtraLayoutSpace (androidx.recyclerview.widget.RecyclerView.State p0)
	{
		return n_getExtraLayoutSpace (p0);
	}

	private native int n_getExtraLayoutSpace (androidx.recyclerview.widget.RecyclerView.State p0);


	public void onLayoutChildren (androidx.recyclerview.widget.RecyclerView.Recycler p0, androidx.recyclerview.widget.RecyclerView.State p1)
	{
		n_onLayoutChildren (p0, p1);
	}

	private native void n_onLayoutChildren (androidx.recyclerview.widget.RecyclerView.Recycler p0, androidx.recyclerview.widget.RecyclerView.State p1);


	public void collectAdjacentPrefetchPositions (int p0, int p1, androidx.recyclerview.widget.RecyclerView.State p2, androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry p3)
	{
		n_collectAdjacentPrefetchPositions (p0, p1, p2, p3);
	}

	private native void n_collectAdjacentPrefetchPositions (int p0, int p1, androidx.recyclerview.widget.RecyclerView.State p2, androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry p3);

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
