package crc645d531d68d1ea7905;


public class WRecyclerView_MyCacheKeyFactory
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.google.android.exoplayer2.upstream.cache.CacheKeyFactory
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_buildCacheKey:(Lcom/google/android/exoplayer2/upstream/DataSpec;)Ljava/lang/String;:GetBuildCacheKey_Lcom_google_android_exoplayer2_upstream_DataSpec_Handler:Com.Google.Android.Exoplayer2.Upstream.Cache.ICacheKeyFactoryInvoker, ExoPlayer.Core\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.NativePost.Extra.WRecyclerView+MyCacheKeyFactory, WoWonder", WRecyclerView_MyCacheKeyFactory.class, __md_methods);
	}


	public WRecyclerView_MyCacheKeyFactory ()
	{
		super ();
		if (getClass () == WRecyclerView_MyCacheKeyFactory.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Extra.WRecyclerView+MyCacheKeyFactory, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public java.lang.String buildCacheKey (com.google.android.exoplayer2.upstream.DataSpec p0)
	{
		return n_buildCacheKey (p0);
	}

	private native java.lang.String n_buildCacheKey (com.google.android.exoplayer2.upstream.DataSpec p0);

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
