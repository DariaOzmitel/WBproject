package com.example.wbproject.ui.theme.molecules

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.R
import com.example.wbproject.ui.theme.LightColors
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.domain.MyAvatarArgs
import com.example.wbproject.ui.theme.elements.MyAvatar
import com.example.wbproject.ui.theme.elements.text.TextBody1
import com.example.wbproject.ui.theme.elements.text.TextMetadata1

@Composable
fun CommunityCard(modifier: Modifier = Modifier, onCommunityCardClickListener: () -> Unit = {}) {
    Card(
        modifier = modifier
            .padding(top = MeetingTheme.dimensions.dimension4)
            .clickable { onCommunityCardClickListener() },
        colors = CardDefaults.cardColors(
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
                    modifier = Modifier.size(MeetingTheme.dimensions.dimension48)
                )
            )
            Spacer(modifier = Modifier.width(MeetingTheme.dimensions.dimension8))
            Column {
                TextBody1(
                    text = stringResource(id = R.string.designa)
                )
                Spacer(modifier = Modifier.height(MeetingTheme.dimensions.dimension8))
                TextMetadata1(
                    text = "10 000 человек",
                    color = LightColors.neutralWeak
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(top = MeetingTheme.dimensions.dimension12),
            color = MeetingTheme.colors.neutralLine
        )
    }
}

@Composable
fun CommunityCardColumn(count: Int, onCommunityCardClickListener: () -> Unit = {}) {
    LazyColumn(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(MeetingTheme.dimensions.dimension16),
    ) {
        items(count) {
            CommunityCard(
                modifier = Modifier
                    .height(MeetingTheme.dimensions.dimension68),
                onCommunityCardClickListener = onCommunityCardClickListener
            )
        }
    }
}

@Preview
@Composable
private fun CommunityCardPreview() {
    CommunityCard(
        Modifier
            .fillMaxWidth()
            .height(MeetingTheme.dimensions.dimension68)
    )
}