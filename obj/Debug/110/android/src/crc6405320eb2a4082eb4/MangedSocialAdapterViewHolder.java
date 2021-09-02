package crc6405320eb2a4082eb4;


public class MangedSocialAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Communities.Adapters.MangedSocialAdapterViewHolder, WoWonder", MangedSocialAdapterViewHolder.class, __md_methods);
	}


	public MangedSocialAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == MangedSocialAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Communities.Adapters.MangedSocialAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
