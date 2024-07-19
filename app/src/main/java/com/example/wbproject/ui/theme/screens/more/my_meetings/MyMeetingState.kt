package com.example.wbproject.ui.theme.screens.more.my_meetings

import com.example.wbproject.model.Meeting

data class MyMeetingState(
    val meetingListPlanned: List<Meeting>?,
    val meetingListAlreadyPassed: List<Meeting>?,
)
