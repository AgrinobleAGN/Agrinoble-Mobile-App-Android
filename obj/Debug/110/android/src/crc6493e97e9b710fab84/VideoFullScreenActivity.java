package crc6493e97e9b710fab84;


public class VideoFullScreenActivity
	extends crc64dcf039a48c5f8fc0.BaseActivity
	implements
		mono.android.IGCUserPeer,
		com.google.android.exoplayer2.Player.EventListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"n_onTrimMemory:(I)V:GetOnTrimMemory_IHandler\n" +
			"n_onLowMemory:()V:GetOnLowMemoryHandler\n" +
			"n_onBackPressed:()V:GetOnBackPressedHandler\n" +
			"n_onPause:()V:GetOnPauseHandler\n" +
			"n_onRestart:()V:GetOnRestartHandler\n" +
			"n_onIsPlayingChanged:(Z)V:GetOnIsPlayingChanged_ZHandler:Com.Google.Android.Exoplayer2.IPlayerEventListener, ExoPlayer.Core\n" +
			"n_onLoadingChanged:(Z)V:GetOnLoadingChanged_ZHandler:Com.Google.Android.Exoplayer2.IPlayerEventListener, ExoPlayer.Core\n" +
			"n_onPlaybackParametersChanged:(Lcom/google/android/exoplayer2/PlaybackParameters;)V:GetOnPlaybackParametersChanged_Lcom_google_android_exoplayer2_PlaybackParameters_Handler:Com.Google.Android.Exoplayer2.IPlayerEventListener, ExoPlayer.Core\n" +
			"n_onPlaybackSuppressionReasonChanged:(I)V:GetOnPlaybackSuppressionReasonChanged_IHandler:Com.Google.Android.Exoplayer2.IPlayerEventListener, ExoPlayer.Core\n" +
			"n_onPlayerError:(Lcom/google/android/exoplayer2/ExoPlaybackException;)V:GetOnPlayerError_Lcom_google_android_exoplayer2_ExoPlaybackException_Handler:Com.Google.Android.Exoplayer2.IPlayerEventListener, ExoPlayer.Core\n" +
			"n_onPlayerStateChanged:(ZI)V:GetOnPlayerStateChanged_ZIHandler:Com.Google.Android.Exoplayer2.IPlayerEventListener, ExoPlayer.Core\n" +
			"n_onPositionDiscontinuity:(I)V:GetOnPositionDiscontinuity_IHandler:Com.Google.Android.Exoplayer2.IPlayerEventListener, ExoPlayer.Core\n" +
			"n_onRepeatModeChanged:(I)V:GetOnRepeatModeChanged_IHandler:Com.Google.Android.Exoplayer2.IPlayerEventListener, ExoPlayer.Core\n" +
			"n_onSeekProcessed:()V:GetOnSeekProcessedHandler:Com.Google.Android.Exoplayer2.IPlayerEventListener, ExoPlayer.Core\n" +
			"n_onShuffleModeEnabledChanged:(Z)V:GetOnShuffleModeEnabledChanged_ZHandler:Com.Google.Android.Exoplayer2.IPlayerEventListener, ExoPlayer.Core\n" +
			"n_onTimelineChanged:(Lcom/google/android/exoplayer2/Timeline;I)V:GetOnTimelineChanged_Lcom_google_android_exoplayer2_Timeline_IHandler:Com.Google.Android.Exoplayer2.IPlayerEventListener, ExoPlayer.Core\n" +
			"n_onTracksChanged:(Lcom/google/android/exoplayer2/source/TrackGroupArray;Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;)V:GetOnTracksChanged_Lcom_google_android_exoplayer2_source_TrackGroupArray_Lcom_google_android_exoplayer2_trackselection_TrackSelectionArray_Handler:Com.Google.Android.Exoplayer2.IPlayerEventListener, ExoPlayer.Core\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.NativePost.Pages.VideoFullScreenActivity, WoWonder", VideoFullScreenActivity.class, __md_methods);
	}


	public VideoFullScreenActivity ()
	{
		super ();
		if (getClass () == VideoFullScreenActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Pages.VideoFullScreenActivity, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public VideoFullScreenActivity (int p0)
	{
		super (p0);
		if (getClass () == VideoFullScreenActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.NativePost.Pages.VideoFullScreenActivity, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);


	public void onTrimMemory (int p0)
	{
		n_onTrimMemory (p0);
	}

	private native void n_onTrimMemory (int p0);


	public void onLowMemory ()
	{
		n_onLowMemory ();
	}

	private native void n_onLowMemory ();


	public void onBackPressed ()
	{
		n_onBackPressed ();
	}

	private native void n_onBackPressed ();


	public void onPause ()
	{
		n_onPause ();
	}

	private native void n_onPause ();


	public void onRestart ()
	{
		n_onRestart ();
	}

	private native void n_onRestart ();


	public void onIsPlayingChanged (boolean p0)
	{
		n_onIsPlayingChanged (p0);
	}

	private native void n_onIsPlayingChanged (boolean p0);


	public void onLoadingChanged (boolean p0)
	{
		n_onLoadingChanged (p0);
	}

	private native void n_onLoadingChanged (boolean p0);


	public void onPlaybackParametersChanged (com.google.android.exoplayer2.PlaybackParameters p0)
	{
		n_onPlaybackParametersChanged (p0);
	}

	private native void n_onPlaybackParametersChanged (com.google.android.exoplayer2.PlaybackParameters p0);


	public void onPlaybackSuppressionReasonChanged (int p0)
	{
		n_onPlaybackSuppressionReasonChanged (p0);
	}

	private native void n_onPlaybackSuppressionReasonChanged (int p0);


	public void onPlayerError (com.google.android.exoplayer2.ExoPlaybackException p0)
	{
		n_onPlayerError (p0);
	}

	private native void n_onPlayerError (com.google.android.exoplayer2.ExoPlaybackException p0);


	public void onPlayerStateChanged (boolean p0, int p1)
	{
		n_onPlayerStateChanged (p0, p1);
	}

	private native void n_onPlayerStateChanged (boolean p0, int p1);


	public void onPositionDiscontinuity (int p0)
	{
		n_onPositionDiscontinuity (p0);
	}

	private native void n_onPositionDiscontinuity (int p0);


	public void onRepeatModeChanged (int p0)
	{
		n_onRepeatModeChanged (p0);
	}

	private native void n_onRepeatModeChanged (int p0);


	public void onSeekProcessed ()
	{
		n_onSeekProcessed ();
	}

	private native void n_onSeekProcessed ();


	public void onShuffleModeEnabledChanged (boolean p0)
	{
		n_onShuffleModeEnabledChanged (p0);
	}

	private native void n_onShuffleModeEnabledChanged (boolean p0);


	public void onTimelineChanged (com.google.android.exoplayer2.Timeline p0, int p1)
	{
		n_onTimelineChanged (p0, p1);
	}

	private native void n_onTimelineChanged (com.google.android.exoplayer2.Timeline p0, int p1);


	public void onTracksChanged (com.google.android.exoplayer2.source.TrackGroupArray p0, com.google.android.exoplayer2.trackselection.TrackSelectionArray p1)
	{
		n_onTracksChanged (p0, p1);
	}

	private native void n_onTracksChanged (com.google.android.exoplayer2.source.TrackGroupArray p0, com.google.android.exoplayer2.trackselection.TrackSelectionArray p1);

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
