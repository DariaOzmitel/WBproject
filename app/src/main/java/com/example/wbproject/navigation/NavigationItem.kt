package com.example.wbproject.navigation

import com.example.wbproject.R

sealed class NavigationItem(
    val screen: Screen,
    val iconResId: Int,
    val title: String,
    val rightIconResId: Int?,
) {
    data object Meetings : NavigationItem(
        screen = Screen.Meetings,
        iconResId = R.drawable.coffe_togo,
        title = MEETINGS,
        rightIconResId = R.drawable.plus
    )

    data object Community : NavigationItem(
        screen = Screen.Community,
        iconResId = R.drawable.group_alt,
        title = COMMUNITY,
        rightIconResId = null
    )

    data object More : NavigationItem(
        screen = Screen.More,
        iconResId = R.drawable.more_horizontal,
        title = MORE,
        rightIconResId = null
    )

    data object MyMeetings : NavigationItem(
        screen = Screen.MyMeetings,
        iconResId = R.drawable.coffe_togo,
        title = MY_MEETINGS,
        rightIconResId = null
    )

    data object Profile : NavigationItem(
        screen = Screen.Profile,
        iconResId = R.drawable.user,
        title = PROFILE,
        rightIconResId = R.drawable.edit
    )

    private companion object {
        const val MORE = "Еще"
        const val MEETINGS = "Встречи"
        const val MY_MEETINGS = "Мои встречи"
        const val COMMUNITY = "Сообщества"
        const val PROFILE = "Профиль"
    }
}