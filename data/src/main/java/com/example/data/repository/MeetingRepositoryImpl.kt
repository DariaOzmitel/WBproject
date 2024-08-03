package com.example.data.repository

import com.example.data.mockData.mockListMeetingAlreadyPassed
import com.example.data.mockData.mockListMeetings
import com.example.domain.model.Meeting
import com.example.domain.model.User
import com.example.domain.repository.MeetingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class MeetingRepositoryImpl : MeetingRepository {

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
        val meeting = mockListMeetings.find { it.id == meetingId }
        val userInMeeting = meeting?.usersList?.find { it.id == user.id }
        val status = userInMeeting != null
        meeting?.let {
            when (status) {
                true -> it.usersList.remove(userInMeeting)
                false -> it.usersList.add(user)
            }

        }
    }
}