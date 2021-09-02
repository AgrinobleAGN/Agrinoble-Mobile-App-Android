package crc6447b7d00dc8d7ead2;


public class ArticlesViewActivity_MyWebViewClient
	extends android.webkit.WebViewClient
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_shouldOverrideUrlLoading:(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z:GetShouldOverrideUrlLoading_Landroid_webkit_WebView_Landroid_webkit_WebResourceRequest_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Articles.ArticlesViewActivity+MyWebViewClient, WoWonder", ArticlesViewActivity_MyWebViewClient.class, __md_methods);
	}


	public ArticlesViewActivity_MyWebViewClient ()
	{
		super ();
		if (getClass () == ArticlesViewActivity_MyWebViewClient.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Articles.ArticlesViewActivity+MyWebViewClient, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public ArticlesViewActivity_MyWebViewClient (crc6447b7d00dc8d7ead2.ArticlesViewActivity p0)
	{
		super ();
		if (getClass () == ArticlesViewActivity_MyWebViewClient.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Articles.ArticlesViewActivity+MyWebViewClient, WoWonder", "WoWonder.Activities.Articles.ArticlesViewActivity, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public boolean shouldOverrideUrlLoading (android.webkit.WebView p0, android.webkit.WebResourceRequest p1)
	{
		return n_shouldOverrideUrlLoading (p0, p1);
	}

	private native boolean n_shouldOverrideUrlLoading (android.webkit.WebView p0, android.webkit.WebResourceRequest p1);

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
