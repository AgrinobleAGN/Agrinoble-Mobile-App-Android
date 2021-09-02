package crc64935c0925864bb664;


public class AgoraEventHandler
	extends io.agora.rtc.IRtcEngineEventHandler
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onJoinChannelSuccess:(Ljava/lang/String;II)V:GetOnJoinChannelSuccess_Ljava_lang_String_IIHandler\n" +
			"n_onLeaveChannel:(Lio/agora/rtc/IRtcEngineEventHandler$RtcStats;)V:GetOnLeaveChannel_Lio_agora_rtc_IRtcEngineEventHandler_RtcStats_Handler\n" +
			"n_onFirstRemoteVideoDecoded:(IIII)V:GetOnFirstRemoteVideoDecoded_IIIIHandler\n" +
			"n_onUserJoined:(II)V:GetOnUserJoined_IIHandler\n" +
			"n_onUserOffline:(II)V:GetOnUserOffline_IIHandler\n" +
			"n_onLocalVideoStats:(Lio/agora/rtc/IRtcEngineEventHandler$LocalVideoStats;)V:GetOnLocalVideoStats_Lio_agora_rtc_IRtcEngineEventHandler_LocalVideoStats_Handler\n" +
			"n_onRtcStats:(Lio/agora/rtc/IRtcEngineEventHandler$RtcStats;)V:GetOnRtcStats_Lio_agora_rtc_IRtcEngineEventHandler_RtcStats_Handler\n" +
			"n_onNetworkQuality:(III)V:GetOnNetworkQuality_IIIHandler\n" +
			"n_onRemoteVideoStats:(Lio/agora/rtc/IRtcEngineEventHandler$RemoteVideoStats;)V:GetOnRemoteVideoStats_Lio_agora_rtc_IRtcEngineEventHandler_RemoteVideoStats_Handler\n" +
			"n_onRemoteAudioStats:(Lio/agora/rtc/IRtcEngineEventHandler$RemoteAudioStats;)V:GetOnRemoteAudioStats_Lio_agora_rtc_IRtcEngineEventHandler_RemoteAudioStats_Handler\n" +
			"n_onLastmileQuality:(I)V:GetOnLastmileQuality_IHandler\n" +
			"n_onLastmileProbeResult:(Lio/agora/rtc/IRtcEngineEventHandler$LastmileProbeResult;)V:GetOnLastmileProbeResult_Lio_agora_rtc_IRtcEngineEventHandler_LastmileProbeResult_Handler\n" +
			"n_onFirstLocalVideoFrame:(III)V:GetOnFirstLocalVideoFrame_IIIHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Live.Rtc.AgoraEventHandler, WoWonder", AgoraEventHandler.class, __md_methods);
	}


	public AgoraEventHandler ()
	{
		super ();
		if (getClass () == AgoraEventHandler.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Live.Rtc.AgoraEventHandler, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void onJoinChannelSuccess (java.lang.String p0, int p1, int p2)
	{
		n_onJoinChannelSuccess (p0, p1, p2);
	}

	private native void n_onJoinChannelSuccess (java.lang.String p0, int p1, int p2);


	public void onLeaveChannel (io.agora.rtc.IRtcEngineEventHandler.RtcStats p0)
	{
		n_onLeaveChannel (p0);
	}

	private native void n_onLeaveChannel (io.agora.rtc.IRtcEngineEventHandler.RtcStats p0);


	public void onFirstRemoteVideoDecoded (int p0, int p1, int p2, int p3)
	{
		n_onFirstRemoteVideoDecoded (p0, p1, p2, p3);
	}

	private native void n_onFirstRemoteVideoDecoded (int p0, int p1, int p2, int p3);


	public void onUserJoined (int p0, int p1)
	{
		n_onUserJoined (p0, p1);
	}

	private native void n_onUserJoined (int p0, int p1);


	public void onUserOffline (int p0, int p1)
	{
		n_onUserOffline (p0, p1);
	}

	private native void n_onUserOffline (int p0, int p1);


	public void onLocalVideoStats (io.agora.rtc.IRtcEngineEventHandler.LocalVideoStats p0)
	{
		n_onLocalVideoStats (p0);
	}

	private native void n_onLocalVideoStats (io.agora.rtc.IRtcEngineEventHandler.LocalVideoStats p0);


	public void onRtcStats (io.agora.rtc.IRtcEngineEventHandler.RtcStats p0)
	{
		n_onRtcStats (p0);
	}

	private native void n_onRtcStats (io.agora.rtc.IRtcEngineEventHandler.RtcStats p0);


	public void onNetworkQuality (int p0, int p1, int p2)
	{
		n_onNetworkQuality (p0, p1, p2);
	}

	private native void n_onNetworkQuality (int p0, int p1, int p2);


	public void onRemoteVideoStats (io.agora.rtc.IRtcEngineEventHandler.RemoteVideoStats p0)
	{
		n_onRemoteVideoStats (p0);
	}

	private native void n_onRemoteVideoStats (io.agora.rtc.IRtcEngineEventHandler.RemoteVideoStats p0);


	public void onRemoteAudioStats (io.agora.rtc.IRtcEngineEventHandler.RemoteAudioStats p0)
	{
		n_onRemoteAudioStats (p0);
	}

	private native void n_onRemoteAudioStats (io.agora.rtc.IRtcEngineEventHandler.RemoteAudioStats p0);


	public void onLastmileQuality (int p0)
	{
		n_onLastmileQuality (p0);
	}

	private native void n_onLastmileQuality (int p0);


	public void onLastmileProbeResult (io.agora.rtc.IRtcEngineEventHandler.LastmileProbeResult p0)
	{
		n_onLastmileProbeResult (p0);
	}

	private native void n_onLastmileProbeResult (io.agora.rtc.IRtcEngineEventHandler.LastmileProbeResult p0);


	public void onFirstLocalVideoFrame (int p0, int p1, int p2)
	{
		n_onFirstLocalVideoFrame (p0, p1, p2);
	}

	private native void n_onFirstLocalVideoFrame (int p0, int p1, int p2);

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
