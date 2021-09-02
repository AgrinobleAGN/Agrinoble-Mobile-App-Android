package crc640d8a71cd6a59a46d;


public class AllCapsTransformationMethod
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.text.method.TransformationMethod
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_getTransformation:(Ljava/lang/CharSequence;Landroid/view/View;)Ljava/lang/CharSequence;:GetGetTransformation_Ljava_lang_CharSequence_Landroid_view_View_Handler:Android.Text.Method.ITransformationMethodInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"n_onFocusChanged:(Landroid/view/View;Ljava/lang/CharSequence;ZILandroid/graphics/Rect;)V:GetOnFocusChanged_Landroid_view_View_Ljava_lang_CharSequence_ZILandroid_graphics_Rect_Handler:Android.Text.Method.ITransformationMethodInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("MaterialDialogsCore.internal.AllCapsTransformationMethod, MaterialDialogsCore", AllCapsTransformationMethod.class, __md_methods);
	}


	public AllCapsTransformationMethod ()
	{
		super ();
		if (getClass () == AllCapsTransformationMethod.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.internal.AllCapsTransformationMethod, MaterialDialogsCore", "", this, new java.lang.Object[] {  });
	}

	public AllCapsTransformationMethod (android.content.Context p0)
	{
		super ();
		if (getClass () == AllCapsTransformationMethod.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.internal.AllCapsTransformationMethod, MaterialDialogsCore", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public java.lang.CharSequence getTransformation (java.lang.CharSequence p0, android.view.View p1)
	{
		return n_getTransformation (p0, p1);
	}

	private native java.lang.CharSequence n_getTransformation (java.lang.CharSequence p0, android.view.View p1);


	public void onFocusChanged (android.view.View p0, java.lang.CharSequence p1, boolean p2, int p3, android.graphics.Rect p4)
	{
		n_onFocusChanged (p0, p1, p2, p3, p4);
	}

	private native void n_onFocusChanged (android.view.View p0, java.lang.CharSequence p1, boolean p2, int p3, android.graphics.Rect p4);

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
