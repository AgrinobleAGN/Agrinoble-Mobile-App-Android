package crc64b2bfdd12e28617ea;


public class EmojisViewTools_MyStickerActions
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.aghajari.emojiview.listener.OnStickerActions
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onClick:(Landroid/view/View;Lcom/aghajari/emojiview/sticker/Sticker;Z)V:GetOnClick_Landroid_view_View_Lcom_aghajari_emojiview_sticker_Sticker_ZHandler:Aghajari.EmojiView.Listeners.IOnStickerActionsInvoker, Aghajari.AXEmojiView\n" +
			"n_onLongClick:(Landroid/view/View;Lcom/aghajari/emojiview/sticker/Sticker;Z)Z:GetOnLongClick_Landroid_view_View_Lcom_aghajari_emojiview_sticker_Sticker_ZHandler:Aghajari.EmojiView.Listeners.IOnStickerActionsInvoker, Aghajari.AXEmojiView\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.EmojiView.EmojisViewTools+MyStickerActions, WoWonder", EmojisViewTools_MyStickerActions.class, __md_methods);
	}


	public EmojisViewTools_MyStickerActions ()
	{
		super ();
		if (getClass () == EmojisViewTools_MyStickerActions.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.EmojiView.EmojisViewTools+MyStickerActions, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public EmojisViewTools_MyStickerActions (android.app.Activity p0, java.lang.String p1)
	{
		super ();
		if (getClass () == EmojisViewTools_MyStickerActions.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.EmojiView.EmojisViewTools+MyStickerActions, WoWonder", "Android.App.Activity, Mono.Android:System.String, mscorlib", this, new java.lang.Object[] { p0, p1 });
	}


	public void onClick (android.view.View p0, com.aghajari.emojiview.sticker.Sticker p1, boolean p2)
	{
		n_onClick (p0, p1, p2);
	}

	private native void n_onClick (android.view.View p0, com.aghajari.emojiview.sticker.Sticker p1, boolean p2);


	public boolean onLongClick (android.view.View p0, com.aghajari.emojiview.sticker.Sticker p1, boolean p2)
	{
		return n_onLongClick (p0, p1, p2);
	}

	private native boolean n_onLongClick (android.view.View p0, com.aghajari.emojiview.sticker.Sticker p1, boolean p2);

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
