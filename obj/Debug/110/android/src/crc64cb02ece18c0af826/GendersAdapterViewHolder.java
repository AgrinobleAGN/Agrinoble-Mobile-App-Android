package crc64cb02ece18c0af826;


public class GendersAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Adapters.GendersAdapterViewHolder, WoWonder", GendersAdapterViewHolder.class, __md_methods);
	}


	public GendersAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == GendersAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Adapters.GendersAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
