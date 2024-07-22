package com.example.wbproject.ui.theme.screens.more.my_meetings

import com.example.domain.model.Meeting

sealed class MyMeetingState {
    data class MyMeetingLists(
        val meetingListPlanned: List<Meeting>?,
        val meetingListAlreadyPassed: List<Meeting>?,
    ) : MyMeetingState()

    object Loading : MyMeetingState()
}