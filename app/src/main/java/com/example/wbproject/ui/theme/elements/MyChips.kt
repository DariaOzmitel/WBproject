package com.example.wbproject.ui.theme.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.ui.theme.MeetingDimensionsValue
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.MeetingTypographyValue
import com.example.wbproject.ui.theme.arguments.MyChipArguments

val listChipsExample = listOf(
    MyChipArguments(
        text = "Python"
    ),
    MyChipArguments(
        text = "Junior"
    ),
    MyChipArguments(
        text = "Moscow"
    )
)

@Composable
fun MyChipRow(modifier: Modifier = Modifier, listChips: List<MyChipArguments> = listChipsExample) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(MeetingTheme.dimensions.dimension8)
    ) {
        listChips.forEach {
            MyChip(myChipArguments = it)
        }
    }
}

@Composable
fun MyChip(
    myChipArguments: MyChipArguments
) {
    with(myChipArguments) {
        Box(
            modifier = modifier
                .height(MeetingDimensionsValue.dimension16)
                .clip(RoundedCornerShape(MeetingTheme.dimensions.dimension32))
                .background(color = containerColor)
                .padding(
                    start = MeetingTheme.dimensions.dimension4,
                    bottom = MeetingTheme.dimensions.dimension2,
                    end = MeetingTheme.dimensions.dimension4,
                    top = MeetingTheme.dimensions.dimension2
                ),
        ) {
            Text(text = text, style = MeetingTypographyValue.metadata3, color = contentColor)
        }
    }
}

@Preview
@Composable
private fun MyChipRowPreview() {
    MyChipRow()
}