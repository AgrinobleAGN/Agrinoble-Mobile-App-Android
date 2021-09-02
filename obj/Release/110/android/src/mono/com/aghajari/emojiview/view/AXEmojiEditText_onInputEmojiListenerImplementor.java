package mono.com.aghajari.emojiview.view;


public class AXEmojiEditText_onInputEmojiListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.aghajari.emojiview.view.AXEmojiEditText.onInputEmojiListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onInput:(Lcom/aghajari/emojiview/view/AXEmojiEditText;Lcom/aghajari/emojiview/emoji/Emoji;)V:GetOnInput_Lcom_aghajari_emojiview_view_AXEmojiEditText_Lcom_aghajari_emojiview_emoji_Emoji_Handler:Aghajari.EmojiView.Views.AXEmojiEditText/IOnInputEmojiListenerInvoker, Aghajari.AXEmojiView\n" +
			"";
		mono.android.Runtime.register ("Aghajari.EmojiView.Views.AXEmojiEditText+IOnInputEmojiListenerImplementor, Aghajari.AXEmojiView", AXEmojiEditText_onInputEmojiListenerImplementor.class, __md_methods);
	}


	public AXEmojiEditText_onInputEmojiListenerImplementor ()
	{
		super ();
		if (getClass () == AXEmojiEditText_onInputEmojiListenerImplementor.class)
			mono.android.TypeManager.Activate ("Aghajari.EmojiView.Views.AXEmojiEditText+IOnInputEmojiListenerImplementor, Aghajari.AXEmojiView", "", this, new java.lang.Object[] {  });
	}


	public void onInput (com.aghajari.emojiview.view.AXEmojiEditText p0, com.aghajari.emojiview.emoji.Emoji p1)
	{
		n_onInput (p0, p1);
	}

	private native void n_onInput (com.aghajari.emojiview.view.AXEmojiEditText p0, com.aghajari.emojiview.emoji.Emoji p1);

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
