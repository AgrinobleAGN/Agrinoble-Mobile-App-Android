package crc6464307ed53f287045;


public class MoreSectionAdapter
	extends androidx.recyclerview.widget.RecyclerView.Adapter
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_getItemCount:()I:GetGetItemCountHandler\n" +
			"n_onCreateViewHolder:(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;:GetOnCreateViewHolder_Landroid_view_ViewGroup_IHandler\n" +
			"n_onBindViewHolder:(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V:GetOnBindViewHolder_Landroidx_recyclerview_widget_RecyclerView_ViewHolder_ILjava_util_List_Handler\n" +
			"n_onBindViewHolder:(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V:GetOnBindViewHolder_Landroidx_recyclerview_widget_RecyclerView_ViewHolder_IHandler\n" +
			"n_getItemId:(I)J:GetGetItemId_IHandler\n" +
			"n_getItemViewType:(I)I:GetGetItemViewType_IHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Tabbes.Adapters.MoreSectionAdapter, WoWonder", MoreSectionAdapter.class, __md_methods);
	}


	public MoreSectionAdapter ()
	{
		super ();
		if (getClass () == MoreSectionAdapter.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Tabbes.Adapters.MoreSectionAdapter, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public MoreSectionAdapter (android.app.Activity p0, int p1)
	{
		super ();
		if (getClass () == MoreSectionAdapter.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Tabbes.Adapters.MoreSectionAdapter, WoWonder", "Android.App.Activity, Mono.Android:WoWonder.Helpers.Model.StyleRowMore, WoWonder", this, new java.lang.Object[] { p0, p1 });
	}


	public int getItemCount ()
	{
		return n_getItemCount ();
	}

	private native int n_getItemCount ();


	public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder (android.view.ViewGroup p0, int p1)
	{
		return n_onCreateViewHolder (p0, p1);
	}

	private native androidx.recyclerview.widget.RecyclerView.ViewHolder n_onCreateViewHolder (android.view.ViewGroup p0, int p1);


	public void onBindViewHolder (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1, java.util.List p2)
	{
		n_onBindViewHolder (p0, p1, p2);
	}

	private native void n_onBindViewHolder (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1, java.util.List p2);


	public void onBindViewHolder (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1)
	{
		n_onBindViewHolder (p0, p1);
	}

	private native void n_onBindViewHolder (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1);


	public long getItemId (int p0)
	{
		return n_getItemId (p0);
	}

	private native long n_getItemId (int p0);


	public int getItemViewType (int p0)
	{
		return n_getItemViewType (p0);
	}

	private native int n_getItemViewType (int p0);

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
