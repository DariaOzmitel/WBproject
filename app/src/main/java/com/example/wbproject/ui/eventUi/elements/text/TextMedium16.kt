package com.example.wbproject.ui.eventUi.elements.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.example.wbproject.ui.eventUi.theme.EventTheme

@Composable
fun TextMedium16(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    lineHeight: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text,
        style = EventTheme.typography.medium16,
        color = color,
        overflow = overflow,
        maxLines = maxLines,
        lineHeight = lineHeight,
        textAlign = textAlign
    )
}