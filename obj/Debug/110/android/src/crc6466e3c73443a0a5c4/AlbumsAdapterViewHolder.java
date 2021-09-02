package crc6466e3c73443a0a5c4;


public class AlbumsAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Album.Adapters.AlbumsAdapterViewHolder, WoWonder", AlbumsAdapterViewHolder.class, __md_methods);
	}


	public AlbumsAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == AlbumsAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Album.Adapters.AlbumsAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
