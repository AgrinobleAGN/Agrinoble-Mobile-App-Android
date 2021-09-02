package crc645446c848f33428ea;


public class AnimFragment3
	extends androidx.fragment.app.Fragment
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreateView:(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;:GetOnCreateView_Landroid_view_LayoutInflater_Landroid_view_ViewGroup_Landroid_os_Bundle_Handler\n" +
			"n_onLowMemory:()V:GetOnLowMemoryHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.WalkTroutPage.AnimFragment3, WoWonder", AnimFragment3.class, __md_methods);
	}


	public AnimFragment3 ()
	{
		super ();
		if (getClass () == AnimFragment3.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.WalkTroutPage.AnimFragment3, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public AnimFragment3 (int p0)
	{
		super (p0);
		if (getClass () == AnimFragment3.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.WalkTroutPage.AnimFragment3, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
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
