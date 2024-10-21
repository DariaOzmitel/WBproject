package com.example.domain.usecase.people

import com.example.domain.model.User
import com.example.domain.repository.PeopleRepository
import com.example.domain.usecase.interfaces.IGetPeopleListUseCase
import kotlinx.coroutines.flow.Flow

internal class GetPeopleListUseCase(
    private val repository: PeopleRepository
) : IGetPeopleListUseCase {
    override operator fun invoke(): Flow<List<User>> {
        return repository.getPeopleListFlow()
    }
}