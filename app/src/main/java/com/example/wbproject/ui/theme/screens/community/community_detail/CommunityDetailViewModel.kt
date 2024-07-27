package com.example.wbproject.ui.theme.screens.community.community_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCommunityUseCase
import com.example.domain.usecase.GetMeetingListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class CommunityDetailViewModel(
    private val communityId: Int,
    private val getCommunityUseCase: GetCommunityUseCase,
    private val getMeetingListUseCase: GetMeetingListUseCase
) : ViewModel() {
    private val communityDetailStateMutable: MutableStateFlow<CommunityDetailState> =
        MutableStateFlow(
            CommunityDetailState.Loading
        )
    private val communityDetailState: StateFlow<CommunityDetailState> = communityDetailStateMutable

    fun getCommunityDetailFlow(): StateFlow<CommunityDetailState> = communityDetailState

    init {
        viewModelScope.launch {
            getMeetingList()
        }
    }

    private fun getMeetingList() {
        viewModelScope.launch {
            val community = getCommunityUseCase.invoke(communityId)
            getMeetingListUseCase().collect { meetingList ->
                communityDetailStateMutable.update {
                    CommunityDetailState.CommunityDetail(
                        community = community,
                        meetingList = meetingList.filter { it.communityId == community.id })
                }
            }
        }
    }

}