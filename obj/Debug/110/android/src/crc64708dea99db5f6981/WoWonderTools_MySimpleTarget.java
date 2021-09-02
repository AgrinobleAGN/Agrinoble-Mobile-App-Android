package crc64708dea99db5f6981;


public class WoWonderTools_MySimpleTarget
	extends com.bumptech.glide.request.target.CustomTarget
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onResourceReady:(Ljava/lang/Object;Lcom/bumptech/glide/request/transition/Transition;)V:GetOnResourceReady_Ljava_lang_Object_Lcom_bumptech_glide_request_transition_Transition_Handler\n" +
			"n_onLoadCleared:(Landroid/graphics/drawable/Drawable;)V:GetOnLoadCleared_Landroid_graphics_drawable_Drawable_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Utils.WoWonderTools+MySimpleTarget, WoWonder", WoWonderTools_MySimpleTarget.class, __md_methods);
	}


	public WoWonderTools_MySimpleTarget ()
	{
		super ();
		if (getClass () == WoWonderTools_MySimpleTarget.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.WoWonderTools+MySimpleTarget, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public WoWonderTools_MySimpleTarget (int p0, int p1)
	{
		super (p0, p1);
		if (getClass () == WoWonderTools_MySimpleTarget.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.WoWonderTools+MySimpleTarget, WoWonder", "System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1 });
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
