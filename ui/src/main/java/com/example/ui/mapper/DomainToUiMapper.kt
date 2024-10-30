package com.example.ui.mapper

import com.example.domain.model.Interest
import com.example.ui.model.InterestUi

internal class DomainToUiMapper {
    private fun interestToUi(interest: Interest, isSelected: Boolean) = interest.run {
        InterestUi(
            id = id,
            name = name,
            isSelected = isSelected,
        )
    }

    fun interestsListToUi(interestsList: List<Interest>, selectedInterestsList: List<Interest>) =
        interestsList.map {
            val isSelected = selectedInterestsList.contains(it)
            interestToUi(it, isSelected)
        }
}