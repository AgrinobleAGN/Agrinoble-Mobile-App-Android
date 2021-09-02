package crc64bf22f72be6f8cba1;


public class PausableProgressBar_MyAnimationListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.view.animation.Animation.AnimationListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onAnimationEnd:(Landroid/view/animation/Animation;)V:GetOnAnimationEnd_Landroid_view_animation_Animation_Handler:Android.Views.Animations.Animation/IAnimationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"n_onAnimationRepeat:(Landroid/view/animation/Animation;)V:GetOnAnimationRepeat_Landroid_view_animation_Animation_Handler:Android.Views.Animations.Animation/IAnimationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"n_onAnimationStart:(Landroid/view/animation/Animation;)V:GetOnAnimationStart_Landroid_view_animation_Animation_Handler:Android.Views.Animations.Animation/IAnimationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.Stories.StoriesProgressView.PausableProgressBar+MyAnimationListener, WoWonder", PausableProgressBar_MyAnimationListener.class, __md_methods);
	}


	public PausableProgressBar_MyAnimationListener ()
	{
		super ();
		if (getClass () == PausableProgressBar_MyAnimationListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.Stories.StoriesProgressView.PausableProgressBar+MyAnimationListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public PausableProgressBar_MyAnimationListener (crc64bf22f72be6f8cba1.PausableProgressBar p0)
	{
		super ();
		if (getClass () == PausableProgressBar_MyAnimationListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.Stories.StoriesProgressView.PausableProgressBar+MyAnimationListener, WoWonder", "WoWonder.Library.Anjo.Stories.StoriesProgressView.PausableProgressBar, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void onAnimationEnd (android.view.animation.Animation p0)
	{
		n_onAnimationEnd (p0);
	}

	private native void n_onAnimationEnd (android.view.animation.Animation p0);


	public void onAnimationRepeat (android.view.animation.Animation p0)
	{
		n_onAnimationRepeat (p0);
	}

	private native void n_onAnimationRepeat (android.view.animation.Animation p0);


	public void onAnimationStart (android.view.animation.Animation p0)
	{
		n_onAnimationStart (p0);
	}

	private native void n_onAnimationStart (android.view.animation.Animation p0);

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
