package mono.com.theartofdev.edmodo.cropper;


public class CropImageView_OnSetCropOverlayReleasedListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.theartofdev.edmodo.cropper.CropImageView.OnSetCropOverlayReleasedListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCropOverlayReleased:(Landroid/graphics/Rect;)V:GetOnCropOverlayReleased_Landroid_graphics_Rect_Handler:TheArtOfDev.Edmodo.Cropper.CropImageView/IOnSetCropOverlayReleasedListenerInvoker, ArthurHub.AndroidImageCropper\n" +
			"";
		mono.android.Runtime.register ("TheArtOfDev.Edmodo.Cropper.CropImageView+IOnSetCropOverlayReleasedListenerImplementor, ArthurHub.AndroidImageCropper", CropImageView_OnSetCropOverlayReleasedListenerImplementor.class, __md_methods);
	}


	public CropImageView_OnSetCropOverlayReleasedListenerImplementor ()
	{
		super ();
		if (getClass () == CropImageView_OnSetCropOverlayReleasedListenerImplementor.class)
			mono.android.TypeManager.Activate ("TheArtOfDev.Edmodo.Cropper.CropImageView+IOnSetCropOverlayReleasedListenerImplementor, ArthurHub.AndroidImageCropper", "", this, new java.lang.Object[] {  });
	}


	public void onCropOverlayReleased (android.graphics.Rect p0)
	{
		n_onCropOverlayReleased (p0);
	}

	private native void n_onCropOverlayReleased (android.graphics.Rect p0);

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
