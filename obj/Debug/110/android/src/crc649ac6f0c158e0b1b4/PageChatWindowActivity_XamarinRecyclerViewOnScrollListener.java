package crc649ac6f0c158e0b1b4;


public class PageChatWindowActivity_XamarinRecyclerViewOnScrollListener
	extends androidx.recyclerview.widget.RecyclerView.OnScrollListener
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onScrolled:(Landroidx/recyclerview/widget/RecyclerView;II)V:GetOnScrolled_Landroidx_recyclerview_widget_RecyclerView_IIHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.PageChat.PageChatWindowActivity+XamarinRecyclerViewOnScrollListener, WoWonder", PageChatWindowActivity_XamarinRecyclerViewOnScrollListener.class, __md_methods);
	}


	public PageChatWindowActivity_XamarinRecyclerViewOnScrollListener ()
	{
		super ();
		if (getClass () == PageChatWindowActivity_XamarinRecyclerViewOnScrollListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.PageChat.PageChatWindowActivity+XamarinRecyclerViewOnScrollListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public PageChatWindowActivity_XamarinRecyclerViewOnScrollListener (crc64bce90b36cddd4e5e.Holders_MsgPreCachingLayoutManager p0, com.google.android.material.floatingactionbutton.FloatingActionButton p1, androidx.swiperefreshlayout.widget.SwipeRefreshLayout p2)
	{
		super ();
		if (getClass () == PageChatWindowActivity_XamarinRecyclerViewOnScrollListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.PageChat.PageChatWindowActivity+XamarinRecyclerViewOnScrollListener, WoWonder", "WoWonder.Activities.Chat.Adapters.Holders+MsgPreCachingLayoutManager, WoWonder:Google.Android.Material.FloatingActionButton.FloatingActionButton, Xamarin.Google.Android.Material:AndroidX.SwipeRefreshLayout.Widget.SwipeRefreshLayout, Xamarin.AndroidX.SwipeRefreshLayout", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public void onScrolled (androidx.recyclerview.widget.RecyclerView p0, int p1, int p2)
	{
		n_onScrolled (p0, p1, p2);
	}

	private native void n_onScrolled (androidx.recyclerview.widget.RecyclerView p0, int p1, int p2);

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
