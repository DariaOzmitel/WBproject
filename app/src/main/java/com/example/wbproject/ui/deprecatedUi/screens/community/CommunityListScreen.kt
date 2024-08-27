package com.example.wbproject.ui.theme.deprecatedUi.screens.community

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.wbproject.ui.theme.deprecatedUi.elements.MySearchTextField
import com.example.wbproject.ui.theme.deprecatedUi.elements.ProgressIndicator
import com.example.wbproject.ui.theme.deprecatedUi.molecules.CommunityCardColumn
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CommunityListScreen(
    modifier: Modifier = Modifier,
    onCommunityCardClickListener: (Int) -> Unit = {}
) {
    var searchText by remember {
        mutableStateOf("")
    }
    val viewModel: CommunityListViewModel = koinViewModel()
    val communityListState by viewModel.getCommunityListStateFlow().collectAsStateWithLifecycle()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = MeetingTheme.dimensions.dimension106,
                start = MeetingTheme.dimensions.dimension16,
                end = MeetingTheme.dimensions.dimension16,
                bottom = MeetingTheme.dimensions.dimension100,
            )
    ) {
        MySearchTextField(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension16),
            searchText = searchText,
            onValueChange = { searchText = it })
        when (val state = communityListState) {
            is CommunityListState.Loading -> ProgressIndicator()
            is CommunityListState.CommunityList ->
                CommunityCardColumn(
                    communityList = state.communityList,
                    onCommunityCardClickListener = onCommunityCardClickListener
                )
        }
    }
}


