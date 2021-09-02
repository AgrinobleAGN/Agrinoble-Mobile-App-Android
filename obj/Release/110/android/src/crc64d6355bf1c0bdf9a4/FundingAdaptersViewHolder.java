package crc64d6355bf1c0bdf9a4;


public class FundingAdaptersViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Fundings.Adapters.FundingAdaptersViewHolder, WoWonder", FundingAdaptersViewHolder.class, __md_methods);
	}


	public FundingAdaptersViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == FundingAdaptersViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Fundings.Adapters.FundingAdaptersViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
