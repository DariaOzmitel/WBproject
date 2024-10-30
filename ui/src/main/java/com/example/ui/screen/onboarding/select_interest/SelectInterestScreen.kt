package com.example.ui.screen.onboarding.select_interest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.R
import com.example.ui.elements.ProgressIndicator
import com.example.ui.elements.buttons.EventButton
import com.example.ui.elements.buttons.EventTextButton
import com.example.ui.elements.chips.EventChipsFlowRow22
import com.example.ui.elements.text.TextHeading1
import com.example.ui.elements.text.TextRegular19
import com.example.ui.model.InterestUi
import com.example.ui.theme.EventTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun SelectInterestScreen(modifier: Modifier = Modifier, onClickListener: () -> Unit) {
    val viewModel: SelectInterestsViewModel = koinViewModel()
    val selectInterestsState by viewModel.getInterestsFlow().collectAsStateWithLifecycle()
    when (val state = selectInterestsState) {
        is SelectInterestsState.Loading -> ProgressIndicator()
        is SelectInterestsState.InterestsList -> {
            Scaffold { innerPadding ->
                SelectInterestScreenContent(
                    modifier = modifier,
                    interestsList = state.list,
                    innerPadding = innerPadding,
                    onChipClickListener = { viewModel.changeUsersInterest(it) }
                ) {
                    onClickListener()
                }
            }
        }
    }
}

@Composable
private fun SelectInterestScreenContent(
    modifier: Modifier = Modifier,
    interestsList: List<InterestUi>,
    innerPadding: PaddingValues,
    onChipClickListener: (Int) -> Unit,
    onClickListener: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = innerPadding.calculateTopPadding(),
                start = EventTheme.dimensions.dimension16,
                bottom = EventTheme.dimensions.dimension28,
                end = EventTheme.dimensions.dimension40,
            )
    ) {
        TextHeading1(
            modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension12),
            text = stringResource(id = R.string.interests)
        )
        TextRegular19(
            modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension24),
            text = stringResource(id = R.string.interests_subheading)
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            item {
                EventChipsFlowRow22(chips = interestsList) {
                    onChipClickListener(it)
                }
            }
        }
        EventButton(
            modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension16),
            text = stringResource(id = R.string.save),
            onClick = onClickListener
        )
        EventTextButton(text = stringResource(id = R.string.say_later))
    }
}
