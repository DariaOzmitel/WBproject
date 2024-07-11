package com.example.wbproject.ui.theme.domain

import com.example.wbproject.R

enum class TabsForMyMeetingList(val titleResId: Int, val pageNumber: Int) {
    PLANNED(R.string.planned, 0),
    ALREADY_PASSED(R.string.already_passed, 1)
}