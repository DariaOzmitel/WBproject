package com.example.ui.elements.images

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ui.R
import com.example.ui.theme.EventTheme

@Composable
fun EventAvatar(
    modifier: Modifier = Modifier,
    model: Any?,
    height: Dp = EventTheme.dimensions.dimension180,
    contentDescription: String = ""
) {
    AsyncImage(
        model = model,
        contentDescription = contentDescription,
        modifier = modifier
            .height(height)
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
private fun EventAvatarPreview() {
    EventAvatar(model = R.drawable.event_card_example)
}