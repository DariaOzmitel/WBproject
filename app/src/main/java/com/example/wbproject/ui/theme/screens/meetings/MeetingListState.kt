package com.example.wbproject.ui.theme.screens.meetings

import com.example.domain.model.Meeting

sealed class MeetingListState {
    data class MeetingList(val list: List<Meeting>) : MeetingListState()
    object Loading : MeetingListState()
}
