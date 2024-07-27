package com.example.domain.di

import com.example.domain.usecase.GetCommunityListUseCase
import com.example.domain.usecase.GetCommunityUseCase
import com.example.domain.usecase.GetMeetingListUseCase
import com.example.domain.usecase.GetMeetingUseCase
import com.example.domain.usecase.GetUserFlowUseCase
import com.example.domain.usecase.interfaces.IGetCommunityListUseCase
import com.example.domain.usecase.interfaces.IGetCommunityUseCase
import com.example.domain.usecase.interfaces.IGetMeetingListUseCase
import com.example.domain.usecase.interfaces.IGetMeetingUseCase
import com.example.domain.usecase.interfaces.IGetUserFlowUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetMeetingListUseCase) bind IGetMeetingListUseCase::class
    factoryOf(::GetCommunityListUseCase) bind IGetCommunityListUseCase::class
    factoryOf(::GetCommunityUseCase) bind IGetCommunityUseCase::class
    factoryOf(::GetMeetingUseCase) bind IGetMeetingUseCase::class
    factoryOf(::GetUserFlowUseCase) bind IGetUserFlowUseCase::class
}