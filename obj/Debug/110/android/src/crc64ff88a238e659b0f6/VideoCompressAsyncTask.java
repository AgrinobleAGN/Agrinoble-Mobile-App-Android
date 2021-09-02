package crc64ff88a238e659b0f6;


public class VideoCompressAsyncTask
	extends android.os.AsyncTask
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_doInBackground:([Ljava/lang/Object;)Ljava/lang/Object;:GetDoInBackground_arrayLjava_lang_Object_Handler\n" +
			"n_onPostExecute:(Ljava/lang/Object;)V:GetOnPostExecute_Ljava_lang_Object_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.AddPost.Service.VideoCompressAsyncTask, WoWonder", VideoCompressAsyncTask.class, __md_methods);
	}


	public VideoCompressAsyncTask ()
	{
		super ();
		if (getClass () == VideoCompressAsyncTask.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.AddPost.Service.VideoCompressAsyncTask, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public VideoCompressAsyncTask (android.content.Context p0)
	{
		super ();
		if (getClass () == VideoCompressAsyncTask.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.AddPost.Service.VideoCompressAsyncTask, WoWonder", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public java.lang.Object doInBackground (java.lang.Object[] p0)
	{
		return n_doInBackground (p0);
	}

	private native java.lang.Object n_doInBackground (java.lang.Object[] p0);


	public void onPostExecute (java.lang.Object p0)
	{
		n_onPostExecute (p0);
	}

	private native void n_onPostExecute (java.lang.Object p0);

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
