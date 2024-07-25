package com.example.wbproject.ui.theme.screens.login.enter_phone

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class EnterPhoneViewModel : ViewModel() {

    private val phoneMutable = MutableStateFlow("")
    private val phone: StateFlow<String> = phoneMutable

    fun getPhoneFlow(): StateFlow<String> = phone

    fun updatePhone(newPhone: String) {
        phoneMutable.value = newPhone
    }
}