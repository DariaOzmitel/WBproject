package com.example.wbproject.ui.theme.screens.meetings

import com.example.wbproject.model.Meeting

data class MeetingListState(
    val meetingList: List<Meeting>,
    val searchText: String = ""
)
