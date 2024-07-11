package com.example.wbproject.ui.theme.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.text.TextBody1


@Composable
fun MyEditText(
    modifier: Modifier = Modifier,
    hint: String = "",
    displayText: String,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .height(MeetingTheme.dimensions.dimension36)
            .fillMaxWidth()
            .clip(RoundedCornerShape(MeetingTheme.dimensions.dimension4))
            .background(MeetingTheme.colors.neutralOffWhite)
            .padding(MeetingTheme.dimensions.dimension8),
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = displayText,
            onValueChange = { onValueChange(it) },
            textStyle = MeetingTheme.typography.bodyText1.copy(color = MeetingTheme.colors.neutralDisabled)
        ) { innerTextField ->
            if (displayText == "")
                TextBody1(text = hint, color = MeetingTheme.colors.neutralDisabled)
            innerTextField()
        }
    }
}

@Preview
@Composable
fun MyEditTextPreview() {
    var displayText by remember { mutableStateOf("") }
    MyEditText(
        hint = stringResource(id = R.string.name_necessarily),
        displayText = displayText,
        onValueChange = { displayText = it })
}