package crc64c0b64c5cd6f1b391;


public class NearbyShopsAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.NearbyShops.Adapters.NearbyShopsAdapterViewHolder, WoWonder", NearbyShopsAdapterViewHolder.class, __md_methods);
	}


	public NearbyShopsAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == NearbyShopsAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NearbyShops.Adapters.NearbyShopsAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
