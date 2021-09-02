package crc641aede91dd5f6d0b4;


public class ReactionComment
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.widget.PopupWindow.OnDismissListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onDismiss:()V:GetOnDismissHandler:Android.Widget.PopupWindow/IOnDismissListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Comment.Fragment.ReactionComment, WoWonder", ReactionComment.class, __md_methods);
	}


	public ReactionComment ()
	{
		super ();
		if (getClass () == ReactionComment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Comment.Fragment.ReactionComment, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public ReactionComment (android.app.Activity p0, java.lang.String p1)
	{
		super ();
		if (getClass () == ReactionComment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Comment.Fragment.ReactionComment, WoWonder", "Android.App.Activity, Mono.Android:System.String, mscorlib", this, new java.lang.Object[] { p0, p1 });
	}


	public void onDismiss ()
	{
		n_onDismiss ();
	}

	private native void n_onDismiss ();

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
