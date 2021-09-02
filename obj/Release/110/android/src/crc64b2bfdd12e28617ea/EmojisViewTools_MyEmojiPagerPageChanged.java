package crc64b2bfdd12e28617ea;


public class EmojisViewTools_MyEmojiPagerPageChanged
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.aghajari.emojiview.listener.OnEmojiPagerPageChanged,
		android.view.View.OnClickListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onPageChanged:(Lcom/aghajari/emojiview/view/AXEmojiPager;Lcom/aghajari/emojiview/view/AXEmojiBase;I)V:GetOnPageChanged_Lcom_aghajari_emojiview_view_AXEmojiPager_Lcom_aghajari_emojiview_view_AXEmojiBase_IHandler:Aghajari.EmojiView.Listeners.IOnEmojiPagerPageChangedInvoker, Aghajari.AXEmojiView\n" +
			"n_onClick:(Landroid/view/View;)V:GetOnClick_Landroid_view_View_Handler:Android.Views.View/IOnClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.EmojiView.EmojisViewTools+MyEmojiPagerPageChanged, WoWonder", EmojisViewTools_MyEmojiPagerPageChanged.class, __md_methods);
	}


	public EmojisViewTools_MyEmojiPagerPageChanged ()
	{
		super ();
		if (getClass () == EmojisViewTools_MyEmojiPagerPageChanged.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.EmojiView.EmojisViewTools+MyEmojiPagerPageChanged, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public EmojisViewTools_MyEmojiPagerPageChanged (android.content.Context p0, android.widget.FrameLayout p1, android.widget.ImageView p2)
	{
		super ();
		if (getClass () == EmojisViewTools_MyEmojiPagerPageChanged.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.EmojiView.EmojisViewTools+MyEmojiPagerPageChanged, WoWonder", "Android.Content.Context, Mono.Android:Android.Widget.FrameLayout, Mono.Android:Android.Widget.ImageView, Mono.Android", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public void onPageChanged (com.aghajari.emojiview.view.AXEmojiPager p0, com.aghajari.emojiview.view.AXEmojiBase p1, int p2)
	{
		n_onPageChanged (p0, p1, p2);
	}

	private native void n_onPageChanged (com.aghajari.emojiview.view.AXEmojiPager p0, com.aghajari.emojiview.view.AXEmojiBase p1, int p2);


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
