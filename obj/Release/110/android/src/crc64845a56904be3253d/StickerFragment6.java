package crc64845a56904be3253d;


public class StickerFragment6
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
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.StickersFragments.StickerFragment6, WoWonder", StickerFragment6.class, __md_methods);
	}


	public StickerFragment6 ()
	{
		super ();
		if (getClass () == StickerFragment6.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.StickersFragments.StickerFragment6, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public StickerFragment6 (int p0)
	{
		super (p0);
		if (getClass () == StickerFragment6.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.StickersFragments.StickerFragment6, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}

	public StickerFragment6 (java.lang.String p0)
	{
		super ();
		if (getClass () == StickerFragment6.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.StickersFragments.StickerFragment6, WoWonder", "System.String, mscorlib", this, new java.lang.Object[] { p0 });
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
