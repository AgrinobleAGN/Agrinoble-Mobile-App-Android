package crc64e3f0aab333e84ad0;


public class PopupDialogController_TimePickerFragment
	extends androidx.fragment.app.DialogFragment
	implements
		mono.android.IGCUserPeer,
		android.app.TimePickerDialog.OnTimeSetListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreateDialog:(Landroid/os/Bundle;)Landroid/app/Dialog;:GetOnCreateDialog_Landroid_os_Bundle_Handler\n" +
			"n_onTimeSet:(Landroid/widget/TimePicker;II)V:GetOnTimeSet_Landroid_widget_TimePicker_IIHandler:Android.App.TimePickerDialog/IOnTimeSetListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Helpers.Controller.PopupDialogController+TimePickerFragment, WoWonder", PopupDialogController_TimePickerFragment.class, __md_methods);
	}


	public PopupDialogController_TimePickerFragment ()
	{
		super ();
		if (getClass () == PopupDialogController_TimePickerFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Controller.PopupDialogController+TimePickerFragment, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public PopupDialogController_TimePickerFragment (int p0)
	{
		super (p0);
		if (getClass () == PopupDialogController_TimePickerFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Helpers.Controller.PopupDialogController+TimePickerFragment, WoWonder", "System.Int32, mscorlib", this, new java.lang.Object[] { p0 });
	}


	public android.app.Dialog onCreateDialog (android.os.Bundle p0)
	{
		return n_onCreateDialog (p0);
	}

	private native android.app.Dialog n_onCreateDialog (android.os.Bundle p0);


	public void onTimeSet (android.widget.TimePicker p0, int p1, int p2)
	{
		n_onTimeSet (p0, p1, p2);
	}

	private native void n_onTimeSet (android.widget.TimePicker p0, int p1, int p2);

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
