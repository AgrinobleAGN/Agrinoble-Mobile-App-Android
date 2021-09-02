package crc644da9829989bd9ec9;


public class ArticlesAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Articles.Adapters.ArticlesAdapterViewHolder, WoWonder", ArticlesAdapterViewHolder.class, __md_methods);
	}


	public ArticlesAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == ArticlesAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Articles.Adapters.ArticlesAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
