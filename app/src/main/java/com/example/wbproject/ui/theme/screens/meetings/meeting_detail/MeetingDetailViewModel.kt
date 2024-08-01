package com.example.wbproject.ui.theme.screens.meetings.meeting_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.mockData.mockMapUrl
import com.example.domain.usecase.interfaces.IGetMeetingUseCase
import com.example.wbproject.navigation.Screen
import com.example.wbproject.orZero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MeetingDetailViewModel(
    private val getMeetingUseCase: IGetMeetingUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val meetingDetailStateMutable: MutableStateFlow<MeetingDetailState> =
        MutableStateFlow(MeetingDetailState.Loading)
    private val meetingDetailState: StateFlow<MeetingDetailState> = meetingDetailStateMutable

    init {
        viewModelScope.launch {
            getMeeting()
        }
    }

    fun getMeetingDetailFlow(): StateFlow<MeetingDetailState> = meetingDetailState

    private fun getMeetingId(): Int {
        return savedStateHandle.get<Int>(Screen.KEY_MEETING_ID).orZero()
    }

    private fun getMeeting() {
        viewModelScope.launch {
            getMeetingUseCase(getMeetingId()).collect { meetingList ->
                meetingDetailStateMutable.update {
                    MeetingDetailState.MeetingDetail(meeting = meetingList, mapUrl = mockMapUrl)
                }
            }
        }
    }
}