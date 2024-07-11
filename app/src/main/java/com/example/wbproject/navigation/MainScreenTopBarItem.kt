package com.example.wbproject.navigation

import com.example.wbproject.R

sealed class MainScreenTopBarItem(
    val screen: Screen,
    val titleResId: Int,
    val rightIconResId: Int?,
    val addLeftArrow: Boolean
) {

    data object MeetingList : MainScreenTopBarItem(
        screen = Screen.MeetingsList,
        titleResId = R.string.meetings,
        rightIconResId = null,
        addLeftArrow = false
    )

    data object MeetingDetail : MainScreenTopBarItem(
        screen = Screen.MeetingDetail,
        titleResId = R.string.developer_meeting,
        rightIconResId = null,
        addLeftArrow = true
    )

    data object CommunityList : MainScreenTopBarItem(
        screen = Screen.CommunityList,
        titleResId = R.string.communities,
        rightIconResId = null,
        addLeftArrow = false
    )

    data object CommunityDetail : MainScreenTopBarItem(
        screen = Screen.CommunityDetail,
        titleResId = R.string.designa,
        rightIconResId = null,
        addLeftArrow = true
    )

    data object MoreMenu : MainScreenTopBarItem(
        screen = Screen.MoreMenu,
        titleResId = R.string.more,
        rightIconResId = null,
        addLeftArrow = false
    )

    data object MyMeetings : MainScreenTopBarItem(
        screen = Screen.MyMeetings,
        titleResId = R.string.my_meetings,
        rightIconResId = null,
        addLeftArrow = true
    )

    data object Profile : MainScreenTopBarItem(
        screen = Screen.Profile,
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