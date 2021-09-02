package crc646bb324bc4b123e90;


public class CommentClickListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Comment.CommentClickListener, WoWonder", CommentClickListener.class, __md_methods);
	}


	public CommentClickListener ()
	{
		super ();
		if (getClass () == CommentClickListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Comment.CommentClickListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public CommentClickListener (android.app.Activity p0, java.lang.String p1)
	{
		super ();
		if (getClass () == CommentClickListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Comment.CommentClickListener, WoWonder", "Android.App.Activity, Mono.Android:System.String, mscorlib", this, new java.lang.Object[] { p0, p1 });
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
