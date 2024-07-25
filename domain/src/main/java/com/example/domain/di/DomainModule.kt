package com.example.domain.di

import com.example.domain.usecase.GetCommunityListUseCase
import com.example.domain.usecase.GetCommunityUseCase
import com.example.domain.usecase.GetMeetingListUseCase
import com.example.domain.usecase.GetMeetingUseCase
import com.example.domain.usecase.GetUserUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetMeetingListUseCase)
    factoryOf(::GetCommunityListUseCase)
    factoryOf(::GetCommunityUseCase)
    factoryOf(::GetMeetingUseCase)
    factoryOf(::GetUserUseCase)
}