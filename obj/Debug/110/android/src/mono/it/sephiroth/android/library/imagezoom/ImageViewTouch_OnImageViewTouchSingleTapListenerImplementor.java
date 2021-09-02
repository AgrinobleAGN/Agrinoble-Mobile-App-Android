package mono.it.sephiroth.android.library.imagezoom;


public class ImageViewTouch_OnImageViewTouchSingleTapListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		it.sephiroth.android.library.imagezoom.ImageViewTouch.OnImageViewTouchSingleTapListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onSingleTapConfirmed:()V:GetOnSingleTapConfirmedHandler:Sephiroth.ImageZoom.ImageViewTouch/IOnImageViewTouchSingleTapListenerInvoker, ImageViewZoom\n" +
			"";
		mono.android.Runtime.register ("Sephiroth.ImageZoom.ImageViewTouch+IOnImageViewTouchSingleTapListenerImplementor, ImageViewZoom", ImageViewTouch_OnImageViewTouchSingleTapListenerImplementor.class, __md_methods);
	}


	public ImageViewTouch_OnImageViewTouchSingleTapListenerImplementor ()
	{
		super ();
		if (getClass () == ImageViewTouch_OnImageViewTouchSingleTapListenerImplementor.class)
			mono.android.TypeManager.Activate ("Sephiroth.ImageZoom.ImageViewTouch+IOnImageViewTouchSingleTapListenerImplementor, ImageViewZoom", "", this, new java.lang.Object[] {  });
	}


	public void onSingleTapConfirmed ()
	{
		n_onSingleTapConfirmed ();
	}

	private native void n_onSingleTapConfirmed ();

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
