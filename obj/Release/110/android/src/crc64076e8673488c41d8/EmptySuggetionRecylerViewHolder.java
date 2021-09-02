package crc64076e8673488c41d8;


public class EmptySuggetionRecylerViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.ChatWindow.Adapters.EmptySuggetionRecylerViewHolder, WoWonder", EmptySuggetionRecylerViewHolder.class, __md_methods);
	}


	public EmptySuggetionRecylerViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == EmptySuggetionRecylerViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.ChatWindow.Adapters.EmptySuggetionRecylerViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
