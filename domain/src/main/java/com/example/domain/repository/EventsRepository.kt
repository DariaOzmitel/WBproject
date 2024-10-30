package com.example.domain.repository

import com.example.domain.model.Event
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface EventsRepository {
    fun getEventsListFlow(): Flow<List<Event>>
    fun getFinishedEventsListFlow(): Flow<List<Event>>
    fun getEventFlow(eventId: Int): Flow<Event>
    fun changeAttendingStatus(eventId: Int, user: User)
}