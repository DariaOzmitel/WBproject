package com.example.wbproject.navigation

sealed class Screen(
    val route: String
) {
    data object Splash : Screen(ROUTE_SPLASH)
    data object EnterPhone : Screen(ROUTE_ENTER_PHONE)
    data object EnterPin : Screen(ROUTE_ENTER_PIN)
    data object AddProfile : Screen(ROUTE_ADD_PROFILE)
    data object MeetingsRoot : Screen(ROUTE_MEETINGS_ROOT)
    data object MeetingsList : Screen(ROUTE_MEETINGS_LIST)
    data object MeetingDetail : Screen(ROUTE_MEETING_DETAIL)
    data object CommunityList : Screen(ROUTE_COMMUNITY_LIST)
    data object CommunityRoot : Screen(ROUTE_COMMUNITY_ROOT)
    data object CommunityDetail : Screen(ROUTE_COMMUNITY_DETAIL)
    data object MoreRoot : Screen(ROUTE_MORE_ROOT)
    data object MoreMenu : Screen(ROUTE_MORE_MENU)
    data object Profile : Screen(ROUTE_PROFILE)
    data object MyMeetings : Screen(ROUTE_MY_MEETINGS)

    private companion object {
        const val ROUTE_MEETINGS_ROOT = "meetings root"
        const val ROUTE_SPLASH = "splash"
        const val ROUTE_ENTER_PHONE = "enter phone"
        const val ROUTE_ENTER_PIN = "enter pin"
        const val ROUTE_ADD_PROFILE = "add profile"
        const val ROUTE_MEETING_DETAIL = "meeting detail"
        const val ROUTE_MEETINGS_LIST = "meetings list"
        const val ROUTE_MY_MEETINGS = "my meetings"
        const val ROUTE_COMMUNITY_LIST = "community list"
        const val ROUTE_COMMUNITY_ROOT = "community root"
        const val ROUTE_COMMUNITY_DETAIL = "community detail"
        const val ROUTE_MORE_ROOT = "more root"
        const val ROUTE_MORE_MENU = "more menu"
        const val ROUTE_PROFILE = "profile"
    }
}