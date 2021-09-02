package crc642b41ce0650c5aa6e;


public class MsgOneSignalNotification
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.onesignal.OneSignal.OSNotificationWillShowInForegroundHandler,
		com.onesignal.OneSignal.OSNotificationOpenedHandler,
		com.onesignal.OSSubscriptionObserver
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_notificationWillShowInForeground:(Lcom/onesignal/OSNotificationReceivedEvent;)V:GetNotificationWillShowInForeground_Lcom_onesignal_OSNotificationReceivedEvent_Handler:Com.Onesignal.OneSignal/IOSNotificationWillShowInForegroundHandlerInvoker, OneSignalAndroid\n" +
			"n_notificationOpened:(Lcom/onesignal/OSNotificationOpenedResult;)V:GetNotificationOpened_Lcom_onesignal_OSNotificationOpenedResult_Handler:Com.Onesignal.OneSignal/IOSNotificationOpenedHandlerInvoker, OneSignalAndroid\n" +
			"n_onOSSubscriptionChanged:(Lcom/onesignal/OSSubscriptionStateChanges;)V:GetOnOSSubscriptionChanged_Lcom_onesignal_OSSubscriptionStateChanges_Handler:Com.Onesignal.IOSSubscriptionObserverInvoker, OneSignalAndroid\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.OneSignalNotif.MsgOneSignalNotification, WoWonder", MsgOneSignalNotification.class, __md_methods);
	}


	public MsgOneSignalNotification ()
	{
		super ();
		if (getClass () == MsgOneSignalNotification.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.OneSignalNotif.MsgOneSignalNotification, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void notificationWillShowInForeground (com.onesignal.OSNotificationReceivedEvent p0)
	{
		n_notificationWillShowInForeground (p0);
	}

	private native void n_notificationWillShowInForeground (com.onesignal.OSNotificationReceivedEvent p0);


	public void notificationOpened (com.onesignal.OSNotificationOpenedResult p0)
	{
		n_notificationOpened (p0);
	}

	private native void n_notificationOpened (com.onesignal.OSNotificationOpenedResult p0);


	public void onOSSubscriptionChanged (com.onesignal.OSSubscriptionStateChanges p0)
	{
		n_onOSSubscriptionChanged (p0);
	}

	private native void n_onOSSubscriptionChanged (com.onesignal.OSSubscriptionStateChanges p0);

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
