package crc64fe00f35973cd1075;


public class AgoraRtcAudioCallHandler
	extends io.agora.rtc.IRtcEngineEventHandler
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onConnectionLost:()V:GetOnConnectionLostHandler\n" +
			"n_onUserOffline:(II)V:GetOnUserOffline_IIHandler\n" +
			"n_onNetworkQuality:(III)V:GetOnNetworkQuality_IIIHandler\n" +
			"n_onUserJoined:(II)V:GetOnUserJoined_IIHandler\n" +
			"n_onJoinChannelSuccess:(Ljava/lang/String;II)V:GetOnJoinChannelSuccess_Ljava_lang_String_IIHandler\n" +
			"n_onUserMuteAudio:(IZ)V:GetOnUserMuteAudio_IZHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.Call.Agora.AgoraRtcAudioCallHandler, WoWonder", AgoraRtcAudioCallHandler.class, __md_methods);
	}


	public AgoraRtcAudioCallHandler ()
	{
		super ();
		if (getClass () == AgoraRtcAudioCallHandler.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Call.Agora.AgoraRtcAudioCallHandler, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AgoraRtcAudioCallHandler (crc64fe00f35973cd1075.AgoraAudioCallActivity p0)
	{
		super ();
		if (getClass () == AgoraRtcAudioCallHandler.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Call.Agora.AgoraRtcAudioCallHandler, WoWonder", "WoWonder.Activities.Chat.Call.Agora.AgoraAudioCallActivity, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void onConnectionLost ()
	{
		n_onConnectionLost ();
	}

	private native void n_onConnectionLost ();


	public void onUserOffline (int p0, int p1)
	{
		n_onUserOffline (p0, p1);
	}

	private native void n_onUserOffline (int p0, int p1);


	public void onNetworkQuality (int p0, int p1, int p2)
	{
		n_onNetworkQuality (p0, p1, p2);
	}

	private native void n_onNetworkQuality (int p0, int p1, int p2);


	public void onUserJoined (int p0, int p1)
	{
		n_onUserJoined (p0, p1);
	}

	private native void n_onUserJoined (int p0, int p1);


	public void onJoinChannelSuccess (java.lang.String p0, int p1, int p2)
	{
		n_onJoinChannelSuccess (p0, p1, p2);
	}

	private native void n_onJoinChannelSuccess (java.lang.String p0, int p1, int p2);


	public void onUserMuteAudio (int p0, boolean p1)
	{
		n_onUserMuteAudio (p0, p1);
	}

	private native void n_onUserMuteAudio (int p0, boolean p1);

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
