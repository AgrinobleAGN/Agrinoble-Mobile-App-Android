package crc64d837af3802c85cae;


public class MoviesAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Movies.Adapters.MoviesAdapterViewHolder, WoWonder", MoviesAdapterViewHolder.class, __md_methods);
	}


	public MoviesAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == MoviesAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Movies.Adapters.MoviesAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
