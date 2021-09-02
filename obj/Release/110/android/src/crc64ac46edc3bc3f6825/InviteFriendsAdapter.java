package crc64ac46edc3bc3f6825;


public class InviteFriendsAdapter
	extends androidx.recyclerview.widget.RecyclerView.Adapter
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreateViewHolder:(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;:GetOnCreateViewHolder_Landroid_view_ViewGroup_IHandler\n" +
			"n_getItemCount:()I:GetGetItemCountHandler\n" +
			"n_onBindViewHolder:(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V:GetOnBindViewHolder_Landroidx_recyclerview_widget_RecyclerView_ViewHolder_IHandler\n" +
			"n_getItemId:(I)J:GetGetItemId_IHandler\n" +
			"n_getItemViewType:(I)I:GetGetItemViewType_IHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.SettingsPreferences.InviteFriends.Adapter.InviteFriendsAdapter, WoWonder", InviteFriendsAdapter.class, __md_methods);
	}


	public InviteFriendsAdapter ()
	{
		super ();
		if (getClass () == InviteFriendsAdapter.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.SettingsPreferences.InviteFriends.Adapter.InviteFriendsAdapter, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public InviteFriendsAdapter (android.app.Activity p0)
	{
		super ();
		if (getClass () == InviteFriendsAdapter.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.SettingsPreferences.InviteFriends.Adapter.InviteFriendsAdapter, WoWonder", "Android.App.Activity, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder (android.view.ViewGroup p0, int p1)
	{
		return n_onCreateViewHolder (p0, p1);
	}

	private native androidx.recyclerview.widget.RecyclerView.ViewHolder n_onCreateViewHolder (android.view.ViewGroup p0, int p1);


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
