package mono.com.jaredrummler.android.colorpicker;


public class ColorPickerDialogListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.jaredrummler.android.colorpicker.ColorPickerDialogListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onColorSelected:(II)V:GetOnColorSelected_IIHandler:JaredRummler.Android.ColorPicker.IColorPickerDialogListenerInvoker, JaredRummler.ColorPicker\n" +
			"n_onDialogDismissed:(I)V:GetOnDialogDismissed_IHandler:JaredRummler.Android.ColorPicker.IColorPickerDialogListenerInvoker, JaredRummler.ColorPicker\n" +
			"";
		mono.android.Runtime.register ("JaredRummler.Android.ColorPicker.IColorPickerDialogListenerImplementor, JaredRummler.ColorPicker", ColorPickerDialogListenerImplementor.class, __md_methods);
	}


	public ColorPickerDialogListenerImplementor ()
	{
		super ();
		if (getClass () == ColorPickerDialogListenerImplementor.class)
			mono.android.TypeManager.Activate ("JaredRummler.Android.ColorPicker.IColorPickerDialogListenerImplementor, JaredRummler.ColorPicker", "", this, new java.lang.Object[] {  });
	}


	public void onColorSelected (int p0, int p1)
	{
		n_onColorSelected (p0, p1);
	}

	private native void n_onColorSelected (int p0, int p1);


	public void onDialogDismissed (int p0)
	{
		n_onDialogDismissed (p0);
	}

	private native void n_onDialogDismissed (int p0);

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
