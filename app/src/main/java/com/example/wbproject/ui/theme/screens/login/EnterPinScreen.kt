package com.example.wbproject.ui.theme.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.CustomPin
import com.example.wbproject.ui.theme.elements.buttons.MyTextButton
import com.example.wbproject.ui.theme.elements.text.TextBody2
import com.example.wbproject.ui.theme.elements.text.TextHeading2

const val TEST_RIGHT_PIN = "1234"

@Preview
@Composable
fun EnterPinScreen(correctPinEnteredListener: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = MeetingTheme.dimensions.dimension200,
                start = MeetingTheme.dimensions.dimension8,
                end = MeetingTheme.dimensions.dimension8
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextHeading2(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension6),
            text = stringResource(id = R.string.enter_code)
        )
        TextBody2(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension6),
            text = stringResource(
                id = R.string.sent_a_code_to_the_number
            ),
        )
        TextBody2(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension40),
            text = stringResource(
                id = R.string.test_profile_phone
            ),
        )
        CustomPin(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension68),
            correctPin = TEST_RIGHT_PIN,
            correctPinEnteredListener = correctPinEnteredListener
        )
        MyTextButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(MeetingTheme.dimensions.dimension52),
            text = stringResource(id = R.string.request_code_again)
        )
    }
}