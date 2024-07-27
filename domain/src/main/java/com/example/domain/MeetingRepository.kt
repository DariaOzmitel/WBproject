package com.example.domain

import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface MeetingRepository {
    fun getCommunityList(): Flow<List<Community>>
    fun getCommunity(communityId: Int): Community
    fun getMeetingList(): Flow<List<Meeting>>
    fun getMeeting(meetingId: Int): Meeting
    fun getUserFlow(): Flow<User>
}