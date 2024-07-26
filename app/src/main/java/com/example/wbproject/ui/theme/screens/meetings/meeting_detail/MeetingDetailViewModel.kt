package com.example.wbproject.ui.theme.screens.meetings.meeting_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.mockData.mockMapUrl
import com.example.domain.usecase.GetMeetingUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MeetingDetailViewModel(
    meetingId: Int,
    getMeetingUseCase: GetMeetingUseCase
) : ViewModel() {
    private val meetingDetailStateMutable: MutableStateFlow<MeetingDetailState> =
        MutableStateFlow(MeetingDetailState.Loading)
    private val meetingDetailState: StateFlow<MeetingDetailState> = meetingDetailStateMutable

    fun getMeetingDetailFlow(): StateFlow<MeetingDetailState> = meetingDetailState

    init {
        viewModelScope.launch {
            val meeting = getMeetingUseCase.invoke(meetingId)
            val mapUrl = mockMapUrl
            delay(500)
            meetingDetailStateMutable.update {
                MeetingDetailState.MeetingDetail(meeting = meeting, mapUrl = mapUrl)
            }
        }
    }
}