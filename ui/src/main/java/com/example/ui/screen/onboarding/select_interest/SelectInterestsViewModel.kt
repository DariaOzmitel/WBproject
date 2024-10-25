package com.example.ui.screen.onboarding.select_interest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.IGetInterestsListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class SelectInterestsViewModel(
    private val getInterestsListUseCase: IGetInterestsListUseCase
) :
    ViewModel() {
    private val selectInterestsStateMutable: MutableStateFlow<SelectInterestsState> =
        MutableStateFlow(SelectInterestsState.Loading)
    private val selectInterestsState: StateFlow<SelectInterestsState> = selectInterestsStateMutable

    init {
        viewModelScope.launch {
            getInterestsList()
        }
    }

    fun getInterestsFlow(): StateFlow<SelectInterestsState> = selectInterestsState

    private fun getInterestsList() {
        viewModelScope.launch {
            getInterestsListUseCase.invoke().collect { interestsList ->
                selectInterestsStateMutable.update {
                    SelectInterestsState.InterestsList(list = interestsList)
                }
            }
        }
    }
}