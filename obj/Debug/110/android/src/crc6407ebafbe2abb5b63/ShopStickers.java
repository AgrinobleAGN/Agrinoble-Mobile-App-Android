package crc6407ebafbe2abb5b63;


public class ShopStickers
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.aghajari.emojiview.sticker.StickerCategory
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_getCategoryData:()Ljava/lang/Object;:GetGetCategoryDataHandler:Aghajari.EmojiView.Stickers.IStickerCategoryInvoker, Aghajari.AXEmojiView\n" +
			"n_bindView:(Landroid/view/View;)V:GetBindView_Landroid_view_View_Handler:Aghajari.EmojiView.Stickers.IStickerCategoryInvoker, Aghajari.AXEmojiView\n" +
			"n_getEmptyView:(Landroid/view/ViewGroup;)Landroid/view/View;:GetGetEmptyView_Landroid_view_ViewGroup_Handler:Aghajari.EmojiView.Stickers.IStickerCategoryInvoker, Aghajari.AXEmojiView\n" +
			"n_getStickers:()[Lcom/aghajari/emojiview/sticker/Sticker;:GetGetStickersHandler:Aghajari.EmojiView.Stickers.IStickerCategoryInvoker, Aghajari.AXEmojiView\n" +
			"n_getView:(Landroid/view/ViewGroup;)Landroid/view/View;:GetGetView_Landroid_view_ViewGroup_Handler:Aghajari.EmojiView.Stickers.IStickerCategoryInvoker, Aghajari.AXEmojiView\n" +
			"n_useCustomView:()Z:GetUseCustomViewHandler:Aghajari.EmojiView.Stickers.IStickerCategoryInvoker, Aghajari.AXEmojiView\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.EmojiView.StickersView.ShopStickers, WoWonder", ShopStickers.class, __md_methods);
	}


	public ShopStickers ()
	{
		super ();
		if (getClass () == ShopStickers.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.EmojiView.StickersView.ShopStickers, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public java.lang.Object getCategoryData ()
	{
		return n_getCategoryData ();
	}

	private native java.lang.Object n_getCategoryData ();


	public void bindView (android.view.View p0)
	{
		n_bindView (p0);
	}

	private native void n_bindView (android.view.View p0);


	public android.view.View getEmptyView (android.view.ViewGroup p0)
	{
		return n_getEmptyView (p0);
	}

	private native android.view.View n_getEmptyView (android.view.ViewGroup p0);


	public com.aghajari.emojiview.sticker.Sticker[] getStickers ()
	{
		return n_getStickers ();
	}

	private native com.aghajari.emojiview.sticker.Sticker[] n_getStickers ();


	public android.view.View getView (android.view.ViewGroup p0)
	{
		return n_getView (p0);
	}

	private native android.view.View n_getView (android.view.ViewGroup p0);


	public boolean useCustomView ()
	{
		return n_useCustomView ();
	}

	private native boolean n_useCustomView ();

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
