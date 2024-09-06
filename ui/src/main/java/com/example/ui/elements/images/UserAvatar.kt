package com.example.ui.elements.images

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.domain.model.User
import com.example.ui.theme.EventTheme

@Composable
internal fun UserAvatar(modifier: Modifier = Modifier, user: User) {
    AsyncImage(
        modifier = modifier
            .size(EventTheme.dimensions.dimension104)
            .clip(CircleShape),
        model = user.avatarModel,
        contentScale = ContentScale.Crop,
        contentDescription = ""
    )
}
