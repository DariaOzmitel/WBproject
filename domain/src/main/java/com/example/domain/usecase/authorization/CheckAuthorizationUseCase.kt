package com.example.domain.usecase.authorization

import com.example.domain.repository.AuthorizationRepository
import com.example.domain.usecase.interfaces.ICheckAuthorizationUseCase
import kotlinx.coroutines.flow.Flow

internal class CheckAuthorizationUseCase(
    private val repository: AuthorizationRepository
) : ICheckAuthorizationUseCase {
    override suspend operator fun invoke(): Flow<Boolean> {
        return repository.checkAuthorization()
    }
}