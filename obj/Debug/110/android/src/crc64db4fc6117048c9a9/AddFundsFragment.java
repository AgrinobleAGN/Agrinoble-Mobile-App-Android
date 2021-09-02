package crc64db4fc6117048c9a9;


public class AddFundsFragment
	extends androidx.fragment.app.Fragment
	implements
		mono.android.IGCUserPeer,
		com.razorpay.PaymentResultListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"n_onCreateView:(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;:GetOnCreateView_Landroid_view_LayoutInflater_Landroid_view_ViewGroup_Landroid_os_Bundle_Handler\n" +
			"n_onViewCreated:(Landroid/view/View;Landroid/os/Bundle;)V:GetOnViewCreated_Landroid_view_View_Landroid_os_Bundle_Handler\n" +
			"n_onLowMemory:()V:GetOnLowMemoryHandler\n" +
			"n_onPaymentError:(ILjava/lang/String;)V:GetOnPaymentError_ILjava_lang_String_Handler:Com.Razorpay.IPaymentResultListenerInvoker, Razorpay\n" +
			"n_onPaymentSuccess:(Ljava/lang/String;)V:GetOnPaymentSuccess_Ljava_lang_String_Handler:Com.Razorpay.IPaymentResultListenerInvoker, Razorpay\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Wallet.Fragment.AddFundsFragment, WoWonder", AddFundsFragment.class, __md_methods);
	}


	public AddFundsFragment ()
	{
		super ();
		if (getClass () == AddFundsFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Wallet.Fragment.AddFundsFragment, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public AddFundsFragment (int p0)
	{
		super (p0);
		if (getClass () == AddFundsFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Wallet.Fragment.AddFundsFragment, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);


	public android.view.View onCreateView (android.view.LayoutInflater p0, android.view.ViewGroup p1, android.os.Bundle p2)
	{
		return n_onCreateView (p0, p1, p2);
	}

	private native android.view.View n_onCreateView (android.view.LayoutInflater p0, android.view.ViewGroup p1, android.os.Bundle p2);


	public void onViewCreated (android.view.View p0, android.os.Bundle p1)
	{
		n_onViewCreated (p0, p1);
	}

	private native void n_onViewCreated (android.view.View p0, android.os.Bundle p1);


	public void onLowMemory ()
	{
		n_onLowMemory ();
	}

	private native void n_onLowMemory ();


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
