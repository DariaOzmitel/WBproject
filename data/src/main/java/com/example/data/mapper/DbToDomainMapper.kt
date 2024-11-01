package com.example.data.mapper

import com.example.data.database.interests.InterestDbModel
import com.example.data.database.interests.UsersInterestsDbModel
import com.example.data.database.user.UserDbModel
import com.example.domain.model.Interest
import com.example.domain.model.User

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

    fun userDbToDomain(dbModel: UserDbModel) =
        dbModel.run {
            User(
                id = id,
                avatarModel = avatarModel,
                name = name,
                lastName = lastName,
                phone = phone,
                city = city
            )
        }

    fun userDomainToDb(user: User) =
        user.run {
            UserDbModel(
                id = id,
                avatarModel = avatarModel.toString(),
                name = name,
                lastName = lastName,
                phone = phone,
                city = city
            )
        }
}