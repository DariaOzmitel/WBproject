package com.example.ui.elements.images

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import com.example.ui.R
import com.example.ui.theme.EventTheme

@Composable
internal fun CommunityAvatar(
    modifier: Modifier = Modifier,
    model: Any?,
    size: Dp = EventTheme.dimensions.dimension104,
    contentDescription: String = ""
) {
    AsyncImage(
        model = model,
        contentDescription = contentDescription,
        modifier = modifier
            .clip(RoundedCornerShape(EventTheme.dimensions.dimension16))
            .size(size),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
private fun CommunityAvatarPreview() {
    CommunityAvatar(model = R.drawable.community_avatar_example)
}