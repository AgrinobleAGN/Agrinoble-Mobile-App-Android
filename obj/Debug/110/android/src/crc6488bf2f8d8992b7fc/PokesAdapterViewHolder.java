package crc6488bf2f8d8992b7fc;


public class PokesAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Pokes.Adapters.PokesAdapterViewHolder, WoWonder", PokesAdapterViewHolder.class, __md_methods);
	}


	public PokesAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == PokesAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Pokes.Adapters.PokesAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
