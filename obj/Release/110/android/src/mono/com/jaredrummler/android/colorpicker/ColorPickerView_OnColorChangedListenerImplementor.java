package mono.com.jaredrummler.android.colorpicker;


public class ColorPickerView_OnColorChangedListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.jaredrummler.android.colorpicker.ColorPickerView.OnColorChangedListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onColorChanged:(I)V:GetOnColorChanged_IHandler:JaredRummler.Android.ColorPicker.ColorPickerView/IOnColorChangedListenerInvoker, JaredRummler.ColorPicker\n" +
			"";
		mono.android.Runtime.register ("JaredRummler.Android.ColorPicker.ColorPickerView+IOnColorChangedListenerImplementor, JaredRummler.ColorPicker", ColorPickerView_OnColorChangedListenerImplementor.class, __md_methods);
	}


	public ColorPickerView_OnColorChangedListenerImplementor ()
	{
		super ();
		if (getClass () == ColorPickerView_OnColorChangedListenerImplementor.class)
			mono.android.TypeManager.Activate ("JaredRummler.Android.ColorPicker.ColorPickerView+IOnColorChangedListenerImplementor, JaredRummler.ColorPicker", "", this, new java.lang.Object[] {  });
	}


	public void onColorChanged (int p0)
	{
		n_onColorChanged (p0);
	}

	private native void n_onColorChanged (int p0);

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
