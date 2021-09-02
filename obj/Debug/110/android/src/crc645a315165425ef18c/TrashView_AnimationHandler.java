package crc645a315165425ef18c;


public class TrashView_AnimationHandler
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
		mono.android.Runtime.register ("FloatingView.Lib.TrashView+AnimationHandler, FloatingView", TrashView_AnimationHandler.class, __md_methods);
	}


	public TrashView_AnimationHandler ()
	{
		super ();
		if (getClass () == TrashView_AnimationHandler.class)
			mono.android.TypeManager.Activate ("FloatingView.Lib.TrashView+AnimationHandler, FloatingView", "", this, new java.lang.Object[] {  });
	}


	public TrashView_AnimationHandler (android.os.Looper p0)
	{
		super (p0);
		if (getClass () == TrashView_AnimationHandler.class)
			mono.android.TypeManager.Activate ("FloatingView.Lib.TrashView+AnimationHandler, FloatingView", "Android.OS.Looper, Mono.Android", this, new java.lang.Object[] { p0 });
	}

	public TrashView_AnimationHandler (crc645a315165425ef18c.TrashView p0)
	{
		super ();
		if (getClass () == TrashView_AnimationHandler.class)
			mono.android.TypeManager.Activate ("FloatingView.Lib.TrashView+AnimationHandler, FloatingView", "FloatingView.Lib.TrashView, FloatingView", this, new java.lang.Object[] { p0 });
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
