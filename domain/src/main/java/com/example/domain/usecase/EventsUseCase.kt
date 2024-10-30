package com.example.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

internal class EventsUseCase {

    private val streamListOfEvents = MutableSharedFlow<Unit>(replay = 1)

    fun observeEventsList(): Flow<Unit> = streamListOfEvents
}