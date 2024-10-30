package com.example.domain.usecase

import com.example.domain.model.Event
import com.example.domain.repository.EventsRepository
import com.example.domain.usecase.interfaces.IInteractorGetMeetingList
import kotlinx.coroutines.flow.Flow

internal class InteractorGetMeetingListStub(
    private val repository: EventsRepository
) : IInteractorGetMeetingList {
    override operator fun invoke(): Flow<List<Event>> {
        return repository.getEventsListFlow()
    }
}