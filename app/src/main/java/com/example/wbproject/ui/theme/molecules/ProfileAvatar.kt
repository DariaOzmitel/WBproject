package com.example.wbproject.ui.theme.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.domain.IconInCircleArgs
import com.example.wbproject.ui.theme.domain.MyAvatarArgs
import com.example.wbproject.ui.theme.elements.IconInCircle
import com.example.wbproject.ui.theme.elements.MyAvatar

@Composable
fun ProfileAvatar(isEditStatus: Boolean = true, iconInCircleArgs: IconInCircleArgs) {
    Box(
        modifier = Modifier.size(MeetingTheme.dimensions.dimension100),
        contentAlignment = Alignment.BottomEnd
    ) {
        IconInCircle(
            iconInCircleArgs
        )

        if (isEditStatus) {
            MyAvatar(
                MyAvatarArgs(
                    painter = painterResource(id = R.drawable.add),
                    modifier = Modifier.size(MeetingTheme.dimensions.dimension22)
                )
            )
        }
    }
}

@Preview
@Composable
private fun ProfileAvatarPreview() {
    ProfileAvatar(
        iconInCircleArgs = IconInCircleArgs(
            painter = painterResource(id = R.drawable.user),
            size = MeetingTheme.dimensions.dimension100
        )
    )
}
