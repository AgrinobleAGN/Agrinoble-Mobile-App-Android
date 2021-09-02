package crc64fe00f35973cd1075;


public class AgoraRtcHandler
	extends io.agora.rtc.IRtcEngineEventHandler
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onFirstRemoteVideoDecoded:(IIII)V:GetOnFirstRemoteVideoDecoded_IIIIHandler\n" +
			"n_onConnectionLost:()V:GetOnConnectionLostHandler\n" +
			"n_onUserOffline:(II)V:GetOnUserOffline_IIHandler\n" +
			"n_onUserMuteVideo:(IZ)V:GetOnUserMuteVideo_IZHandler\n" +
			"n_onFirstLocalVideoFrame:(III)V:GetOnFirstLocalVideoFrame_IIIHandler\n" +
			"n_onNetworkQuality:(III)V:GetOnNetworkQuality_IIIHandler\n" +
			"n_onUserJoined:(II)V:GetOnUserJoined_IIHandler\n" +
			"n_onJoinChannelSuccess:(Ljava/lang/String;II)V:GetOnJoinChannelSuccess_Ljava_lang_String_IIHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.Call.Agora.AgoraRtcHandler, WoWonder", AgoraRtcHandler.class, __md_methods);
	}


	public AgoraRtcHandler ()
	{
		super ();
		if (getClass () == AgoraRtcHandler.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Call.Agora.AgoraRtcHandler, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public AgoraRtcHandler (crc64fe00f35973cd1075.AgoraVideoCallActivity p0)
	{
		super ();
		if (getClass () == AgoraRtcHandler.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Call.Agora.AgoraRtcHandler, WoWonder", "WoWonder.Activities.Chat.Call.Agora.AgoraVideoCallActivity, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void onFirstRemoteVideoDecoded (int p0, int p1, int p2, int p3)
	{
		n_onFirstRemoteVideoDecoded (p0, p1, p2, p3);
	}

	private native void n_onFirstRemoteVideoDecoded (int p0, int p1, int p2, int p3);


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


	public void onUserMuteVideo (int p0, boolean p1)
	{
		n_onUserMuteVideo (p0, p1);
	}

	private native void n_onUserMuteVideo (int p0, boolean p1);


	public void onFirstLocalVideoFrame (int p0, int p1, int p2)
	{
		n_onFirstLocalVideoFrame (p0, p1, p2);
	}

	private native void n_onFirstLocalVideoFrame (int p0, int p1, int p2);


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
