package com.example.wbproject.ui.theme.screens.authorization.enter_phone

import androidx.lifecycle.ViewModel
import com.example.wbproject.ui.theme.items.DropdownMenuItems
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

internal class EnterPhoneViewModel : ViewModel() {

    private val enterPhoneStateMutable: MutableStateFlow<EnterPhoneState> =
        MutableStateFlow(EnterPhoneState.EnterPhoneContent(countryCode = DropdownMenuItems.RUSSIA))
    private val enterPhoneState: StateFlow<EnterPhoneState> = enterPhoneStateMutable


    fun getEnterPhoneStateFlow(): StateFlow<EnterPhoneState> = enterPhoneState
//    fun getPhoneFlow(): StateFlow<String> = enterPhoneState

    fun updatePhone(newPhone: String) {
        enterPhoneStateMutable.update {
            when (it) {
                is EnterPhoneState.EnterPhoneContent ->
                    it.copy(phone = newPhone)

                else -> it
            }
        }
    }

    fun updateCountryCode(newCountryCode: DropdownMenuItems) {
        enterPhoneStateMutable.update {
            when (it) {
                is EnterPhoneState.EnterPhoneContent ->
                    it.copy(countryCode = newCountryCode)

                else -> it
            }
        }
    }

    fun updateIsMenuExpanded(isExpanded: Boolean) {
        enterPhoneStateMutable.update {
            when (it) {
                is EnterPhoneState.EnterPhoneContent ->
                    it.copy(isMenuExpanded = isExpanded)

                else -> it
            }
        }
    }
}