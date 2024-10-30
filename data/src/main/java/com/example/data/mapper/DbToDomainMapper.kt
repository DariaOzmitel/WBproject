package com.example.data.mapper

import com.example.data.database.interests.InterestDbModel
import com.example.data.database.interests.UsersInterestsDbModel
import com.example.domain.model.Interest

internal class DbToDomainMapper {
    fun interestDbToDomain(dbModel: InterestDbModel) =
        dbModel.run {
            Interest(
                id = id,
                name = name
            )
        }

    fun interestsDbToDomain(dbModelList: List<InterestDbModel>) = dbModelList.map {
        interestDbToDomain(it)
    }

    fun usersInterestToDb(interestId: Int) = UsersInterestsDbModel(id = interestId)
}