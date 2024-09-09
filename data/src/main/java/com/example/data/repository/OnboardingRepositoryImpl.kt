package com.example.data.repository

import com.example.domain.model.Interest
import com.example.domain.repository.OnBoardingRepository
import kotlinx.coroutines.flow.Flow

class OnboardingRepositoryImpl : OnBoardingRepository {
    private val listInterests = ""

    override fun loadAllInterests(): Flow<List<Interest>> {
        TODO("Not yet implemented")
    }
}