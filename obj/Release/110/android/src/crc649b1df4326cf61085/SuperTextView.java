package crc649b1df4326cf61085;


public class SuperTextView
	extends android.widget.TextView
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_setText:(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V:GetSetText_Ljava_lang_CharSequence_Landroid_widget_TextView_BufferType_Handler\n" +
			"n_onMeasure:(II)V:GetOnMeasure_IIHandler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Library.Anjo.SuperTextLibrary.SuperTextView, WoWonder", SuperTextView.class, __md_methods);
	}


	public SuperTextView (android.content.Context p0)
	{
		super (p0);
		if (getClass () == SuperTextView.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.SuperTextLibrary.SuperTextView, WoWonder", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public SuperTextView (android.content.Context p0, android.util.AttributeSet p1)
	{
		super (p0, p1);
		if (getClass () == SuperTextView.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.SuperTextLibrary.SuperTextView, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public SuperTextView (android.content.Context p0, android.util.AttributeSet p1, int p2)
	{
		super (p0, p1, p2);
		if (getClass () == SuperTextView.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.SuperTextLibrary.SuperTextView, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public SuperTextView (android.content.Context p0, android.util.AttributeSet p1, int p2, int p3)
	{
		super (p0, p1, p2, p3);
		if (getClass () == SuperTextView.class)
			mono.android.TypeManager.Activate ("WoWonder.Library.Anjo.SuperTextLibrary.SuperTextView, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public void setText (java.lang.CharSequence p0, android.widget.TextView.BufferType p1)
	{
		n_setText (p0, p1);
	}

	private native void n_setText (java.lang.CharSequence p0, android.widget.TextView.BufferType p1);


	public void onMeasure (int p0, int p1)
	{
		n_onMeasure (p0, p1);
	}

	private native void n_onMeasure (int p0, int p1);

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
