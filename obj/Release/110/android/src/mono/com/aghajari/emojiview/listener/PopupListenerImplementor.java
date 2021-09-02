package mono.com.aghajari.emojiview.listener;


public class PopupListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.aghajari.emojiview.listener.PopupListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onDismiss:()V:GetOnDismissHandler:Aghajari.EmojiView.Listeners.IPopupListenerInvoker, Aghajari.AXEmojiView\n" +
			"n_onKeyboardClosed:()V:GetOnKeyboardClosedHandler:Aghajari.EmojiView.Listeners.IPopupListenerInvoker, Aghajari.AXEmojiView\n" +
			"n_onKeyboardOpened:(I)V:GetOnKeyboardOpened_IHandler:Aghajari.EmojiView.Listeners.IPopupListenerInvoker, Aghajari.AXEmojiView\n" +
			"n_onShow:()V:GetOnShowHandler:Aghajari.EmojiView.Listeners.IPopupListenerInvoker, Aghajari.AXEmojiView\n" +
			"";
		mono.android.Runtime.register ("Aghajari.EmojiView.Listeners.IPopupListenerImplementor, Aghajari.AXEmojiView", PopupListenerImplementor.class, __md_methods);
	}


	public PopupListenerImplementor ()
	{
		super ();
		if (getClass () == PopupListenerImplementor.class)
			mono.android.TypeManager.Activate ("Aghajari.EmojiView.Listeners.IPopupListenerImplementor, Aghajari.AXEmojiView", "", this, new java.lang.Object[] {  });
	}


	public void onDismiss ()
	{
		n_onDismiss ();
	}

	private native void n_onDismiss ();


	public void onKeyboardClosed ()
	{
		n_onKeyboardClosed ();
	}

	private native void n_onKeyboardClosed ();


	public void onKeyboardOpened (int p0)
	{
		n_onKeyboardOpened (p0);
	}

	private native void n_onKeyboardOpened (int p0);


	public void onShow ()
	{
		n_onShow ();
	}

	private native void n_onShow ();

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
