package com.example.wbproject.ui.theme.items

import com.example.wbproject.R

sealed class MoreMenuItem(
    val titleResId: Int,
    val iconResId: Int,
) {
    data object MyMeetings : MoreMenuItem(
        titleResId = R.string.my_meetings,
        iconResId = R.drawable.coffe_togo
    )

    data object Theme : MoreMenuItem(
        titleResId = R.string.theme,
        iconResId = R.drawable.theme_icon
    )

    data object Notifications : MoreMenuItem(
        titleResId = R.string.notifications,
        iconResId = R.drawable.notification_icon
    )

    data object Safety : MoreMenuItem(
        titleResId = R.string.safety,
        iconResId = R.drawable.safety_icon
    )

    data object MemoryAndResources : MoreMenuItem(
        titleResId = R.string.memory_and_resources,
        iconResId = R.drawable.memory_and_resource_icon
    )

    data object Help : MoreMenuItem(
        titleResId = R.string.help,
        iconResId = R.drawable.help_icon
    )

    data object InviteFriend : MoreMenuItem(
        titleResId = R.string.invite_friend,
        iconResId = R.drawable.invite_icon
    )
}