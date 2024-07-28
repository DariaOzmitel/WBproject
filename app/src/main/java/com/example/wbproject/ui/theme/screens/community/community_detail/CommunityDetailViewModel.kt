package com.example.wbproject.ui.theme.screens.community.community_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Community
import com.example.domain.usecase.interfaces.IGetCommunityUseCase
import com.example.domain.usecase.interfaces.IGetMeetingListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class CommunityDetailViewModel(
    private val communityId: Int,
    private val getCommunityUseCase: IGetCommunityUseCase,
    private val getMeetingListUseCase: IGetMeetingListUseCase
) : ViewModel() {
    private val communityDetailStateMutable: MutableStateFlow<CommunityDetailState> =
        MutableStateFlow(
            CommunityDetailState.Loading
        )
    private val communityDetailState: StateFlow<CommunityDetailState> = communityDetailStateMutable

    init {
        viewModelScope.launch {
            getCommunityById()
        }
    }

    fun getCommunityDetailFlow(): StateFlow<CommunityDetailState> = communityDetailState

    private fun getCommunityById() {
        viewModelScope.launch {
            getCommunityUseCase(communityId).collect { community ->
                getMeetingListByCommunity(community)
            }
        }
    }

    private fun getMeetingListByCommunity(community: Community) {
        viewModelScope.launch {
            getMeetingListUseCase().collect { meetingList ->
                communityDetailStateMutable.update {
                    CommunityDetailState.CommunityDetail(
                        community = community,
                        meetingList = meetingList.filter { meeting -> meeting.communityId == community.id })
                }

            }
        }
    }
}