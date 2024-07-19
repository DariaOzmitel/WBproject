package com.example.wbproject.ui.theme.screens.community.community_detail

import com.example.wbproject.model.Community
import com.example.wbproject.model.Meeting

data class CommunityDetailState(
    val community: Community,
    val meetingList: List<Meeting>
)
