package com.example.ui.screen.onboarding.select_interest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.data.mockData.mockAllInterests
import com.example.ui.R
import com.example.ui.elements.buttons.EventButton
import com.example.ui.elements.buttons.EventTextButton
import com.example.ui.elements.chips.EventChipsRow22
import com.example.ui.elements.text.TextHeading1
import com.example.ui.elements.text.TextRegular19
import com.example.ui.theme.EventTheme

@Composable
fun SelectInterestScreen(modifier: Modifier = Modifier, onClickListener: () -> Unit) {
    Scaffold { innerPadding ->
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
                    EventChipsRow22(chips = mockAllInterests)
                }
                item { EventChipsRow22(chips = mockAllInterests) }
            }
            EventButton(text = stringResource(id = R.string.save), onClick = onClickListener)
            EventTextButton(text = stringResource(id = R.string.say_later))
        }
    }
}