package crc64297040596eefa26a;


public class AdapterHolders_EmptyStateAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.NativePost.Post.AdapterHolders+EmptyStateAdapterViewHolder, WoWonder", AdapterHolders_EmptyStateAdapterViewHolder.class, __md_methods);
	}


	public AdapterHolders_EmptyStateAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == AdapterHolders_EmptyStateAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Post.AdapterHolders+EmptyStateAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
