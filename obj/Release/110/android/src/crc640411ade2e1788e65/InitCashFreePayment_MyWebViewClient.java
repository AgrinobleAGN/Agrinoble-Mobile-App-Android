package crc640411ade2e1788e65;


public class InitCashFreePayment_MyWebViewClient
	extends android.webkit.WebViewClient
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onPageStarted:(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V:GetOnPageStarted_Landroid_webkit_WebView_Ljava_lang_String_Landroid_graphics_Bitmap_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Payment.InitCashFreePayment+MyWebViewClient, WoWonder", InitCashFreePayment_MyWebViewClient.class, __md_methods);
	}


	public InitCashFreePayment_MyWebViewClient ()
	{
		super ();
		if (getClass () == InitCashFreePayment_MyWebViewClient.class)
			mono.android.TypeManager.Activate ("WoWonder.Payment.InitCashFreePayment+MyWebViewClient, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public void onPageStarted (android.webkit.WebView p0, java.lang.String p1, android.graphics.Bitmap p2)
	{
		n_onPageStarted (p0, p1, p2);
	}

	private native void n_onPageStarted (android.webkit.WebView p0, java.lang.String p1, android.graphics.Bitmap p2);

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
