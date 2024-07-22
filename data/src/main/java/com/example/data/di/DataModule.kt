package com.example.data.di

import com.example.data.repository.MeetingRepositoryImpl
import com.example.domain.MeetingRepository
import org.koin.dsl.module

val dataModule = module {
    single<MeetingRepository> { MeetingRepositoryImpl() }
}