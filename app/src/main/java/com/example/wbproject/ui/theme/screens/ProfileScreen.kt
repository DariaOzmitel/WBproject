package com.example.wbproject.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.arguments.IconInCircleArgs
import com.example.wbproject.ui.theme.arguments.MyOutlineButtonArguments
import com.example.wbproject.ui.theme.arguments.MyTextArguments
import com.example.wbproject.ui.theme.elements.IconInCircle
import com.example.wbproject.ui.theme.elements.MyOutlinedButton
import com.example.wbproject.ui.theme.elements.MyText

@Preview
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = MeetingTheme.dimensions.dimension150,
                start = MeetingTheme.dimensions.dimension8,
                end = MeetingTheme.dimensions.dimension8
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconInCircle(
            iconInCircleArgs = IconInCircleArgs(
                size = MeetingTheme.dimensions.dimension200, painter = painterResource(
                    id = R.drawable.user
                )
            )
        )
        Spacer(modifier = Modifier.height(MeetingTheme.dimensions.dimension16))
        MyText(
            myTextArguments = MyTextArguments(
                text = "Иван Иванов",
                textStyle = MeetingTheme.typography.heading2
            )
        )
        MyText(
            myTextArguments = MyTextArguments(
                text = "+7 999 999-99-99",
                textStyle = MeetingTheme.typography.subheading2,
                color = MeetingTheme.colors.neutralDisabled
            )
        )
        Spacer(modifier = Modifier.height(MeetingTheme.dimensions.dimension40))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MyOutlinedButton(
                args = MyOutlineButtonArguments(
                    modifier = Modifier
                        .width(MeetingTheme.dimensions.dimension72)
                        .height(MeetingTheme.dimensions.dimension40),
                    isIcon = true,
                    iconResId = R.drawable.twitter
                )
            )
            MyOutlinedButton(
                args = MyOutlineButtonArguments(
                    modifier = Modifier
                        .width(MeetingTheme.dimensions.dimension72)
                        .height(MeetingTheme.dimensions.dimension40),
                    isIcon = true,
                    iconResId = R.drawable.instagram
                )
            )
            MyOutlinedButton(
                args = MyOutlineButtonArguments(
                    modifier = Modifier
                        .width(MeetingTheme.dimensions.dimension72)
                        .height(MeetingTheme.dimensions.dimension40),
                    isIcon = true,
                    iconResId = R.drawable.linked_in
                )
            )
            MyOutlinedButton(
                args = MyOutlineButtonArguments(
                    modifier = Modifier
                        .width(MeetingTheme.dimensions.dimension72)
                        .height(MeetingTheme.dimensions.dimension40),
                    isIcon = true,
                    iconResId = R.drawable.facebook
                )
            )
        }
    }

}