package com.example.wbproject.navigation

import com.example.wbproject.R

sealed class NavigationItem(
    val screen: Screen,
    val iconResId: Int,
    val titleResId: Int,
    val rightIconResId: Int?,
    val addLeftArrow: Boolean
) {

    data object MeetingList : NavigationItem(
        screen = Screen.MeetingsList,
        iconResId = R.drawable.coffe_togo,
        titleResId = R.string.meetings,
        rightIconResId = null,
        addLeftArrow = false
    )

    data object MeetingDetail : NavigationItem(
        screen = Screen.MeetingDetail,
        iconResId = R.drawable.coffe_togo,
        titleResId = R.string.developer_meeting,
        rightIconResId = null,
        addLeftArrow = true
    )

    data object CommunityList : NavigationItem(
        screen = Screen.CommunityList,
        iconResId = R.drawable.group_alt,
        titleResId = R.string.communities,
        rightIconResId = null,
        addLeftArrow = false
    )

    data object CommunityDetail : NavigationItem(
        screen = Screen.CommunityDetail,
        iconResId = R.drawable.coffe_togo,
        titleResId = R.string.designa,
        rightIconResId = null,
        addLeftArrow = true
    )

    data object MoreMenu : NavigationItem(
        screen = Screen.MoreMenu,
        iconResId = R.drawable.more_horizontal,
        titleResId = R.string.more,
        rightIconResId = null,
        addLeftArrow = false
    )

    data object MyMeetings : NavigationItem(
        screen = Screen.MyMeetings,
        iconResId = R.drawable.coffe_togo,
        titleResId = R.string.my_meetings,
        rightIconResId = null,
        addLeftArrow = true
    )

    data object Profile : NavigationItem(
        screen = Screen.Profile,
        iconResId = R.drawable.user,
        titleResId = R.string.profile,
        rightIconResId = R.drawable.edit,
        addLeftArrow = true
    )

    companion object {
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