package crc64425a0e16e43a95fc;


public class TextViewWithImages
	extends androidx.appcompat.widget.AppCompatTextView
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_setText:(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V:GetSetText_Ljava_lang_CharSequence_Landroid_widget_TextView_BufferType_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Fonts.TextViewWithImages, WoWonder", TextViewWithImages.class, __md_methods);
	}


	public TextViewWithImages (android.content.Context p0)
	{
		super (p0);
		if (getClass () == TextViewWithImages.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Fonts.TextViewWithImages, WoWonder", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public TextViewWithImages (android.content.Context p0, android.util.AttributeSet p1)
	{
		super (p0, p1);
		if (getClass () == TextViewWithImages.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Fonts.TextViewWithImages, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public TextViewWithImages (android.content.Context p0, android.util.AttributeSet p1, int p2)
	{
		super (p0, p1, p2);
		if (getClass () == TextViewWithImages.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Fonts.TextViewWithImages, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public void setText (java.lang.CharSequence p0, android.widget.TextView.BufferType p1)
	{
		n_setText (p0, p1);
	}

	private native void n_setText (java.lang.CharSequence p0, android.widget.TextView.BufferType p1);

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
