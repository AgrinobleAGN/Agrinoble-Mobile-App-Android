package crc64b5ba31be690e32d9;


public class PlacesAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.PlacesAsync.Adapters.PlacesAdapterViewHolder, WoWonder", PlacesAdapterViewHolder.class, __md_methods);
	}


	public PlacesAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == PlacesAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.PlacesAsync.Adapters.PlacesAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
