package com.example.wbproject.ui.theme.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbproject.R
import com.example.wbproject.ui.theme.LightColors
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.MeetingTypographyValue
import com.example.wbproject.ui.theme.arguments.MyAvatarArgs
import com.example.wbproject.ui.theme.arguments.MyTextArguments
import com.example.wbproject.ui.theme.elements.MyAvatar
import com.example.wbproject.ui.theme.elements.MyText

@Composable
fun CommunityCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier, colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            MyAvatar(
                MyAvatarArgs(
                    painter = painterResource(id = R.drawable.avatar),
                    modifier = Modifier.size(MeetingTheme.dimensions.dimension56)
                )
            )
            Spacer(modifier = Modifier.width(MeetingTheme.dimensions.dimension8))
            Column(modifier = Modifier.height(MeetingTheme.dimensions.dimension70)) {
                MyText(
                    myTextArguments = MyTextArguments(
                        text = "Designa",
                        textStyle = MeetingTypographyValue.bodyText1
                    )
                )
                Spacer(modifier = Modifier.height(MeetingTheme.dimensions.dimension4))
                MyText(
                    myTextArguments = MyTextArguments(
                        text = "10 000 человек",
                        color = LightColors.neutralWeak,
                        textStyle = MeetingTypographyValue.metadata1
                    )
                )
            }
        }

    }
}

@Preview
@Composable
private fun CommunityCardPreview() {
    CommunityCard(
        Modifier
            .fillMaxWidth()
            .height(70.dp)
    )
}