package com.example.ui.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.data.mockData.mockUserList
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme
import com.example.ui.theme.NoRippleConfiguration

private const val MAX_DISPLAYED_AVATARS = 5

@Composable
private fun PeopleRow(
    modifier: Modifier = Modifier,
    overlappingPercentage: Float,
    content: @Composable () -> Unit
) {

    val factor = (1 - overlappingPercentage)

    Layout(
        modifier = modifier,
        content = content,
        measurePolicy = { measurables, constraints ->
            val placeables = measurables.map { it.measure(constraints) }
            val widthsExceptFirst = placeables.subList(1, placeables.size).sumOf { it.width }
            val firstWidth = placeables.getOrNull(0)?.width ?: 0
            val width = (widthsExceptFirst * factor + firstWidth).toInt()
            val height = placeables.maxOf { it.height }
            layout(width, height) {
                var x = 0
                placeables.forEachIndexed { index, placeable ->
                    placeable.placeRelative(x, 0, (placeables.size - index).toFloat())
                    x += (placeable.width * factor).toInt()
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PeopleAvatarsRow(
    modifier: Modifier = Modifier,
    avatars: List<String>?,
    displayedAvatarsNum: Int = MAX_DISPLAYED_AVATARS,
    onAvatarsRowClickListener: () -> Unit,
) {
    CompositionLocalProvider(LocalRippleConfiguration provides NoRippleConfiguration) {
        LazyRow(
            modifier = modifier.clickable { onAvatarsRowClickListener() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!avatars.isNullOrEmpty()) {
                item {
                    PeopleRow(
                        modifier = Modifier.padding(end = EventTheme.dimensions.dimension16),
                        overlappingPercentage = 0.20f
                    ) {
                        avatars.take(MAX_DISPLAYED_AVATARS).forEach {
                            AsyncImage(
                                model = it,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(EventTheme.dimensions.dimension48)
                                    .clip(CircleShape)
                            )
                        }
                    }
                }
                if (avatars.size > displayedAvatarsNum) {
                    item {
                        TextSecondary(
                            text = "+${avatars.size - displayedAvatarsNum}",
                            color = EventTheme.colors.brandColorPurple,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PeopleAvatarsRowPreview() {
    PeopleAvatarsRow(avatars = mockUserList.map { it.avatarModel.toString() }) {}
}