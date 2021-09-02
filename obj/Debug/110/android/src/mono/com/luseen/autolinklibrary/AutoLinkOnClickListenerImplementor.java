package mono.com.luseen.autolinklibrary;


public class AutoLinkOnClickListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.luseen.autolinklibrary.AutoLinkOnClickListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onAutoLinkTextClick:(Lcom/luseen/autolinklibrary/AutoLinkMode;Ljava/lang/String;)V:GetOnAutoLinkTextClick_Lcom_luseen_autolinklibrary_AutoLinkMode_Ljava_lang_String_Handler:Com.Luseen.Autolinklibrary.IAutoLinkOnClickListenerInvoker, AutoLinkTextView\n" +
			"";
		mono.android.Runtime.register ("Com.Luseen.Autolinklibrary.IAutoLinkOnClickListenerImplementor, AutoLinkTextView", AutoLinkOnClickListenerImplementor.class, __md_methods);
	}


	public AutoLinkOnClickListenerImplementor ()
	{
		super ();
		if (getClass () == AutoLinkOnClickListenerImplementor.class)
			mono.android.TypeManager.Activate ("Com.Luseen.Autolinklibrary.IAutoLinkOnClickListenerImplementor, AutoLinkTextView", "", this, new java.lang.Object[] {  });
	}


	public void onAutoLinkTextClick (com.luseen.autolinklibrary.AutoLinkMode p0, java.lang.String p1)
	{
		n_onAutoLinkTextClick (p0, p1);
	}

	private native void n_onAutoLinkTextClick (com.luseen.autolinklibrary.AutoLinkMode p0, java.lang.String p1);

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
