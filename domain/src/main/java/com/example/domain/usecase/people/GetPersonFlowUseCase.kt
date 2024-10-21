package com.example.domain.usecase.people

import com.example.domain.model.User
import com.example.domain.repository.PeopleRepository
import com.example.domain.usecase.interfaces.IGetPersonFlowUseCase
import kotlinx.coroutines.flow.Flow

internal class GetPersonFlowUseCase(
    private val repository: PeopleRepository
) : IGetPersonFlowUseCase {
    override operator fun invoke(personId: Int): Flow<User> {
        return repository.getPersonFlow(personId)
    }
}