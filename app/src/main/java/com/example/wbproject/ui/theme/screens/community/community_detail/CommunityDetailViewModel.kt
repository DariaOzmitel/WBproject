package com.example.wbproject.ui.theme.screens.community.community_detail

import androidx.lifecycle.ViewModel
import com.example.wbproject.data.mockData.mockCommunity
import com.example.wbproject.data.mockData.mockListMeetings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CommunityDetailViewModel : ViewModel() {
    private val communityDetailStateMutable = MutableStateFlow(
        CommunityDetailState(
            community = mockCommunity,
            meetingList = mockListMeetings
        )
    )
    private val communityDetailState: StateFlow<CommunityDetailState> = communityDetailStateMutable

    fun getCommunityDetailFlow(): StateFlow<CommunityDetailState> = communityDetailState
}