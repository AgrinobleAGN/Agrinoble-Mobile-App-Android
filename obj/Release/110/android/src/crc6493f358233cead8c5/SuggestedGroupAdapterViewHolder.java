package crc6493f358233cead8c5;


public class SuggestedGroupAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Suggested.Adapters.SuggestedGroupAdapterViewHolder, WoWonder", SuggestedGroupAdapterViewHolder.class, __md_methods);
	}


	public SuggestedGroupAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == SuggestedGroupAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Suggested.Adapters.SuggestedGroupAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
