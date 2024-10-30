package com.example.wbproject.ui.theme.deprecatedUi.screens.meetings

import com.example.domain.model.Event

sealed class MeetingListState {
    data class MeetingList(val list: List<Event>) : MeetingListState()
    object Loading : MeetingListState()
}
