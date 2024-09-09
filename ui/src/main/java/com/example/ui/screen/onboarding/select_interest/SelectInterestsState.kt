package com.example.ui.screen.onboarding.select_interest

import com.example.domain.model.Interest

sealed class SelectInterestsState {
    data class InterestsList(val list: List<Interest>) : SelectInterestsState()
    object Loading : SelectInterestsState()
}