package mono.com.sothree.slidinguppanel;


public class SlidingUpPanelLayout_PanelSlideListenerImplementor
	extends java.lang.Object
	implements
		mono.android.IGCUserPeer,
		com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onPanelSlide:(Landroid/view/View;F)V:GetOnPanelSlide_Landroid_view_View_FHandler:Com.Sothree.Slidinguppanel.SlidingUpPanelLayout/IPanelSlideListenerInvoker, Xamarin.Bindings.AndroidSlidingUpPanel\n" +
			"n_onPanelStateChanged:(Landroid/view/View;Lcom/sothree/slidinguppanel/SlidingUpPanelLayout$PanelState;Lcom/sothree/slidinguppanel/SlidingUpPanelLayout$PanelState;)V:GetOnPanelStateChanged_Landroid_view_View_Lcom_sothree_slidinguppanel_SlidingUpPanelLayout_PanelState_Lcom_sothree_slidinguppanel_SlidingUpPanelLayout_PanelState_Handler:Com.Sothree.Slidinguppanel.SlidingUpPanelLayout/IPanelSlideListenerInvoker, Xamarin.Bindings.AndroidSlidingUpPanel\n" +
			"";
		mono.android.Runtime.register ("Com.Sothree.Slidinguppanel.SlidingUpPanelLayout+IPanelSlideListenerImplementor, Xamarin.Bindings.AndroidSlidingUpPanel", SlidingUpPanelLayout_PanelSlideListenerImplementor.class, __md_methods);
	}


	public SlidingUpPanelLayout_PanelSlideListenerImplementor ()
	{
		super ();
		if (getClass () == SlidingUpPanelLayout_PanelSlideListenerImplementor.class)
			mono.android.TypeManager.Activate ("Com.Sothree.Slidinguppanel.SlidingUpPanelLayout+IPanelSlideListenerImplementor, Xamarin.Bindings.AndroidSlidingUpPanel", "", this, new java.lang.Object[] {  });
	}


	public void onPanelSlide (android.view.View p0, float p1)
	{
		n_onPanelSlide (p0, p1);
	}

	private native void n_onPanelSlide (android.view.View p0, float p1);


	public void onPanelStateChanged (android.view.View p0, com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState p1, com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState p2)
	{
		n_onPanelStateChanged (p0, p1, p2);
	}

	private native void n_onPanelStateChanged (android.view.View p0, com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState p1, com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState p2);

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
