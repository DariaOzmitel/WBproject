package com.example.domain.usecase.interfaces

interface IChangeUsersInterestUseCase {
    suspend operator fun invoke(interestId: Int)
}