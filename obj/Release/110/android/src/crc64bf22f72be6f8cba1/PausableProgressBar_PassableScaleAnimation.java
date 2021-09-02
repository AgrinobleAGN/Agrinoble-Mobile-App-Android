package crc64bf22f72be6f8cba1;


public class PausableProgressBar_PassableScaleAnimation
	extends android.view.animation.ScaleAnimation
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_getTransformation:(JLandroid/view/animation/Transformation;F)Z:GetGetTransformation_JLandroid_view_animation_Transformation_FHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.Stories.StoriesProgressView.PausableProgressBar+PassableScaleAnimation, WoWonder", PausableProgressBar_PassableScaleAnimation.class, __md_methods);
	}


	public PausableProgressBar_PassableScaleAnimation (android.content.Context p0, android.util.AttributeSet p1)
	{
		super (p0, p1);
		if (getClass () == PausableProgressBar_PassableScaleAnimation.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.Stories.StoriesProgressView.PausableProgressBar+PassableScaleAnimation, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public PausableProgressBar_PassableScaleAnimation (float p0, float p1, float p2, float p3)
	{
		super (p0, p1, p2, p3);
		if (getClass () == PausableProgressBar_PassableScaleAnimation.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.Stories.StoriesProgressView.PausableProgressBar+PassableScaleAnimation, WoWonder", "System.Single, mscorlib:System.Single, mscorlib:System.Single, mscorlib:System.Single, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public PausableProgressBar_PassableScaleAnimation (float p0, float p1, float p2, float p3, float p4, float p5)
	{
		super (p0, p1, p2, p3, p4, p5);
		if (getClass () == PausableProgressBar_PassableScaleAnimation.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.Stories.StoriesProgressView.PausableProgressBar+PassableScaleAnimation, WoWonder", "System.Single, mscorlib:System.Single, mscorlib:System.Single, mscorlib:System.Single, mscorlib:System.Single, mscorlib:System.Single, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3, p4, p5 });
	}


	public PausableProgressBar_PassableScaleAnimation (float p0, float p1, float p2, float p3, int p4, float p5, int p6, float p7)
	{
		super (p0, p1, p2, p3, p4, p5, p6, p7);
		if (getClass () == PausableProgressBar_PassableScaleAnimation.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.Stories.StoriesProgressView.PausableProgressBar+PassableScaleAnimation, WoWonder", "System.Single, mscorlib:System.Single, mscorlib:System.Single, mscorlib:System.Single, mscorlib:Android.Views.Animations.Dimension, Mono.Android:System.Single, mscorlib:Android.Views.Animations.Dimension, Mono.Android:System.Single, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3, p4, p5, p6, p7 });
	}


	public boolean getTransformation (long p0, android.view.animation.Transformation p1, float p2)
	{
		return n_getTransformation (p0, p1, p2);
	}

	private native boolean n_getTransformation (long p0, android.view.animation.Transformation p1, float p2);

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
