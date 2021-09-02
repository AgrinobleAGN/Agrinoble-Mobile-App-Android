package crc6407ebafbe2abb5b63;


public class WoWonderProvider_MyStickerLoader
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.aghajari.emojiview.sticker.StickerLoader
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onLoadSticker:(Landroid/view/View;Lcom/aghajari/emojiview/sticker/Sticker;)V:GetOnLoadSticker_Landroid_view_View_Lcom_aghajari_emojiview_sticker_Sticker_Handler:Aghajari.EmojiView.Stickers.IStickerLoaderInvoker, Aghajari.AXEmojiView\n" +
			"n_onLoadStickerCategory:(Landroid/view/View;Lcom/aghajari/emojiview/sticker/StickerCategory;Z)V:GetOnLoadStickerCategory_Landroid_view_View_Lcom_aghajari_emojiview_sticker_StickerCategory_ZHandler:Aghajari.EmojiView.Stickers.IStickerLoaderInvoker, Aghajari.AXEmojiView\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.EmojiView.StickersView.WoWonderProvider+MyStickerLoader, WoWonder", WoWonderProvider_MyStickerLoader.class, __md_methods);
	}


	public WoWonderProvider_MyStickerLoader ()
	{
		super ();
		if (getClass () == WoWonderProvider_MyStickerLoader.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.EmojiView.StickersView.WoWonderProvider+MyStickerLoader, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void onLoadSticker (android.view.View p0, com.aghajari.emojiview.sticker.Sticker p1)
	{
		n_onLoadSticker (p0, p1);
	}

	private native void n_onLoadSticker (android.view.View p0, com.aghajari.emojiview.sticker.Sticker p1);


	public void onLoadStickerCategory (android.view.View p0, com.aghajari.emojiview.sticker.StickerCategory p1, boolean p2)
	{
		n_onLoadStickerCategory (p0, p1, p2);
	}

	private native void n_onLoadStickerCategory (android.view.View p0, com.aghajari.emojiview.sticker.StickerCategory p1, boolean p2);

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
