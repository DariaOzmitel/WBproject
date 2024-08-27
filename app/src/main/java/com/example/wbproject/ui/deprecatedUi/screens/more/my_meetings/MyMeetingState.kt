package com.example.wbproject.ui.theme.deprecatedUi.screens.more.my_meetings

import com.example.domain.model.Meeting

sealed class MyMeetingState {
    data class MyMeetingLists(
        val meetingList: List<Meeting>?,
        val meetingListAlreadyPassed: List<Meeting>?,
    ) : MyMeetingState()

    object Loading : MyMeetingState()
}