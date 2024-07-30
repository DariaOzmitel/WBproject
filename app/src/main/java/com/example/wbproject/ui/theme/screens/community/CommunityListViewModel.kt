package com.example.wbproject.ui.theme.screens.community

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.IGetCommunityListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class CommunityListViewModel(
    private val getCommunityListUseCase: IGetCommunityListUseCase
) : ViewModel() {
    private val communityListStateMutable =
        MutableStateFlow<CommunityListState>(CommunityListState.Loading)
    private val communityListState: StateFlow<CommunityListState> = communityListStateMutable

    init {
        viewModelScope.launch {
            getCommunityList()
        }
    }

    fun getCommunityListStateFlow(): StateFlow<CommunityListState> = communityListState

    private fun getCommunityList() {
        viewModelScope.launch {
            getCommunityListUseCase().collect { communityList ->
                communityListStateMutable.update {
                    CommunityListState.CommunityList(communityList)
                }
            }
        }
    }
}