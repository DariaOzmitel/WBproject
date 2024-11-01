package com.example.domain.usecase.authorization

import com.example.domain.model.User
import com.example.domain.repository.AuthorizationRepository
import com.example.domain.usecase.interfaces.IAddUserUseCase

internal class AddUserUseCase(
    private val repository: AuthorizationRepository
) : IAddUserUseCase {
    override suspend operator fun invoke(user: User) {
        return repository.addUser(user)
    }
}