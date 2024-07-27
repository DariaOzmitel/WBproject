package com.example.domain.usecase

import com.example.domain.MeetingRepository
import com.example.domain.model.Community
import kotlinx.coroutines.flow.Flow

class GetCommunityListUseCase(
    private val repository: MeetingRepository
) {
    operator fun invoke(): Flow<List<Community>> {
        return repository.getCommunityList()
    }
}