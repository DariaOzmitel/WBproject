package com.example.wbproject.navigation

sealed class Screen(
    val route: String
) {
    object Profile : Screen(ROUTE_PROFILE)
    object MyMeetings : Screen(ROUTE_MY_MEETINGS)
    object Meetings : Screen(ROUTE_MEETINGS)

    private companion object {
        const val ROUTE_PROFILE = "profile"
        const val ROUTE_MY_MEETINGS = "my_meetings"
        const val ROUTE_MEETINGS = "meetings"
    }
}