package crc64e3f0aab333e84ad0;


public class VideoController_MediaSourceFactoryAnonymousInnerClass
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.google.android.exoplayer2.source.MediaSourceFactory
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_createMediaSource:(Landroid/net/Uri;)Lcom/google/android/exoplayer2/source/MediaSource;:GetCreateMediaSource_Landroid_net_Uri_Handler:Com.Google.Android.Exoplayer2.Source.IMediaSourceFactoryInvoker, ExoPlayer.Core\n" +
			"n_getSupportedTypes:()[I:GetGetSupportedTypesHandler:Com.Google.Android.Exoplayer2.Source.IMediaSourceFactoryInvoker, ExoPlayer.Core\n" +
			"n_setDrmSessionManager:(Lcom/google/android/exoplayer2/drm/DrmSessionManager;)Lcom/google/android/exoplayer2/source/MediaSourceFactory;:GetSetDrmSessionManager_Lcom_google_android_exoplayer2_drm_DrmSessionManager_Handler:Com.Google.Android.Exoplayer2.Source.IMediaSourceFactoryInvoker, ExoPlayer.Core\n" +
			"n_setStreamKeys:(Ljava/util/List;)Lcom/google/android/exoplayer2/source/MediaSourceFactory;:GetSetStreamKeys_Ljava_util_List_Handler:Com.Google.Android.Exoplayer2.Source.IMediaSourceFactory, ExoPlayer.Core\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Controller.VideoController+MediaSourceFactoryAnonymousInnerClass, WoWonder", VideoController_MediaSourceFactoryAnonymousInnerClass.class, __md_methods);
	}


	public VideoController_MediaSourceFactoryAnonymousInnerClass ()
	{
		super ();
		if (getClass () == VideoController_MediaSourceFactoryAnonymousInnerClass.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Controller.VideoController+MediaSourceFactoryAnonymousInnerClass, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public VideoController_MediaSourceFactoryAnonymousInnerClass (crc64e3f0aab333e84ad0.VideoController p0)
	{
		super ();
		if (getClass () == VideoController_MediaSourceFactoryAnonymousInnerClass.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Controller.VideoController+MediaSourceFactoryAnonymousInnerClass, WoWonder", "WoWonder.Helpers.Controller.VideoController, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public com.google.android.exoplayer2.source.MediaSource createMediaSource (android.net.Uri p0)
	{
		return n_createMediaSource (p0);
	}

	private native com.google.android.exoplayer2.source.MediaSource n_createMediaSource (android.net.Uri p0);


	public int[] getSupportedTypes ()
	{
		return n_getSupportedTypes ();
	}

	private native int[] n_getSupportedTypes ();


	public com.google.android.exoplayer2.source.MediaSourceFactory setDrmSessionManager (com.google.android.exoplayer2.drm.DrmSessionManager p0)
	{
		return n_setDrmSessionManager (p0);
	}

	private native com.google.android.exoplayer2.source.MediaSourceFactory n_setDrmSessionManager (com.google.android.exoplayer2.drm.DrmSessionManager p0);


	public com.google.android.exoplayer2.source.MediaSourceFactory setStreamKeys (java.util.List p0)
	{
		return n_setStreamKeys (p0);
	}

	private native com.google.android.exoplayer2.source.MediaSourceFactory n_setStreamKeys (java.util.List p0);

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
