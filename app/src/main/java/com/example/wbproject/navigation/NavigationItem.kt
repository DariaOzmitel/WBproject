package com.example.wbproject.navigation

import com.example.wbproject.R

sealed class NavigationItem (
    val screen: Screen,
    val iconResId: Int?,
    val title: String?
) {
    object Profile : NavigationItem(
        screen = Screen.Profile,
        iconResId = R.drawable.user,
        title = null
    )
    object MyMeetings : NavigationItem(
        screen = Screen.MyMeetings,
        iconResId = R.drawable.user,
        title = MY_MEETINGS
    )
    object Meetings : NavigationItem(
        screen = Screen.Meetings,
        iconResId = R.drawable.user,
        title = MEETINGS
    )
    private companion object {
        const val MY_MEETINGS = "Мои встречи"
        const val MEETINGS = "Встречи"
    }
}