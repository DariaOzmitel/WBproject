package com.example.ui.screen.main.event

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.mockData.mockMapUrl
import com.example.domain.usecase.interfaces.IChangeAttendingStatusUseCase
import com.example.domain.usecase.interfaces.IGetEventByIdUseCase
import com.example.domain.usecase.interfaces.IGetUserFlowUseCase
import com.example.ui.navigation.Screen
import com.example.ui.orZero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class EventViewModel(
    private val getMeetingUseCase: IGetEventByIdUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val changeAttendingStatusUseCase: IChangeAttendingStatusUseCase,
    private val getUserFlowUseCase: IGetUserFlowUseCase
) : ViewModel() {
    private val eventStateMutable: MutableStateFlow<EventState> =
        MutableStateFlow(EventState.Loading)
    private val eventState: StateFlow<EventState> = eventStateMutable

    init {
        viewModelScope.launch {
            getMeeting()
        }
    }

    fun getMeetingFlow(): StateFlow<EventState> = eventState

    fun updateAttendingStatus() {
        viewModelScope.launch {
            val user = getUserFlowUseCase.invoke().first()
            changeAttendingStatusUseCase.invoke(meetingId = getMeetingId(), user = user)
            eventStateMutable.update { state ->
                when (state) {
                    is EventState.EventDetail ->
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
                eventStateMutable.update {
                    val attendingStatus =
                        meeting.usersList.find {
                            it.id == getUserFlowUseCase.invoke().first().id
                        } != null
                    EventState.EventDetail(
                        event = meeting,
                        attendingStatus = attendingStatus,
                        mapUrl = mockMapUrl
                    )
                }
            }
        }
    }
}