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
import com.example.wbproject.ui.eventUi.elements.chips.EventChip14
import com.example.wbproject.ui.eventUi.elements.chips.EventChip16
import com.example.wbproject.ui.eventUi.elements.chips.EventChip22
import com.example.wbproject.ui.eventUi.theme.EventTheme

@Composable
fun UiKitScreen() {
    var isPressed by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(
                top = EventTheme.dimensions.dimension128,
                start = EventTheme.dimensions.dimension8
            ),
        verticalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension8)
    ) {
        EventChip14(text = "Тестирование")
        EventChip16(text = "Тестирование", isPressed = isPressed) {
            isPressed = !isPressed
        }
        EventChip22(text = "Дизайн", isPressed = isPressed) {
            isPressed = !isPressed
        }
    }
}