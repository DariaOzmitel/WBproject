package com.example.ui.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.data.mockData.mockUser
import com.example.data.mockData.mockUserList
import com.example.domain.model.User
import com.example.ui.elements.chips.EventChip14
import com.example.ui.elements.images.UserAvatar
import com.example.ui.elements.text.TextPrimary
import com.example.ui.theme.EventTheme

@Composable
internal fun UserCard(modifier: Modifier = Modifier, user: User) {
    Column(modifier = modifier) {
        UserAvatar(
            modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension4),
            user = user
        )
        TextPrimary(
            modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension4),
            text = user.name
        )
        user.interests?.first()?.name?.let { EventChip14(text = it) }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun UserCardFlowRow(modifier: Modifier = Modifier, userList: List<User>) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(EventTheme.dimensions.dimension24),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        userList.forEach {
            UserCard(
                user = it
            )
        }
    }
}

@Preview
@Composable
private fun UserCardRowPreview() {
    UserCardFlowRow(userList = mockUserList)
}

@Preview
@Composable
private fun UserCardPreview() {
    UserCard(user = mockUser)
}