package com.example.wbproject.ui.theme.screens.community

import com.example.wbproject.model.Community

data class CommunityListState(
    val communityList: List<Community>,
    val searchText: String = ""
)
