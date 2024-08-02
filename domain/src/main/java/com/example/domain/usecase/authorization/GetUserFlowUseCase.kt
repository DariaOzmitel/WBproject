package com.example.domain.usecase.authorization

import com.example.domain.model.User
import com.example.domain.repository.AuthorizationRepository
import com.example.domain.usecase.interfaces.IGetUserFlowUseCase
import kotlinx.coroutines.flow.Flow

internal class GetUserFlowUseCase(
    private val repository: AuthorizationRepository
) : IGetUserFlowUseCase {
    override operator fun invoke(): Flow<User> {
        return repository.getUserFlow()
    }
}