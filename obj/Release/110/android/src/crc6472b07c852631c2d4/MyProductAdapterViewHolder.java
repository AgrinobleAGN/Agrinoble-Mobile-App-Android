package crc6472b07c852631c2d4;


public class MyProductAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Market.Adapters.MyProductAdapterViewHolder, WoWonder", MyProductAdapterViewHolder.class, __md_methods);
	}


	public MyProductAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == MyProductAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Market.Adapters.MyProductAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
