package com.example.wbproject.ui.theme.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.text.TextHeading1

const val PIN_LENGTH = 4
const val TEST_RIGHT_PIN = "1234"

@Composable
fun CustomPin(modifier: Modifier = Modifier, correctPinEnteredListener: () -> Unit = {}) {
    var displayText by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    BasicTextField(modifier = modifier, value = displayText, onValueChange = {
        if (it.length == PIN_LENGTH) {
            keyboardController?.hide()
        }
        displayText = it
    },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = {
            PinString(inputText = displayText, correctPinEnteredListener)
        }
    )
}

@Composable
fun PinString(inputText: String, correctPinEnteredListener: () -> Unit = {}) {
    val inputTextLength = inputText.length
    val correctPinEntered = inputText == TEST_RIGHT_PIN
    Row(
        modifier = Modifier.padding(MeetingTheme.dimensions.dimension8),
        horizontalArrangement = Arrangement.spacedBy(MeetingTheme.dimensions.dimension24)
    ) {
        repeat(PIN_LENGTH) { index ->
            Box(
                modifier = Modifier
                    .height(MeetingTheme.dimensions.dimension38)
                    .width(MeetingTheme.dimensions.dimension32),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(MeetingTheme.dimensions.dimension24)
                        .clip(CircleShape)
                        .background(
                            color = if (index >= inputTextLength) {
                                MeetingTheme.colors.neutralLine
                            } else Color.Transparent
                        )
                )
                if (index < inputTextLength) {
                    TextHeading1(
                        text = inputText[index].toString(),
                        color = MeetingTheme.colors.neutralActive
                    )
                }
                if (correctPinEntered) {
                    correctPinEnteredListener()
                }
            }
        }
    }
}

@Preview
@Composable
private fun PinCharPreview() {
    CustomPin()
}