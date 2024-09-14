package com.example.wbproject.ui.deprecatedUi.screens.authorization.enter_phone

import com.example.wbproject.ui.deprecatedUi.items.DropdownMenuItemsV1

sealed class EnterPhoneState {
    data class EnterPhoneContent(
        val countryCode: DropdownMenuItemsV1,
        val isMenuExpanded: Boolean = false,
        val phone: String = ""
    ) : EnterPhoneState()

    object Loading : EnterPhoneState()
}
