package crc643337d088ce3a2c11;


public class CustomSwitchPreference
	extends androidx.preference.SwitchPreferenceCompat
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onBindViewHolder:(Landroidx/preference/PreferenceViewHolder;)V:GetOnBindViewHolder_Landroidx_preference_PreferenceViewHolder_Handler\n" +
			"";
		mono.android.Runtime.register ("WoWonder.Activities.SettingsPreferences.Custom.CustomSwitchPreference, WoWonder", CustomSwitchPreference.class, __md_methods);
	}


	public CustomSwitchPreference (android.content.Context p0)
	{
		super (p0);
		if (getClass () == CustomSwitchPreference.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.SettingsPreferences.Custom.CustomSwitchPreference, WoWonder", "Android.Content.Context, Mono.Android", this, new java.lang.Object[] { p0 });
	}


	public CustomSwitchPreference (android.content.Context p0, android.util.AttributeSet p1)
	{
		super (p0, p1);
		if (getClass () == CustomSwitchPreference.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.SettingsPreferences.Custom.CustomSwitchPreference, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new java.lang.Object[] { p0, p1 });
	}


	public CustomSwitchPreference (android.content.Context p0, android.util.AttributeSet p1, int p2)
	{
		super (p0, p1, p2);
		if (getClass () == CustomSwitchPreference.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.SettingsPreferences.Custom.CustomSwitchPreference, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2 });
	}


	public CustomSwitchPreference (android.content.Context p0, android.util.AttributeSet p1, int p2, int p3)
	{
		super (p0, p1, p2, p3);
		if (getClass () == CustomSwitchPreference.class)
			mono.android.TypeManager.Activate ("WoWonder.Activities.SettingsPreferences.Custom.CustomSwitchPreference, WoWonder", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib:System.Int32, mscorlib", this, new java.lang.Object[] { p0, p1, p2, p3 });
	}


	public void onBindViewHolder (androidx.preference.PreferenceViewHolder p0)
	{
		n_onBindViewHolder (p0);
	}

	private native void n_onBindViewHolder (androidx.preference.PreferenceViewHolder p0);

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
