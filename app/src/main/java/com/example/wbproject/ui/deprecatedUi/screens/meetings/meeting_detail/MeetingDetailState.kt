package com.example.wbproject.ui.theme.deprecatedUi.screens.meetings.meeting_detail

import com.example.domain.model.Event

sealed class MeetingDetailState {
    data class MeetingDetail(
        val event: Event,
        val mapUrl: String,
        val attendingStatus: Boolean
    ) : MeetingDetailState()

    object Loading : MeetingDetailState()
}