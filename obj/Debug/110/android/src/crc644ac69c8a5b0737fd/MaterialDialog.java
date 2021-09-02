package crc644ac69c8a5b0737fd;


public class MaterialDialog
	extends crc644ac69c8a5b0737fd.DialogBase
	implements
		mono.android.IGCUserPeer,
		android.view.View.OnClickListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_show:()V:GetShowHandler\n" +
			"n_dismiss:()V:GetDismissHandler\n" +
			"n_onClick:(Landroid/view/View;)V:GetOnClick_Landroid_view_View_Handler:Android.Views.View/IOnClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("MaterialDialogsCore.MaterialDialog, MaterialDialogsCore", MaterialDialog.class, __md_methods);
	}


	public MaterialDialog (android.content.Context p0)
	{
		super (p0);
		if (getClass () == MaterialDialog.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.MaterialDialog, MaterialDialogsCore", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public MaterialDialog (android.content.Context p0, int p1)
	{
		super (p0, p1);
		if (getClass () == MaterialDialog.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.MaterialDialog, MaterialDialogsCore", "Android.Content.Context, Mono.Android:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1 });
	}


	public void show ()
	{
		n_show ();
	}

	private native void n_show ();


	public void dismiss ()
	{
		n_dismiss ();
	}

	private native void n_dismiss ();


	public void onClick (android.view.View p0)
	{
		n_onClick (p0);
	}

	private native void n_onClick (android.view.View p0);

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
