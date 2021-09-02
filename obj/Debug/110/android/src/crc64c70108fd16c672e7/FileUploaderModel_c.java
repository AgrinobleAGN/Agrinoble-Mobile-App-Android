package crc64c70108fd16c672e7;


public class FileUploaderModel_c
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		io.reactivex.SingleOnSubscribe
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_subscribe:(Lio/reactivex/SingleEmitter;)V:GetSubscribe_Lio_reactivex_SingleEmitter_Handler:ReactiveX.ISingleOnSubscribeInvoker, Xamarin.Android.ReactiveX.RxJava\n" +
			"";
		mono.android.Runtime.register ("WoWonderClient.JobWorker.FileUploaderModel+c, WoWonderClient", FileUploaderModel_c.class, __md_methods);
	}


	public FileUploaderModel_c ()
	{
		super ();
		if (getClass () == FileUploaderModel_c.class)
			mono.android.TypeManager.Activate ("WoWonderClient.JobWorker.FileUploaderModel+c, WoWonderClient", "", this, new java.lang.Object[] {  });
	}


	public void subscribe (io.reactivex.SingleEmitter p0)
	{
		n_subscribe (p0);
	}

	private native void n_subscribe (io.reactivex.SingleEmitter p0);

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
