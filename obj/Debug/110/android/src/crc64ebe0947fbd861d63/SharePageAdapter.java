package crc64ebe0947fbd861d63;


public class SharePageAdapter
	extends androidx.recyclerview.widget.RecyclerView.Adapter
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_getItemCount:()I:GetGetItemCountHandler\n" +
			"n_onBindViewHolder:(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V:GetOnBindViewHolder_Landroidx_recyclerview_widget_RecyclerView_ViewHolder_IHandler\n" +
			"n_onCreateViewHolder:(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;:GetOnCreateViewHolder_Landroid_view_ViewGroup_IHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.NativePost.Share.SharePageAdapter, WoWonder", SharePageAdapter.class, __md_methods);
	}


	public SharePageAdapter ()
	{
		super ();
		if (getClass () == SharePageAdapter.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Share.SharePageAdapter, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public int getItemCount ()
	{
		return n_getItemCount ();
	}

	private native int n_getItemCount ();


	public void onBindViewHolder (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1)
	{
		n_onBindViewHolder (p0, p1);
	}

	private native void n_onBindViewHolder (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1);


	public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder (android.view.ViewGroup p0, int p1)
	{
		return n_onCreateViewHolder (p0, p1);
	}

	private native androidx.recyclerview.widget.RecyclerView.ViewHolder n_onCreateViewHolder (android.view.ViewGroup p0, int p1);

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
