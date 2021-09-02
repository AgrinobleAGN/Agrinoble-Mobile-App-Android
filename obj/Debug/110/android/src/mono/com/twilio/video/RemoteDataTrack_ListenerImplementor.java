package mono.com.twilio.video;


public class RemoteDataTrack_ListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.twilio.video.RemoteDataTrack.Listener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onMessage:(Lcom/twilio/video/RemoteDataTrack;Ljava/lang/String;)V:GetOnMessage1_Lcom_twilio_video_RemoteDataTrack_Ljava_lang_String_Handler:TwilioVideo.RemoteDataTrack/IListenerInvoker, Twilio.Video.Android\n" +
			"n_onMessage:(Lcom/twilio/video/RemoteDataTrack;Ljava/nio/ByteBuffer;)V:GetOnMessage2_Lcom_twilio_video_RemoteDataTrack_Ljava_nio_ByteBuffer_Handler:TwilioVideo.RemoteDataTrack/IListenerInvoker, Twilio.Video.Android\n" +
			"";
		mono.android.Runtime.register ("TwilioVideo.RemoteDataTrack+IListenerImplementor, Twilio.Video.Android", RemoteDataTrack_ListenerImplementor.class, __md_methods);
	}


	public RemoteDataTrack_ListenerImplementor ()
	{
		super ();
		if (getClass () == RemoteDataTrack_ListenerImplementor.class)
			mono.android.TypeManager.Activate ("TwilioVideo.RemoteDataTrack+IListenerImplementor, Twilio.Video.Android", "", this, new java.lang.Object[] {  });
	}


	public void onMessage (com.twilio.video.RemoteDataTrack p0, java.lang.String p1)
	{
		n_onMessage (p0, p1);
	}

	private native void n_onMessage (com.twilio.video.RemoteDataTrack p0, java.lang.String p1);


	public void onMessage (com.twilio.video.RemoteDataTrack p0, java.nio.ByteBuffer p1)
	{
		n_onMessage (p0, p1);
	}

	private native void n_onMessage (com.twilio.video.RemoteDataTrack p0, java.nio.ByteBuffer p1);

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
