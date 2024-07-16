package com.example.wbproject.navigation

sealed class Screen(
    val route: String
) {
    object Splash : Screen(ROUTE_SPLASH)
    object EnterPhone : Screen(ROUTE_ENTER_PHONE)
    object EnterPin : Screen(ROUTE_ENTER_PIN)
    object AddProfile : Screen(ROUTE_ADD_PROFILE)
    object MeetingsRoot : Screen(ROUTE_MEETINGS_ROOT)
    object MeetingsList : Screen(ROUTE_MEETINGS_LIST)
    object MeetingDetail : Screen(ROUTE_MEETING_DETAIL)
    object CommunityList : Screen(ROUTE_COMMUNITY_LIST)
    object CommunityRoot : Screen(ROUTE_COMMUNITY_ROOT)
    object CommunityDetail : Screen(ROUTE_COMMUNITY_DETAIL)
    object MoreRoot : Screen(ROUTE_MORE_ROOT)
    object MoreMenu : Screen(ROUTE_MORE_MENU)
    object Profile : Screen(ROUTE_PROFILE)
    object MyMeetings : Screen(ROUTE_MY_MEETINGS)

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