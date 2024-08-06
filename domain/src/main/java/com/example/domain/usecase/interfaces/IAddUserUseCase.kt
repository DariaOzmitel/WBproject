package com.example.domain.usecase.interfaces

interface IAddUserUseCase {
    suspend operator fun invoke(name: String, lastName: String?, avatar: String?, phone: String)
}