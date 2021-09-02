package crc64c70108fd16c672e7;


public class FileUploaderPresenter_b
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		io.reactivex.functions.Action
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_run:()V:GetRunHandler:ReactiveX.Functions.IActionInvoker, Xamarin.Android.ReactiveX.RxJava\n" +
			"";
		mono.android.Runtime.register ("WoWonderClient.JobWorker.FileUploaderPresenter+b, WoWonderClient", FileUploaderPresenter_b.class, __md_methods);
	}


	public FileUploaderPresenter_b ()
	{
		super ();
		if (getClass () == FileUploaderPresenter_b.class)
			mono.android.TypeManager.Activate ("WoWonderClient.JobWorker.FileUploaderPresenter+b, WoWonderClient", "", this, new java.lang.Object[] {  });
	}


	public void run ()
	{
		n_run ();
	}

	private native void n_run ();

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
