package crc64632b162eba757138;


public class FriendRequestViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.MsgTabbes.Adapter.FriendRequestViewHolder, WoWonder", FriendRequestViewHolder.class, __md_methods);
	}


	public FriendRequestViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == FriendRequestViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.MsgTabbes.Adapter.FriendRequestViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
