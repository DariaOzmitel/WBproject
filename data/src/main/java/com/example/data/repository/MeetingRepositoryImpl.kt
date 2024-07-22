package com.example.data.repository

import com.example.data.mockData.mockCommunity
import com.example.data.mockData.mockCommunityList
import com.example.data.mockData.mockListMeetings
import com.example.data.mockData.mockMeeting
import com.example.data.mockData.mockUser
import com.example.domain.MeetingRepository
import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.domain.model.User

internal class MeetingRepositoryImpl() : MeetingRepository {
    override fun getCommunityList(): List<Community> {
        return mockCommunityList
    }

    override fun getCommunity(): Community {
        return mockCommunity
    }

    override fun getMeetingList(): List<Meeting> {
        return mockListMeetings
    }

    override fun getMeeting(): Meeting {
        return mockMeeting
    }

    override fun getUser(): User {
        return mockUser
    }
}