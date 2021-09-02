package mono.it.sephiroth.android.library.imagezoom;


public class ImageViewTouch_OnImageViewTouchDoubleTapListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		it.sephiroth.android.library.imagezoom.ImageViewTouch.OnImageViewTouchDoubleTapListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onDoubleTap:()V:GetOnDoubleTapHandler:Sephiroth.ImageZoom.ImageViewTouch/IOnImageViewTouchDoubleTapListenerInvoker, ImageViewZoom\n" +
			"";
		mono.android.Runtime.register ("Sephiroth.ImageZoom.ImageViewTouch+IOnImageViewTouchDoubleTapListenerImplementor, ImageViewZoom", ImageViewTouch_OnImageViewTouchDoubleTapListenerImplementor.class, __md_methods);
	}


	public ImageViewTouch_OnImageViewTouchDoubleTapListenerImplementor ()
	{
		super ();
		if (getClass () == ImageViewTouch_OnImageViewTouchDoubleTapListenerImplementor.class)
			mono.android.TypeManager.Activate ("Sephiroth.ImageZoom.ImageViewTouch+IOnImageViewTouchDoubleTapListenerImplementor, ImageViewZoom", "", this, new java.lang.Object[] {  });
	}


	public void onDoubleTap ()
	{
		n_onDoubleTap ();
	}

	private native void n_onDoubleTap ();

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
