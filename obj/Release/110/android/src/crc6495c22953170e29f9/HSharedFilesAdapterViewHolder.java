package crc6495c22953170e29f9;


public class HSharedFilesAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.SharedFiles.Adapter.HSharedFilesAdapterViewHolder, WoWonder", HSharedFilesAdapterViewHolder.class, __md_methods);
	}


	public HSharedFilesAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == HSharedFilesAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.SharedFiles.Adapter.HSharedFilesAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
