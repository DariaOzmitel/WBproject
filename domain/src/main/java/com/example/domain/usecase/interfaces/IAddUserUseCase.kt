package com.example.domain.usecase.interfaces

import com.example.domain.model.User

interface IAddUserUseCase {
    suspend operator fun invoke(user: User)
}