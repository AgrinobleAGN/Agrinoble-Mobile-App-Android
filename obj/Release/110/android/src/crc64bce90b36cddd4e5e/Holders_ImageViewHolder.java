package crc64bce90b36cddd4e5e;


public class Holders_ImageViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.Adapters.Holders+ImageViewHolder, WoWonder", Holders_ImageViewHolder.class, __md_methods);
	}


	public Holders_ImageViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == Holders_ImageViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Adapters.Holders+ImageViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
