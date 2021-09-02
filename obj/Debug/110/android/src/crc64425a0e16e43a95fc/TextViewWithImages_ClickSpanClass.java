package crc64425a0e16e43a95fc;


public class TextViewWithImages_ClickSpanClass
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
		mono.android.Runtime.register ("WoWonder.Helpers.Fonts.TextViewWithImages+ClickSpanClass, WoWonder", TextViewWithImages_ClickSpanClass.class, __md_methods);
	}


	public TextViewWithImages_ClickSpanClass ()
	{
		super ();
		if (getClass () == TextViewWithImages_ClickSpanClass.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Fonts.TextViewWithImages+ClickSpanClass, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public TextViewWithImages_ClickSpanClass (java.lang.String p0, crc64297040596eefa26a.AdapterHolders_PostTopSectionViewHolder p1)
	{
		super ();
		if (getClass () == TextViewWithImages_ClickSpanClass.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Fonts.TextViewWithImages+ClickSpanClass, WoWonder", "System.String, mscorlib:WoWonder.Activities.NativePost.Post.AdapterHolders+PostTopSectionViewHolder, WoWonder", this, new java.lang.Object[] { p0, p1 });
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
