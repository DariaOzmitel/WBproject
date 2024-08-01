package com.example.wbproject.ui.theme.screens.meetings.meeting_detail

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.data.mockData.mockMapUrl
import com.example.data.mockData.mockMeeting
import com.example.domain.model.Meeting
import com.example.wbproject.R
import com.example.wbproject.ui.theme.MeetingTheme
import com.example.wbproject.ui.theme.elements.MyChipRow
import com.example.wbproject.ui.theme.elements.ProgressIndicator
import com.example.wbproject.ui.theme.elements.buttons.MyButton
import com.example.wbproject.ui.theme.elements.text.TextBody1
import com.example.wbproject.ui.theme.molecules.RowAvatars
import com.example.wbproject.ui.theme.molecules.TextForDescription
import org.koin.androidx.compose.koinViewModel

private const val TEXT_MAX_LINE = 8

@Composable
fun MeetingDetailScreen(modifier: Modifier = Modifier) {
    val viewModel: MeetingDetailViewModel = koinViewModel()
    val meetingDetailState by viewModel.getMeetingDetailFlow().collectAsStateWithLifecycle()
    var fullText by rememberSaveable {
        mutableStateOf(false)
    }
    var fullMap by rememberSaveable {
        mutableStateOf(false)
    }
    when (val state = meetingDetailState) {
        is MeetingDetailState.Loading -> ProgressIndicator()
        is MeetingDetailState.MeetingDetail -> MeetingDetailContent(
            modifier = modifier,
            meeting = state.meeting,
            mapUrl = state.mapUrl,
            fullMap = fullMap,
            fullText = fullText,
            onDismissRequestClickListener = { fullMap = false },
            onTextClickListener = { fullText = !fullText }) {
            fullMap = true
        }
    }
}

@Composable
private fun MeetingDetailContent(
    modifier: Modifier = Modifier,
    meeting: Meeting,
    mapUrl: String,
    fullMap: Boolean,
    fullText: Boolean,
    onDismissRequestClickListener: () -> Unit,
    onTextClickListener: () -> Unit,
    onMapClickListener: () -> Unit,
) {
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
                    text = String.format(
                        stringResource(id = R.string.date_city_template),
                        meeting.date,
                        meeting.city
                    ),
                    color = MeetingTheme.colors.neutralWeak,
                )
            }
            item {
                meeting.chipsList?.let {
                    MyChipRow(modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension16))
                }
            }
            item {
                AsyncImage(
                    modifier = Modifier
                        .padding(bottom = MeetingTheme.dimensions.dimension32)
                        .fillMaxWidth()
                        .height(MeetingTheme.dimensions.dimension176)
                        .clip(RoundedCornerShape(16.dp))
                        .clickable { onMapClickListener() },
                    contentScale = ContentScale.None,
                    model = mapUrl,
                    contentDescription = null,
                )
            }
            item {
                TextForDescription(
                    fullText = fullText,
                    description = meeting.description,
                    textMaxLine = TEXT_MAX_LINE
                ) {
                    onTextClickListener()
                }
            }
            item {
                RowAvatars(
                    modifier = Modifier.padding(bottom = MeetingTheme.dimensions.dimension20),
                    avatars = meeting.usersList?.map { it.avatarUrl }
                )
            }
            item {
                MyButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(id = R.string.i_am_going_to_a_meeting),
                )
            }
        }
        if (fullMap) {
            IsFullMapContent(mapUrl = mapUrl) {
                onDismissRequestClickListener()
            }
        }
    }
}

@Composable
private fun IsFullMapContent(mapUrl: String, onDismissRequestClickListener: () -> Unit) {
    Dialog(
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnClickOutside = true
        ),
        onDismissRequest = { onDismissRequestClickListener() }
    ) {
        AsyncImage(
            model = mapUrl,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun MeetingDetailScreenPreview() {
    MeetingDetailContent(
        meeting = mockMeeting,
        mapUrl = mockMapUrl,
        fullMap = false,
        fullText = false,
        onDismissRequestClickListener = {},
        onTextClickListener = {}) {
    }
}