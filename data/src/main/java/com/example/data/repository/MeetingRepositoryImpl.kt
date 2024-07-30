package com.example.data.repository

import com.example.data.mockData.mockCommunityList
import com.example.data.mockData.mockListMeetingAlreadyPassed
import com.example.data.mockData.mockListMeetings
import com.example.data.mockData.mockUser
import com.example.domain.MeetingRepository
import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class MeetingRepositoryImpl : MeetingRepository {
    override fun getCommunityListFlow(): Flow<List<Community>> {
        return flowOf(mockCommunityList)
    }

    override fun getCommunityFlow(communityId: Int): Flow<Community> {
        return flowOf(mockCommunityList.first { it.id == communityId })
    }

    override fun getMeetingListFlow(): Flow<List<Meeting>> {
        return flowOf(mockListMeetings)
    }

    override fun getFinishedMeetingListFlow(): Flow<List<Meeting>> {
        return flowOf(mockListMeetingAlreadyPassed)
    }

    override fun getMeetingFlow(meetingId: Int): Flow<Meeting> {
        return flowOf(mockListMeetings.first { it.id == meetingId })
    }

    override fun getUserFlow(): Flow<User> {
        return flowOf(mockUser)
    }
}