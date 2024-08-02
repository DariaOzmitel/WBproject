package com.example.domain.usecase.interfaces

import kotlinx.coroutines.flow.Flow

interface ICheckAuthorizationUseCase {
    suspend operator fun invoke(): Flow<Boolean>
}