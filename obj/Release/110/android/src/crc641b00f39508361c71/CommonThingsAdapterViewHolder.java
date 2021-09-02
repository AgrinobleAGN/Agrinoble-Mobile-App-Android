package crc641b00f39508361c71;


public class CommonThingsAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.CommonThings.Adapters.CommonThingsAdapterViewHolder, WoWonder", CommonThingsAdapterViewHolder.class, __md_methods);
	}


	public CommonThingsAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == CommonThingsAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.CommonThings.Adapters.CommonThingsAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
