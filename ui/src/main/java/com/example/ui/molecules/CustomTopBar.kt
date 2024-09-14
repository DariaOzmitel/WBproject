package com.example.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.R
import com.example.ui.elements.text.TextPrimary
import com.example.ui.theme.EventTheme
import com.example.ui.theme.NoRippleConfiguration

private const val MAX_LINES_TOP_BAR = 1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CustomTopBar(
    modifier: Modifier = Modifier,
    heading: String? = null,
    onLeftIconClickListener: () -> Unit,
    rightIcon: Painter? = null,
    onRightIconClickListener: () -> Unit = {}
) {
    CompositionLocalProvider(LocalRippleConfiguration provides NoRippleConfiguration) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = EventTheme.dimensions.dimension8),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                modifier = Modifier
                    .clickable { onLeftIconClickListener() }
                    .size(EventTheme.dimensions.dimension24),
                contentDescription = stringResource(id = R.string.search_hint),
            )
            heading?.let {
                TextPrimary(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = EventTheme.dimensions.dimension10),
                    text = heading,
                    maxLines = MAX_LINES_TOP_BAR,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
            rightIcon?.let {
                Image(
                    painter = rightIcon,
                    modifier = Modifier
                        .clickable { onRightIconClickListener() }
                        .size(EventTheme.dimensions.dimension24),
                    contentDescription = stringResource(id = R.string.search_hint)
                )
            }
        }
    }
}

@Preview
@Composable
private fun CustomTopBarPreview() {
    CustomTopBar(
        heading = stringResource(id = R.string.interests_subheading),
        onLeftIconClickListener = {}, rightIcon = painterResource(id = R.drawable.share)
    )
}