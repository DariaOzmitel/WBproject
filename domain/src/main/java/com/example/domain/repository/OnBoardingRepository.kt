package com.example.domain.repository

import com.example.domain.model.Interest
import kotlinx.coroutines.flow.Flow

interface OnBoardingRepository {
    fun loadAllInterests(): Flow<List<Interest>>
}