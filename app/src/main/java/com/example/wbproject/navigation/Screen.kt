package com.example.wbproject.navigation

sealed class Screen(
    val route: String
) {
    data object Meetings : Screen(ROUTE_MEETINGS)
    data object Community : Screen(ROUTE_COMMUNITY)
    data object More : Screen(ROUTE_MORE)
    data object Profile : Screen(ROUTE_PROFILE)
    data object MyMeetings : Screen(ROUTE_MY_MEETINGS)

    private companion object {
        const val ROUTE_MEETINGS = "meetings"
        const val ROUTE_MY_MEETINGS = "my meetings"
        const val ROUTE_COMMUNITY = "community"
        const val ROUTE_MORE = "more"
        const val ROUTE_PROFILE = "profile"
    }
}