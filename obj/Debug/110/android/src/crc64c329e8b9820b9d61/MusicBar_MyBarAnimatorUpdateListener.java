package crc64c329e8b9820b9d61;


public class MusicBar_MyBarAnimatorUpdateListener
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
		mono.android.Runtime.register ("WoWonder.Library.MusicBar.MusicBar+MyBarAnimatorUpdateListener, WoWonder", MusicBar_MyBarAnimatorUpdateListener.class, __md_methods);
	}


	public MusicBar_MyBarAnimatorUpdateListener ()
	{
		super ();
		if (getClass () == MusicBar_MyBarAnimatorUpdateListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.MusicBar.MusicBar+MyBarAnimatorUpdateListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public MusicBar_MyBarAnimatorUpdateListener (crc64c329e8b9820b9d61.MusicBar p0)
	{
		super ();
		if (getClass () == MusicBar_MyBarAnimatorUpdateListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.MusicBar.MusicBar+MyBarAnimatorUpdateListener, WoWonder", "WoWonder.Library.MusicBar.MusicBar, WoWonder", this, new java.lang.Object[] { p0 });
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
