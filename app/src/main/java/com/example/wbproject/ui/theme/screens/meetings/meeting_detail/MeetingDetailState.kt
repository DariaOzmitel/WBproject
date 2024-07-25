package com.example.wbproject.ui.theme.screens.meetings.meeting_detail

import com.example.domain.model.Meeting

sealed class MeetingDetailState {
    data class MeetingDetail(
        val meeting: Meeting,
        val mapUrl: String
    ) : MeetingDetailState()

    object Loading : MeetingDetailState()
}