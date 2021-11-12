package com.rohitjakhar.cryptocoin.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rohitjakhar.cryptocoin.presentation.coin_details.CoinDetailsScreen
import com.rohitjakhar.cryptocoin.presentation.coin_list.CoinListScreen
import com.rohitjakhar.cryptocoin.presentation.person_detail.PersonDetailScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(
            route = Screen.CoinListScreen.route
        ) {
            CoinListScreen(navController)
        }
        composable(
            route = Screen.CoinDetailsScreen.route + "/{coin_id}"
        ) {
            CoinDetailsScreen(navController = navController)
        }
        composable(
            route = Screen.PersonDetailScreen.route + "/{person_id}"
        ) {
            PersonDetailScreen(navController = navController)
        }
    }
}
