package com.example.domain.di

import com.example.domain.usecase.EventsUseCase
import com.example.domain.usecase.authorization.AddUserUseCase
import com.example.domain.usecase.authorization.CheckAuthorizationUseCase
import com.example.domain.usecase.authorization.GetUserFlowUseCase
import com.example.domain.usecase.community.GetCommunityListUseCase
import com.example.domain.usecase.community.GetCommunityUseCase
import com.example.domain.usecase.event.ChangeAttendingStatusUseCase
import com.example.domain.usecase.event.GetEventByIdUseCase
import com.example.domain.usecase.event.GetEventsListUseCase
import com.example.domain.usecase.event.GetFinishedEventsListUseCase
import com.example.domain.usecase.interests.ChangeUsersInterestUseCase
import com.example.domain.usecase.interests.GetInterestsListUseCase
import com.example.domain.usecase.interests.GetUsersInterestsListUseCase
import com.example.domain.usecase.interfaces.IAddUserUseCase
import com.example.domain.usecase.interfaces.IChangeAttendingStatusUseCase
import com.example.domain.usecase.interfaces.IChangeUsersInterestUseCase
import com.example.domain.usecase.interfaces.ICheckAuthorizationUseCase
import com.example.domain.usecase.interfaces.IGetCommunityListUseCase
import com.example.domain.usecase.interfaces.IGetCommunityUseCase
import com.example.domain.usecase.interfaces.IGetEventByIdUseCase
import com.example.domain.usecase.interfaces.IGetEventListUseCase
import com.example.domain.usecase.interfaces.IGetFinishedEventsListUseCase
import com.example.domain.usecase.interfaces.IGetInterestsListUseCase
import com.example.domain.usecase.interfaces.IGetPeopleListUseCase
import com.example.domain.usecase.interfaces.IGetPersonFlowUseCase
import com.example.domain.usecase.interfaces.IGetUserFlowUseCase
import com.example.domain.usecase.interfaces.IGetUsersInterestsListUseCase
import com.example.domain.usecase.people.GetPeopleListUseCase
import com.example.domain.usecase.people.GetPersonFlowUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetEventsListUseCase) bind IGetEventListUseCase::class
    factoryOf(::GetFinishedEventsListUseCase) bind IGetFinishedEventsListUseCase::class
    factoryOf(::GetCommunityListUseCase) bind IGetCommunityListUseCase::class
    factoryOf(::GetCommunityUseCase) bind IGetCommunityUseCase::class
    factoryOf(::GetEventByIdUseCase) bind IGetEventByIdUseCase::class
    factoryOf(::GetUserFlowUseCase) bind IGetUserFlowUseCase::class
    factoryOf(::AddUserUseCase) bind IAddUserUseCase::class
    factoryOf(::CheckAuthorizationUseCase) bind ICheckAuthorizationUseCase::class
    factoryOf(::ChangeAttendingStatusUseCase) bind IChangeAttendingStatusUseCase::class
    factoryOf(::GetPeopleListUseCase) bind IGetPeopleListUseCase::class
    factoryOf(::GetPersonFlowUseCase) bind IGetPersonFlowUseCase::class

    factoryOf(::GetInterestsListUseCase) bind IGetInterestsListUseCase::class
    factoryOf(::GetUsersInterestsListUseCase) bind IGetUsersInterestsListUseCase::class
    factoryOf(::ChangeUsersInterestUseCase) bind IChangeUsersInterestUseCase::class

    singleOf(::EventsUseCase)
}