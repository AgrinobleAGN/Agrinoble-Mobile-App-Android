package mono.com.aghajari.emojiview.listener;


public class EmojiVariantCreatorListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.aghajari.emojiview.listener.EmojiVariantCreatorListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_create:(Landroid/view/View;Lcom/aghajari/emojiview/listener/OnEmojiActions;)Lcom/aghajari/emojiview/variant/AXEmojiVariantPopup;:GetCreate_Landroid_view_View_Lcom_aghajari_emojiview_listener_OnEmojiActions_Handler:Aghajari.EmojiView.Listeners.IEmojiVariantCreatorListenerInvoker, Aghajari.AXEmojiView\n" +
			"";
		mono.android.Runtime.register ("Aghajari.EmojiView.Listeners.IEmojiVariantCreatorListenerImplementor, Aghajari.AXEmojiView", EmojiVariantCreatorListenerImplementor.class, __md_methods);
	}


	public EmojiVariantCreatorListenerImplementor ()
	{
		super ();
		if (getClass () == EmojiVariantCreatorListenerImplementor.class)
			mono.android.TypeManager.Activate ("Aghajari.EmojiView.Listeners.IEmojiVariantCreatorListenerImplementor, Aghajari.AXEmojiView", "", this, new java.lang.Object[] {  });
	}


	public com.aghajari.emojiview.variant.AXEmojiVariantPopup create (android.view.View p0, com.aghajari.emojiview.listener.OnEmojiActions p1)
	{
		return n_create (p0, p1);
	}

	private native com.aghajari.emojiview.variant.AXEmojiVariantPopup n_create (android.view.View p0, com.aghajari.emojiview.listener.OnEmojiActions p1);

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
