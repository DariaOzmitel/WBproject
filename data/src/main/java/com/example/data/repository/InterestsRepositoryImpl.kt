package com.example.data.repository

import com.example.data.database.interests.InterestsDao
import com.example.data.mapper.DbToDomainMapper
import com.example.domain.model.Interest
import com.example.domain.repository.InterestsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class InterestsRepositoryImpl(
    private val interestsDao: InterestsDao,
    private val mapper: DbToDomainMapper
) : InterestsRepository {

    override fun getAllInterests(): Flow<List<Interest>> {
        return interestsDao.getInterestsList().map { mapper.interestsDbToDomain(it) }
    }

    override fun getUsersInterests(): Flow<List<Interest>> {
        return interestsDao.getUsersInterests().map { mapper.interestsDbToDomain(it) }
    }

    override suspend fun addUsersInterest(interestId: Int) {
        interestsDao.addUsersInterest(mapper.usersInterestToDb(interestId))
    }

    override suspend fun deleteUsersInterest(interestId: Int) {
        interestsDao.deleteUsersInterest(interestId)
    }

    override suspend fun changeUsersInterest(interestId: Int) {
        val isSelected = interestsDao.isInterestSelected(interestId)
        when (isSelected) {
            true -> deleteUsersInterest(interestId)
            false -> addUsersInterest(interestId)
        }
    }
}