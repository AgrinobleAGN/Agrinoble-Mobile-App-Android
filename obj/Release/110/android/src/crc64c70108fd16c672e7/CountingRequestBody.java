package crc64c70108fd16c672e7;


public class CountingRequestBody
	extends okhttp3.RequestBody
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_contentType:()Lokhttp3/MediaType;:GetContentTypeHandler\n" +
			"n_contentLength:()J:GetContentLengthHandler\n" +
			"n_writeTo:(Lokio/BufferedSink;)V:GetWriteTo_Lokio_BufferedSink_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonderClient.JobWorker.CountingRequestBody, WoWonderClient", CountingRequestBody.class, __md_methods);
	}


	public CountingRequestBody ()
	{
		super ();
		if (getClass () == CountingRequestBody.class)
			mono.android.TypeManager.Activate ("WoWonderClient.JobWorker.CountingRequestBody, WoWonderClient", "", this, new java.lang.Object[] {  });
	}


	public okhttp3.MediaType contentType ()
	{
		return n_contentType ();
	}

	private native okhttp3.MediaType n_contentType ();


	public long contentLength ()
	{
		return n_contentLength ();
	}

	private native long n_contentLength ();


	public void writeTo (okio.BufferedSink p0)
	{
		n_writeTo (p0);
	}

	private native void n_writeTo (okio.BufferedSink p0);

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
