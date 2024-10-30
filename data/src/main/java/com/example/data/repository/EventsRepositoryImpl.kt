package com.example.data.repository

import com.example.data.mockData.mockListEventAlreadyPasseds
import com.example.data.mockData.mockListEvents
import com.example.domain.model.Event
import com.example.domain.model.User
import com.example.domain.repository.EventsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class EventsRepositoryImpl : EventsRepository {

    override fun getEventsListFlow(): Flow<List<Event>> {
        return flowOf(mockListEvents)
    }

    override fun getFinishedEventsListFlow(): Flow<List<Event>> {
        return flowOf(mockListEventAlreadyPasseds)
    }

    override fun getEventFlow(eventId: Int): Flow<Event> {
        return flowOf(mockListEvents.first { it.id == eventId })
    }

    override fun changeAttendingStatus(eventId: Int, user: User) {
        val meeting = mockListEvents.find { it.id == eventId }
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