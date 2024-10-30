package com.example.wbproject.ui.theme.deprecatedUi.screens.community.community_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Community
import com.example.domain.usecase.interfaces.IGetCommunityUseCase
import com.example.domain.usecase.interfaces.IInteractorGetMeetingList
import com.example.wbproject.navigation.ScreenV1
import com.example.wbproject.orZero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class CommunityDetailViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getCommunityUseCase: IGetCommunityUseCase,
    private val getMeetingListUseCase: IInteractorGetMeetingList
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

    private fun getCommunityId(): Int {
        return savedStateHandle.get<Int>(ScreenV1.KEY_COMMUNITY_ID).orZero()
    }

    private fun getCommunityById() {
        viewModelScope.launch {
            getCommunityUseCase(getCommunityId()).collect { community ->
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
                        eventList = meetingList.filter { meeting -> meeting.communityId == community.id })
                }

            }
        }
    }
}