package com.example.wbproject.ui.theme.deprecatedUi.screens.community.community_detail

import com.example.domain.model.Community
import com.example.domain.model.Meeting

sealed class CommunityDetailState {
    data class CommunityDetail(
        val community: Community,
        val meetingList: List<Meeting>
    ) : CommunityDetailState()

    object Loading : CommunityDetailState()
}


