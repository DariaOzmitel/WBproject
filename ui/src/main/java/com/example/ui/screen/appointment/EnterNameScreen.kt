package com.example.ui.screen.appointment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.data.mockData.mockMeeting
import com.example.ui.R
import com.example.ui.elements.EventEditText
import com.example.ui.elements.buttons.EventButton
import com.example.ui.elements.text.TextHeadingHuge
import com.example.ui.elements.text.TextRegular19
import com.example.ui.theme.EventTheme

@Composable
fun EnterNameScreen(modifier: Modifier = Modifier, onButtonClickListener: () -> Unit) {
    val meeting = mockMeeting
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    start = EventTheme.dimensions.dimension16,
                    bottom = innerPadding.calculateBottomPadding() + EventTheme.dimensions.dimension28,
                    end = EventTheme.dimensions.dimension16
                )
        ) {
            Row(modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension14)) {
                TextHeadingHuge(
                    modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.enter_name_heading)
                )
                Image(
                    modifier = Modifier
                        .padding(top = EventTheme.dimensions.dimension10)
                        .size(EventTheme.dimensions.dimension28),
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = ""
                )
            }
            TextRegular19(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension24),
                text = "${meeting.name} · ${meeting.date} · ${meeting.address}"
            )
            EventEditText(displayText = "") {
            }
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                EventButton(text = stringResource(id = R.string.resume)) {
                    onButtonClickListener()
                }
            }

        }
    }
}

@Preview
@Composable
private fun EnterNameScreenPreview() {
    EnterNameScreen {}
}