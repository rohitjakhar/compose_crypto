package com.rohitjakhar.cryptocoin.presentation.coin_list

import com.rohitjakhar.cryptocoin.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
