package com.example.domain.repository

import com.example.domain.model.Meeting
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface MeetingRepository {
    fun getMeetingListFlow(): Flow<List<Meeting>>
    fun getFinishedMeetingListFlow(): Flow<List<Meeting>>
    fun getMeetingFlow(meetingId: Int): Flow<Meeting>
    fun changeAttendingStatus(meetingId: Int, user: User)
}