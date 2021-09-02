package crc64297040596eefa26a;


public class AdapterHolders_PostDividerSectionViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.NativePost.Post.AdapterHolders+PostDividerSectionViewHolder, WoWonder", AdapterHolders_PostDividerSectionViewHolder.class, __md_methods);
	}


	public AdapterHolders_PostDividerSectionViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == AdapterHolders_PostDividerSectionViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Post.AdapterHolders+PostDividerSectionViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
