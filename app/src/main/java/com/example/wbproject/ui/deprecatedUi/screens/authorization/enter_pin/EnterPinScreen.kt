package com.example.wbproject.ui.theme.deprecatedUi.screens.authorization.enter_pin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.wbproject.R
import com.example.wbproject.ui.theme.deprecatedUi.elements.CustomPin
import com.example.wbproject.ui.theme.deprecatedUi.elements.buttons.MyTextButton
import com.example.wbproject.ui.theme.deprecatedUi.elements.text.TextBody2
import com.example.wbproject.ui.theme.deprecatedUi.elements.text.TextHeading2Old
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme
import org.koin.androidx.compose.koinViewModel

const val TEST_RIGHT_PIN = "1234"

@Composable
fun EnterPinScreen(
    modifier: Modifier = Modifier,
    correctPinEnteredListener: (String) -> Unit = {}
) {
    val viewModel: EnterPinViewModel = koinViewModel()
    val pin by viewModel.getPinFlow().collectAsStateWithLifecycle()
    val phone = viewModel.getPhone()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = MeetingTheme.dimensions.dimension168,
                start = MeetingTheme.dimensions.dimension8,
                end = MeetingTheme.dimensions.dimension8
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextHeading2Old(
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
            text = phone,
        )
        CustomPin(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension68),
            correctPin = TEST_RIGHT_PIN,
            displayText = pin,
            onValueChangeListener = { viewModel.updatePin(it) },
            correctPinEnteredListener = { correctPinEnteredListener(phone) }
        )
        MyTextButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.request_code_again)
        )
    }
}