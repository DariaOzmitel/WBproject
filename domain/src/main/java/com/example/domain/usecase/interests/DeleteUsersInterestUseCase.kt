package com.example.domain.usecase.interests

import com.example.domain.repository.InterestsRepository
import com.example.domain.usecase.interfaces.IDeleteUsersInterestUseCase

internal class DeleteUsersInterestUseCase(
    private val repository: InterestsRepository
) : IDeleteUsersInterestUseCase {
    override suspend operator fun invoke(interestId: Int) {
        return repository.deleteUsersInterest(interestId)
    }
}