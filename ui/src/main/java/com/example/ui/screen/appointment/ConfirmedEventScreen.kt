package com.example.ui.screen.appointment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.data.mockData.mockMeeting
import com.example.ui.R
import com.example.ui.elements.buttons.EventButton
import com.example.ui.elements.buttons.EventTextButton
import com.example.ui.elements.text.TextHeadingHuge
import com.example.ui.elements.text.TextRegular20
import com.example.ui.theme.EventTheme

@Composable
fun ConfirmedEventScreen(
    modifier: Modifier = Modifier,
    onMyEventsButtonClickListener: () -> Unit,
    onOtherEventsButtonClickListener: () -> Unit,
) {
    val meeting = mockMeeting
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding() + EventTheme.dimensions.dimension28,
                )
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.confirmed_event_background),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = modifier
                    .padding(
                        horizontal = EventTheme.dimensions.dimension16,
                    )
            ) {
                TextHeadingHuge(
                    text = stringResource(id = R.string.you_registered_event),
                    color = EventTheme.colors.fontColorWhite
                )
                TextRegular20(
                    modifier = Modifier.padding(
                        bottom = EventTheme.dimensions.dimension24,
                        end = EventTheme.dimensions.dimension40
                    ),
                    text = "${meeting.name} · ${meeting.date} · ${meeting.address}",
                    color = EventTheme.colors.fontColorWhite
                )
                Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                    EventTextButton(
                        modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension20),
                        text = stringResource(id = R.string.my_event),
                        color = EventTheme.colors.brandColorPurple
                    ) {
                        onMyEventsButtonClickListener()
                    }
                    EventButton(text = stringResource(id = R.string.find_event)) {
                        onOtherEventsButtonClickListener()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ConfirmedEventScreenPreview() {
    ConfirmedEventScreen(onMyEventsButtonClickListener = {}) {}
}