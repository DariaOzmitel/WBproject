package com.example.domain

import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface MeetingRepository {
    fun getCommunityListFlow(): Flow<List<Community>>
    fun getCommunityFlow(communityId: Int): Flow<Community>
    fun getMeetingListFlow(): Flow<List<Meeting>>
    fun getMeetingFlow(meetingId: Int): Flow<Meeting>
    fun getUserFlow(): Flow<User>
}