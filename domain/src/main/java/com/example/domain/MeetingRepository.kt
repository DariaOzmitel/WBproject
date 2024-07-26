package com.example.domain

import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.domain.model.User

interface MeetingRepository {
    fun getCommunityList(): List<Community>
    fun getCommunity(communityId: Int): Community
    fun getMeetingList(): List<Meeting>
    fun getMeeting(meetingId: Int): Meeting
    fun getUser(): User
}