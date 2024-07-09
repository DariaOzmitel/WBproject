package com.example.wbproject.navigation

import com.example.wbproject.R

sealed class NavigationItem(
    val screen: Screen,
    val iconResId: Int,
    val title: String,
    val rightIconResId: Int?,
    val addLeftArrow: Boolean
) {

    data object MeetingList : NavigationItem(
        screen = Screen.MeetingsList,
        iconResId = R.drawable.coffe_togo,
        title = MEETINGS,
        rightIconResId = null,
        addLeftArrow = false
    )

    data object MeetingDetail : NavigationItem(
        screen = Screen.MeetingDetail,
        iconResId = R.drawable.coffe_togo,
        title = MEETING_DETAIL,
        rightIconResId = null,
        addLeftArrow = true
    )

    data object CommunityList : NavigationItem(
        screen = Screen.CommunityList,
        iconResId = R.drawable.group_alt,
        title = COMMUNITY,
        rightIconResId = null,
        addLeftArrow = false
    )

    data object CommunityDetail : NavigationItem(
        screen = Screen.CommunityDetail,
        iconResId = R.drawable.coffe_togo,
        title = COMMUNITY_DETAIL,
        rightIconResId = null,
        addLeftArrow = true
    )

    data object MoreMenu : NavigationItem(
        screen = Screen.MoreMenu,
        iconResId = R.drawable.more_horizontal,
        title = MORE,
        rightIconResId = null,
        addLeftArrow = false
    )

    data object MyMeetings : NavigationItem(
        screen = Screen.MyMeetings,
        iconResId = R.drawable.coffe_togo,
        title = MY_MEETINGS,
        rightIconResId = null,
        addLeftArrow = true
    )

    data object Profile : NavigationItem(
        screen = Screen.Profile,
        iconResId = R.drawable.user,
        title = PROFILE,
        rightIconResId = R.drawable.edit,
        addLeftArrow = true
    )


    companion object {
        const val MORE = "Еще"
        const val MEETINGS = "Встречи"
        const val MEETING_DETAIL = "Developer meeting"
        const val COMMUNITY_DETAIL = "Designa"
        const val MY_MEETINGS = "Мои встречи"
        const val COMMUNITY = "Сообщества"
        const val PROFILE = "Профиль"

        val items =
            listOf(
                Profile,
                MyMeetings,
                MeetingList,
                MoreMenu,
                CommunityList,
                CommunityDetail,
                MeetingDetail
            )
    }
}