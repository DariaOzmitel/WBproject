package com.example.wbproject.ui.theme.screens.community

import androidx.lifecycle.ViewModel
import com.example.wbproject.data.mockData.mockCommunityList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CommunityListViewModel : ViewModel() {
    private val communityListStateMutable =
        MutableStateFlow(CommunityListState(communityList = mockCommunityList))
    private val communityListState: StateFlow<CommunityListState> = communityListStateMutable

    fun getCommunityListFlow(): StateFlow<CommunityListState> = communityListState
    fun updateSearchText(newSearchText: String) {
        communityListStateMutable.update {
            it.copy(searchText = newSearchText)
        }
    }
}