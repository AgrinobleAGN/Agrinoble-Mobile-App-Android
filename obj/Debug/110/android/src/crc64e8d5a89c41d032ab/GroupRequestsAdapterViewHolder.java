package crc64e8d5a89c41d032ab;


public class GroupRequestsAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.GroupChat.Adapter.GroupRequestsAdapterViewHolder, WoWonder", GroupRequestsAdapterViewHolder.class, __md_methods);
	}


	public GroupRequestsAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == GroupRequestsAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.GroupChat.Adapter.GroupRequestsAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
