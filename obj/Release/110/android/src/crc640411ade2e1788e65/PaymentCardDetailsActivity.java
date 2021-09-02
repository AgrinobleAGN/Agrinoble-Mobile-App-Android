package crc640411ade2e1788e65;


public class PaymentCardDetailsActivity
	extends crc64dcf039a48c5f8fc0.BaseActivity
	implements
		mono.android.IGCUserPeer,
		com.stripe.android.TokenCallback
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"n_onResume:()V:GetOnResumeHandler\n" +
			"n_onPause:()V:GetOnPauseHandler\n" +
			"n_onTrimMemory:(I)V:GetOnTrimMemory_IHandler\n" +
			"n_onLowMemory:()V:GetOnLowMemoryHandler\n" +
			"n_onOptionsItemSelected:(Landroid/view/MenuItem;)Z:GetOnOptionsItemSelected_Landroid_view_MenuItem_Handler\n" +
			"n_onError:(Ljava/lang/Exception;)V:GetOnError_Ljava_lang_Exception_Handler:Com.Stripe.Android.ITokenCallbackInvoker, Naxam.Stripe.Droid\n" +
			"n_onSuccess:(Lcom/stripe/android/model/Token;)V:GetOnSuccess_Lcom_stripe_android_model_Token_Handler:Com.Stripe.Android.ITokenCallbackInvoker, Naxam.Stripe.Droid\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Payment.PaymentCardDetailsActivity, WoWonder", PaymentCardDetailsActivity.class, __md_methods);
	}


	public PaymentCardDetailsActivity ()
	{
		super ();
		if (getClass () == PaymentCardDetailsActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Payment.PaymentCardDetailsActivity, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public PaymentCardDetailsActivity (int p0)
	{
		super (p0);
		if (getClass () == PaymentCardDetailsActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Payment.PaymentCardDetailsActivity, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);


	public void onResume ()
	{
		n_onResume ();
	}

	private native void n_onResume ();


	public void onPause ()
	{
		n_onPause ();
	}

	private native void n_onPause ();


	public void onTrimMemory (int p0)
	{
		n_onTrimMemory (p0);
	}

	private native void n_onTrimMemory (int p0);


	public void onLowMemory ()
	{
		n_onLowMemory ();
	}

	private native void n_onLowMemory ();


	public boolean onOptionsItemSelected (android.view.MenuItem p0)
	{
		return n_onOptionsItemSelected (p0);
	}

	private native boolean n_onOptionsItemSelected (android.view.MenuItem p0);


	public void onError (java.lang.Exception p0)
	{
		n_onError (p0);
	}

	private native void n_onError (java.lang.Exception p0);


	public void onSuccess (com.stripe.android.model.Token p0)
	{
		n_onSuccess (p0);
	}

	private native void n_onSuccess (com.stripe.android.model.Token p0);

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
