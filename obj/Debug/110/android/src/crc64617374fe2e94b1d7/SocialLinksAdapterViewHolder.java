package crc64617374fe2e94b1d7;


public class SocialLinksAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.MyProfile.Adapters.SocialLinksAdapterViewHolder, WoWonder", SocialLinksAdapterViewHolder.class, __md_methods);
	}


	public SocialLinksAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == SocialLinksAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.MyProfile.Adapters.SocialLinksAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
