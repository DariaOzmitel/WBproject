package com.example.wbproject.ui.theme.screens.community

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCommunityListUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class CommunityListViewModel(
    private val getCommunityListUseCase: GetCommunityListUseCase
) : ViewModel() {
    private val communityListStateMutable =
        MutableStateFlow<CommunityListState>(CommunityListState.Loading)
    private val communityListState: StateFlow<CommunityListState> = communityListStateMutable

    fun getCommunityListStateFlow(): StateFlow<CommunityListState> = communityListState

    init {
        viewModelScope.launch {
            val communityList = getCommunityListUseCase.invoke()
            delay(500)
            communityListStateMutable.update { CommunityListState.CommunityList(communityList = communityList) }
        }
    }
}