package com.example.wbproject.ui.theme.deprecatedUi.screens.meetings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.IInteractorGetMeetingList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MeetingListViewModel(private val getMeetingListUseCase: IInteractorGetMeetingList) :
    ViewModel() {
    private val meetingListStateMutable: MutableStateFlow<MeetingListState> =
        MutableStateFlow(MeetingListState.Loading)
    private val meetingListState: StateFlow<MeetingListState> = meetingListStateMutable

    init {
        viewModelScope.launch {
            getMeetingList()
        }
    }

    fun getMeetingListStateFlow(): StateFlow<MeetingListState> = meetingListState

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
