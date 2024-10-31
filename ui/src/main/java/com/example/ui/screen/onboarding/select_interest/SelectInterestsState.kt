package com.example.ui.screen.onboarding.select_interest

import com.example.ui.model.InterestUi

internal sealed class SelectInterestsState {
    data class InterestsList(val list: List<InterestUi>) : SelectInterestsState()
    object Loading : SelectInterestsState()
}