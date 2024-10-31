package com.example.ui.screen.main.community

import com.example.domain.model.Community
import com.example.domain.model.Event

internal sealed class CommunityState {
    data class CommunityDetail(
        val community: Community,
        val eventList: List<Event>
    ) : CommunityState()

    object Loading : CommunityState()
}


