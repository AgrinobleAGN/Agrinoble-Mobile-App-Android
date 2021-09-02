package crc64b7401b1cc845868f;


public class TabbedWalletActivity
	extends crc64dcf039a48c5f8fc0.BaseActivity
	implements
		mono.android.IGCUserPeer,
		com.razorpay.PaymentResultListener,
		com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"n_onTrimMemory:(I)V:GetOnTrimMemory_IHandler\n" +
			"n_onLowMemory:()V:GetOnLowMemoryHandler\n" +
			"n_onDestroy:()V:GetOnDestroyHandler\n" +
			"n_onOptionsItemSelected:(Landroid/view/MenuItem;)Z:GetOnOptionsItemSelected_Landroid_view_MenuItem_Handler\n" +
			"n_onActivityResult:(IILandroid/content/Intent;)V:GetOnActivityResult_IILandroid_content_Intent_Handler\n" +
			"n_onPaymentError:(ILjava/lang/String;)V:GetOnPaymentError_ILjava_lang_String_Handler:Com.Razorpay.IPaymentResultListenerInvoker, Razorpay\n" +
			"n_onPaymentSuccess:(Ljava/lang/String;)V:GetOnPaymentSuccess_Ljava_lang_String_Handler:Com.Razorpay.IPaymentResultListenerInvoker, Razorpay\n" +
			"n_onConfigureTab:(Lcom/google/android/material/tabs/TabLayout$Tab;I)V:GetOnConfigureTab_Lcom_google_android_material_tabs_TabLayout_Tab_IHandler:Google.Android.Material.Tabs.TabLayoutMediator/ITabConfigurationStrategyInvoker, Xamarin.Google.Android.Material\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Wallet.TabbedWalletActivity, WoWonder", TabbedWalletActivity.class, __md_methods);
	}


	public TabbedWalletActivity ()
	{
		super ();
		if (getClass () == TabbedWalletActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Wallet.TabbedWalletActivity, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public TabbedWalletActivity (int p0)
	{
		super (p0);
		if (getClass () == TabbedWalletActivity.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Wallet.TabbedWalletActivity, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);


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


	public void onDestroy ()
	{
		n_onDestroy ();
	}

	private native void n_onDestroy ();


	public boolean onOptionsItemSelected (android.view.MenuItem p0)
	{
		return n_onOptionsItemSelected (p0);
	}

	private native boolean n_onOptionsItemSelected (android.view.MenuItem p0);


	public void onActivityResult (int p0, int p1, android.content.Intent p2)
	{
		n_onActivityResult (p0, p1, p2);
	}

	private native void n_onActivityResult (int p0, int p1, android.content.Intent p2);


	public void onPaymentError (int p0, java.lang.String p1)
	{
		n_onPaymentError (p0, p1);
	}

	private native void n_onPaymentError (int p0, java.lang.String p1);


	public void onPaymentSuccess (java.lang.String p0)
	{
		n_onPaymentSuccess (p0);
	}

	private native void n_onPaymentSuccess (java.lang.String p0);


	public void onConfigureTab (com.google.android.material.tabs.TabLayout.Tab p0, int p1)
	{
		n_onConfigureTab (p0, p1);
	}

	private native void n_onConfigureTab (com.google.android.material.tabs.TabLayout.Tab p0, int p1);

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
