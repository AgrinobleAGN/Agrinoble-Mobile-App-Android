package crc6407815878d8bfa477;


public class MeowBottomNavigationCell_MeowBottomNavigationCellAnimateProgressInlinedApplyLambda1
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
		mono.android.Runtime.register ("MeoNavLib.Com.MeowBottomNavigationCell+MeowBottomNavigationCellAnimateProgressInlinedApplyLambda1, MeoNavLib", MeowBottomNavigationCell_MeowBottomNavigationCellAnimateProgressInlinedApplyLambda1.class, __md_methods);
	}


	public MeowBottomNavigationCell_MeowBottomNavigationCellAnimateProgressInlinedApplyLambda1 ()
	{
		super ();
		if (getClass () == MeowBottomNavigationCell_MeowBottomNavigationCellAnimateProgressInlinedApplyLambda1.class)
			mono.android.TypeManager.Activate ("MeoNavLib.Com.MeowBottomNavigationCell+MeowBottomNavigationCellAnimateProgressInlinedApplyLambda1, MeoNavLib", "", this, new java.lang.Object[] {  });
	}

	public MeowBottomNavigationCell_MeowBottomNavigationCellAnimateProgressInlinedApplyLambda1 (crc6407815878d8bfa477.MeowBottomNavigationCell p0, boolean p1, long p2, boolean p3)
	{
		super ();
		if (getClass () == MeowBottomNavigationCell_MeowBottomNavigationCellAnimateProgressInlinedApplyLambda1.class)
			mono.android.TypeManager.Activate ("MeoNavLib.Com.MeowBottomNavigationCell+MeowBottomNavigationCellAnimateProgressInlinedApplyLambda1, MeoNavLib", "MeoNavLib.Com.MeowBottomNavigationCell, MeoNavLib:System.Boolean, mscorlib:System.Int64, mscorlib:System.Boolean, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
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
