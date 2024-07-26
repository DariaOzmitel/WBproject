package com.example.domain.usecase

import com.example.domain.MeetingRepository
import com.example.domain.model.Community

class GetCommunityUseCase(
    private val repository: MeetingRepository
) {
    operator fun invoke(communityId: Int): Community {
        return repository.getCommunity(communityId)
    }
}