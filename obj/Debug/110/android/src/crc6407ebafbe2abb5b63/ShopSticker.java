package crc6407ebafbe2abb5b63;


public class ShopSticker
	extends com.aghajari.emojiview.sticker.Sticker
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.EmojiView.StickersView.ShopSticker, WoWonder", ShopSticker.class, __md_methods);
	}


	public ShopSticker (java.lang.Object p0)
	{
		super (p0);
		if (getClass () == ShopSticker.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.EmojiView.StickersView.ShopSticker, WoWonder", "Java.Lang.Object, Mono.Android", this, new java.lang.Object[] { p0 });
	}

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