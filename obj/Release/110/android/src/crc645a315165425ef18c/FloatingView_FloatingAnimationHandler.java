package crc645a315165425ef18c;


public class FloatingView_FloatingAnimationHandler
	extends android.os.Handler
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_handleMessage:(Landroid/os/Message;)V:GetHandleMessage_Landroid_os_Message_Handler\n" +
			"";
		mono.android.Runtime.register ("FloatingView.Lib.FloatingView+FloatingAnimationHandler, FloatingView", FloatingView_FloatingAnimationHandler.class, __md_methods);
	}


	public FloatingView_FloatingAnimationHandler ()
	{
		super ();
		if (getClass () == FloatingView_FloatingAnimationHandler.class)
			mono.android.TypeManager.Activate ("FloatingView.Lib.FloatingView+FloatingAnimationHandler, FloatingView", "", this, new java.lang.Object[] {  });
	}


	public FloatingView_FloatingAnimationHandler (android.os.Looper p0)
	{
		super (p0);
		if (getClass () == FloatingView_FloatingAnimationHandler.class)
			mono.android.TypeManager.Activate ("FloatingView.Lib.FloatingView+FloatingAnimationHandler, FloatingView", "Android.OS.Looper, Mono.Android", this, new java.lang.Object[] { p0 });
	}

	public FloatingView_FloatingAnimationHandler (crc645a315165425ef18c.FloatingView p0)
	{
		super ();
		if (getClass () == FloatingView_FloatingAnimationHandler.class)
			mono.android.TypeManager.Activate ("FloatingView.Lib.FloatingView+FloatingAnimationHandler, FloatingView", "FloatingView.Lib.FloatingView, FloatingView", this, new java.lang.Object[] { p0 });
	}


	public void handleMessage (android.os.Message p0)
	{
		n_handleMessage (p0);
	}

	private native void n_handleMessage (android.os.Message p0);

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
