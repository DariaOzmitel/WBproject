package com.example.wbproject.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.MySearchTextField
import com.example.wbproject.ui.theme.molecules.CommunityCardColumn

@Composable
fun CommunityListScreen(onCommunityCardClickListener: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = MeetingTheme.dimensions.dimension128,
                start = MeetingTheme.dimensions.dimension16,
                end = MeetingTheme.dimensions.dimension16,
                bottom = MeetingTheme.dimensions.dimension100,
            )
    ) {
        MySearchTextField()
        Spacer(modifier = Modifier.height(MeetingTheme.dimensions.dimension16))
        CommunityCardColumn(10, onCommunityCardClickListener = onCommunityCardClickListener)
    }
}