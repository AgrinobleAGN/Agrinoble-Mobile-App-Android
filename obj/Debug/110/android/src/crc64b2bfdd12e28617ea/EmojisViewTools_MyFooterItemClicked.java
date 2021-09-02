package crc64b2bfdd12e28617ea;


public class EmojisViewTools_MyFooterItemClicked
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.aghajari.emojiview.view.AXEmojiPager.OnFooterItemClicked
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onClick:(Landroid/view/View;Z)V:GetOnClick_Landroid_view_View_ZHandler:Aghajari.EmojiView.Views.AXEmojiPager/IOnFooterItemClickedInvoker, Aghajari.AXEmojiView\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.EmojiView.EmojisViewTools+MyFooterItemClicked, WoWonder", EmojisViewTools_MyFooterItemClicked.class, __md_methods);
	}


	public EmojisViewTools_MyFooterItemClicked ()
	{
		super ();
		if (getClass () == EmojisViewTools_MyFooterItemClicked.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.EmojiView.EmojisViewTools+MyFooterItemClicked, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void onClick (android.view.View p0, boolean p1)
	{
		n_onClick (p0, p1);
	}

	private native void n_onClick (android.view.View p0, boolean p1);

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
