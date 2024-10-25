package com.example.ui.screen.main.people

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.interfaces.IGetPeopleListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class PeopleViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getPeopleListUseCase: IGetPeopleListUseCase
) : ViewModel() {
    private val peopleStateMutable: MutableStateFlow<PeopleState> =
        MutableStateFlow(
            PeopleState.Loading
        )
    private val peopleState: StateFlow<PeopleState> = peopleStateMutable

//    private fun getCommunityOrEventId(): Int {
//        return
//        when (savedStateHandle.get<Int>(Screen.KEY_TYPE_ID))
//    }

    init {
        viewModelScope.launch {
            getPeopleList()
        }
    }

    fun getPeopleFlow(): StateFlow<PeopleState> = peopleState

    private fun getPeopleList() {
        viewModelScope.launch {
            getPeopleListUseCase.invoke().collect { peopleList ->
                peopleStateMutable.update {
                    PeopleState.PeopleContent(peopleList = peopleList)
                }
            }
        }
    }
}