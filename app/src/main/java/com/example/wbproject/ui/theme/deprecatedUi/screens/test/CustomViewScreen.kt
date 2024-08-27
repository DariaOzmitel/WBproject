package com.example.wbproject.ui.theme.deprecatedUi.screens.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbproject.ui.theme.deprecatedUi.elements.CustomPhoneNumber
import com.example.wbproject.ui.theme.deprecatedUi.elements.CustomPin
import com.example.wbproject.ui.theme.deprecatedUi.items.DropdownMenuItems
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme

const val TEST_RIGHT_PIN = "1234"

@Preview
@Composable
fun CustomViewScreen() {
    var phone: String by rememberSaveable {
        mutableStateOf("")
    }
    var pin: String by rememberSaveable {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(top = 100.dp, start = 50.dp)) {
        CustomPin(
            modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension80),
            correctPin = TEST_RIGHT_PIN,
            displayText = pin,
            onValueChangeListener = { pin = it },
            correctPinEnteredListener = {})
        CustomPhoneNumber(
            displayText = phone,
            expanded = false,
            selectedCountryCode = DropdownMenuItems.RUSSIA,
            onDismissRequestClickListener = {},
            onItemClickListener = {},
            onRowClickListener = {},
            onValueChangeClickListener = { phone = it })
    }
}