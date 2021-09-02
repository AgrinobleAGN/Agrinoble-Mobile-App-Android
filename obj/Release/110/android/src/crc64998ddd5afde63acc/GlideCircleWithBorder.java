package crc64998ddd5afde63acc;


public class GlideCircleWithBorder
	extends com.bumptech.glide.load.resource.bitmap.BitmapTransformation
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_transform:(Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;:GetTransform_Lcom_bumptech_glide_load_engine_bitmap_recycle_BitmapPool_Landroid_graphics_Bitmap_IIHandler\n" +
			"n_updateDiskCacheKey:(Ljava/security/MessageDigest;)V:GetUpdateDiskCacheKey_Ljava_security_MessageDigest_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.CacheLoaders.GlideCircleWithBorder, WoWonder", GlideCircleWithBorder.class, __md_methods);
	}


	public GlideCircleWithBorder ()
	{
		super ();
		if (getClass () == GlideCircleWithBorder.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.CacheLoaders.GlideCircleWithBorder, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public android.graphics.Bitmap transform (com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool p0, android.graphics.Bitmap p1, int p2, int p3)
	{
		return n_transform (p0, p1, p2, p3);
	}

	private native android.graphics.Bitmap n_transform (com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool p0, android.graphics.Bitmap p1, int p2, int p3);


	public void updateDiskCacheKey (java.security.MessageDigest p0)
	{
		n_updateDiskCacheKey (p0);
	}

	private native void n_updateDiskCacheKey (java.security.MessageDigest p0);

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
