package crc64a52b123960dd7f34;


public class WoLayoutAsyncLoader_HeavyLayoutAsyncInflater
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onInflateFinished:(Landroid/view/View;ILandroid/view/ViewGroup;)V:GetOnInflateFinished_Landroid_view_View_ILandroid_view_ViewGroup_Handler:AndroidX.AsyncLayoutInflater.View.AsyncLayoutInflater/IOnInflateFinishedListenerInvoker, Xamarin.AndroidX.AsyncLayoutInflater\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.UI.WoLayoutAsyncLoader+HeavyLayoutAsyncInflater, WoWonder", WoLayoutAsyncLoader_HeavyLayoutAsyncInflater.class, __md_methods);
	}


	public WoLayoutAsyncLoader_HeavyLayoutAsyncInflater ()
	{
		super ();
		if (getClass () == WoLayoutAsyncLoader_HeavyLayoutAsyncInflater.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.UI.WoLayoutAsyncLoader+HeavyLayoutAsyncInflater, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public WoLayoutAsyncLoader_HeavyLayoutAsyncInflater (crc64297040596eefa26a.AdapterHolders_PostTopSectionViewHolder p0)
	{
		super ();
		if (getClass () == WoLayoutAsyncLoader_HeavyLayoutAsyncInflater.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.UI.WoLayoutAsyncLoader+HeavyLayoutAsyncInflater, WoWonder", "WoWonder.Activities.NativePost.Post.AdapterHolders+PostTopSectionViewHolder, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void onInflateFinished (android.view.View p0, int p1, android.view.ViewGroup p2)
	{
		n_onInflateFinished (p0, p1, p2);
	}

	private native void n_onInflateFinished (android.view.View p0, int p1, android.view.ViewGroup p2);

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
