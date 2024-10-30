package com.example.domain.usecase.interfaces

interface IDeleteUsersInterestUseCase {
    suspend operator fun invoke(interestId: Int)
}