package crc64c51607effc384a79;


public class VoiceRecorder
	extends com.google.android.material.bottomsheet.BottomSheetDialogFragment
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreateView:(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;:GetOnCreateView_Landroid_view_LayoutInflater_Landroid_view_ViewGroup_Landroid_os_Bundle_Handler\n" +
			"n_onLowMemory:()V:GetOnLowMemoryHandler\n" +
			"n_onDestroy:()V:GetOnDestroyHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.AddPost.VoiceRecorder, WoWonder", VoiceRecorder.class, __md_methods);
	}


	public VoiceRecorder ()
	{
		super ();
		if (getClass () == VoiceRecorder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.AddPost.VoiceRecorder, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public VoiceRecorder (android.app.Activity p0, java.lang.String p1)
	{
		super ();
		if (getClass () == VoiceRecorder.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.AddPost.VoiceRecorder, WoWonder", "Android.App.Activity, Mono.Android:System.String, mscorlib", this, new java.lang.Object[] { p0, p1 });
	}


	public android.view.View onCreateView (android.view.LayoutInflater p0, android.view.ViewGroup p1, android.os.Bundle p2)
	{
		return n_onCreateView (p0, p1, p2);
	}

	private native android.view.View n_onCreateView (android.view.LayoutInflater p0, android.view.ViewGroup p1, android.os.Bundle p2);


	public void onLowMemory ()
	{
		n_onLowMemory ();
	}

	private native void n_onLowMemory ();


	public void onDestroy ()
	{
		n_onDestroy ();
	}

	private native void n_onDestroy ();

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
