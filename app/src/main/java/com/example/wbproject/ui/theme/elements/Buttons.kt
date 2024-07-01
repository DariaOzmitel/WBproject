package com.example.wbproject.ui.theme.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.arguments.MyButtonArguments

@Composable
fun MyButtonsRow(
    args: MyButtonArguments
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        MyButton(args = args)
        MyOutlinedButton(args = args)
        MyTextButton(args = args)
    }
}


//@Preview
@Composable
fun MyButtonsPreview() {

    Column(modifier = Modifier.fillMaxWidth()) {
        MyButtonsRow(MyButtonArguments())
        MyButtonsRow(MyButtonArguments(primaryColor = MeetingTheme.colors.brandColorDark))
        MyButtonsRow(MyButtonArguments(enabled = false))
    }
}