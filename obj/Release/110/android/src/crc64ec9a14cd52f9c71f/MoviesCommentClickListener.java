package crc64ec9a14cd52f9c71f;


public class MoviesCommentClickListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Movies.MoviesCommentClickListener, WoWonder", MoviesCommentClickListener.class, __md_methods);
	}


	public MoviesCommentClickListener ()
	{
		super ();
		if (getClass () == MoviesCommentClickListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Movies.MoviesCommentClickListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public MoviesCommentClickListener (android.app.Activity p0, java.lang.String p1)
	{
		super ();
		if (getClass () == MoviesCommentClickListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Movies.MoviesCommentClickListener, WoWonder", "Android.App.Activity, Mono.Android:System.String, mscorlib", this, new java.lang.Object[] { p0, p1 });
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
