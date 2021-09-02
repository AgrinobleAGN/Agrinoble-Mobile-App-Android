package crc64708dea99db5f6981;


public class OnCompleteListener
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.google.android.play.core.tasks.OnCompleteListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onComplete:(Lcom/google/android/play/core/tasks/Task;)V:GetOnComplete_Lcom_google_android_play_core_tasks_Task_Handler:Com.Google.Android.Play.Core.Tasks.IOnCompleteListenerInvoker, PlayCore\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Utils.OnCompleteListener, WoWonder", OnCompleteListener.class, __md_methods);
	}


	public OnCompleteListener ()
	{
		super ();
		if (getClass () == OnCompleteListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.OnCompleteListener, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public OnCompleteListener (android.app.Activity p0, com.google.android.play.core.review.ReviewManager p1)
	{
		super ();
		if (getClass () == OnCompleteListener.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Utils.OnCompleteListener, WoWonder", "Android.App.Activity, Mono.Android:Com.Google.Android.Play.Core.Review.IReviewManager, PlayCore", this, new java.lang.Object[] { p0, p1 });
	}


	public void onComplete (com.google.android.play.core.tasks.Task p0)
	{
		n_onComplete (p0);
	}

	private native void n_onComplete (com.google.android.play.core.tasks.Task p0);

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
