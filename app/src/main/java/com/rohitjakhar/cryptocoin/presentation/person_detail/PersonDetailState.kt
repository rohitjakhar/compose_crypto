package com.rohitjakhar.cryptocoin.presentation.person_detail

import com.rohitjakhar.cryptocoin.domain.model.Coin
import com.rohitjakhar.cryptocoin.domain.model.PersonDetail

data class PersonDetailState(
    val isLoading: Boolean = false,
    val personDetails: PersonDetail? = null,
    val error: String = "",
)
