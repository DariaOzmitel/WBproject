package com.example.ui.elements.images

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.ui.theme.EventTheme

@Composable
internal fun MapImage(
    modifier: Modifier = Modifier,
    model: Any?,
    contentDescription: String = ""
) {
    AsyncImage(
        model = model,
        contentDescription = contentDescription,
        modifier = modifier
            .fillMaxWidth()
            .height(EventTheme.dimensions.dimension180)
            .clip(RoundedCornerShape(EventTheme.dimensions.dimension24)),
        contentScale = ContentScale.Crop
    )
}