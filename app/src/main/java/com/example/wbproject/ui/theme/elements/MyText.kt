package com.example.wbproject.ui.theme.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbproject.ui.theme.MeetingTypographyValue
import com.example.wbproject.ui.theme.arguments.MyTextArguments

@Composable
fun MyTextColumn(modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        MyText(MyTextArguments(textStyle = MeetingTypographyValue.heading1))
        MyText(MyTextArguments(textStyle = MeetingTypographyValue.heading2))
        MyText(MyTextArguments(textStyle = MeetingTypographyValue.subheading1))
        MyText(MyTextArguments(textStyle = MeetingTypographyValue.subheading2))
        MyText(MyTextArguments(textStyle = MeetingTypographyValue.bodyText1))
        MyText(MyTextArguments(textStyle = MeetingTypographyValue.bodyText2))
        MyText(MyTextArguments(textStyle = MeetingTypographyValue.metadata1))
        MyText(MyTextArguments(textStyle = MeetingTypographyValue.metadata2))
        MyText(MyTextArguments(textStyle = MeetingTypographyValue.metadata3))
    }
}

@Composable
fun MyText(
    myTextArguments: MyTextArguments
) {
    with(myTextArguments) {
        Text(
            modifier = modifier,
            text = text,
            style = textStyle,
            color = color
        )
    }
}

@Preview
@Composable
private fun MyTextPreview() {
    MyTextColumn()
}