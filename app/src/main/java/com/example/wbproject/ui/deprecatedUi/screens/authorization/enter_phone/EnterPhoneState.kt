package com.example.wbproject.ui.deprecatedUi.screens.authorization.enter_phone

import com.example.wbproject.ui.deprecatedUi.items.DropdownMenuItems

sealed class EnterPhoneState {
    data class EnterPhoneContent(
        val countryCode: DropdownMenuItems,
        val isMenuExpanded: Boolean = false,
        val phone: String = ""
    ) : EnterPhoneState()

    object Loading : EnterPhoneState()
}
