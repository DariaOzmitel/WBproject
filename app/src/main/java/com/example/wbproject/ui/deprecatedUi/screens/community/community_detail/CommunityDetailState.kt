package com.example.wbproject.ui.theme.deprecatedUi.screens.community.community_detail

import com.example.domain.model.Community
import com.example.domain.model.Event

sealed class CommunityDetailState {
    data class CommunityDetail(
        val community: Community,
        val eventList: List<Event>
    ) : CommunityDetailState()

    object Loading : CommunityDetailState()
}


