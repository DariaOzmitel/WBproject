package com.example.wbproject.ui.theme.screens.meetings

import androidx.lifecycle.ViewModel
import com.example.wbproject.data.mockData.mockListMeetings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MeetingListViewModel : ViewModel() {
    private val meetingListStateMutable =
        MutableStateFlow(MeetingListState(meetingList = mockListMeetings))
    private val meetingListState: StateFlow<MeetingListState> = meetingListStateMutable

    fun getMeetingListFlow(): StateFlow<MeetingListState> = meetingListState
    fun updateSearchText(newSearchText: String) {
        meetingListStateMutable.update {
            it.copy(searchText = newSearchText)
        }
    }
}
