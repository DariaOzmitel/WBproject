package com.example.domain.usecase.interests

import com.example.domain.model.Interest
import com.example.domain.repository.InterestsRepository
import com.example.domain.usecase.interfaces.IGetUsersInterestsListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetUsersInterestsListUseCase(
    private val repository: InterestsRepository
) : IGetUsersInterestsListUseCase {
    override operator fun invoke(): Flow<List<Interest>> {
        return repository.getUsersInterests()
    }
}