package com.example.wbproject.ui.theme.screens.community

import com.example.domain.model.Community

sealed class CommunityListState {
    data class CommunityList(
        val communityList: List<Community>,
    ) : CommunityListState()

    object Loading : CommunityListState()
}


