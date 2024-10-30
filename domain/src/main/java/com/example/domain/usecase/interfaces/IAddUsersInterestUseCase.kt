package com.example.domain.usecase.interfaces

interface IAddUsersInterestUseCase {
    suspend operator fun invoke(interestId: Int)
}