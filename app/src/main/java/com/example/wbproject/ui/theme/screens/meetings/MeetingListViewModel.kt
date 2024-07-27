package com.example.wbproject.ui.theme.screens.meetings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMeetingListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MeetingListViewModel(private val getMeetingListUseCase: GetMeetingListUseCase) :
    ViewModel() {
    private val meetingListStateMutable: MutableStateFlow<MeetingListState> =
        MutableStateFlow(MeetingListState.Loading)
    private val meetingListState: StateFlow<MeetingListState> = meetingListStateMutable

    fun getMeetingListStateFlow(): StateFlow<MeetingListState> = meetingListState

    init {
        viewModelScope.launch {
            getMeetingList()
        }
    }

    private fun getMeetingList() {
        viewModelScope.launch {
            getMeetingListUseCase().collect { meetingList ->
                meetingListStateMutable.update {
                    MeetingListState.MeetingList(meetingList)
                }
            }
        }
    }
}
