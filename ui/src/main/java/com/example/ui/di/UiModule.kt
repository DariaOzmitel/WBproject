package com.example.ui.di

import com.example.ui.mapper.DomainToUiMapper
import com.example.ui.screen.main.community.CommunityViewModel
import com.example.ui.screen.main.event.EventViewModel
import com.example.ui.screen.main.mainPage.MainPageViewModel
import com.example.ui.screen.main.people.PeopleViewModel
import com.example.ui.screen.onboarding.select_interest.SelectInterestsViewModel
import com.example.ui.screen.profile.ProfileViewModel
import com.example.ui.screen.profile.editProfile.EditProfileViewModel
import com.example.ui.screen.splash.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::SplashScreenViewModel)
    viewModelOf(::CommunityViewModel)
    viewModelOf(::EventViewModel)
    viewModelOf(::PeopleViewModel)
    viewModelOf(::SelectInterestsViewModel)
    viewModelOf(::EditProfileViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::MainPageViewModel)
    singleOf(::DomainToUiMapper)
}