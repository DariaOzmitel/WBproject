package com.example.wbproject.ui.eventUi.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.wbproject.R
import com.example.wbproject.ui.eventUi.elements.EventEditText
import com.example.wbproject.ui.eventUi.elements.buttons.EventButton
import com.example.wbproject.ui.eventUi.elements.buttons.SubscribeButton
import com.example.wbproject.ui.eventUi.elements.chips.EventChip14
import com.example.wbproject.ui.eventUi.elements.chips.EventChip16
import com.example.wbproject.ui.eventUi.elements.chips.EventChip22
import com.example.wbproject.ui.eventUi.theme.EventTheme

@Composable
fun UiKitScreen() {
    var isPressed by rememberSaveable {
        mutableStateOf(false)
    }
    var displayText by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .padding(
                top = EventTheme.dimensions.dimension128,
                start = EventTheme.dimensions.dimension8,
                end = EventTheme.dimensions.dimension8,
            ),
        verticalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension8)
    ) {
        EventEditText(
            hint = stringResource(id = R.string.name_and_surname),
            displayText = displayText
        ) {
            displayText = it
        }
        EventEditText(
            hint = stringResource(id = R.string.name_and_surname),
            displayText = displayText,
            isError = true
        ) {
            displayText = it
        }
        EventChip14(text = stringResource(id = R.string.testing))
        EventChip16(text = stringResource(id = R.string.testing), isPressed = isPressed) {
            isPressed = !isPressed
        }
        EventChip22(text = stringResource(id = R.string.design), isPressed = isPressed) {
            isPressed = !isPressed
        }
        EventButton(text = stringResource(id = R.string.pay), isLoading = isPressed) {
            isPressed = !isPressed
        }
        EventButton(text = stringResource(id = R.string.pay), enabled = false)
        EventButton(text = stringResource(id = R.string.pay), secondaryStatus = true)
        SubscribeButton(subscribeStatus = isPressed) {
            isPressed = !isPressed
        }
    }
}