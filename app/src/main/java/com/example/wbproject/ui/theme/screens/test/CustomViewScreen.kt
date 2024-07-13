package com.example.wbproject.ui.theme.screens.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbproject.ui.theme.elements.CustomPhoneNumber
import com.example.wbproject.ui.theme.elements.CustomPin

const val TEST_RIGHT_PIN = "1234"

@Preview
@Composable
fun CustomViewScreen() {
    var phone: String by rememberSaveable {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(top = 100.dp, start = 50.dp)) {
        CustomPin(correctPin = TEST_RIGHT_PIN, correctPinEnteredListener = {})
        Spacer(modifier = Modifier.height(80.dp))
        CustomPhoneNumber(
            displayText = phone,
            onValueChangeClickListener = { phone = it })
    }
}