package crc6407ebafbe2abb5b63;


public class WoWonderProvider
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.aghajari.emojiview.sticker.StickerProvider
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_isRecentEnabled:()Z:GetIsRecentEnabledHandler:Aghajari.EmojiView.Stickers.IStickerProviderInvoker, Aghajari.AXEmojiView\n" +
			"n_getLoader:()Lcom/aghajari/emojiview/sticker/StickerLoader;:GetGetLoaderHandler:Aghajari.EmojiView.Stickers.IStickerProviderInvoker, Aghajari.AXEmojiView\n" +
			"n_getCategories:()[Lcom/aghajari/emojiview/sticker/StickerCategory;:GetGetCategoriesHandler:Aghajari.EmojiView.Stickers.IStickerProviderInvoker, Aghajari.AXEmojiView\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.EmojiView.StickersView.WoWonderProvider, WoWonder", WoWonderProvider.class, __md_methods);
	}


	public WoWonderProvider ()
	{
		super ();
		if (getClass () == WoWonderProvider.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.EmojiView.StickersView.WoWonderProvider, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public boolean isRecentEnabled ()
	{
		return n_isRecentEnabled ();
	}

	private native boolean n_isRecentEnabled ();


	public com.aghajari.emojiview.sticker.StickerLoader getLoader ()
	{
		return n_getLoader ();
	}

	private native com.aghajari.emojiview.sticker.StickerLoader n_getLoader ();


	public com.aghajari.emojiview.sticker.StickerCategory[] getCategories ()
	{
		return n_getCategories ();
	}

	private native com.aghajari.emojiview.sticker.StickerCategory[] n_getCategories ();

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
