package crc64a7a858605d6dc9ea;


public class HashTagAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Hashtag.Adapters.HashTagAdapterViewHolder, WoWonder", HashTagAdapterViewHolder.class, __md_methods);
	}


	public HashTagAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == HashTagAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Hashtag.Adapters.HashTagAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
