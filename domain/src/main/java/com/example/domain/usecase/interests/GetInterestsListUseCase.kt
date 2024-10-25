package com.example.domain.usecase.interests

import com.example.domain.model.Interest
import com.example.domain.repository.InterestsRepository
import com.example.domain.usecase.interfaces.IGetInterestsListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetInterestsListUseCase(
    private val repository: InterestsRepository
) : IGetInterestsListUseCase {
    override operator fun invoke(): Flow<List<Interest>> {
        return repository.loadAllInterests()
    }
}