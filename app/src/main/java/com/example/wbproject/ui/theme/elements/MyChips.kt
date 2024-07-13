package com.example.wbproject.ui.theme.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.ui.theme.LightColors
import com.example.wbproject.ui.theme.MeetingDimensionsValue
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.text.TextMetadata3

val listChipsExample = listOf(
    "Python",
    "Junior",
    "Moscow"
)

@Composable
fun MyChipRow(
    modifier: Modifier = Modifier,
    containerColor: Color = LightColors.brandColorBackGround,
    contentColor: Color = LightColors.brandColorDark,
    listChips: List<String> = listChipsExample
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(MeetingTheme.dimensions.dimension8)
    ) {
        listChips.forEach {
            MyChip(
                modifier = modifier,
                text = it,
                containerColor = containerColor,
                contentColor = contentColor
            )
        }
    }
}

@Composable
fun MyChip(
    modifier: Modifier = Modifier,
    text: String,
    containerColor: Color = LightColors.brandColorBackGround,
    contentColor: Color = LightColors.brandColorDark,
) {
    Box(
        modifier = modifier
            .height(MeetingDimensionsValue.dimension16)
            .clip(RoundedCornerShape(MeetingTheme.dimensions.dimension32))
            .background(color = containerColor)
            .padding(
                vertical = MeetingTheme.dimensions.dimension2,
                horizontal = MeetingTheme.dimensions.dimension4
            ),
    ) {
        TextMetadata3(text = text, color = contentColor)
    }
}

@Preview
@Composable
private fun MyChipRowPreview() {
    MyChipRow()
}