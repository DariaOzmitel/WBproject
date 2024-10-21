package com.example.ui.screen.main.community

import com.example.domain.model.Community
import com.example.domain.model.Meeting

sealed class CommunityState {
    data class CommunityDetail(
        val community: Community,
        val meetingList: List<Meeting>
    ) : CommunityState()

    object Loading : CommunityState()
}


