package crc6447b7d00dc8d7ead2;


public class FilterCategoryAdapter_CategoryHolder
	extends androidx.recyclerview.widget.RecyclerView.ViewHolder
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Articles.FilterCategoryAdapter+CategoryHolder, WoWonder", FilterCategoryAdapter_CategoryHolder.class, __md_methods);
	}


	public FilterCategoryAdapter_CategoryHolder (android.view.View p0)
	{
		super (p0);
		if (getClass () == FilterCategoryAdapter_CategoryHolder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Articles.FilterCategoryAdapter+CategoryHolder, WoWonder", "Android.Views.View, Mono.Android", this, new java.lang.Object[] { p0 });
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
