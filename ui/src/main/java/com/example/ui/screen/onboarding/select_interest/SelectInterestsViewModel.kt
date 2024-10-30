package com.example.ui.screen.onboarding.select_interest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.IChangeUsersInterestUseCase
import com.example.domain.usecase.interfaces.IGetInterestsListUseCase
import com.example.domain.usecase.interfaces.IGetUsersInterestsListUseCase
import com.example.ui.mapper.DomainToUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class SelectInterestsViewModel(
    private val getInterestsListUseCase: IGetInterestsListUseCase,
    private val getUsersInterestsListUseCase: IGetUsersInterestsListUseCase,
    private val changeUsersInterestUseCase: IChangeUsersInterestUseCase,
    private val mapper: DomainToUiMapper
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

    fun changeUsersInterest(interestId: Int) {
        viewModelScope.launch {
            changeUsersInterestUseCase.invoke(interestId)
        }
    }

    private fun getInterestsList() {
        viewModelScope.launch {
            combine(
                getInterestsListUseCase.invoke(),
                getUsersInterestsListUseCase.invoke()
            ) { interestsList, selectedInterests ->
                mapper.interestsListToUi(interestsList, selectedInterests)
            }.collect { interestsUiList ->
                selectInterestsStateMutable.update {
                    SelectInterestsState.InterestsList(list = interestsUiList)
                }
            }
        }
    }
}