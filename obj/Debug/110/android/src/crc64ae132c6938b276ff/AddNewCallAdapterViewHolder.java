package crc64ae132c6938b276ff;


public class AddNewCallAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.Call.Adapters.AddNewCallAdapterViewHolder, WoWonder", AddNewCallAdapterViewHolder.class, __md_methods);
	}


	public AddNewCallAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == AddNewCallAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Call.Adapters.AddNewCallAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
