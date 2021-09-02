package crc648fd5d4561675ac42;


public class ChatRecordSoundFragment
	extends androidx.fragment.app.Fragment
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreateView:(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;:GetOnCreateView_Landroid_view_LayoutInflater_Landroid_view_ViewGroup_Landroid_os_Bundle_Handler\n" +
			"n_onViewCreated:(Landroid/view/View;Landroid/os/Bundle;)V:GetOnViewCreated_Landroid_view_View_Landroid_os_Bundle_Handler\n" +
			"n_onLowMemory:()V:GetOnLowMemoryHandler\n" +
			"n_onDestroy:()V:GetOnDestroyHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.ChatWindow.Fragment.ChatRecordSoundFragment, WoWonder", ChatRecordSoundFragment.class, __md_methods);
	}


	public ChatRecordSoundFragment ()
	{
		super ();
		if (getClass () == ChatRecordSoundFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.ChatWindow.Fragment.ChatRecordSoundFragment, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public ChatRecordSoundFragment (int p0)
	{
		super (p0);
		if (getClass () == ChatRecordSoundFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.ChatWindow.Fragment.ChatRecordSoundFragment, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}

	public ChatRecordSoundFragment (java.lang.String p0)
	{
		super ();
		if (getClass () == ChatRecordSoundFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.ChatWindow.Fragment.ChatRecordSoundFragment, WoWonder", "System.String, mscorlib", this, new java.lang.Object[] { p0 });
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
