package crc64e2750609c8b6fae9;


public class MyPhotosAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.MyPhoto.Adapters.MyPhotosAdapterViewHolder, WoWonder", MyPhotosAdapterViewHolder.class, __md_methods);
	}


	public MyPhotosAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == MyPhotosAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.MyPhoto.Adapters.MyPhotosAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
