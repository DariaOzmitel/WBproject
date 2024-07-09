package com.example.wbproject.navigation

import com.example.wbproject.R

sealed class BottomNavigationItem(
    val screen: Screen,
    val iconResId: Int,
    val title: String,
) {
    data object Meetings : BottomNavigationItem(
        screen = Screen.Meetings,
        iconResId = R.drawable.coffe_togo,
        title = MEETINGS,
    )

    data object Community : BottomNavigationItem(
        screen = Screen.Community,
        iconResId = R.drawable.group_alt,
        title = COMMUNITY,
    )

    data object More : BottomNavigationItem(
        screen = Screen.More,
        iconResId = R.drawable.more_horizontal,
        title = MORE,
    )

    private companion object {
        const val MORE = "Еще"
        const val MEETINGS = "Встречи"
        const val COMMUNITY = "Сообщества"
    }
}

