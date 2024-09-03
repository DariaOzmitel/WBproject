package com.example.wbproject.ui.eventUi.elements.images

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.wbproject.R
import com.example.wbproject.ui.eventUi.theme.EventTheme

@Composable
fun CommunityAvatar(
    modifier: Modifier = Modifier,
    model: Any?,
    size: Dp = EventTheme.dimensions.dimension104,
    contentDescription: String = ""
) {
    AsyncImage(
        model = model,
        contentDescription = contentDescription,
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .size(size),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
private fun CommunityAvatarPreview() {
    CommunityAvatar(model = R.drawable.community_avatar_example)
}