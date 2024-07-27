package com.example.domain.usecase

import com.example.domain.MeetingRepository
import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

class GetUserFlowUseCase(
    private val repository: MeetingRepository
) {
    operator fun invoke(): Flow<User> {
        return repository.getUserFlow()
    }
}