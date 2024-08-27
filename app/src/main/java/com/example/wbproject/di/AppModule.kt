package com.example.wbproject.di

import com.example.wbproject.ui.theme.deprecatedUi.screens.authorization.add_profile.AddProfileViewModel
import com.example.wbproject.ui.theme.deprecatedUi.screens.authorization.enter_phone.EnterPhoneViewModel
import com.example.wbproject.ui.theme.deprecatedUi.screens.authorization.enter_pin.EnterPinViewModel
import com.example.wbproject.ui.theme.deprecatedUi.screens.community.CommunityListViewModel
import com.example.wbproject.ui.theme.deprecatedUi.screens.community.community_detail.CommunityDetailViewModel
import com.example.wbproject.ui.theme.deprecatedUi.screens.meetings.MeetingListViewModel
import com.example.wbproject.ui.theme.deprecatedUi.screens.meetings.meeting_detail.MeetingDetailViewModel
import com.example.wbproject.ui.theme.deprecatedUi.screens.more.MoreViewModel
import com.example.wbproject.ui.theme.deprecatedUi.screens.more.my_meetings.MyMeetingViewModel
import com.example.wbproject.ui.theme.deprecatedUi.screens.more.profile.ProfileViewModel
import com.example.wbproject.ui.theme.deprecatedUi.screens.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::SplashViewModel)
    viewModelOf(::EnterPhoneViewModel)
    viewModelOf(::EnterPinViewModel)
    viewModelOf(::AddProfileViewModel)
    viewModelOf(::MeetingListViewModel)
    viewModelOf(::MeetingDetailViewModel)
    viewModelOf(::CommunityListViewModel)
    viewModelOf(::CommunityDetailViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::MoreViewModel)
    viewModelOf(::MyMeetingViewModel)

}