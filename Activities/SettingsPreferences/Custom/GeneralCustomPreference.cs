using System;
using Android.Content;
using Android.Widget;
using AndroidX.Preference;
using WoWonder.Helpers.Utils;

namespace WoWonder.Activities.SettingsPreferences.Custom
{
    public class GeneralCustomPreference : Preference
    {
        public GeneralCustomPreference(Context context) : base(context)
        {

        }

        public GeneralCustomPreference(Context context, Android.Util.IAttributeSet attrs) : base(context, attrs)
        {
            try
            {
                LayoutResource = Resource.Layout.SettingGeneralPreference;
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

                var title = holder.ItemView.FindViewById<TextView>(Resource.Id.title);
                title.Text = Title;

            }
            catch (Exception e)
            {
                Methods.DisplayReportResultTrack(e);
            }
        }
    }
}