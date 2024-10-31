package com.example.ui.screen.main.event

import com.example.domain.model.Event

internal sealed class EventState {
    data class EventDetail(
        val event: Event,
        val mapUrl: String,
        val attendingStatus: Boolean
    ) : EventState()

    object Loading : EventState()
}