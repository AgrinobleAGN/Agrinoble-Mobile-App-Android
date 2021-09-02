package crc642b3b56a503d6cae8;


public class DiscountTypeAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Offers.Adapters.DiscountTypeAdapterViewHolder, WoWonder", DiscountTypeAdapterViewHolder.class, __md_methods);
	}


	public DiscountTypeAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == DiscountTypeAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Offers.Adapters.DiscountTypeAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
