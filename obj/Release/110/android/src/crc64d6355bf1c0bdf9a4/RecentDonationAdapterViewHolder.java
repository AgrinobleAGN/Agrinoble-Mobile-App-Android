package crc64d6355bf1c0bdf9a4;


public class RecentDonationAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Fundings.Adapters.RecentDonationAdapterViewHolder, WoWonder", RecentDonationAdapterViewHolder.class, __md_methods);
	}


	public RecentDonationAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == RecentDonationAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Fundings.Adapters.RecentDonationAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
