package com.rohitjakhar.cryptocoin.presentation

sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coin_list_screen")
    object CoinDetailsScreen : Screen("coin_details_screen")
    object PersonDetailScreen : Screen("person_detail")
}
