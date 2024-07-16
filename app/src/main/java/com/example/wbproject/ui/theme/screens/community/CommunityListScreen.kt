package com.example.wbproject.ui.theme.screens.community

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.MySearchTextField
import com.example.wbproject.ui.theme.molecules.CommunityCardColumn

private const val COMMUNITY_CARD_COUNT = 10

@Preview
@Composable
fun CommunityListScreen(
    modifier: Modifier = Modifier,
    onCommunityCardClickListener: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = MeetingTheme.dimensions.dimension106,
                start = MeetingTheme.dimensions.dimension16,
                end = MeetingTheme.dimensions.dimension16,
                bottom = MeetingTheme.dimensions.dimension100,
            )
    ) {
        MySearchTextField(modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension16))
        CommunityCardColumn(
            count = COMMUNITY_CARD_COUNT,
            onCommunityCardClickListener = onCommunityCardClickListener
        )
    }
}
