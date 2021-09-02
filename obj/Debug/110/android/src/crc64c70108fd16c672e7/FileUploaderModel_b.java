package crc64c70108fd16c672e7;


public class FileUploaderModel_b
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		io.reactivex.FlowableOnSubscribe
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_subscribe:(Lio/reactivex/FlowableEmitter;)V:GetSubscribe_Lio_reactivex_FlowableEmitter_Handler:ReactiveX.IFlowableOnSubscribeInvoker, Xamarin.Android.ReactiveX.RxJava\n" +
			"";
		mono.android.Runtime.register ("WoWonderClient.JobWorker.FileUploaderModel+b, WoWonderClient", FileUploaderModel_b.class, __md_methods);
	}


	public FileUploaderModel_b ()
	{
		super ();
		if (getClass () == FileUploaderModel_b.class)
			mono.android.TypeManager.Activate ("WoWonderClient.JobWorker.FileUploaderModel+b, WoWonderClient", "", this, new java.lang.Object[] {  });
	}


	public void subscribe (io.reactivex.FlowableEmitter p0)
	{
		n_subscribe (p0);
	}

	private native void n_subscribe (io.reactivex.FlowableEmitter p0);

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
