package crc644df6ddeb6504f643;


public class TextEditorFragment
	extends androidx.fragment.app.DialogFragment
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreateView:(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;:GetOnCreateView_Landroid_view_LayoutInflater_Landroid_view_ViewGroup_Landroid_os_Bundle_Handler\n" +
			"n_onViewCreated:(Landroid/view/View;Landroid/os/Bundle;)V:GetOnViewCreated_Landroid_view_View_Landroid_os_Bundle_Handler\n" +
			"n_onStart:()V:GetOnStartHandler\n" +
			"n_onLowMemory:()V:GetOnLowMemoryHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.Editor.Tools.TextEditorFragment, WoWonder", TextEditorFragment.class, __md_methods);
	}


	public TextEditorFragment ()
	{
		super ();
		if (getClass () == TextEditorFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Editor.Tools.TextEditorFragment, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public TextEditorFragment (int p0)
	{
		super (p0);
		if (getClass () == TextEditorFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Editor.Tools.TextEditorFragment, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}

	public TextEditorFragment (crc64b7bb8055b86bb22a.EditColorActivity p0)
	{
		super ();
		if (getClass () == TextEditorFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Editor.Tools.TextEditorFragment, WoWonder", "WoWonder.Activities.Chat.Editor.EditColorActivity, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public android.view.View onCreateView (android.view.LayoutInflater p0, android.view.ViewGroup p1, android.os.Bundle p2)
	{
		return n_onCreateView (p0, p1, p2);
	}

	private native android.view.View n_onCreateView (android.view.LayoutInflater p0, android.view.ViewGroup p1, android.os.Bundle p2);


	public void onViewCreated (android.view.View p0, android.os.Bundle p1)
	{
		n_onViewCreated (p0, p1);
	}

	private native void n_onViewCreated (android.view.View p0, android.os.Bundle p1);


	public void onStart ()
	{
		n_onStart ();
	}

	private native void n_onStart ();


	public void onLowMemory ()
	{
		n_onLowMemory ();
	}

	private native void n_onLowMemory ();

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
