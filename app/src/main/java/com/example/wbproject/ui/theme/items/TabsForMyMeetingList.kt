package com.example.wbproject.ui.theme.items

import androidx.annotation.StringRes
import com.example.wbproject.R

enum class TabsForMyMeetingList(@StringRes val titleResId: Int) {
    PLANNED(R.string.planned),
    ALREADY_PASSED(R.string.already_passed)
}