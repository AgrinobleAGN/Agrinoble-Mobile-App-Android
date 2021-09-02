package mono.it.sephiroth.android.library.imagezoom;


public class ImageViewTouchBase_OnDrawableChangeListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		it.sephiroth.android.library.imagezoom.ImageViewTouchBase.OnDrawableChangeListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onDrawableChanged:(Landroid/graphics/drawable/Drawable;)V:GetOnDrawableChanged_Landroid_graphics_drawable_Drawable_Handler:Sephiroth.ImageZoom.ImageViewTouchBase/IOnDrawableChangeListenerInvoker, ImageViewZoom\n" +
			"";
		mono.android.Runtime.register ("Sephiroth.ImageZoom.ImageViewTouchBase+IOnDrawableChangeListenerImplementor, ImageViewZoom", ImageViewTouchBase_OnDrawableChangeListenerImplementor.class, __md_methods);
	}


	public ImageViewTouchBase_OnDrawableChangeListenerImplementor ()
	{
		super ();
		if (getClass () == ImageViewTouchBase_OnDrawableChangeListenerImplementor.class)
			mono.android.TypeManager.Activate ("Sephiroth.ImageZoom.ImageViewTouchBase+IOnDrawableChangeListenerImplementor, ImageViewZoom", "", this, new java.lang.Object[] {  });
	}


	public void onDrawableChanged (android.graphics.drawable.Drawable p0)
	{
		n_onDrawableChanged (p0);
	}

	private native void n_onDrawableChanged (android.graphics.drawable.Drawable p0);

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
