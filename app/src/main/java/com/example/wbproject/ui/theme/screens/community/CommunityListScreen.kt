package com.example.wbproject.ui.theme.screens.community

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.MySearchTextField
import com.example.wbproject.ui.theme.elements.ProgressIndicator
import com.example.wbproject.ui.theme.molecules.CommunityCardColumn
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun CommunityListScreen(
    modifier: Modifier = Modifier,
    onCommunityCardClickListener: (Int) -> Unit = {}
) {
    var searchText by remember {
        mutableStateOf("")
    }
    val viewModel: CommunityListViewModel = koinViewModel()
    val communityListState by viewModel.getCommunityListStateFlow().collectAsState()
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


