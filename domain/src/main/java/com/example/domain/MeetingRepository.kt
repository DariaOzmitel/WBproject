package com.example.domain

import com.example.domain.model.Community
import com.example.domain.model.Meeting
import com.example.domain.model.User

interface MeetingRepository {
    fun getCommunityList(): List<Community>
    fun getCommunity(): Community
    fun getMeetingList(): List<Meeting>
    fun getMeeting(): Meeting
    fun getUser(): User
}