package mono.com.twilio.video;


public class RemoteParticipant_ListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.twilio.video.RemoteParticipant.Listener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onAudioTrackDisabled:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteAudioTrackPublication;)V:GetOnAudioTrackDisabled_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteAudioTrackPublication_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onAudioTrackEnabled:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteAudioTrackPublication;)V:GetOnAudioTrackEnabled_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteAudioTrackPublication_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onAudioTrackPublished:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteAudioTrackPublication;)V:GetOnAudioTrackPublished_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteAudioTrackPublication_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onAudioTrackSubscribed:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteAudioTrackPublication;Lcom/twilio/video/RemoteAudioTrack;)V:GetOnAudioTrackSubscribed_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteAudioTrackPublication_Lcom_twilio_video_RemoteAudioTrack_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onAudioTrackSubscriptionFailed:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteAudioTrackPublication;Lcom/twilio/video/TwilioException;)V:GetOnAudioTrackSubscriptionFailed_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteAudioTrackPublication_Lcom_twilio_video_TwilioException_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onAudioTrackUnpublished:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteAudioTrackPublication;)V:GetOnAudioTrackUnpublished_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteAudioTrackPublication_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onAudioTrackUnsubscribed:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteAudioTrackPublication;Lcom/twilio/video/RemoteAudioTrack;)V:GetOnAudioTrackUnsubscribed_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteAudioTrackPublication_Lcom_twilio_video_RemoteAudioTrack_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onDataTrackPublished:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteDataTrackPublication;)V:GetOnDataTrackPublished_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteDataTrackPublication_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onDataTrackSubscribed:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteDataTrackPublication;Lcom/twilio/video/RemoteDataTrack;)V:GetOnDataTrackSubscribed_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteDataTrackPublication_Lcom_twilio_video_RemoteDataTrack_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onDataTrackSubscriptionFailed:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteDataTrackPublication;Lcom/twilio/video/TwilioException;)V:GetOnDataTrackSubscriptionFailed_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteDataTrackPublication_Lcom_twilio_video_TwilioException_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onDataTrackUnpublished:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteDataTrackPublication;)V:GetOnDataTrackUnpublished_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteDataTrackPublication_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onDataTrackUnsubscribed:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteDataTrackPublication;Lcom/twilio/video/RemoteDataTrack;)V:GetOnDataTrackUnsubscribed_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteDataTrackPublication_Lcom_twilio_video_RemoteDataTrack_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onNetworkQualityLevelChanged:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/NetworkQualityLevel;)V:GetOnNetworkQualityLevelChanged_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_NetworkQualityLevel_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onVideoTrackDisabled:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteVideoTrackPublication;)V:GetOnVideoTrackDisabled_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteVideoTrackPublication_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onVideoTrackEnabled:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteVideoTrackPublication;)V:GetOnVideoTrackEnabled_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteVideoTrackPublication_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onVideoTrackPublished:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteVideoTrackPublication;)V:GetOnVideoTrackPublished_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteVideoTrackPublication_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onVideoTrackSubscribed:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteVideoTrackPublication;Lcom/twilio/video/RemoteVideoTrack;)V:GetOnVideoTrackSubscribed_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteVideoTrackPublication_Lcom_twilio_video_RemoteVideoTrack_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onVideoTrackSubscriptionFailed:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteVideoTrackPublication;Lcom/twilio/video/TwilioException;)V:GetOnVideoTrackSubscriptionFailed_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteVideoTrackPublication_Lcom_twilio_video_TwilioException_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onVideoTrackUnpublished:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteVideoTrackPublication;)V:GetOnVideoTrackUnpublished_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteVideoTrackPublication_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onVideoTrackUnsubscribed:(Lcom/twilio/video/RemoteParticipant;Lcom/twilio/video/RemoteVideoTrackPublication;Lcom/twilio/video/RemoteVideoTrack;)V:GetOnVideoTrackUnsubscribed_Lcom_twilio_video_RemoteParticipant_Lcom_twilio_video_RemoteVideoTrackPublication_Lcom_twilio_video_RemoteVideoTrack_Handler:TwilioVideo.RemoteParticipant/IListenerInvoker, Twilio.Video.Android\n" +
			"";
		mono.android.Runtime.register ("TwilioVideo.RemoteParticipant+IListenerImplementor, Twilio.Video.Android", RemoteParticipant_ListenerImplementor.class, __md_methods);
	}


	public RemoteParticipant_ListenerImplementor ()
	{
		super ();
		if (getClass () == RemoteParticipant_ListenerImplementor.class)
			mono.android.TypeManager.Activate ("TwilioVideo.RemoteParticipant+IListenerImplementor, Twilio.Video.Android", "", this, new java.lang.Object[] {  });
	}


	public void onAudioTrackDisabled (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1)
	{
		n_onAudioTrackDisabled (p0, p1);
	}

	private native void n_onAudioTrackDisabled (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1);


	public void onAudioTrackEnabled (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1)
	{
		n_onAudioTrackEnabled (p0, p1);
	}

	private native void n_onAudioTrackEnabled (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1);


	public void onAudioTrackPublished (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1)
	{
		n_onAudioTrackPublished (p0, p1);
	}

	private native void n_onAudioTrackPublished (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1);


	public void onAudioTrackSubscribed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1, com.twilio.video.RemoteAudioTrack p2)
	{
		n_onAudioTrackSubscribed (p0, p1, p2);
	}

	private native void n_onAudioTrackSubscribed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1, com.twilio.video.RemoteAudioTrack p2);


	public void onAudioTrackSubscriptionFailed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1, com.twilio.video.TwilioException p2)
	{
		n_onAudioTrackSubscriptionFailed (p0, p1, p2);
	}

	private native void n_onAudioTrackSubscriptionFailed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1, com.twilio.video.TwilioException p2);


	public void onAudioTrackUnpublished (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1)
	{
		n_onAudioTrackUnpublished (p0, p1);
	}

	private native void n_onAudioTrackUnpublished (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1);


	public void onAudioTrackUnsubscribed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1, com.twilio.video.RemoteAudioTrack p2)
	{
		n_onAudioTrackUnsubscribed (p0, p1, p2);
	}

	private native void n_onAudioTrackUnsubscribed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteAudioTrackPublication p1, com.twilio.video.RemoteAudioTrack p2);


	public void onDataTrackPublished (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteDataTrackPublication p1)
	{
		n_onDataTrackPublished (p0, p1);
	}

	private native void n_onDataTrackPublished (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteDataTrackPublication p1);


	public void onDataTrackSubscribed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteDataTrackPublication p1, com.twilio.video.RemoteDataTrack p2)
	{
		n_onDataTrackSubscribed (p0, p1, p2);
	}

	private native void n_onDataTrackSubscribed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteDataTrackPublication p1, com.twilio.video.RemoteDataTrack p2);


	public void onDataTrackSubscriptionFailed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteDataTrackPublication p1, com.twilio.video.TwilioException p2)
	{
		n_onDataTrackSubscriptionFailed (p0, p1, p2);
	}

	private native void n_onDataTrackSubscriptionFailed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteDataTrackPublication p1, com.twilio.video.TwilioException p2);


	public void onDataTrackUnpublished (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteDataTrackPublication p1)
	{
		n_onDataTrackUnpublished (p0, p1);
	}

	private native void n_onDataTrackUnpublished (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteDataTrackPublication p1);


	public void onDataTrackUnsubscribed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteDataTrackPublication p1, com.twilio.video.RemoteDataTrack p2)
	{
		n_onDataTrackUnsubscribed (p0, p1, p2);
	}

	private native void n_onDataTrackUnsubscribed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteDataTrackPublication p1, com.twilio.video.RemoteDataTrack p2);


	public void onNetworkQualityLevelChanged (com.twilio.video.RemoteParticipant p0, com.twilio.video.NetworkQualityLevel p1)
	{
		n_onNetworkQualityLevelChanged (p0, p1);
	}

	private native void n_onNetworkQualityLevelChanged (com.twilio.video.RemoteParticipant p0, com.twilio.video.NetworkQualityLevel p1);


	public void onVideoTrackDisabled (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1)
	{
		n_onVideoTrackDisabled (p0, p1);
	}

	private native void n_onVideoTrackDisabled (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1);


	public void onVideoTrackEnabled (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1)
	{
		n_onVideoTrackEnabled (p0, p1);
	}

	private native void n_onVideoTrackEnabled (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1);


	public void onVideoTrackPublished (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1)
	{
		n_onVideoTrackPublished (p0, p1);
	}

	private native void n_onVideoTrackPublished (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1);


	public void onVideoTrackSubscribed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1, com.twilio.video.RemoteVideoTrack p2)
	{
		n_onVideoTrackSubscribed (p0, p1, p2);
	}

	private native void n_onVideoTrackSubscribed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1, com.twilio.video.RemoteVideoTrack p2);


	public void onVideoTrackSubscriptionFailed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1, com.twilio.video.TwilioException p2)
	{
		n_onVideoTrackSubscriptionFailed (p0, p1, p2);
	}

	private native void n_onVideoTrackSubscriptionFailed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1, com.twilio.video.TwilioException p2);


	public void onVideoTrackUnpublished (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1)
	{
		n_onVideoTrackUnpublished (p0, p1);
	}

	private native void n_onVideoTrackUnpublished (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1);


	public void onVideoTrackUnsubscribed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1, com.twilio.video.RemoteVideoTrack p2)
	{
		n_onVideoTrackUnsubscribed (p0, p1, p2);
	}

	private native void n_onVideoTrackUnsubscribed (com.twilio.video.RemoteParticipant p0, com.twilio.video.RemoteVideoTrackPublication p1, com.twilio.video.RemoteVideoTrack p2);

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
