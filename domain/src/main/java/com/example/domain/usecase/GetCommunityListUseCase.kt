package com.example.domain.usecase

import com.example.domain.MeetingRepository
import com.example.domain.model.Community

class GetCommunityListUseCase(
    private val repository: MeetingRepository
) {
    operator fun invoke(): List<Community> {
        return repository.getCommunityList()
    }
}