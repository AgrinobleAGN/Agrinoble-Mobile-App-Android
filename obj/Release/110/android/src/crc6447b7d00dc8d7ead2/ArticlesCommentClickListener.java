package crc6447b7d00dc8d7ead2;


public class ArticlesCommentClickListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Articles.ArticlesCommentClickListener, WoWonder", ArticlesCommentClickListener.class, __md_methods);
	}


	public ArticlesCommentClickListener ()
	{
		super ();
		if (getClass () == ArticlesCommentClickListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Articles.ArticlesCommentClickListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public ArticlesCommentClickListener (android.app.Activity p0, java.lang.String p1)
	{
		super ();
		if (getClass () == ArticlesCommentClickListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Articles.ArticlesCommentClickListener, WoWonder", "Android.App.Activity, Mono.Android:System.String, mscorlib", this, new java.lang.Object[] { p0, p1 });
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
