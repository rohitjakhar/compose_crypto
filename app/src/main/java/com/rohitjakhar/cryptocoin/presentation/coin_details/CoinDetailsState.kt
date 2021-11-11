package com.rohitjakhar.cryptocoin.presentation.coin_details

import com.rohitjakhar.cryptocoin.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coins: CoinDetails? = null,
    val error: String = ""
)
