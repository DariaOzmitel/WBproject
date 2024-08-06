package com.example.domain.usecase.authorization

import com.example.domain.repository.AuthorizationRepository
import com.example.domain.usecase.interfaces.IAddUserUseCase

internal class AddUserUseCase(
    private val repository: AuthorizationRepository
) : IAddUserUseCase {
    override suspend operator fun invoke(
        name: String,
        lastName: String?,
        avatar: String?,
        phone: String
    ) {
        return repository.addUser(name, lastName, avatar, phone)
    }
}