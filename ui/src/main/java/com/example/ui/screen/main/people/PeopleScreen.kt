package com.example.ui.screen.main.people

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.domain.model.User
import com.example.ui.R
import com.example.ui.elements.CustomTopBar
import com.example.ui.molecules.UserCardFlowRow
import com.example.ui.theme.EventTheme

@Composable
fun PeopleScreen(
    modifier: Modifier = Modifier,
    peopleList: List<User>,
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
                    UserCardFlowRow(userList = peopleList)
                }
            }
        }
    }
}