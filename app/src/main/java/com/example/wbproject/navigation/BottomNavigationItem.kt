package com.example.wbproject.navigation

import com.example.wbproject.R

sealed class BottomNavigationItem(
    val screen: ScreenV1,
    val iconResId: Int,
    val titleResId: Int,
) {
    data object Meetings : BottomNavigationItem(
        screen = ScreenV1.MeetingsRoot,
        iconResId = R.drawable.coffe_togo,
        titleResId = R.string.meetings,
    )

    data object Community : BottomNavigationItem(
        screen = ScreenV1.CommunityRoot,
        iconResId = R.drawable.group_alt,
        titleResId = R.string.communities,
    )

    data object More : BottomNavigationItem(
        screen = ScreenV1.MoreRoot,
        iconResId = R.drawable.more_horizontal,
        titleResId = R.string.more,
    )

    companion object {
        val bottomNavigationItems =
            listOf(
                Meetings,
                Community,
                More
            )
    }
}

