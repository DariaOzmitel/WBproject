package com.example.wbproject.navigation

sealed class Screen(
    val route: String
) {
    data object Splash : Screen(ROUTE_SPLASH)
    data object Meetings : Screen(ROUTE_MEETINGS)
    data object MeetingsList : Screen(ROUTE_MEETINGS_LIST)
    data object MeetingDetail : Screen(ROUTE_MEETING_DETAIL)
    data object CommunityList : Screen(ROUTE_COMMUNITY_LIST)
    data object Community : Screen(ROUTE_COMMUNITY)
    data object CommunityDetail : Screen(ROUTE_COMMUNITY_DETAIL)
    data object More : Screen(ROUTE_MORE)
    data object MoreMenu : Screen(ROUTE_MORE_MENU)
    data object Profile : Screen(ROUTE_PROFILE)
    data object MyMeetings : Screen(ROUTE_MY_MEETINGS)

    private companion object {
        const val ROUTE_MEETINGS = "meetings"
        const val ROUTE_SPLASH = "splash"
        const val ROUTE_MEETING_DETAIL = "meeting detail"
        const val ROUTE_MEETINGS_LIST = "meetings list"
        const val ROUTE_MY_MEETINGS = "my meetings"
        const val ROUTE_COMMUNITY_LIST = "community list"
        const val ROUTE_COMMUNITY = "community"
        const val ROUTE_COMMUNITY_DETAIL = "community detail"
        const val ROUTE_MORE = "more"
        const val ROUTE_MORE_MENU = "more menu"
        const val ROUTE_PROFILE = "profile"
    }
}