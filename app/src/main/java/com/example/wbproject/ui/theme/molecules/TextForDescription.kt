package com.example.wbproject.ui.theme.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.text.TextMetadata1

@Composable
fun TextForDescription(
    modifier: Modifier = Modifier,
    fullText: Boolean,
    description: String?,
    textMaxLine: Int,
    onClickListener: () -> Unit
) {
    TextMetadata1(
        modifier = modifier
            .clickable {
                onClickListener()
            }
            .padding(bottom = MeetingTheme.dimensions.dimension30),
        text = description.orEmpty(),
        color = MeetingTheme.colors.neutralWeak,
        maxLines = when (fullText) {
            true -> Int.MAX_VALUE
            false -> textMaxLine
        },
        overflow = TextOverflow.Ellipsis,
        lineHeight = 20.sp
    )
}