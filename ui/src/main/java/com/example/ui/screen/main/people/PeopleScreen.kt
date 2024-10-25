package com.example.ui.screen.main.people

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.mockData.mockUserList
import com.example.domain.model.User
import com.example.ui.R
import com.example.ui.elements.ProgressIndicator
import com.example.ui.molecules.CustomTopBar
import com.example.ui.molecules.UserCardFlowRow
import com.example.ui.theme.EventTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun PeopleScreen(
    modifier: Modifier = Modifier,
    onUserCardClickListener: (Int) -> Unit,
    onLeftIconClickListener: () -> Unit
) {
    val viewModel: PeopleViewModel = koinViewModel()
    val peopleState by viewModel.getPeopleFlow().collectAsStateWithLifecycle()
    when (val state = peopleState) {
        is PeopleState.Loading -> ProgressIndicator()
        is PeopleState.PeopleContent -> {
            PeopleScreenContent(
                modifier = modifier,
                peopleList = state.peopleList,
                onUserCardClickListener = { onUserCardClickListener(it) }) {
                onLeftIconClickListener()
            }
        }
    }
}

@Composable
private fun PeopleScreenContent(
    modifier: Modifier = Modifier,
    peopleList: List<User>?,
    onUserCardClickListener: (Int) -> Unit,
    onLeftIconClickListener: () -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = modifier.padding(
                top = innerPadding.calculateTopPadding(),
                start = EventTheme.dimensions.dimension16,
                end = EventTheme.dimensions.dimension16,
                bottom = innerPadding.calculateBottomPadding()
            )
        ) {
            CustomTopBar(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension32),
                heading = stringResource(id = R.string.people_screen_heading),
                onLeftIconClickListener = onLeftIconClickListener,
            )
            LazyColumn {
                item {
                    peopleList?.let { peopleList ->
                        UserCardFlowRow(userList = peopleList) {
                            onUserCardClickListener(it)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PeopleScreenContentPreview() {
    PeopleScreenContent(peopleList = mockUserList, onUserCardClickListener = {}) {
    }
}
