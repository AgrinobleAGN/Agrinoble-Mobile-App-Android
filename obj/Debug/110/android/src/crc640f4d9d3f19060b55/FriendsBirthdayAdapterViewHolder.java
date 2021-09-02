package crc640f4d9d3f19060b55;


public class FriendsBirthdayAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.FriendsBirthday.Adapter.FriendsBirthdayAdapterViewHolder, WoWonder", FriendsBirthdayAdapterViewHolder.class, __md_methods);
	}


	public FriendsBirthdayAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == FriendsBirthdayAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.FriendsBirthday.Adapter.FriendsBirthdayAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
