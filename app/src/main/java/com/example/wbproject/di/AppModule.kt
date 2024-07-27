package com.example.wbproject.di

import com.example.wbproject.ui.theme.screens.community.CommunityListViewModel
import com.example.wbproject.ui.theme.screens.community.community_detail.CommunityDetailViewModel
import com.example.wbproject.ui.theme.screens.login.add_profile.AddProfileViewModel
import com.example.wbproject.ui.theme.screens.login.enter_phone.EnterPhoneViewModel
import com.example.wbproject.ui.theme.screens.login.enter_pin.EnterPinViewModel
import com.example.wbproject.ui.theme.screens.meetings.MeetingListViewModel
import com.example.wbproject.ui.theme.screens.meetings.meeting_detail.MeetingDetailViewModel
import com.example.wbproject.ui.theme.screens.more.MoreViewModel
import com.example.wbproject.ui.theme.screens.more.my_meetings.MyMeetingViewModel
import com.example.wbproject.ui.theme.screens.more.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::EnterPhoneViewModel)
    viewModelOf(::EnterPinViewModel)
    viewModelOf(::AddProfileViewModel)
    viewModelOf(::MeetingListViewModel)
    viewModel { parameters ->
        MeetingDetailViewModel(meetingId = parameters.get(), get())
    }
    viewModelOf(::CommunityListViewModel)
    viewModel { parameters ->
        CommunityDetailViewModel(communityId = parameters.get(), get(), get())
    }
    viewModelOf(::ProfileViewModel)
    viewModelOf(::MoreViewModel)
    viewModelOf(::MyMeetingViewModel)
}