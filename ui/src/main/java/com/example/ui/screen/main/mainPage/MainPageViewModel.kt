package com.example.ui.screen.main.mainPage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.IChangeUsersInterestUseCase
import com.example.domain.usecase.interfaces.ICheckAuthorizationUseCase
import com.example.domain.usecase.interfaces.IGetCommunityListUseCase
import com.example.domain.usecase.interfaces.IGetEventListUseCase
import com.example.domain.usecase.interfaces.IGetInterestsListUseCase
import com.example.domain.usecase.interfaces.IGetUsersInterestsListUseCase
import com.example.ui.mapper.DomainToUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class MainPageViewModel(
    private val getEventListUseCase: IGetEventListUseCase,
    private val getCommunityListUseCase: IGetCommunityListUseCase,
    private val getInterestsListUseCase: IGetInterestsListUseCase,
    private val getUsersInterestsListUseCase: IGetUsersInterestsListUseCase,
    private val changeUsersInterestUseCase: IChangeUsersInterestUseCase,
    private val checkAuthorizationUseCase: ICheckAuthorizationUseCase,
    private val mapper: DomainToUiMapper
) : ViewModel() {
    private val mainPageStateMutable: MutableStateFlow<MainPageState> =
        MutableStateFlow(MainPageState.Loading)
    private val mainPageState: StateFlow<MainPageState> = mainPageStateMutable

    init {
        viewModelScope.launch {
            getMainPageData()
        }
    }

    fun getMainPageStateFlow(): StateFlow<MainPageState> = mainPageState

    fun changeUsersInterest(interestId: Int) {
        viewModelScope.launch {
            changeUsersInterestUseCase.invoke(interestId)
        }
    }

    private fun getMainPageData() {
        viewModelScope.launch {
            combine(
                getEventListUseCase.invoke(),
                getCommunityListUseCase.invoke(),
                getInterestsListUseCase.invoke(),
                getUsersInterestsListUseCase.invoke(),
                checkAuthorizationUseCase.invoke()
            ) { eventList, communityList, allInterestsList, selectedInterests, authorizationStatus ->
                MainPageState.MainPageDetail(
                    eventList = eventList,
                    communityList = communityList,
                    interestsList = mapper.interestsListToUi(
                        interestsList = allInterestsList,
                        selectedInterestsList = selectedInterests
                    ),
                    authorizationStatus = authorizationStatus
                )
            }.collect { mainPageDetail ->
                mainPageStateMutable.update { mainPageDetail }
            }
        }
    }
}