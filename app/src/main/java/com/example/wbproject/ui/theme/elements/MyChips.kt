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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbproject.ui.theme.LightColors
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.MeetingTypographyValue
import com.example.wbproject.ui.theme.arguments.MyChipArguments
import com.example.wbproject.ui.theme.arguments.MyTextArguments

val listChipsExample = listOf(
    MyChipArguments(
        myTextArguments = MyTextArguments(
            text = "Python",
            color = LightColors.brandColorDark,
            textStyle = MeetingTypographyValue.metadata3
        )
    ),
    MyChipArguments(
        myTextArguments = MyTextArguments(
            text = "Junior",
            color = LightColors.brandColorDark,
            textStyle = MeetingTypographyValue.metadata3
        )
    ),
    MyChipArguments(
        myTextArguments = MyTextArguments(
            text = "Moscow",
            color = LightColors.brandColorDark,
            textStyle = MeetingTypographyValue.metadata3
        )
    )
)

@Composable
fun MyChipRow(modifier: Modifier = Modifier, listChips: List<MyChipArguments> = listChipsExample) {
    Row(
        modifier = modifier.height(24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
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
                .clip(RoundedCornerShape(MeetingTheme.dimensions.dimension32))
                .background(color = containerColor)
                .padding(
                    start = MeetingTheme.dimensions.dimension4,
                    bottom = MeetingTheme.dimensions.dimension2,
                    end = MeetingTheme.dimensions.dimension4,
                    top = MeetingTheme.dimensions.dimension2
                )
        ) {
            MyText(myTextArguments = myTextArguments)
        }

//        AssistChip(
//            modifier = modifier.defaultMinSize(1.dp,1.dp),
//            onClick = onClick,
//            label = { MyText(myTextArguments = myTextArguments) },
//            colors = AssistChipDefaults.assistChipColors(
//                containerColor = containerColor,
//            ),
//            shape = shape,
//            border = border
//        )
    }
}

@Preview
@Composable
private fun MyChipRowPreview() {

    MyChipRow()
//    AssistChip(
//        modifier = Modifier.defaultMinSize(1.dp,1.dp),
//        onClick = {},
//        label = { Text( text = "Junior") },
//        colors = AssistChipDefaults.assistChipColors(
//            containerColor = BrandColorBackGround,
//        ),
//        shape = CircleShape,
//        border = null
//    )

}