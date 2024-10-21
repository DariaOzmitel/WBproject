package com.example.ui.di

import com.example.ui.screen.main.community.CommunityViewModel
import com.example.ui.screen.main.event.MeetingViewModel
import com.example.ui.screen.splash.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::SplashScreenViewModel)
    viewModelOf(::CommunityViewModel)
    viewModelOf(::MeetingViewModel)
}