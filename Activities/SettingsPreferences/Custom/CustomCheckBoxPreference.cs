using System;
using Android.Content;
using Android.Graphics;
using Android.Widget;
using AndroidX.Preference;
using WoWonder.Helpers.Utils;

namespace WoWonder.Activities.SettingsPreferences.Custom
{
    public class CustomCheckBoxPreference : CheckBoxPreference
    {
        public CustomCheckBoxPreference(Context context) : base(context)
        {

        }

        public CustomCheckBoxPreference(Context context, Android.Util.IAttributeSet attrs) : base(context, attrs)
        {
            try
            {
                LayoutResource = Resource.Layout.SettingCheckboxPreference;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }

        public override void OnBindViewHolder(PreferenceViewHolder holder)
        {
            try
            {
                base.OnBindViewHolder(holder);

                holder.ItemView.SetBackgroundColor(AppSettings.SetTabDarkTheme ? Color.ParseColor("#444444") : Color.ParseColor("#ffffff"));

                var title = holder.ItemView.FindViewById<TextView>(Resource.Id.title);
                title.SetTextColor(AppSettings.SetTabDarkTheme ? Color.ParseColor("#ffffff") : Color.ParseColor("#444444"));
                title.Text = Title;

                var check = holder.ItemView.FindViewById<CheckBox>(Resource.Id.check);
                check.Checked = Checked;
            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
    }
}