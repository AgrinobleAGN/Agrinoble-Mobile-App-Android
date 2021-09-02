package crc6466aa6d4bc5664840;


public class AdsFacebook_NativeAdListener_MediaViewListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.facebook.ads.MediaViewListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onComplete:(Lcom/facebook/ads/MediaView;)V:GetOnComplete_Lcom_facebook_ads_MediaView_Handler:Xamarin.Facebook.Ads.IMediaViewListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onEnterFullscreen:(Lcom/facebook/ads/MediaView;)V:GetOnEnterFullscreen_Lcom_facebook_ads_MediaView_Handler:Xamarin.Facebook.Ads.IMediaViewListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onExitFullscreen:(Lcom/facebook/ads/MediaView;)V:GetOnExitFullscreen_Lcom_facebook_ads_MediaView_Handler:Xamarin.Facebook.Ads.IMediaViewListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onFullscreenBackground:(Lcom/facebook/ads/MediaView;)V:GetOnFullscreenBackground_Lcom_facebook_ads_MediaView_Handler:Xamarin.Facebook.Ads.IMediaViewListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onFullscreenForeground:(Lcom/facebook/ads/MediaView;)V:GetOnFullscreenForeground_Lcom_facebook_ads_MediaView_Handler:Xamarin.Facebook.Ads.IMediaViewListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onPause:(Lcom/facebook/ads/MediaView;)V:GetOnPause_Lcom_facebook_ads_MediaView_Handler:Xamarin.Facebook.Ads.IMediaViewListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onPlay:(Lcom/facebook/ads/MediaView;)V:GetOnPlay_Lcom_facebook_ads_MediaView_Handler:Xamarin.Facebook.Ads.IMediaViewListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"n_onVolumeChange:(Lcom/facebook/ads/MediaView;F)V:GetOnVolumeChange_Lcom_facebook_ads_MediaView_FHandler:Xamarin.Facebook.Ads.IMediaViewListenerInvoker, Xamarin.Facebook.AudienceNetwork.Android\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Ads.AdsFacebook+NativeAdListener+MediaViewListener, WoWonder", AdsFacebook_NativeAdListener_MediaViewListener.class, __md_methods);
	}


	public AdsFacebook_NativeAdListener_MediaViewListener ()
	{
		super ();
		if (getClass () == AdsFacebook_NativeAdListener_MediaViewListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Ads.AdsFacebook+NativeAdListener+MediaViewListener, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void onComplete (com.facebook.ads.MediaView p0)
	{
		n_onComplete (p0);
	}

	private native void n_onComplete (com.facebook.ads.MediaView p0);


	public void onEnterFullscreen (com.facebook.ads.MediaView p0)
	{
		n_onEnterFullscreen (p0);
	}

	private native void n_onEnterFullscreen (com.facebook.ads.MediaView p0);


	public void onExitFullscreen (com.facebook.ads.MediaView p0)
	{
		n_onExitFullscreen (p0);
	}

	private native void n_onExitFullscreen (com.facebook.ads.MediaView p0);


	public void onFullscreenBackground (com.facebook.ads.MediaView p0)
	{
		n_onFullscreenBackground (p0);
	}

	private native void n_onFullscreenBackground (com.facebook.ads.MediaView p0);


	public void onFullscreenForeground (com.facebook.ads.MediaView p0)
	{
		n_onFullscreenForeground (p0);
	}

	private native void n_onFullscreenForeground (com.facebook.ads.MediaView p0);


	public void onPause (com.facebook.ads.MediaView p0)
	{
		n_onPause (p0);
	}

	private native void n_onPause (com.facebook.ads.MediaView p0);


	public void onPlay (com.facebook.ads.MediaView p0)
	{
		n_onPlay (p0);
	}

	private native void n_onPlay (com.facebook.ads.MediaView p0);


	public void onVolumeChange (com.facebook.ads.MediaView p0, float p1)
	{
		n_onVolumeChange (p0, p1);
	}

	private native void n_onVolumeChange (com.facebook.ads.MediaView p0, float p1);

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
