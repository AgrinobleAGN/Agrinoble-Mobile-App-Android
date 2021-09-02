using System.Collections.Generic;
using WoWonderClient.Classes.Global;

namespace WoWonder.Activities.Communities.Adapters
{
    public enum SocialModelType
    {
        MangedGroups = 100,
        JoinedGroups = 200,
        SuggestedGroups = 300,
        MangedPages = 400,
        LikedPages = 500,
        SuggestedPages = 600,

        Section = 10,
        Divider = 20,
    }

    public class SocialModelsClass
    {
        public long Id { get; set; }
        public SocialModelType TypeView { get; set; }
        public List<PageClass> PageList { get; set; }
        public List<PageClass> SuggestedPageList { get; set; }
        public List<GroupClass> SuggestedGroupList { get; set; }

        public PageClass Page { get; set; }
        public GroupClass Group { get; set; }

        public string TitleHead { get; set; }
        public string MoreIcon { get; set; }
    }

}