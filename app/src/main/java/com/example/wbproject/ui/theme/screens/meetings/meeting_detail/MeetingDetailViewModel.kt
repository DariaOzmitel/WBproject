package com.example.wbproject.ui.theme.screens.meetings.meeting_detail

import androidx.lifecycle.ViewModel
import com.example.wbproject.data.mockData.mockMapUrl
import com.example.wbproject.data.mockData.mockMeeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MeetingDetailViewModel : ViewModel() {
    private val meetingDetailStateMutable =
        MutableStateFlow(MeetingDetailState(meeting = mockMeeting, mapUrl = mockMapUrl))
    private val meetingDetailState: StateFlow<MeetingDetailState> = meetingDetailStateMutable

    fun getMeetingDetailFlow(): StateFlow<MeetingDetailState> = meetingDetailState
}