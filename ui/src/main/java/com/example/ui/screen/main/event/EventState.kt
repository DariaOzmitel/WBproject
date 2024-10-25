package com.example.ui.screen.main.event

import com.example.domain.model.Meeting

sealed class EventState {
    data class EventDetail(
        val meeting: Meeting,
        val mapUrl: String,
        val attendingStatus: Boolean
    ) : EventState()

    object Loading : EventState()
}