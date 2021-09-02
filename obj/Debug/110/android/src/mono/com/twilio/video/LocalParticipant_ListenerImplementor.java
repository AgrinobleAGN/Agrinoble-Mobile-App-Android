package mono.com.twilio.video;


public class LocalParticipant_ListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.twilio.video.LocalParticipant.Listener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onAudioTrackPublicationFailed:(Lcom/twilio/video/LocalParticipant;Lcom/twilio/video/LocalAudioTrack;Lcom/twilio/video/TwilioException;)V:GetOnAudioTrackPublicationFailed_Lcom_twilio_video_LocalParticipant_Lcom_twilio_video_LocalAudioTrack_Lcom_twilio_video_TwilioException_Handler:TwilioVideo.LocalParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onAudioTrackPublished:(Lcom/twilio/video/LocalParticipant;Lcom/twilio/video/LocalAudioTrackPublication;)V:GetOnAudioTrackPublished_Lcom_twilio_video_LocalParticipant_Lcom_twilio_video_LocalAudioTrackPublication_Handler:TwilioVideo.LocalParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onDataTrackPublicationFailed:(Lcom/twilio/video/LocalParticipant;Lcom/twilio/video/LocalDataTrack;Lcom/twilio/video/TwilioException;)V:GetOnDataTrackPublicationFailed_Lcom_twilio_video_LocalParticipant_Lcom_twilio_video_LocalDataTrack_Lcom_twilio_video_TwilioException_Handler:TwilioVideo.LocalParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onDataTrackPublished:(Lcom/twilio/video/LocalParticipant;Lcom/twilio/video/LocalDataTrackPublication;)V:GetOnDataTrackPublished_Lcom_twilio_video_LocalParticipant_Lcom_twilio_video_LocalDataTrackPublication_Handler:TwilioVideo.LocalParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onNetworkQualityLevelChanged:(Lcom/twilio/video/LocalParticipant;Lcom/twilio/video/NetworkQualityLevel;)V:GetOnNetworkQualityLevelChanged_Lcom_twilio_video_LocalParticipant_Lcom_twilio_video_NetworkQualityLevel_Handler:TwilioVideo.LocalParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onVideoTrackPublicationFailed:(Lcom/twilio/video/LocalParticipant;Lcom/twilio/video/LocalVideoTrack;Lcom/twilio/video/TwilioException;)V:GetOnVideoTrackPublicationFailed_Lcom_twilio_video_LocalParticipant_Lcom_twilio_video_LocalVideoTrack_Lcom_twilio_video_TwilioException_Handler:TwilioVideo.LocalParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onVideoTrackPublished:(Lcom/twilio/video/LocalParticipant;Lcom/twilio/video/LocalVideoTrackPublication;)V:GetOnVideoTrackPublished_Lcom_twilio_video_LocalParticipant_Lcom_twilio_video_LocalVideoTrackPublication_Handler:TwilioVideo.LocalParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"";
		mono.android.Runtime.register ("TwilioVideo.LocalParticipant+IListenerImplementor, Twilio.Video.Android", LocalParticipant_ListenerImplementor.class, __md_methods);
	}


	public LocalParticipant_ListenerImplementor ()
	{
		super ();
		if (getClass () == LocalParticipant_ListenerImplementor.class)
			mono.android.TypeManager.Activate ("TwilioVideo.LocalParticipant+IListenerImplementor, Twilio.Video.Android", "", this, new java.lang.Object[] {  });
	}


	public void onAudioTrackPublicationFailed (com.twilio.video.LocalParticipant p0, com.twilio.video.LocalAudioTrack p1, com.twilio.video.TwilioException p2)
	{
		n_onAudioTrackPublicationFailed (p0, p1, p2);
	}

	private native void n_onAudioTrackPublicationFailed (com.twilio.video.LocalParticipant p0, com.twilio.video.LocalAudioTrack p1, com.twilio.video.TwilioException p2);


	public void onAudioTrackPublished (com.twilio.video.LocalParticipant p0, com.twilio.video.LocalAudioTrackPublication p1)
	{
		n_onAudioTrackPublished (p0, p1);
	}

	private native void n_onAudioTrackPublished (com.twilio.video.LocalParticipant p0, com.twilio.video.LocalAudioTrackPublication p1);


	public void onDataTrackPublicationFailed (com.twilio.video.LocalParticipant p0, com.twilio.video.LocalDataTrack p1, com.twilio.video.TwilioException p2)
	{
		n_onDataTrackPublicationFailed (p0, p1, p2);
	}

	private native void n_onDataTrackPublicationFailed (com.twilio.video.LocalParticipant p0, com.twilio.video.LocalDataTrack p1, com.twilio.video.TwilioException p2);


	public void onDataTrackPublished (com.twilio.video.LocalParticipant p0, com.twilio.video.LocalDataTrackPublication p1)
	{
		n_onDataTrackPublished (p0, p1);
	}

	private native void n_onDataTrackPublished (com.twilio.video.LocalParticipant p0, com.twilio.video.LocalDataTrackPublication p1);


	public void onNetworkQualityLevelChanged (com.twilio.video.LocalParticipant p0, com.twilio.video.NetworkQualityLevel p1)
	{
		n_onNetworkQualityLevelChanged (p0, p1);
	}

	private native void n_onNetworkQualityLevelChanged (com.twilio.video.LocalParticipant p0, com.twilio.video.NetworkQualityLevel p1);


	public void onVideoTrackPublicationFailed (com.twilio.video.LocalParticipant p0, com.twilio.video.LocalVideoTrack p1, com.twilio.video.TwilioException p2)
	{
		n_onVideoTrackPublicationFailed (p0, p1, p2);
	}

	private native void n_onVideoTrackPublicationFailed (com.twilio.video.LocalParticipant p0, com.twilio.video.LocalVideoTrack p1, com.twilio.video.TwilioException p2);


	public void onVideoTrackPublished (com.twilio.video.LocalParticipant p0, com.twilio.video.LocalVideoTrackPublication p1)
	{
		n_onVideoTrackPublished (p0, p1);
	}

	private native void n_onVideoTrackPublished (com.twilio.video.LocalParticipant p0, com.twilio.video.LocalVideoTrackPublication p1);

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
