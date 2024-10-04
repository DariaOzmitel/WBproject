package com.example.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.ui.R
import com.example.ui.elements.text.TextMedium16
import com.example.ui.elements.text.TextSecondary
import com.example.ui.theme.EventTheme

@Composable
internal fun SelectInterestsCard(
    modifier: Modifier = Modifier,
    onSelectInterestButtonClickListener: () -> Unit
) {
    Box(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(EventTheme.dimensions.dimension16)),
            painter = painterResource(id = R.drawable.select_iterests_banner),
            contentDescription = stringResource(
                id = R.string.select_interests
            )
        )
        Column(modifier = Modifier.padding(start = EventTheme.dimensions.dimension10)) {
            TextSecondary(
                modifier = Modifier.padding(
                    top = EventTheme.dimensions.dimension10,
                    end = EventTheme.dimensions.dimension80,
                    bottom = EventTheme.dimensions.dimension14
                ),
                text = stringResource(id = R.string.select_interests_text),
                color = EventTheme.colors.fontColorWhite
            )
            CompositionLocalProvider(
                LocalMinimumInteractiveComponentSize provides Dp.Unspecified
            ) {
                Button(
                    modifier = Modifier
                        .padding()
                        .clip(RoundedCornerShape(EventTheme.dimensions.dimension8))
                        .background(EventTheme.colors.gradientWhite),
                    onClick = onSelectInterestButtonClickListener,
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = EventTheme.colors.brandColorPurple
                    ),
                    contentPadding = PaddingValues(horizontal = EventTheme.dimensions.dimension12)
                ) {
                    TextMedium16(text = stringResource(id = R.string.select_interests))
                }
            }
        }
    }
}

@Preview
@Composable
private fun SelectInterestsCardPreview() {
    SelectInterestsCard {}
}