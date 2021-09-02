package mono.com.stripe.android.view;


public class CardInputListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.stripe.android.view.CardInputListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCardComplete:()V:GetOnCardCompleteHandler:Com.Stripe.Android.View.ICardInputListenerInvoker, Naxam.Stripe.Droid\n" +
			"n_onCvcComplete:()V:GetOnCvcCompleteHandler:Com.Stripe.Android.View.ICardInputListenerInvoker, Naxam.Stripe.Droid\n" +
			"n_onExpirationComplete:()V:GetOnExpirationCompleteHandler:Com.Stripe.Android.View.ICardInputListenerInvoker, Naxam.Stripe.Droid\n" +
			"n_onFocusChange:(Ljava/lang/String;)V:GetOnFocusChange_Ljava_lang_String_Handler:Com.Stripe.Android.View.ICardInputListenerInvoker, Naxam.Stripe.Droid\n" +
			"n_onPostalCodeComplete:()V:GetOnPostalCodeCompleteHandler:Com.Stripe.Android.View.ICardInputListenerInvoker, Naxam.Stripe.Droid\n" +
			"";
		mono.android.Runtime.register ("Com.Stripe.Android.View.ICardInputListenerImplementor, Naxam.Stripe.Droid", CardInputListenerImplementor.class, __md_methods);
	}


	public CardInputListenerImplementor ()
	{
		super ();
		if (getClass () == CardInputListenerImplementor.class)
			mono.android.TypeManager.Activate ("Com.Stripe.Android.View.ICardInputListenerImplementor, Naxam.Stripe.Droid", "", this, new java.lang.Object[] {  });
	}


	public void onCardComplete ()
	{
		n_onCardComplete ();
	}

	private native void n_onCardComplete ();


	public void onCvcComplete ()
	{
		n_onCvcComplete ();
	}

	private native void n_onCvcComplete ();


	public void onExpirationComplete ()
	{
		n_onExpirationComplete ();
	}

	private native void n_onExpirationComplete ();


	public void onFocusChange (java.lang.String p0)
	{
		n_onFocusChange (p0);
	}

	private native void n_onFocusChange (java.lang.String p0);


	public void onPostalCodeComplete ()
	{
		n_onPostalCodeComplete ();
	}

	private native void n_onPostalCodeComplete ();

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
