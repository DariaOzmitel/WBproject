package com.example.ui.screen.onboarding.select_interest

import com.example.ui.model.InterestUi

sealed class SelectInterestsState {
    data class InterestsList(val list: List<InterestUi>) : SelectInterestsState()
    object Loading : SelectInterestsState()
}