package com.example.wbproject.ui.theme.deprecatedUi.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.wbproject.R
import com.example.wbproject.ui.theme.deprecatedUi.elements.IconInCircle
import com.example.wbproject.ui.theme.deprecatedUi.elements.MyAvatar
import com.example.wbproject.ui.theme.deprecatedUi.theme.MeetingTheme

@Composable
fun ProfileAvatar(
    modifier: Modifier = Modifier,
    isEditStatus: Boolean = true,
    size: Dp,
    painter: Painter,
    contentDescription: String = ""
) {
    Box(
        modifier = modifier.size(MeetingTheme.dimensions.dimension100),
        contentAlignment = Alignment.BottomEnd
    ) {
        IconInCircle(
            painter = painter,
            size = size
        )
        if (isEditStatus) {
            MyAvatar(
                painter = painterResource(id = R.drawable.add),
                modifier = Modifier.size(MeetingTheme.dimensions.dimension22)
            )
        }
    }
}

@Preview
@Composable
private fun ProfileAvatarPreview() {
    ProfileAvatar(
        painter = painterResource(id = R.drawable.user),
        size = MeetingTheme.dimensions.dimension100
    )
}
