package crc6447b7d00dc8d7ead2;


public class FilterCategoriesActivity
	extends crc64dcf039a48c5f8fc0.BaseActivity
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Articles.FilterCategoriesActivity, WoWonder", FilterCategoriesActivity.class, __md_methods);
	}


	public FilterCategoriesActivity ()
	{
		super ();
		if (getClass () == FilterCategoriesActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Articles.FilterCategoriesActivity, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public FilterCategoriesActivity (int p0)
	{
		super (p0);
		if (getClass () == FilterCategoriesActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Articles.FilterCategoriesActivity, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);

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
