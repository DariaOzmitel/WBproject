package com.example.ui.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.R
import com.example.ui.elements.buttons.EventButton
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme

@Composable
internal fun EventBottomBar(modifier: Modifier = Modifier, placesCount: Int) {
    Column(
        modifier = Modifier
            .padding(
                start = EventTheme.dimensions.dimension16,
                end = EventTheme.dimensions.dimension16,
                top = EventTheme.dimensions.dimension10,
                bottom = EventTheme.dimensions.dimension2,
            )
    ) {
        TextSecondary(
            modifier = Modifier.padding(bottom = EventTheme.dimensions.dimension8),
            text = String.format(
                stringResource(id = R.string.reminder_number_places),
                placesCount
            ),
            color = EventTheme.colors.brandColorPurple
        )
        EventButton(text = stringResource(id = R.string.register_event))
    }
}


@Preview
@Composable
private fun EventBottomBarPreview() {
    EventBottomBar(placesCount = 30)
}