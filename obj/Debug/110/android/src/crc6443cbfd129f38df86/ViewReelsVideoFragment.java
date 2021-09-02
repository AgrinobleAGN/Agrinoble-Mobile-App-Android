package crc6443cbfd129f38df86;


public class ViewReelsVideoFragment
	extends androidx.fragment.app.Fragment
	implements
		mono.android.IGCUserPeer,
		com.google.android.youtube.player.YouTubePlayer.OnInitializedListener,
		com.google.android.exoplayer2.Player.EventListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"n_onCreateView:(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;:GetOnCreateView_Landroid_view_LayoutInflater_Landroid_view_ViewGroup_Landroid_os_Bundle_Handler\n" +
			"n_onViewCreated:(Landroid/view/View;Landroid/os/Bundle;)V:GetOnViewCreated_Landroid_view_View_Landroid_os_Bundle_Handler\n" +
			"n_setMenuVisibility:(Z)V:GetSetMenuVisibility_ZHandler\n" +
			"n_onResume:()V:GetOnResumeHandler\n" +
			"n_onPause:()V:GetOnPauseHandler\n" +
			"n_onStop:()V:GetOnStopHandler\n" +
			"n_onLowMemory:()V:GetOnLowMemoryHandler\n" +
			"n_onDestroyView:()V:GetOnDestroyViewHandler\n" +
			"n_onDestroy:()V:GetOnDestroyHandler\n" +
			"n_onInitializationFailure:(Lcom/google/android/youtube/player/YouTubePlayer$Provider;Lcom/google/android/youtube/player/YouTubeInitializationResult;)V:GetOnInitializationFailure_Lcom_google_android_youtube_player_YouTubePlayer_Provider_Lcom_google_android_youtube_player_YouTubeInitializationResult_Handler:Com.Google.Android.Youtube.Player.IYouTubePlayerOnInitializedListenerInvoker, Naxam.YoutubePlayerApi.Droid\n" +
			"n_onInitializationSuccess:(Lcom/google/android/youtube/player/YouTubePlayer$Provider;Lcom/google/android/youtube/player/YouTubePlayer;Z)V:GetOnInitializationSuccess_Lcom_google_android_youtube_player_YouTubePlayer_Provider_Lcom_google_android_youtube_player_YouTubePlayer_ZHandler:Com.Google.Android.Youtube.Player.IYouTubePlayerOnInitializedListenerInvoker, Naxam.YoutubePlayerApi.Droid\n" +
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
		mono.android.Runtime.register ("WoWonder.Activities.ReelsVideo.ViewReelsVideoFragment, WoWonder", ViewReelsVideoFragment.class, __md_methods);
	}


	public ViewReelsVideoFragment ()
	{
		super ();
		if (getClass () == ViewReelsVideoFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.ReelsVideo.ViewReelsVideoFragment, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public ViewReelsVideoFragment (int p0)
	{
		super (p0);
		if (getClass () == ViewReelsVideoFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.ReelsVideo.ViewReelsVideoFragment, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);


	public android.view.View onCreateView (android.view.LayoutInflater p0, android.view.ViewGroup p1, android.os.Bundle p2)
	{
		return n_onCreateView (p0, p1, p2);
	}

	private native android.view.View n_onCreateView (android.view.LayoutInflater p0, android.view.ViewGroup p1, android.os.Bundle p2);


	public void onViewCreated (android.view.View p0, android.os.Bundle p1)
	{
		n_onViewCreated (p0, p1);
	}

	private native void n_onViewCreated (android.view.View p0, android.os.Bundle p1);


	public void setMenuVisibility (boolean p0)
	{
		n_setMenuVisibility (p0);
	}

	private native void n_setMenuVisibility (boolean p0);


	public void onResume ()
	{
		n_onResume ();
	}

	private native void n_onResume ();


	public void onPause ()
	{
		n_onPause ();
	}

	private native void n_onPause ();


	public void onStop ()
	{
		n_onStop ();
	}

	private native void n_onStop ();


	public void onLowMemory ()
	{
		n_onLowMemory ();
	}

	private native void n_onLowMemory ();


	public void onDestroyView ()
	{
		n_onDestroyView ();
	}

	private native void n_onDestroyView ();


	public void onDestroy ()
	{
		n_onDestroy ();
	}

	private native void n_onDestroy ();


	public void onInitializationFailure (com.google.android.youtube.player.YouTubePlayer.Provider p0, com.google.android.youtube.player.YouTubeInitializationResult p1)
	{
		n_onInitializationFailure (p0, p1);
	}

	private native void n_onInitializationFailure (com.google.android.youtube.player.YouTubePlayer.Provider p0, com.google.android.youtube.player.YouTubeInitializationResult p1);


	public void onInitializationSuccess (com.google.android.youtube.player.YouTubePlayer.Provider p0, com.google.android.youtube.player.YouTubePlayer p1, boolean p2)
	{
		n_onInitializationSuccess (p0, p1, p2);
	}

	private native void n_onInitializationSuccess (com.google.android.youtube.player.YouTubePlayer.Provider p0, com.google.android.youtube.player.YouTubePlayer p1, boolean p2);


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
