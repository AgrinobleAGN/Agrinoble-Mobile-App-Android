package crc6422b8cccb337149a2;


public class StorySeenListAdapterViewHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Story.Adapters.StorySeenListAdapterViewHolder, WoWonder", StorySeenListAdapterViewHolder.class, __md_methods);
	}


	public StorySeenListAdapterViewHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == StorySeenListAdapterViewHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Story.Adapters.StorySeenListAdapterViewHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
