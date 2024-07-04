package com.example.wbproject.ui.theme.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import com.example.wbproject.ui.theme.elements.MyChipRow
import com.example.wbproject.ui.theme.elements.MyText


@Composable
fun MeetingCard(modifier: Modifier = Modifier, isEnded: Boolean = false) {
    Card(
        modifier = modifier,
        shape = RectangleShape, colors = CardDefaults.cardColors(
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
            Column(
                modifier = Modifier
                    .height(68.dp)
                    .weight(1f),

                verticalArrangement = Arrangement.SpaceBetween
            ) {
                MyText(
                    myTextArguments = MyTextArguments(
                        text = "Developer meeting",
                        textStyle = MeetingTypographyValue.bodyText1
                    )
                )
                MyText(
                    myTextArguments = MyTextArguments(
                        text = "13.09.2024 - Москва",
                        color = LightColors.neutralWeak,
                        textStyle = MeetingTypographyValue.metadata1
                    )
                )
                MyChipRow()
            }
            if (isEnded) {
                MyText(
                    myTextArguments = MyTextArguments(
                        text = "Закончилась",
                        textStyle = MeetingTheme.typography.metadata2,
                        color = MeetingTheme.colors.neutralWeak
                    )
                )
            }

        }
        HorizontalDivider(
            Modifier.padding(top = MeetingTheme.dimensions.dimension16),
            color = MeetingTheme.colors.neutralLine
        )
    }

}

@Composable
fun MeetingCardColumn(count: Int) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(count) {
            MeetingCard(
                modifier = Modifier
                    .height(88.dp)
            )
        }
    }
}

@Preview
@Composable
private fun MeetingCardPreview() {
    MeetingCard(
        modifier = Modifier
            .height(88.dp)
            .fillMaxWidth()
    )
}