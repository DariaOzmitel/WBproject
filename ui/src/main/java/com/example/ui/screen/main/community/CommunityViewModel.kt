package com.example.ui.screen.main.community

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Community
import com.example.domain.usecase.interfaces.IGetCommunityUseCase
import com.example.domain.usecase.interfaces.IGetEventListUseCase
import com.example.ui.navigation.Screen
import com.example.ui.orZero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class CommunityViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getCommunityUseCase: IGetCommunityUseCase,
    private val getMeetingListUseCase: IGetEventListUseCase
) : ViewModel() {
    private val communityStateMutable: MutableStateFlow<CommunityState> =
        MutableStateFlow(
            CommunityState.Loading
        )
    private val communityState: StateFlow<CommunityState> = communityStateMutable

    init {
        viewModelScope.launch {
            getCommunityById()
        }
    }

    fun getCommunityFlow(): StateFlow<CommunityState> = communityState

    private fun getCommunityId(): Int {
        return savedStateHandle.get<Int>(Screen.KEY_COMMUNITY_ID).orZero()
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
                communityStateMutable.update {
                    CommunityState.CommunityDetail(
                        community = community,
                        eventList = meetingList.filter { meeting -> meeting.communityId == community.id })
                }
            }
        }
    }
}