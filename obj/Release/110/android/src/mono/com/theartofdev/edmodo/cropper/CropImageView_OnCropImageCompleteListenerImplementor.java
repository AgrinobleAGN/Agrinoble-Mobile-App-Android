package mono.com.theartofdev.edmodo.cropper;


public class CropImageView_OnCropImageCompleteListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.theartofdev.edmodo.cropper.CropImageView.OnCropImageCompleteListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCropImageComplete:(Lcom/theartofdev/edmodo/cropper/CropImageView;Lcom/theartofdev/edmodo/cropper/CropImageView$CropResult;)V:GetOnCropImageComplete_Lcom_theartofdev_edmodo_cropper_CropImageView_Lcom_theartofdev_edmodo_cropper_CropImageView_CropResult_Handler:TheArtOfDev.Edmodo.Cropper.CropImageView/IOnCropImageCompleteListenerInvoker, ArthurHub.AndroidImageCropper\n" +
			"";
		mono.android.Runtime.register ("TheArtOfDev.Edmodo.Cropper.CropImageView+IOnCropImageCompleteListenerImplementor, ArthurHub.AndroidImageCropper", CropImageView_OnCropImageCompleteListenerImplementor.class, __md_methods);
	}


	public CropImageView_OnCropImageCompleteListenerImplementor ()
	{
		super ();
		if (getClass () == CropImageView_OnCropImageCompleteListenerImplementor.class)
			mono.android.TypeManager.Activate ("TheArtOfDev.Edmodo.Cropper.CropImageView+IOnCropImageCompleteListenerImplementor, ArthurHub.AndroidImageCropper", "", this, new java.lang.Object[] {  });
	}


	public void onCropImageComplete (com.theartofdev.edmodo.cropper.CropImageView p0, com.theartofdev.edmodo.cropper.CropImageView.CropResult p1)
	{
		n_onCropImageComplete (p0, p1);
	}

	private native void n_onCropImageComplete (com.theartofdev.edmodo.cropper.CropImageView p0, com.theartofdev.edmodo.cropper.CropImageView.CropResult p1);

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
