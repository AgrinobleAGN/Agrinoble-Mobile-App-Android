package crc6473614a04dc5e4f40;


public class MyVideoAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.MyVideo.Adapters.MyVideoAdapterViewHolder, WoWonder", MyVideoAdapterViewHolder.class, __md_methods);
	}


	public MyVideoAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == MyVideoAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.MyVideo.Adapters.MyVideoAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
