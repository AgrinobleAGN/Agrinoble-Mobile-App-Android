package crc644e62c38dd9bf4678;


public class FilterMarketDialogFragment
	extends com.google.android.material.bottomsheet.BottomSheetDialogFragment
	implements
		mono.android.IGCUserPeer,
		android.widget.SeekBar.OnSeekBarChangeListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreateView:(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;:GetOnCreateView_Landroid_view_LayoutInflater_Landroid_view_ViewGroup_Landroid_os_Bundle_Handler\n" +
			"n_onViewCreated:(Landroid/view/View;Landroid/os/Bundle;)V:GetOnViewCreated_Landroid_view_View_Landroid_os_Bundle_Handler\n" +
			"n_onProgressChanged:(Landroid/widget/SeekBar;IZ)V:GetOnProgressChanged_Landroid_widget_SeekBar_IZHandler:Android.Widget.SeekBar/IOnSeekBarChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"n_onStartTrackingTouch:(Landroid/widget/SeekBar;)V:GetOnStartTrackingTouch_Landroid_widget_SeekBar_Handler:Android.Widget.SeekBar/IOnSeekBarChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"n_onStopTrackingTouch:(Landroid/widget/SeekBar;)V:GetOnStopTrackingTouch_Landroid_widget_SeekBar_Handler:Android.Widget.SeekBar/IOnSeekBarChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Market.FilterMarketDialogFragment, WoWonder", FilterMarketDialogFragment.class, __md_methods);
	}


	public FilterMarketDialogFragment ()
	{
		super ();
		if (getClass () == FilterMarketDialogFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Market.FilterMarketDialogFragment, WoWonder", "", this, new java.lang.Object[] {  });
	}


	public android.view.View onCreateView (android.view.LayoutInflater p0, android.view.ViewGroup p1, android.os.Bundle p2)
	{
		return n_onCreateView (p0, p1, p2);
	}

	private native android.view.View n_onCreateView (android.view.LayoutInflater p0, android.view.ViewGroup p1, android.os.Bundle p2);


	public void onViewCreated (android.view.View p0, android.os.Bundle p1)
	{
		n_onViewCreated (p0, p1);
	}

	private native void n_onViewCreated (android.view.View p0, android.os.Bundle p1);


	public void onProgressChanged (android.widget.SeekBar p0, int p1, boolean p2)
	{
		n_onProgressChanged (p0, p1, p2);
	}

	private native void n_onProgressChanged (android.widget.SeekBar p0, int p1, boolean p2);


	public void onStartTrackingTouch (android.widget.SeekBar p0)
	{
		n_onStartTrackingTouch (p0);
	}

	private native void n_onStartTrackingTouch (android.widget.SeekBar p0);


	public void onStopTrackingTouch (android.widget.SeekBar p0)
	{
		n_onStopTrackingTouch (p0);
	}

	private native void n_onStopTrackingTouch (android.widget.SeekBar p0);

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
