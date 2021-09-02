package crc6475c912d1a5454bca;


public class SearchGroupAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Search.Adapters.SearchGroupAdapterViewHolder, WoWonder", SearchGroupAdapterViewHolder.class, __md_methods);
	}


	public SearchGroupAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == SearchGroupAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Search.Adapters.SearchGroupAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
