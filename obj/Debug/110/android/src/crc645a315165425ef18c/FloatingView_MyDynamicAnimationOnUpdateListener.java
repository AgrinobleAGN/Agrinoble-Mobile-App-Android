package crc645a315165425ef18c;


public class FloatingView_MyDynamicAnimationOnUpdateListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onAnimationUpdate:(Landroidx/dynamicanimation/animation/DynamicAnimation;FF)V:GetOnAnimationUpdate_Landroidx_dynamicanimation_animation_DynamicAnimation_FFHandler:AndroidX.DynamicAnimation.DynamicAnimation/IOnAnimationUpdateListenerInvoker, Xamarin.AndroidX.DynamicAnimation\n" +
			"";
		mono.android.Runtime.register ("FloatingView.Lib.FloatingView+MyDynamicAnimationOnUpdateListener, FloatingView", FloatingView_MyDynamicAnimationOnUpdateListener.class, __md_methods);
	}


	public FloatingView_MyDynamicAnimationOnUpdateListener ()
	{
		super ();
		if (getClass () == FloatingView_MyDynamicAnimationOnUpdateListener.class)
			mono.android.TypeManager.Activate ("FloatingView.Lib.FloatingView+MyDynamicAnimationOnUpdateListener, FloatingView", "", this, new java.lang.Object[] {  });
	}

	public FloatingView_MyDynamicAnimationOnUpdateListener (crc645a315165425ef18c.FloatingView p0, java.lang.String p1)
	{
		super ();
		if (getClass () == FloatingView_MyDynamicAnimationOnUpdateListener.class)
			mono.android.TypeManager.Activate ("FloatingView.Lib.FloatingView+MyDynamicAnimationOnUpdateListener, FloatingView", "FloatingView.Lib.FloatingView, FloatingView:System.String, mscorlib", this, new java.lang.Object[] { p0, p1 });
	}


	public void onAnimationUpdate (androidx.dynamicanimation.animation.DynamicAnimation p0, float p1, float p2)
	{
		n_onAnimationUpdate (p0, p1, p2);
	}

	private native void n_onAnimationUpdate (androidx.dynamicanimation.animation.DynamicAnimation p0, float p1, float p2);

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
