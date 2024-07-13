package com.example.wbproject.ui.theme.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.CustomPhoneNumber
import com.example.wbproject.ui.theme.elements.buttons.MyButton
import com.example.wbproject.ui.theme.elements.text.TextBody2
import com.example.wbproject.ui.theme.elements.text.TextHeading2

private const val PHONE_LENGTH = 10

@Composable
fun EnterPhoneScreen(onButtonClickListener: () -> Unit) {
    var phone: String by rememberSaveable {
        mutableStateOf("")
    }
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
            text = stringResource(id = R.string.enter_phone_number),
            textAlign = TextAlign.Center,
        )
        TextBody2(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension40),
            text = stringResource(
                id = R.string.we_will_send_a_confirmation_code_to_the_specified_number
            ),
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )
        CustomPhoneNumber(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension68),
            displayText = phone,
            onValueChangeClickListener = { phone = it })
        MyButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(MeetingTheme.dimensions.dimension52),
            text = stringResource(id = R.string.resume),
            onClick = onButtonClickListener,
            enabled = phone.length == PHONE_LENGTH
        )
    }
}

