package crc645c89c82444ddc4ec;


public class EventAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Events.Adapters.EventAdapterViewHolder, WoWonder", EventAdapterViewHolder.class, __md_methods);
	}


	public EventAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == EventAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Events.Adapters.EventAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
