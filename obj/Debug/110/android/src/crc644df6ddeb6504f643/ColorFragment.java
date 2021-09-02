package crc644df6ddeb6504f643;


public class ColorFragment
	extends com.google.android.material.bottomsheet.BottomSheetDialogFragment
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_setupDialog:(Landroid/app/Dialog;I)V:GetSetupDialog_Landroid_app_Dialog_IHandler\n" +
			"n_onStart:()V:GetOnStartHandler\n" +
			"n_onLowMemory:()V:GetOnLowMemoryHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.Editor.Tools.ColorFragment, WoWonder", ColorFragment.class, __md_methods);
	}


	public ColorFragment ()
	{
		super ();
		if (getClass () == ColorFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Editor.Tools.ColorFragment, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public ColorFragment (crc641a27b1fa7fd000ab.NiceArtEditor p0, crc64b7bb8055b86bb22a.EditColorActivity p1)
	{
		super ();
		if (getClass () == ColorFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.Editor.Tools.ColorFragment, WoWonder", "WoWonder.NiceArt.NiceArtEditor, WoWonder:WoWonder.Activities.Chat.Editor.EditColorActivity, WoWonder", this, new java.lang.Object[] { p0, p1 });
	}


	public void setupDialog (android.app.Dialog p0, int p1)
	{
		n_setupDialog (p0, p1);
	}

	private native void n_setupDialog (android.app.Dialog p0, int p1);


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
