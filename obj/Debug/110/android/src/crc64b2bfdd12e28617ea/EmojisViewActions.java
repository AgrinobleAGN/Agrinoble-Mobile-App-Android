package crc64b2bfdd12e28617ea;


public class EmojisViewActions
	extends com.aghajari.emojiview.listener.SimplePopupAdapter
	implements
		mono.android.IGCUserPeer,
		android.view.View.OnClickListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onShow:()V:GetOnShowHandler\n" +
			"n_onDismiss:()V:GetOnDismissHandler\n" +
			"n_onClick:(Landroid/view/View;)V:GetOnClick_Landroid_view_View_Handler:Android.Views.View/IOnClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.EmojiView.EmojisViewActions, WoWonder", EmojisViewActions.class, __md_methods);
	}


	public EmojisViewActions ()
	{
		super ();
		if (getClass () == EmojisViewActions.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.EmojiView.EmojisViewActions, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public EmojisViewActions (android.app.Activity p0, java.lang.String p1, com.aghajari.emojiview.view.AXEmojiPopup p2, com.aghajari.emojiview.view.AXEmojiEditText p3, android.widget.ImageView p4)
	{
		super ();
		if (getClass () == EmojisViewActions.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.EmojiView.EmojisViewActions, WoWonder", "Android.App.Activity, Mono.Android:System.String, mscorlib:Aghajari.EmojiView.Views.AXEmojiPopup, Aghajari.AXEmojiView:Aghajari.EmojiView.Views.AXEmojiEditText, Aghajari.AXEmojiView:Android.Widget.ImageView, Mono.Android", this, new java.lang.Object[] { p0, p1, p2, p3, p4 });
	}


	public void onShow ()
	{
		n_onShow ();
	}

	private native void n_onShow ();


	public void onDismiss ()
	{
		n_onDismiss ();
	}

	private native void n_onDismiss ();


	public void onClick (android.view.View p0)
	{
		n_onClick (p0);
	}

	private native void n_onClick (android.view.View p0);

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
