package crc644cb17e6be451a532;


public class RecyclerViewPreloader_1
	extends androidx.recyclerview.widget.RecyclerView.OnScrollListener
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onScrolled:(Landroidx/recyclerview/widget/RecyclerView;II)V:GetOnScrolled_Landroidx_recyclerview_widget_RecyclerView_IIHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.IntegrationRecyclerView.RecyclerViewPreloader`1, WoWonder", RecyclerViewPreloader_1.class, __md_methods);
	}


	public RecyclerViewPreloader_1 ()
	{
		super ();
		if (getClass () == RecyclerViewPreloader_1.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.IntegrationRecyclerView.RecyclerViewPreloader`1, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public RecyclerViewPreloader_1 (android.app.Activity p0, com.bumptech.glide.ListPreloader.PreloadModelProvider p1, com.bumptech.glide.ListPreloader.PreloadSizeProvider p2, int p3)
	{
		super ();
		if (getClass () == RecyclerViewPreloader_1.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.IntegrationRecyclerView.RecyclerViewPreloader`1, WoWonder", "Android.App.Activity, Mono.Android:Bumptech.Glide.ListPreloader+IPreloadModelProvider, Xamarin.Android.Glide:Bumptech.Glide.ListPreloader+IPreloadSizeProvider, Xamarin.Android.Glide:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}

	public RecyclerViewPreloader_1 (androidx.fragment.app.FragmentActivity p0, com.bumptech.glide.ListPreloader.PreloadModelProvider p1, com.bumptech.glide.ListPreloader.PreloadSizeProvider p2, int p3)
	{
		super ();
		if (getClass () == RecyclerViewPreloader_1.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.IntegrationRecyclerView.RecyclerViewPreloader`1, WoWonder", "AndroidX.Fragment.App.FragmentActivity, Xamarin.AndroidX.Fragment:Bumptech.Glide.ListPreloader+IPreloadModelProvider, Xamarin.Android.Glide:Bumptech.Glide.ListPreloader+IPreloadSizeProvider, Xamarin.Android.Glide:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}

	public RecyclerViewPreloader_1 (androidx.fragment.app.Fragment p0, com.bumptech.glide.ListPreloader.PreloadModelProvider p1, com.bumptech.glide.ListPreloader.PreloadSizeProvider p2, int p3)
	{
		super ();
		if (getClass () == RecyclerViewPreloader_1.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.IntegrationRecyclerView.RecyclerViewPreloader`1, WoWonder", "AndroidX.Fragment.App.Fragment, Xamarin.AndroidX.Fragment:Bumptech.Glide.ListPreloader+IPreloadModelProvider, Xamarin.Android.Glide:Bumptech.Glide.ListPreloader+IPreloadSizeProvider, Xamarin.Android.Glide:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}

	public RecyclerViewPreloader_1 (com.bumptech.glide.RequestManager p0, com.bumptech.glide.ListPreloader.PreloadModelProvider p1, com.bumptech.glide.ListPreloader.PreloadSizeProvider p2, int p3)
	{
		super ();
		if (getClass () == RecyclerViewPreloader_1.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.IntegrationRecyclerView.RecyclerViewPreloader`1, WoWonder", "Bumptech.Glide.RequestManager, Xamarin.Android.Glide:Bumptech.Glide.ListPreloader+IPreloadModelProvider, Xamarin.Android.Glide:Bumptech.Glide.ListPreloader+IPreloadSizeProvider, Xamarin.Android.Glide:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public void onScrolled (androidx.recyclerview.widget.RecyclerView p0, int p1, int p2)
	{
		n_onScrolled (p0, p1, p2);
	}

	private native void n_onScrolled (androidx.recyclerview.widget.RecyclerView p0, int p1, int p2);

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
