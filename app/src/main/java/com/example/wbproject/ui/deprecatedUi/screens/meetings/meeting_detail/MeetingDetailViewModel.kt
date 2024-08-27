package com.example.wbproject.ui.theme.deprecatedUi.screens.meetings.meeting_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.mockData.mockMapUrl
import com.example.domain.usecase.interfaces.IChangeAttendingStatusUseCase
import com.example.domain.usecase.interfaces.IGetMeetingUseCase
import com.example.domain.usecase.interfaces.IGetUserFlowUseCase
import com.example.wbproject.navigation.Screen
import com.example.wbproject.orZero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MeetingDetailViewModel(
    private val getMeetingUseCase: IGetMeetingUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val changeAttendingStatusUseCase: IChangeAttendingStatusUseCase,
    private val getUserFlowUseCase: IGetUserFlowUseCase
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

    fun updateAttendingStatus() {
        viewModelScope.launch {
            val user = getUserFlowUseCase.invoke().first()
            changeAttendingStatusUseCase.invoke(meetingId = getMeetingId(), user = user)
            meetingDetailStateMutable.update { state ->
                when (state) {
                    is MeetingDetailState.MeetingDetail ->
                        state.copy(attendingStatus = !state.attendingStatus)

                    else -> state
                }
            }
        }
    }

    private fun getMeetingId(): Int {
        return savedStateHandle.get<Int>(Screen.KEY_MEETING_ID).orZero()
    }

    private fun getMeeting() {
        viewModelScope.launch {
            getMeetingUseCase(getMeetingId()).collect { meeting ->
                meetingDetailStateMutable.update { state ->
                    val attendingStatus =
                        meeting.usersList.find {
                            it.id == getUserFlowUseCase.invoke().first().id
                        } != null
                    MeetingDetailState.MeetingDetail(
                        meeting = meeting,
                        attendingStatus = attendingStatus,
                        mapUrl = mockMapUrl
                    )
                }
            }
        }
    }
}