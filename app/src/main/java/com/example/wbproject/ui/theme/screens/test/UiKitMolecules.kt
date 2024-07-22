package com.example.wbproject.ui.theme.screens.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.data.mockData.mockCommunity
import com.example.data.mockData.mockMeeting
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.molecules.CommunityCard
import com.example.wbproject.ui.theme.molecules.MeetingCard
import com.example.wbproject.ui.theme.molecules.ProfileAvatar
import com.example.wbproject.ui.theme.molecules.RowAvatarsPreview

@Composable
fun UiKitMolecules() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = MeetingTheme.dimensions.dimension16
            )
    ) {
        Column(
            modifier = Modifier
                .padding(MeetingTheme.dimensions.dimension16)
                .padding(
                    8.dp
                )
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(MeetingTheme.dimensions.dimension16)
        ) {
            MeetingCard(meeting = mockMeeting)
            RowAvatarsPreview()
            CommunityCard(community = mockCommunity)
            ProfileAvatar(
                isEditStatus = false,
                painter = painterResource(id = R.drawable.user),
                size = MeetingTheme.dimensions.dimension100
            )
            ProfileAvatar(
                painter = painterResource(id = R.drawable.user),
                size = MeetingTheme.dimensions.dimension100
            )
        }
    }

}