package crc6466e3c73443a0a5c4;


public class PhotosAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Album.Adapters.PhotosAdapterViewHolder, WoWonder", PhotosAdapterViewHolder.class, __md_methods);
	}


	public PhotosAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == PhotosAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Album.Adapters.PhotosAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
