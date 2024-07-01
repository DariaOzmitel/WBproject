package com.example.wbproject.ui.theme.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wbproject.R
import com.example.wbproject.ui.theme.LightColors
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.arguments.IconInCircleArgs
import com.example.wbproject.ui.theme.arguments.MyAvatarArgs

@Composable
private fun MyAvatarColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconInCircle(
            IconInCircleArgs(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "", size = MeetingTheme.dimensions.dimension80
            )
        )
        MyAvatar(
            MyAvatarArgs(
                painter = painterResource(R.drawable.avatar_example), modifier = Modifier
                    .size(MeetingTheme.dimensions.dimension48)
            )
        )
    }
}

@Composable
fun MyAvatar(
    myAvatarArgs: MyAvatarArgs
) {
    with(myAvatarArgs) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = modifier.clip(RoundedCornerShape(16.dp))
        )
    }
}

@Composable
fun IconInCircle(iconInCircleArgs: IconInCircleArgs) {
    with(iconInCircleArgs) {
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(size)
                .clip(CircleShape)
                .background(LightColors.brandColorBackGround)
                .padding(size * 0.25f),
        )
    }

}

@Preview
@Composable
fun MyAvatarColumnPreview() {
    MyAvatarColumn(
        Modifier
            .fillMaxWidth()
    )
}