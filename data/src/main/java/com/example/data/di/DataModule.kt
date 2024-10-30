package com.example.data.di

import com.example.data.repository.AuthorizationRepositoryImpl
import com.example.data.repository.CommunityRepositoryImpl
import com.example.data.repository.EventsRepositoryImpl
import com.example.data.repository.InterestsRepositoryImpl
import com.example.data.repository.PeopleRepositoryImpl
import com.example.domain.repository.AuthorizationRepository
import com.example.domain.repository.CommunityRepository
import com.example.domain.repository.EventsRepository
import com.example.domain.repository.InterestsRepository
import com.example.domain.repository.PeopleRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    singleOf(::EventsRepositoryImpl) bind EventsRepository::class
    singleOf(::CommunityRepositoryImpl) bind CommunityRepository::class
    singleOf(::AuthorizationRepositoryImpl) bind AuthorizationRepository::class
    singleOf(::PeopleRepositoryImpl) bind PeopleRepository::class
    singleOf(::InterestsRepositoryImpl) bind InterestsRepository::class
}