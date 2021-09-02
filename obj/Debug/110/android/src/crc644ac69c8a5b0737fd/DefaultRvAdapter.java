package crc644ac69c8a5b0737fd;


public class DefaultRvAdapter
	extends androidx.recyclerview.widget.RecyclerView.Adapter
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onBindViewHolder:(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V:GetOnBindViewHolder_Landroidx_recyclerview_widget_RecyclerView_ViewHolder_IHandler\n" +
			"n_onCreateViewHolder:(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;:GetOnCreateViewHolder_Landroid_view_ViewGroup_IHandler\n" +
			"n_getItemCount:()I:GetGetItemCountHandler\n" +
			"";
		mono.android.Runtime.register ("MaterialDialogsCore.DefaultRvAdapter, MaterialDialogsCore", DefaultRvAdapter.class, __md_methods);
	}


	public DefaultRvAdapter ()
	{
		super ();
		if (getClass () == DefaultRvAdapter.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.DefaultRvAdapter, MaterialDialogsCore", "", this, new java.lang.Object[] {  });
	}

	public DefaultRvAdapter (crc644ac69c8a5b0737fd.MaterialDialog p0, int p1)
	{
		super ();
		if (getClass () == DefaultRvAdapter.class)
			mono.android.TypeManager.Activate ("MaterialDialogsCore.DefaultRvAdapter, MaterialDialogsCore", "MaterialDialogsCore.MaterialDialog, MaterialDialogsCore:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1 });
	}


	public void onBindViewHolder (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1)
	{
		n_onBindViewHolder (p0, p1);
	}

	private native void n_onBindViewHolder (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1);


	public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder (android.view.ViewGroup p0, int p1)
	{
		return n_onCreateViewHolder (p0, p1);
	}

	private native androidx.recyclerview.widget.RecyclerView.ViewHolder n_onCreateViewHolder (android.view.ViewGroup p0, int p1);


	public int getItemCount ()
	{
		return n_getItemCount ();
	}

	private native int n_getItemCount ();

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
