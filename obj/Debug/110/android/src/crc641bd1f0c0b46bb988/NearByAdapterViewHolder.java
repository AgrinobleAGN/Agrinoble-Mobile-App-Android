package crc641bd1f0c0b46bb988;


public class NearByAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.NearBy.Adapters.NearByAdapterViewHolder, WoWonder", NearByAdapterViewHolder.class, __md_methods);
	}


	public NearByAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == NearByAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NearBy.Adapters.NearByAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
