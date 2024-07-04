package com.example.wbproject.ui.theme.molecules

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.arguments.MyTextArguments
import com.example.wbproject.ui.theme.elements.MyText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    addArrowLeft: Boolean,
    rightIconResId: Int?,
    title: String,
    onRightButtonClickListener: () -> Unit = {}
) {
    TopAppBar(modifier = Modifier.padding(top = MeetingTheme.dimensions.dimension16),
        title = {
            MyText(
                myTextArguments = MyTextArguments(
                    text = title,
                    textStyle = MeetingTheme.typography.subheading1
                )
            )
        },
        navigationIcon = {
            if (addArrowLeft) {
                IconButton(onClick = {}) {
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
    MyTopBar(addArrowLeft = true, rightIconResId = R.drawable.group_alt, title = "Test")
}
