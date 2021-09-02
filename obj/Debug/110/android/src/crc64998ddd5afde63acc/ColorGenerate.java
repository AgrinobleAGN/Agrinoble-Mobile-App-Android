package crc64998ddd5afde63acc;


public class ColorGenerate
	extends com.bumptech.glide.request.target.CustomTarget
	implements
		mono.android.IGCUserPeer,
		androidx.palette.graphics.Palette.PaletteAsyncListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onResourceReady:(Ljava/lang/Object;Lcom/bumptech/glide/request/transition/Transition;)V:GetOnResourceReady_Ljava_lang_Object_Lcom_bumptech_glide_request_transition_Transition_Handler\n" +
			"n_onLoadCleared:(Landroid/graphics/drawable/Drawable;)V:GetOnLoadCleared_Landroid_graphics_drawable_Drawable_Handler\n" +
			"n_onGenerated:(Landroidx/palette/graphics/Palette;)V:GetOnGenerated_Landroidx_palette_graphics_Palette_Handler:AndroidX.Palette.Graphics.Palette/IPaletteAsyncListenerInvoker, Xamarin.AndroidX.Palette\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.CacheLoaders.ColorGenerate, WoWonder", ColorGenerate.class, __md_methods);
	}


	public ColorGenerate ()
	{
		super ();
		if (getClass () == ColorGenerate.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.CacheLoaders.ColorGenerate, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public ColorGenerate (int p0, int p1)
	{
		super (p0, p1);
		if (getClass () == ColorGenerate.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.CacheLoaders.ColorGenerate, WoWonder", "System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1 });
	}

	public ColorGenerate (android.app.Activity p0, android.widget.ImageView p1)
	{
		super ();
		if (getClass () == ColorGenerate.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.CacheLoaders.ColorGenerate, WoWonder", "Android.App.Activity, Mono.Android:Android.Widget.ImageView, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public void onResourceReady (java.lang.Object p0, com.bumptech.glide.request.transition.Transition p1)
	{
		n_onResourceReady (p0, p1);
	}

	private native void n_onResourceReady (java.lang.Object p0, com.bumptech.glide.request.transition.Transition p1);


	public void onLoadCleared (android.graphics.drawable.Drawable p0)
	{
		n_onLoadCleared (p0);
	}

	private native void n_onLoadCleared (android.graphics.drawable.Drawable p0);


	public void onGenerated (androidx.palette.graphics.Palette p0)
	{
		n_onGenerated (p0);
	}

	private native void n_onGenerated (androidx.palette.graphics.Palette p0);

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
