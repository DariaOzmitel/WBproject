package com.example.ui.screen.main.event

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.mockData.mockMapUrl
import com.example.domain.usecase.interfaces.IChangeAttendingStatusUseCase
import com.example.domain.usecase.interfaces.IGetMeetingUseCase
import com.example.domain.usecase.interfaces.IGetUserFlowUseCase
import com.example.ui.navigation.Screen
import com.example.ui.orZero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MeetingViewModel(
    private val getMeetingUseCase: IGetMeetingUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val changeAttendingStatusUseCase: IChangeAttendingStatusUseCase,
    private val getUserFlowUseCase: IGetUserFlowUseCase
) : ViewModel() {
    private val meetingStateMutable: MutableStateFlow<MeetingState> =
        MutableStateFlow(MeetingState.Loading)
    private val meetingState: StateFlow<MeetingState> = meetingStateMutable

    init {
        viewModelScope.launch {
            getMeeting()
        }
    }

    fun getMeetingFlow(): StateFlow<MeetingState> = meetingState

    fun updateAttendingStatus() {
        viewModelScope.launch {
            val user = getUserFlowUseCase.invoke().first()
            changeAttendingStatusUseCase.invoke(meetingId = getMeetingId(), user = user)
            meetingStateMutable.update { state ->
                when (state) {
                    is MeetingState.MeetingDetail ->
                        state.copy(attendingStatus = !state.attendingStatus)

                    else -> state
                }
            }
        }
    }

    private fun getMeetingId(): Int {
        return savedStateHandle.get<Int>(Screen.KEY_EVENT_ID).orZero()
    }

    private fun getMeeting() {
        viewModelScope.launch {
            getMeetingUseCase(getMeetingId()).collect { meeting ->
                meetingStateMutable.update {
                    val attendingStatus =
                        meeting.usersList.find {
                            it.id == getUserFlowUseCase.invoke().first().id
                        } != null
                    MeetingState.MeetingDetail(
                        meeting = meeting,
                        attendingStatus = attendingStatus,
                        mapUrl = mockMapUrl
                    )
                }
            }
        }
    }
}