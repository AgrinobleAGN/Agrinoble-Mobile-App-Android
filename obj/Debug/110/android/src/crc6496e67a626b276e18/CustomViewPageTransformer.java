package crc6496e67a626b276e18;


public class CustomViewPageTransformer
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		androidx.viewpager2.widget.ViewPager2.PageTransformer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_transformPage:(Landroid/view/View;F)V:GetTransformPage_Landroid_view_View_FHandler:AndroidX.ViewPager2.Widget.ViewPager2/IPageTransformerInvoker, Xamarin.AndroidX.ViewPager2\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.Stories.CustomViewPageTransformer, WoWonder", CustomViewPageTransformer.class, __md_methods);
	}


	public CustomViewPageTransformer ()
	{
		super ();
		if (getClass () == CustomViewPageTransformer.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.Stories.CustomViewPageTransformer, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public CustomViewPageTransformer (int p0)
	{
		super ();
		if (getClass () == CustomViewPageTransformer.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.Stories.CustomViewPageTransformer, WoWonder", "WoWonder.Library.Anjo.Stories.TransformType, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void transformPage (android.view.View p0, float p1)
	{
		n_transformPage (p0, p1);
	}

	private native void n_transformPage (android.view.View p0, float p1);

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
