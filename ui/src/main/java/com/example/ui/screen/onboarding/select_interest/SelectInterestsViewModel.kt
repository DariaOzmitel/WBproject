package com.example.ui.screen.onboarding.select_interest

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class SelectInterestsViewModel :
    ViewModel() {
    private val selectInterestsStateMutable: MutableStateFlow<SelectInterestsState> =
        MutableStateFlow(SelectInterestsState.Loading)
    private val selectInterestsState: StateFlow<SelectInterestsState> = selectInterestsStateMutable
}