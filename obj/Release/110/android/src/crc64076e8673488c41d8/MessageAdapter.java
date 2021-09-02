package crc64076e8673488c41d8;


public class MessageAdapter
	extends androidx.recyclerview.widget.RecyclerView.Adapter
	implements
		mono.android.IGCUserPeer,
		com.bumptech.glide.ListPreloader.PreloadModelProvider
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreateViewHolder:(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;:GetOnCreateViewHolder_Landroid_view_ViewGroup_IHandler\n" +
			"n_onBindViewHolder:(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V:GetOnBindViewHolder_Landroidx_recyclerview_widget_RecyclerView_ViewHolder_IHandler\n" +
			"n_onBindViewHolder:(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V:GetOnBindViewHolder_Landroidx_recyclerview_widget_RecyclerView_ViewHolder_ILjava_util_List_Handler\n" +
			"n_getItemCount:()I:GetGetItemCountHandler\n" +
			"n_getItemId:(I)J:GetGetItemId_IHandler\n" +
			"n_getItemViewType:(I)I:GetGetItemViewType_IHandler\n" +
			"n_getPreloadItems:(I)Ljava/util/List;:GetGetPreloadItems_IHandler:Bumptech.Glide.ListPreloader/IPreloadModelProviderInvoker, Xamarin.Android.Glide\n" +
			"n_getPreloadRequestBuilder:(Ljava/lang/Object;)Lcom/bumptech/glide/RequestBuilder;:GetGetPreloadRequestBuilder_Ljava_lang_Object_Handler:Bumptech.Glide.ListPreloader/IPreloadModelProviderInvoker, Xamarin.Android.Glide\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.Chat.ChatWindow.Adapters.MessageAdapter, WoWonder", MessageAdapter.class, __md_methods);
	}


	public MessageAdapter ()
	{
		super ();
		if (getClass () == MessageAdapter.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.ChatWindow.Adapters.MessageAdapter, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public MessageAdapter (android.app.Activity p0, java.lang.String p1, boolean p2)
	{
		super ();
		if (getClass () == MessageAdapter.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.Chat.ChatWindow.Adapters.MessageAdapter, WoWonder", "Android.App.Activity, Mono.Android:System.String, mscorlib:System.Boolean, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder (android.view.ViewGroup p0, int p1)
	{
		return n_onCreateViewHolder (p0, p1);
	}

	private native androidx.recyclerview.widget.RecyclerView.ViewHolder n_onCreateViewHolder (android.view.ViewGroup p0, int p1);


	public void onBindViewHolder (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1)
	{
		n_onBindViewHolder (p0, p1);
	}

	private native void n_onBindViewHolder (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1);


	public void onBindViewHolder (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1, java.util.List p2)
	{
		n_onBindViewHolder (p0, p1, p2);
	}

	private native void n_onBindViewHolder (androidx.recyclerview.widget.RecyclerView.ViewHolder p0, int p1, java.util.List p2);


	public int getItemCount ()
	{
		return n_getItemCount ();
	}

	private native int n_getItemCount ();


	public long getItemId (int p0)
	{
		return n_getItemId (p0);
	}

	private native long n_getItemId (int p0);


	public int getItemViewType (int p0)
	{
		return n_getItemViewType (p0);
	}

	private native int n_getItemViewType (int p0);


	public java.util.List getPreloadItems (int p0)
	{
		return n_getPreloadItems (p0);
	}

	private native java.util.List n_getPreloadItems (int p0);


	public com.bumptech.glide.RequestBuilder getPreloadRequestBuilder (java.lang.Object p0)
	{
		return n_getPreloadRequestBuilder (p0);
	}

	private native com.bumptech.glide.RequestBuilder n_getPreloadRequestBuilder (java.lang.Object p0);

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
