package com.example.domain.usecase.interests

import com.example.domain.repository.InterestsRepository
import com.example.domain.usecase.interfaces.IChangeUsersInterestUseCase

internal class ChangeUsersInterestUseCase(
    private val repository: InterestsRepository
) : IChangeUsersInterestUseCase {
    override suspend operator fun invoke(interestId: Int) {
        return repository.changeUsersInterest(interestId)
    }
}