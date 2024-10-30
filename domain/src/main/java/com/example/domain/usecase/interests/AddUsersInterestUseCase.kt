package com.example.domain.usecase.interests

import com.example.domain.repository.InterestsRepository
import com.example.domain.usecase.interfaces.IAddUsersInterestUseCase

internal class AddUsersInterestUseCase(
    private val repository: InterestsRepository
) : IAddUsersInterestUseCase {
    override suspend operator fun invoke(interestId: Int) {
        return repository.addUsersInterest(interestId)
    }
}