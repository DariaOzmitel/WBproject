package com.example.ui.screen.main.event

import com.example.domain.model.Meeting

sealed class MeetingState {
    data class MeetingDetail(
        val meeting: Meeting,
        val mapUrl: String,
        val attendingStatus: Boolean
    ) : MeetingState()

    object Loading : MeetingState()
}