package com.example.wbproject.ui.theme.screens.meetings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.MyChipRow
import com.example.wbproject.ui.theme.elements.buttons.MyButton
import com.example.wbproject.ui.theme.elements.text.TextBody1
import com.example.wbproject.ui.theme.elements.text.TextMetadata1
import com.example.wbproject.ui.theme.molecules.RowAvatars

private const val TEXT_MAX_LINE = 8
private const val TEST_MAP =
    "https://s3-alpha-sig.figma.com/img/a7d0/b7a1/73dfa50190eed292a52792c6d52bb4be?Expires=1721606400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Lbp~3M0cO0QqU4lp~FXgS4hYwsMVN97j2OZ3HVxb8dEnfLglnfSrPAkaAzJfYEpb69jK3ownyv8GlElutrbD8Ae3vdiQjXpFbOoK-3sgXTVMdTNHCDC7yyRnqwxiCN-9OLFYuwlzvRem139gTzBSrgQ4h0~2T1Gf-XE7I29MM6n3SpJ-xLwwpHaOnDMFG35KkPwHIMVl~RQOSb3CNPrf2CLrbrcuTeLGJdoItKkuEobXERZjHBVTh4PvhxdXMmHiRKykksWEEYGc1UmbH7x~oY1EVQx2UTob2aMF4ro~eu57F8-JthhN3Cd8t9o9Tyi92ZIayuZyICVx9Q7bMzgMoQ__"

@Preview
@Composable
fun MeetingDetailScreen(modifier: Modifier = Modifier) {
    var fullText by rememberSaveable {
        mutableStateOf(false)
    }
    val testImageList = mutableListOf<Int>().apply {
        repeat(16) {
            add(R.drawable.avatar_example)
        }
    }
    var fullMap by rememberSaveable {
        mutableStateOf(false)
    }
    val testText = "13.09.2024 - Москва,ул.Громова,4"

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    top = MeetingTheme.dimensions.dimension106,
                    start = MeetingTheme.dimensions.dimension16,
                    end = MeetingTheme.dimensions.dimension16,
                    bottom = MeetingTheme.dimensions.dimension100,
                )
        ) {
            item {
                TextBody1(
                    modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension12),
                    text = testText,
                    color = MeetingTheme.colors.neutralWeak,
                )
            }
            item {
                MyChipRow(modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension16))
            }
            item {
                AsyncImage(
                    modifier = Modifier
                        .padding(bottom = MeetingTheme.dimensions.dimension32)
                        .fillMaxWidth()
                        .height(MeetingTheme.dimensions.dimension176)
                        .clip(RoundedCornerShape(16.dp))
                        .clickable { fullMap = true },
                    contentScale = ContentScale.None,
                    model = TEST_MAP,
                    contentDescription = null,
                )
            }
            item {
                TextMetadata1(
                    modifier = Modifier
                        .padding(bottom = MeetingTheme.dimensions.dimension32)
                        .clickable {
                            fullText = !fullText
                        },
                    text = LoremIpsum(300).values.first(),
                    color = MeetingTheme.colors.neutralWeak,
                    maxLines = when (fullText) {
                        true -> Int.MAX_VALUE
                        false -> TEXT_MAX_LINE
                    },
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 20.sp
                )
            }
            item {
                RowAvatars(
                    modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension20),
                    avatars = testImageList
                )
                MyButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MeetingTheme.dimensions.dimension52),
                    text = stringResource(id = R.string.i_am_going_to_a_meeting),
                )
            }
        }
        if (fullMap) {
            Dialog(
                properties = DialogProperties(
                    usePlatformDefaultWidth = false,
                    dismissOnClickOutside = true
                ),
                onDismissRequest = { fullMap = false }
            ) {
                AsyncImage(
                    model = TEST_MAP,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}