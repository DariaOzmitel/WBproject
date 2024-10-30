package com.example.domain.repository

import com.example.domain.mockData.mockListEventAlreadyPasseds
import com.example.domain.mockData.mockListEvents
import com.example.domain.model.Event
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal class EventsRepositoryStub : EventsRepository {
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
        TODO("Not yet implemented")
    }
}