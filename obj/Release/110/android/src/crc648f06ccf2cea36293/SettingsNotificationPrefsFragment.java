package crc648f06ccf2cea36293;


public class SettingsNotificationPrefsFragment
	extends androidx.preference.PreferenceFragmentCompat
	implements
		mono.android.IGCUserPeer,
		android.content.SharedPreferences.OnSharedPreferenceChangeListener
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreateView:(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;:GetOnCreateView_Landroid_view_LayoutInflater_Landroid_view_ViewGroup_Landroid_os_Bundle_Handler\n" +
			"n_onCreatePreferences:(Landroid/os/Bundle;Ljava/lang/String;)V:GetOnCreatePreferences_Landroid_os_Bundle_Ljava_lang_String_Handler\n" +
			"n_onResume:()V:GetOnResumeHandler\n" +
			"n_onPause:()V:GetOnPauseHandler\n" +
			"n_onLowMemory:()V:GetOnLowMemoryHandler\n" +
			"n_onSharedPreferenceChanged:(Landroid/content/SharedPreferences;Ljava/lang/String;)V:GetOnSharedPreferenceChanged_Landroid_content_SharedPreferences_Ljava_lang_String_Handler:Android.Content.ISharedPreferencesOnSharedPreferenceChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.SettingsPreferences.Notification.SettingsNotificationPrefsFragment, WoWonder", SettingsNotificationPrefsFragment.class, __md_methods);
	}


	public SettingsNotificationPrefsFragment ()
	{
		super ();
		if (getClass () == SettingsNotificationPrefsFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.SettingsPreferences.Notification.SettingsNotificationPrefsFragment, WoWonder", "", this, new java.lang.Object[] {  });
	}

	public SettingsNotificationPrefsFragment (android.app.Activity p0)
	{
		super ();
		if (getClass () == SettingsNotificationPrefsFragment.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.SettingsPreferences.Notification.SettingsNotificationPrefsFragment, WoWonder", "Android.App.Activity, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public android.view.View onCreateView (android.view.LayoutInflater p0, android.view.ViewGroup p1, android.os.Bundle p2)
	{
		return n_onCreateView (p0, p1, p2);
	}

	private native android.view.View n_onCreateView (android.view.LayoutInflater p0, android.view.ViewGroup p1, android.os.Bundle p2);


	public void onCreatePreferences (android.os.Bundle p0, java.lang.String p1)
	{
		n_onCreatePreferences (p0, p1);
	}

	private native void n_onCreatePreferences (android.os.Bundle p0, java.lang.String p1);


	public void onResume ()
	{
		n_onResume ();
	}

	private native void n_onResume ();


	public void onPause ()
	{
		n_onPause ();
	}

	private native void n_onPause ();


	public void onLowMemory ()
	{
		n_onLowMemory ();
	}

	private native void n_onLowMemory ();


	public void onSharedPreferenceChanged (android.content.SharedPreferences p0, java.lang.String p1)
	{
		n_onSharedPreferenceChanged (p0, p1);
	}

	private native void n_onSharedPreferenceChanged (android.content.SharedPreferences p0, java.lang.String p1);

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
