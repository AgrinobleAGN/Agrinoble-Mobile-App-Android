package mono.it.sephiroth.android.library.imagezoom;


public class ImageViewTouchBase_OnLayoutChangeListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		it.sephiroth.android.library.imagezoom.ImageViewTouchBase.OnLayoutChangeListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onLayoutChanged:(ZIIII)V:GetOnLayoutChanged_ZIIIIHandler:Sephiroth.ImageZoom.ImageViewTouchBase/IOnLayoutChangeListenerInvoker, ImageViewZoom\n" +
			"";
		mono.android.Runtime.register ("Sephiroth.ImageZoom.ImageViewTouchBase+IOnLayoutChangeListenerImplementor, ImageViewZoom", ImageViewTouchBase_OnLayoutChangeListenerImplementor.class, __md_methods);
	}


	public ImageViewTouchBase_OnLayoutChangeListenerImplementor ()
	{
		super ();
		if (getClass () == ImageViewTouchBase_OnLayoutChangeListenerImplementor.class)
			mono.android.TypeManager.Activate ("Sephiroth.ImageZoom.ImageViewTouchBase+IOnLayoutChangeListenerImplementor, ImageViewZoom", "", this, new java.lang.Object[] {  });
	}


	public void onLayoutChanged (boolean p0, int p1, int p2, int p3, int p4)
	{
		n_onLayoutChanged (p0, p1, p2, p3, p4);
	}

	private native void n_onLayoutChanged (boolean p0, int p1, int p2, int p3, int p4);

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
