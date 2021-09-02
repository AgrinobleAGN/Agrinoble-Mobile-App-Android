package crc64ac46edc3bc3f6825;


public class InviteFriendsAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.SettingsPreferences.InviteFriends.Adapter.InviteFriendsAdapterViewHolder, WoWonder", InviteFriendsAdapterViewHolder.class, __md_methods);
	}


	public InviteFriendsAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == InviteFriendsAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.SettingsPreferences.InviteFriends.Adapter.InviteFriendsAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
	}

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
