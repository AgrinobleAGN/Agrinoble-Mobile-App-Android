package crc64c70108fd16c672e7;


public class CountingRequestBody_a
	extends okio.ForwardingSink
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_write:(Lokio/Buffer;J)V:GetWrite_Lokio_Buffer_JHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonderClient.JobWorker.CountingRequestBody+a, WoWonderClient", CountingRequestBody_a.class, __md_methods);
	}


	public CountingRequestBody_a (okio.Sink p0)
	{
		super (p0);
		if (getClass () == CountingRequestBody_a.class)
			mono.android.TypeManager.Activate ("WoWonderClient.JobWorker.CountingRequestBody+a, WoWonderClient", "Square.OkIO.ISink, Square.OkIO", this, new java.lang.Object[] { p0 });
	}


	public void write (okio.Buffer p0, long p1)
	{
		n_write (p0, p1);
	}

	private native void n_write (okio.Buffer p0, long p1);

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
