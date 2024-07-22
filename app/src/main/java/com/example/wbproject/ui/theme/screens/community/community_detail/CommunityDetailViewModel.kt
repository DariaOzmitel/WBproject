package com.example.wbproject.ui.theme.screens.community.community_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCommunityUseCase
import com.example.domain.usecase.GetMeetingListUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CommunityDetailViewModel(
    getCommunityUseCase: GetCommunityUseCase,
    getMeetingListUseCase: GetMeetingListUseCase
) : ViewModel() {
    private val communityDetailStateMutable: MutableStateFlow<CommunityDetailState> =
        MutableStateFlow(
            CommunityDetailState.Loading
        )
    private val communityDetailState: StateFlow<CommunityDetailState> = communityDetailStateMutable

    fun getCommunityDetailFlow(): StateFlow<CommunityDetailState> = communityDetailState

    init {
        viewModelScope.launch {
            val community = getCommunityUseCase.invoke()
            val meetingList = getMeetingListUseCase.invoke()
            delay(500)
            communityDetailStateMutable.update {
                CommunityDetailState.CommunityDetail(
                    community = community,
                    meetingList = meetingList
                )
            }
        }
    }
}