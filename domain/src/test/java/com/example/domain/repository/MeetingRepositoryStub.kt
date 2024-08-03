package com.example.domain.repository

import com.example.domain.mockData.mockListMeetingAlreadyPassed
import com.example.domain.mockData.mockListMeetings
import com.example.domain.model.Meeting
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class MeetingRepositoryStub : MeetingRepository {
    override fun getMeetingListFlow(): Flow<List<Meeting>> {
        return flowOf(mockListMeetings)
    }

    override fun getFinishedMeetingListFlow(): Flow<List<Meeting>> {
        return flowOf(mockListMeetingAlreadyPassed)
    }

    override fun getMeetingFlow(meetingId: Int): Flow<Meeting> {
        return flowOf(mockListMeetings.first { it.id == meetingId })
    }

    override fun changeAttendingStatus(meetingId: Int, user: User) {
        TODO("Not yet implemented")
    }
}