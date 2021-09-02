package crc64ab11c816561f839c;


public class PlayerEvents
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.google.android.exoplayer2.Player.EventListener,
		com.google.android.exoplayer2.ui.PlayerControlView.VisibilityListener,
		com.google.android.exoplayer2.ui.PlayerControlView.ProgressUpdateListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
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
			"n_onVisibilityChange:(I)V:GetOnVisibilityChange_IHandler:Com.Google.Android.Exoplayer2.UI.PlayerControlView/IVisibilityListenerInvoker, ExoPlayer.UI\n" +
			"n_onProgressUpdate:(JJ)V:GetOnProgressUpdate_JJHandler:Com.Google.Android.Exoplayer2.UI.PlayerControlView/IProgressUpdateListenerInvoker, ExoPlayer.UI\n" +
			"";
		mono.android.Runtime.register ("WoWonder.MediaPlayers.PlayerEvents, WoWonder", PlayerEvents.class, __md_methods);
	}


	public PlayerEvents ()
	{
		super ();
		if (getClass () == PlayerEvents.class)
			mono.android.TypeManager.Activate ("WoWonder.MediaPlayers.PlayerEvents, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public PlayerEvents (android.app.Activity p0, com.google.android.exoplayer2.ui.PlayerControlView p1)
	{
		super ();
		if (getClass () == PlayerEvents.class)
			mono.android.TypeManager.Activate ("WoWonder.MediaPlayers.PlayerEvents, WoWonder", "Android.App.Activity, Mono.Android:Com.Google.Android.Exoplayer2.UI.PlayerControlView, ExoPlayer.UI", this, new java.lang.Object[] { p0, p1 });
	}


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


	public void onVisibilityChange (int p0)
	{
		n_onVisibilityChange (p0);
	}

	private native void n_onVisibilityChange (int p0);


	public void onProgressUpdate (long p0, long p1)
	{
		n_onProgressUpdate (p0, p1);
	}

	private native void n_onProgressUpdate (long p0, long p1);

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
