package crc6466aa6d4bc5664840;


public class TemplateView
	extends android.widget.FrameLayout
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onFinishInflate:()V:GetOnFinishInflateHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.TemplateView, WoWonder", TemplateView.class, __md_methods);
	}


	public TemplateView (android.content.Context p0)
	{
		super (p0);
		if (getClass () == TemplateView.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.TemplateView, WoWonder", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public TemplateView (android.content.Context p0, android.util.AttributeSet p1)
	{
		super (p0, p1);
		if (getClass () == TemplateView.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.TemplateView, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public TemplateView (android.content.Context p0, android.util.AttributeSet p1, int p2)
	{
		super (p0, p1, p2);
		if (getClass () == TemplateView.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.TemplateView, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public TemplateView (android.content.Context p0, android.util.AttributeSet p1, int p2, int p3)
	{
		super (p0, p1, p2, p3);
		if (getClass () == TemplateView.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.TemplateView, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public void onFinishInflate ()
	{
		n_onFinishInflate ();
	}

	private native void n_onFinishInflate ();

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
