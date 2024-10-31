package com.example.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import com.example.ui.theme.EventDimensionsValue

internal fun Modifier.ignoreHorizontalParentPadding(horizontal: Dp = EventDimensionsValue.dimension16): Modifier {
    return this.layout { measurable, constraints ->
        val overridenWidth = constraints.maxWidth + 2 * horizontal.roundToPx()
        val placeable = measurable.measure(constraints.copy(maxWidth = overridenWidth))
        layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}

internal fun Int?.orZero(): Int {
    return this ?: 0
}