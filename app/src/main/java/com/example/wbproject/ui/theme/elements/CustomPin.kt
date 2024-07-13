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
import androidx.compose.material3.Text
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

const val PIN_LENGTH = 4

@Composable
fun CustomPin() {
    var inputText by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    BasicTextField(value = inputText, onValueChange = {
        if (it.length == PIN_LENGTH) {
            keyboardController?.hide()
        }
        inputText = it
    },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = {
            PinChar(inputText = inputText)
        }
    )
}

@Composable
fun PinChar(inputText: String) {
    val inputTextLength = inputText.length
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
                    Text(
                        text = inputText[index].toString(),
                        style = MeetingTheme.typography.heading1,
                        color = MeetingTheme.colors.neutralActive
                    )
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