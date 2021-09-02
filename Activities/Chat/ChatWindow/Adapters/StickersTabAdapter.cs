using System;
using System.Collections.Generic;
using Android.Runtime;
using AndroidX.Fragment.App;
using AndroidX.Lifecycle;
using AndroidX.ViewPager2.Adapter;
using WoWonder.Helpers.Utils;

namespace WoWonder.Activities.Chat.ChatWindow.Adapters
{
    public class StickersTabAdapter : FragmentStateAdapter
    {
        public List<AndroidX.Fragment.App.Fragment> Fragments { get; set; }
        public List<string> FragmentNames { get; set; }

        public StickersTabAdapter(IntPtr javaReference, JniHandleOwnership transfer) : base(javaReference, transfer)
        {
        }

        public StickersTabAdapter(AndroidX.Fragment.App.Fragment fragment) : base(fragment)
        {
            Fragments = new List<AndroidX.Fragment.App.Fragment>();
            FragmentNames = new List<string>();
        }

        public StickersTabAdapter(FragmentActivity fragmentActivity) : base(fragmentActivity)
        {
            Fragments = new List<AndroidX.Fragment.App.Fragment>();
            FragmentNames = new List<string>();
        }

        public StickersTabAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) : base(fragmentManager, lifecycle)
        {
            Fragments = new List<AndroidX.Fragment.App.Fragment>();
            FragmentNames = new List<string>();
        }

        public override int ItemCount { get; }
        public override AndroidX.Fragment.App.Fragment CreateFragment(int position)
        {
            return Fragments[position];
        }

        public string GetFragment(int position)
        {
            try
            {
                if (FragmentNames[position] != null)
                {
                    return FragmentNames[position];
                }
                else
                {
                    return FragmentNames[0];
                }
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
                return "";
            }
        }

        public void AddFragment(AndroidX.Fragment.App.Fragment fragment, string name)
        {
            try
            {
                Fragments.Add(fragment);
                FragmentNames.Add(name);
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        public void ClaerFragment()
        {
            try
            {
                Fragments.Clear();
                FragmentNames.Clear();
                NotifyDataSetChanged();
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        public void RemoveFragment(AndroidX.Fragment.App.Fragment fragment, string name)
        {
            try
            {
                Fragments.Remove(fragment);
                FragmentNames.Remove(name);
                NotifyDataSetChanged();
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }

        public void InsertFragment(int index, AndroidX.Fragment.App.Fragment fragment, string name)
        {
            try
            {
                Fragments.Insert(index, fragment);
                FragmentNames.Insert(index, name);
            }
            catch (Exception exception)
            {
                Methods.DisplayReportResultTrack(exception);
            }
        }


    }
}