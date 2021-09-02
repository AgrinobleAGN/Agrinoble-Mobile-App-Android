package crc649b1df4326cf61085;


public class StReadMoreOption_StRclickableSpan
	extends android.text.style.ClickableSpan
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onClick:(Landroid/view/View;)V:GetOnClick_Landroid_view_View_Handler\n" +
			"n_updateDrawState:(Landroid/text/TextPaint;)V:GetUpdateDrawState_Landroid_text_TextPaint_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.SuperTextLibrary.StReadMoreOption+StRclickableSpan, WoWonder", StReadMoreOption_StRclickableSpan.class, __md_methods);
	}


	public StReadMoreOption_StRclickableSpan ()
	{
		super ();
		if (getClass () == StReadMoreOption_StRclickableSpan.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.SuperTextLibrary.StReadMoreOption+StRclickableSpan, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void onClick (android.view.View p0)
	{
		n_onClick (p0);
	}

	private native void n_onClick (android.view.View p0);


	public void updateDrawState (android.text.TextPaint p0)
	{
		n_updateDrawState (p0);
	}

	private native void n_updateDrawState (android.text.TextPaint p0);

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
