package crc640c988d1d9ccbca1d;


public class ContactsAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Contacts.Adapters.ContactsAdapterViewHolder, WoWonder", ContactsAdapterViewHolder.class, __md_methods);
	}


	public ContactsAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == ContactsAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Contacts.Adapters.ContactsAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
