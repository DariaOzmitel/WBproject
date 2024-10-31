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
import com.example.data.mockData.mockEvent
import com.example.ui.R
import com.example.ui.elements.EventEditText
import com.example.ui.elements.buttons.EventButton
import com.example.ui.elements.buttons.EventTextButton
import com.example.ui.elements.text.TextHeadingHuge
import com.example.ui.elements.text.TextRegular19
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme

private const val EDIT_TEXT_HINT = "0000"

@Composable
internal fun EnterPinScreen(modifier: Modifier = Modifier, onButtonClickListener: () -> Unit) {
    val event = mockEvent
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
                text = "${event.name} · ${event.date} · ${event.address}"
            )
            EventEditText(
                modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
                hint = EDIT_TEXT_HINT,
                displayText = ""
            ) {
            }
            TextSecondary(
                text = stringResource(id = R.string.send_code_text),
                color = EventTheme.colors.fontColorGrey
            )
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                EventTextButton(
                    modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension20),
                    text = stringResource(id = R.string.get_code_text),
                    color = EventTheme.colors.fontColorGrey
                )
                EventButton(text = stringResource(id = R.string.send_code_button)) {
                    onButtonClickListener()
                }
            }
        }
    }
}

@Preview
@Composable
private fun EnterPinScreenPreview() {
    EnterPinScreen {}
}