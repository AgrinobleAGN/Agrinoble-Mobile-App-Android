package crc641a27b1fa7fd000ab;


public class FilterImageView
	extends android.widget.ImageView
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_setImageBitmap:(Landroid/graphics/Bitmap;)V:GetSetImageBitmap_Landroid_graphics_Bitmap_Handler\n" +
			"n_setImageIcon:(Landroid/graphics/drawable/Icon;)V:GetSetImageIcon_Landroid_graphics_drawable_Icon_Handler\n" +
			"n_setImageState:([IZ)V:GetSetImageState_arrayIZHandler\n" +
			"n_setImageDrawable:(Landroid/graphics/drawable/Drawable;)V:GetSetImageDrawable_Landroid_graphics_drawable_Drawable_Handler\n" +
			"n_setImageResource:(I)V:GetSetImageResource_IHandler\n" +
			"n_setImageURI:(Landroid/net/Uri;)V:GetSetImageURI_Landroid_net_Uri_Handler\n" +
			"n_setImageLevel:(I)V:GetSetImageLevel_IHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.NiceArt.FilterImageView, WoWonder", FilterImageView.class, __md_methods);
	}


	public FilterImageView (android.content.Context p0)
	{
		super (p0);
		if (getClass () == FilterImageView.class)
			mono.android.TypeManager.Activate ("WoWonder.NiceArt.FilterImageView, WoWonder", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public FilterImageView (android.content.Context p0, android.util.AttributeSet p1)
	{
		super (p0, p1);
		if (getClass () == FilterImageView.class)
			mono.android.TypeManager.Activate ("WoWonder.NiceArt.FilterImageView, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public FilterImageView (android.content.Context p0, android.util.AttributeSet p1, int p2)
	{
		super (p0, p1, p2);
		if (getClass () == FilterImageView.class)
			mono.android.TypeManager.Activate ("WoWonder.NiceArt.FilterImageView, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public FilterImageView (android.content.Context p0, android.util.AttributeSet p1, int p2, int p3)
	{
		super (p0, p1, p2, p3);
		if (getClass () == FilterImageView.class)
			mono.android.TypeManager.Activate ("WoWonder.NiceArt.FilterImageView, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public void setImageBitmap (android.graphics.Bitmap p0)
	{
		n_setImageBitmap (p0);
	}

	private native void n_setImageBitmap (android.graphics.Bitmap p0);


	public void setImageIcon (android.graphics.drawable.Icon p0)
	{
		n_setImageIcon (p0);
	}

	private native void n_setImageIcon (android.graphics.drawable.Icon p0);


	public void setImageState (int[] p0, boolean p1)
	{
		n_setImageState (p0, p1);
	}

	private native void n_setImageState (int[] p0, boolean p1);


	public void setImageDrawable (android.graphics.drawable.Drawable p0)
	{
		n_setImageDrawable (p0);
	}

	private native void n_setImageDrawable (android.graphics.drawable.Drawable p0);


	public void setImageResource (int p0)
	{
		n_setImageResource (p0);
	}

	private native void n_setImageResource (int p0);


	public void setImageURI (android.net.Uri p0)
	{
		n_setImageURI (p0);
	}

	private native void n_setImageURI (android.net.Uri p0);


	public void setImageLevel (int p0)
	{
		n_setImageLevel (p0);
	}

	private native void n_setImageLevel (int p0);

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
