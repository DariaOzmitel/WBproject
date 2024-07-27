package com.example.data.repository

import com.example.data.mockData.mockCommunityList
import com.example.data.mockData.mockListMeetings
import com.example.data.mockData.mockUser
import com.example.domain.MeetingRepository
import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MeetingRepositoryImpl() : MeetingRepository {
    override fun getCommunityList(): Flow<List<Community>> {
        return flow {
            emit(mockCommunityList)
        }
    }

    override fun getCommunity(communityId: Int): Community {
        return mockCommunityList.first { it.id == communityId }
    }

    override fun getMeetingList(): Flow<List<Meeting>> {
        return flow {
            emit(mockListMeetings)
        }

    }

    override fun getMeeting(meetingId: Int): Meeting {
        return mockListMeetings.first { it.id == meetingId }
    }

    override fun getUserFlow(): Flow<User> {
        return flow {
            emit(mockUser)
        }
    }
}