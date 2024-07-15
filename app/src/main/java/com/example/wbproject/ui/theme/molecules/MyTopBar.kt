package com.example.wbproject.ui.theme.molecules

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.R
import com.example.wbproject.ui.theme.elements.text.TextSubheading1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    modifier: Modifier = Modifier,
    canNavigateBack: Boolean,
    rightIconResId: Int? = null,
    title: String,
    navigateUp: () -> Unit = {},
    onRightButtonClickListener: () -> Unit = {}
) {
    TopAppBar(modifier = modifier,
        title = {
            TextSubheading1(
                text = title,
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
            }
        },
        actions = {
            if (rightIconResId != null) {
                IconButton(onClick = onRightButtonClickListener) {
                    Icon(
                        painter = painterResource(id = rightIconResId),
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun MyTopBarPreview() {
    MyTopBar(
        canNavigateBack = true, rightIconResId = R.drawable.group_alt, title = stringResource(
            id = R.string.profile
        )
    )
}
