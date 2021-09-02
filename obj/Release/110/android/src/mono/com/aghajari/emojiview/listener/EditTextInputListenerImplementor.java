package mono.com.aghajari.emojiview.listener;


public class EditTextInputListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.aghajari.emojiview.listener.EditTextInputListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_input:(Landroid/widget/EditText;Lcom/aghajari/emojiview/emoji/Emoji;)V:GetInput_Landroid_widget_EditText_Lcom_aghajari_emojiview_emoji_Emoji_Handler:Aghajari.EmojiView.Listeners.IEditTextInputListenerInvoker, Aghajari.AXEmojiView\n" +
			"";
		mono.android.Runtime.register ("Aghajari.EmojiView.Listeners.IEditTextInputListenerImplementor, Aghajari.AXEmojiView", EditTextInputListenerImplementor.class, __md_methods);
	}


	public EditTextInputListenerImplementor ()
	{
		super ();
		if (getClass () == EditTextInputListenerImplementor.class)
			mono.android.TypeManager.Activate ("Aghajari.EmojiView.Listeners.IEditTextInputListenerImplementor, Aghajari.AXEmojiView", "", this, new java.lang.Object[] {  });
	}


	public void input (android.widget.EditText p0, com.aghajari.emojiview.emoji.Emoji p1)
	{
		n_input (p0, p1);
	}

	private native void n_input (android.widget.EditText p0, com.aghajari.emojiview.emoji.Emoji p1);

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
