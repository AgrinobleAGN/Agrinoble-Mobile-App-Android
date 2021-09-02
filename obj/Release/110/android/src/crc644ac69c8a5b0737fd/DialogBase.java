package crc644ac69c8a5b0737fd;


public class DialogBase
	extends android.app.Dialog
	implements
		mono.android.IGCUserPeer,
		android.content.DialogInterface.OnShowListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_findViewById:(I)Landroid/view/View;:GetFindViewById_IHandler\n" +
			"n_setContentView:(I)V:GetSetContentView_IHandler\n" +
			"n_setContentView:(Landroid/view/View;)V:GetSetContentView_Landroid_view_View_Handler\n" +
			"n_setContentView:(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V:GetSetContentView_Landroid_view_View_Landroid_view_ViewGroup_LayoutParams_Handler\n" +
			"n_onShow:(Landroid/content/DialogInterface;)V:GetOnShow_Landroid_content_DialogInterface_Handler:Android.Content.IDialogInterfaceOnShowListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("MaterialDialogsCore.DialogBase, MaterialDialogsCore", DialogBase.class, __md_methods);
	}


	public DialogBase (android.content.Context p0)
	{
		super (p0);
		if (getClass () == DialogBase.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.DialogBase, MaterialDialogsCore", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public DialogBase (android.content.Context p0, int p1)
	{
		super (p0, p1);
		if (getClass () == DialogBase.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.DialogBase, MaterialDialogsCore", "Android.Content.Context, Mono.Android:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1 });
	}


	public android.view.View findViewById (int p0)
	{
		return n_findViewById (p0);
	}

	private native android.view.View n_findViewById (int p0);


	public void setContentView (int p0)
	{
		n_setContentView (p0);
	}

	private native void n_setContentView (int p0);


	public void setContentView (android.view.View p0)
	{
		n_setContentView (p0);
	}

	private native void n_setContentView (android.view.View p0);


	public void setContentView (android.view.View p0, android.view.ViewGroup.LayoutParams p1)
	{
		n_setContentView (p0, p1);
	}

	private native void n_setContentView (android.view.View p0, android.view.ViewGroup.LayoutParams p1);


	public void onShow (android.content.DialogInterface p0)
	{
		n_onShow (p0);
	}

	private native void n_onShow (android.content.DialogInterface p0);

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
