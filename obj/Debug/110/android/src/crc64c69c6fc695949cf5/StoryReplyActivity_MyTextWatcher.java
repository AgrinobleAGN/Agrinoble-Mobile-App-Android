package crc64c69c6fc695949cf5;


public class StoryReplyActivity_MyTextWatcher
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		android.text.TextWatcher,
		android.text.NoCopySpan
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_afterTextChanged:(Landroid/text/Editable;)V:GetAfterTextChanged_Landroid_text_Editable_Handler:Android.Text.ITextWatcherInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"n_beforeTextChanged:(Ljava/lang/CharSequence;III)V:GetBeforeTextChanged_Ljava_lang_CharSequence_IIIHandler:Android.Text.ITextWatcherInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"n_onTextChanged:(Ljava/lang/CharSequence;III)V:GetOnTextChanged_Ljava_lang_CharSequence_IIIHandler:Android.Text.ITextWatcherInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Story.StoryReplyActivity+MyTextWatcher, WoWonder", StoryReplyActivity_MyTextWatcher.class, __md_methods);
	}


	public StoryReplyActivity_MyTextWatcher ()
	{
		super ();
		if (getClass () == StoryReplyActivity_MyTextWatcher.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Story.StoryReplyActivity+MyTextWatcher, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public StoryReplyActivity_MyTextWatcher (crc64c69c6fc695949cf5.StoryReplyActivity p0)
	{
		super ();
		if (getClass () == StoryReplyActivity_MyTextWatcher.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Story.StoryReplyActivity+MyTextWatcher, WoWonder", "WoWonder.Activities.Story.StoryReplyActivity, WoWonder", this, new java.lang.Object[] { p0 });
	}


	public void afterTextChanged (android.text.Editable p0)
	{
		n_afterTextChanged (p0);
	}

	private native void n_afterTextChanged (android.text.Editable p0);


	public void beforeTextChanged (java.lang.CharSequence p0, int p1, int p2, int p3)
	{
		n_beforeTextChanged (p0, p1, p2, p3);
	}

	private native void n_beforeTextChanged (java.lang.CharSequence p0, int p1, int p2, int p3);


	public void onTextChanged (java.lang.CharSequence p0, int p1, int p2, int p3)
	{
		n_onTextChanged (p0, p1, p2, p3);
	}

	private native void n_onTextChanged (java.lang.CharSequence p0, int p1, int p2, int p3);

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
