package crc64c70108fd16c672e7;


public class FileUploaderPresenter_a
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		io.reactivex.functions.Consumer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_accept:(Ljava/lang/Object;)V:GetAccept_Ljava_lang_Object_Handler:ReactiveX.Functions.IConsumerInvoker, Xamarin.Android.ReactiveX.RxJava\n" +
			"";
		mono.android.Runtime.register ("WoWonderClient.JobWorker.FileUploaderPresenter+a, WoWonderClient", FileUploaderPresenter_a.class, __md_methods);
	}


	public FileUploaderPresenter_a ()
	{
		super ();
		if (getClass () == FileUploaderPresenter_a.class)
			mono.android.TypeManager.Activate ("WoWonderClient.JobWorker.FileUploaderPresenter+a, WoWonderClient", "", this, new java.lang.Object[] {  });
	}


	public void accept (java.lang.Object p0)
	{
		n_accept (p0);
	}

	private native void n_accept (java.lang.Object p0);

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
