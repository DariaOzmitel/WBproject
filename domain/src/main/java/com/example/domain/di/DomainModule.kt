package com.example.domain.di

import com.example.domain.usecase.authorization.AddUserUseCase
import com.example.domain.usecase.authorization.CheckAuthorizationUseCase
import com.example.domain.usecase.authorization.GetUserFlowUseCase
import com.example.domain.usecase.community.GetCommunityListUseCase
import com.example.domain.usecase.community.GetCommunityUseCase
import com.example.domain.usecase.interfaces.IAddUserUseCase
import com.example.domain.usecase.interfaces.ICheckAuthorizationUseCase
import com.example.domain.usecase.interfaces.IGetCommunityListUseCase
import com.example.domain.usecase.interfaces.IGetCommunityUseCase
import com.example.domain.usecase.interfaces.IGetFinishedMeetingListUseCase
import com.example.domain.usecase.interfaces.IGetMeetingListUseCase
import com.example.domain.usecase.interfaces.IGetMeetingUseCase
import com.example.domain.usecase.interfaces.IGetUserFlowUseCase
import com.example.domain.usecase.meeting.GetFinishedMeetingListUseCase
import com.example.domain.usecase.meeting.GetMeetingListUseCase
import com.example.domain.usecase.meeting.GetMeetingUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetMeetingListUseCase) bind IGetMeetingListUseCase::class
    factoryOf(::GetFinishedMeetingListUseCase) bind IGetFinishedMeetingListUseCase::class
    factoryOf(::GetCommunityListUseCase) bind IGetCommunityListUseCase::class
    factoryOf(::GetCommunityUseCase) bind IGetCommunityUseCase::class
    factoryOf(::GetMeetingUseCase) bind IGetMeetingUseCase::class
    factoryOf(::GetUserFlowUseCase) bind IGetUserFlowUseCase::class
    factoryOf(::AddUserUseCase) bind IAddUserUseCase::class
    factoryOf(::CheckAuthorizationUseCase) bind ICheckAuthorizationUseCase::class

}