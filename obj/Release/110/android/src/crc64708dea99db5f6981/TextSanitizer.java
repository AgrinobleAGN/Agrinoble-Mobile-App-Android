package crc64708dea99db5f6981;


public class TextSanitizer
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Utils.TextSanitizer, WoWonder", TextSanitizer.class, __md_methods);
	}


	public TextSanitizer ()
	{
		super ();
		if (getClass () == TextSanitizer.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.TextSanitizer, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public TextSanitizer (com.luseen.autolinklibrary.AutoLinkTextView p0, android.app.Activity p1, java.lang.String p2)
	{
		super ();
		if (getClass () == TextSanitizer.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.TextSanitizer, WoWonder", "Com.Luseen.Autolinklibrary.AutoLinkTextView, AutoLinkTextView:Android.App.Activity, Mono.Android:System.String, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
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
