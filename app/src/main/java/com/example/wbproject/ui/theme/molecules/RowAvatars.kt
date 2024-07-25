package com.example.wbproject.ui.theme.molecules

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.data.mockData.mockUserList
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.text.TextBody1

private const val MAX_DISPLAYED_AVATARS = 5

@Composable
fun OverlappingRow(
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

@Composable
fun RowAvatars(
    modifier: Modifier = Modifier,
    avatars: List<String>?,
    displayedAvatarsNum: Int = MAX_DISPLAYED_AVATARS
) {

    LazyRow(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        if (!avatars.isNullOrEmpty()) {
            item {
                OverlappingRow(
                    modifier = Modifier.padding(end = MeetingTheme.dimensions.dimension16),
                    overlappingPercentage = 0.20f
                ) {
                    avatars.take(displayedAvatarsNum).forEach {
                        AsyncImage(
                            model = it,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(MeetingTheme.dimensions.dimension48)
                                .clip(RoundedCornerShape(16.dp))
                                .border(
                                    MeetingTheme.dimensions.dimension2,
                                    Color(0xFFFFA0A0),
                                    shape = RoundedCornerShape(16.dp)
                                )
                        )
                    }
                }
            }
            if (avatars.size > displayedAvatarsNum) {
                item {
                    TextBody1(
                        text = "+${avatars.size - displayedAvatarsNum}",
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun RowAvatarsPreview() {
    RowAvatars(avatars = mockUserList.map { it.avatarUrl })
}