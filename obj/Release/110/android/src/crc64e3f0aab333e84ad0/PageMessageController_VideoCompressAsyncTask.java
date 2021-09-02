package crc64e3f0aab333e84ad0;


public class PageMessageController_VideoCompressAsyncTask
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
		mono.android.Runtime.register ("WoWonder.Helpers.Controller.PageMessageController+VideoCompressAsyncTask, WoWonder", PageMessageController_VideoCompressAsyncTask.class, __md_methods);
	}


	public PageMessageController_VideoCompressAsyncTask ()
	{
		super ();
		if (getClass () == PageMessageController_VideoCompressAsyncTask.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Controller.PageMessageController+VideoCompressAsyncTask, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public PageMessageController_VideoCompressAsyncTask (crc649ac6f0c158e0b1b4.PageChatWindowActivity p0, java.lang.String p1, java.lang.String p2, java.lang.String p3, java.lang.String p4, java.lang.String p5, java.lang.String p6, java.lang.String p7)
	{
		super ();
		if (getClass () == PageMessageController_VideoCompressAsyncTask.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Controller.PageMessageController+VideoCompressAsyncTask, WoWonder", "WoWonder.Activities.Chat.PageChat.PageChatWindowActivity, WoWonder:System.String, mscorlib:System.String, mscorlib:System.String, mscorlib:System.String, mscorlib:System.String, mscorlib:System.String, mscorlib:System.String, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3, p4, p5, p6, p7 });
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
