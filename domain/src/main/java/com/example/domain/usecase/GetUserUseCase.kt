package com.example.domain.usecase

import com.example.domain.MeetingRepository
import com.example.domain.model.User

class GetUserUseCase(
    private val repository: MeetingRepository
) {
    operator fun invoke(): User {
        return repository.getUser()
    }
}