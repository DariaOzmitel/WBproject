package com.example.domain.usecase.interfaces

import com.example.domain.model.Meeting
import kotlinx.coroutines.flow.Flow

interface IGetMeetingListUseCase {
    operator fun invoke(): Flow<List<Meeting>>
}