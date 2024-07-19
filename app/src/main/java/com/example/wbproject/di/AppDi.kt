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
import org.koin.dsl.module

val appModule = module {
    viewModel {
        EnterPhoneViewModel()
    }
    viewModel {
        EnterPinViewModel()
    }
    viewModel {
        AddProfileViewModel()
    }
    viewModel {
        MeetingListViewModel()
    }
    viewModel {
        MeetingDetailViewModel()
    }
    viewModel {
        CommunityListViewModel()
    }
    viewModel {
        CommunityDetailViewModel()
    }
    viewModel {
        ProfileViewModel()
    }
    viewModel {
        MoreViewModel()
    }
    viewModel {
        MyMeetingViewModel()
    }
}