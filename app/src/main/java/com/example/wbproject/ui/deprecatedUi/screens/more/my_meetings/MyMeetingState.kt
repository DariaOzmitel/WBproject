package com.example.wbproject.ui.theme.deprecatedUi.screens.more.my_meetings

import com.example.domain.model.Event

sealed class MyMeetingState {
    data class MyMeetingLists(
        val eventList: List<Event>?,
        val eventListAlreadyPassed: List<Event>?,
    ) : MyMeetingState()

    object Loading : MyMeetingState()
}