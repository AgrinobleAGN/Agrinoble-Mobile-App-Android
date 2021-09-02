package mono.com.aghajari.emojiview.listener;


public class StickerViewCreatorListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.aghajari.emojiview.listener.StickerViewCreatorListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreateCategoryView:(Landroid/content/Context;)Landroid/view/View;:GetOnCreateCategoryView_Landroid_content_Context_Handler:Aghajari.EmojiView.Listeners.IStickerViewCreatorListenerInvoker, Aghajari.AXEmojiView\n" +
			"n_onCreateStickerView:(Landroid/content/Context;Lcom/aghajari/emojiview/sticker/StickerCategory;Z)Landroid/view/View;:GetOnCreateStickerView_Landroid_content_Context_Lcom_aghajari_emojiview_sticker_StickerCategory_ZHandler:Aghajari.EmojiView.Listeners.IStickerViewCreatorListenerInvoker, Aghajari.AXEmojiView\n" +
			"";
		mono.android.Runtime.register ("Aghajari.EmojiView.Listeners.IStickerViewCreatorListenerImplementor, Aghajari.AXEmojiView", StickerViewCreatorListenerImplementor.class, __md_methods);
	}


	public StickerViewCreatorListenerImplementor ()
	{
		super ();
		if (getClass () == StickerViewCreatorListenerImplementor.class)
			mono.android.TypeManager.Activate ("Aghajari.EmojiView.Listeners.IStickerViewCreatorListenerImplementor, Aghajari.AXEmojiView", "", this, new java.lang.Object[] {  });
	}


	public android.view.View onCreateCategoryView (android.content.Context p0)
	{
		return n_onCreateCategoryView (p0);
	}

	private native android.view.View n_onCreateCategoryView (android.content.Context p0);


	public android.view.View onCreateStickerView (android.content.Context p0, com.aghajari.emojiview.sticker.StickerCategory p1, boolean p2)
	{
		return n_onCreateStickerView (p0, p1, p2);
	}

	private native android.view.View n_onCreateStickerView (android.content.Context p0, com.aghajari.emojiview.sticker.StickerCategory p1, boolean p2);

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
