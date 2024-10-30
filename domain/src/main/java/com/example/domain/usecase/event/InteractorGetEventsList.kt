package com.example.domain.usecase.event

import com.example.domain.model.Event
import com.example.domain.repository.EventsRepository
import com.example.domain.usecase.EventsUseCase
import com.example.domain.usecase.interfaces.IInteractorGetMeetingList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest

internal class InteractorGetEventsList(
    private val useCase: EventsUseCase,
    private val repository: EventsRepository
) : IInteractorGetMeetingList {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val eventsListFlow = useCase.observeEventsList().flatMapLatest {
        repository.getEventsListFlow()
    }

    override operator fun invoke(): Flow<List<Event>> = eventsListFlow
}