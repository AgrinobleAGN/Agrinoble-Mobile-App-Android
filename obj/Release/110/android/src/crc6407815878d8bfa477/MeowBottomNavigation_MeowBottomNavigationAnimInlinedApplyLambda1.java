package crc6407815878d8bfa477;


public class MeowBottomNavigation_MeowBottomNavigationAnimInlinedApplyLambda1
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.animation.ValueAnimator.AnimatorUpdateListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onAnimationUpdate:(Landroid/animation/ValueAnimator;)V:GetOnAnimationUpdate_Landroid_animation_ValueAnimator_Handler:Android.Animation.ValueAnimator/IAnimatorUpdateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("MeoNavLib.Com.MeowBottomNavigation+MeowBottomNavigationAnimInlinedApplyLambda1, MeoNavLib", MeowBottomNavigation_MeowBottomNavigationAnimInlinedApplyLambda1.class, __md_methods);
	}


	public MeowBottomNavigation_MeowBottomNavigationAnimInlinedApplyLambda1 ()
	{
		super ();
		if (getClass () == MeowBottomNavigation_MeowBottomNavigationAnimInlinedApplyLambda1.class)
			mono.android.TypeManager.Activate ("MeoNavLib.Com.MeowBottomNavigation+MeowBottomNavigationAnimInlinedApplyLambda1, MeoNavLib", "", this, new java.lang.Object[] {  });
	}

	public MeowBottomNavigation_MeowBottomNavigationAnimInlinedApplyLambda1 (float p0, crc6407815878d8bfa477.MeowBottomNavigation p1, long p2, androidx.interpolator.view.animation.FastOutSlowInInterpolator p3, crc6407815878d8bfa477.MeowBottomNavigationCell p4)
	{
		super ();
		if (getClass () == MeowBottomNavigation_MeowBottomNavigationAnimInlinedApplyLambda1.class)
			mono.android.TypeManager.Activate ("MeoNavLib.Com.MeowBottomNavigation+MeowBottomNavigationAnimInlinedApplyLambda1, MeoNavLib", "System.Single, mscorlib:MeoNavLib.Com.MeowBottomNavigation, MeoNavLib:System.Int64, mscorlib:AndroidX.Interpolator.View.Animation.FastOutSlowInInterpolator, Xamarin.AndroidX.Interpolator:MeoNavLib.Com.MeowBottomNavigationCell, MeoNavLib", this, new java.lang.Object[] { p0, p1, p2, p3, p4 });
	}


	public void onAnimationUpdate (android.animation.ValueAnimator p0)
	{
		n_onAnimationUpdate (p0);
	}

	private native void n_onAnimationUpdate (android.animation.ValueAnimator p0);

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
