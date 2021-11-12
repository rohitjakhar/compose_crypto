package com.rohitjakhar.cryptocoin.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.rohitjakhar.cryptocoin.presentation.coin_details.CoinDetailsScreen
import com.rohitjakhar.cryptocoin.presentation.coin_list.CoinListScreen
import com.rohitjakhar.cryptocoin.presentation.person_detail.PersonDetailScreen

@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(
            route = Screen.CoinListScreen.route,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 600 },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 100 },
                    animationSpec = tween(600)
                ) + fadeOut(animationSpec = tween(300))
            }
        ) {
            CoinListScreen(navController)
        }
        composable(
            route = Screen.CoinDetailsScreen.route + "/{coin_id}",
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 600 },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 100 },
                    animationSpec = tween(600)
                ) + fadeOut(animationSpec = tween(300))
            }
        ) {
            CoinDetailsScreen(navController = navController)
        }
        composable(
            route = Screen.PersonDetailScreen.route + "/{person_id}",
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { 600 },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { 100 },
                    animationSpec = tween(600)
                ) + fadeOut(animationSpec = tween(300))
            }
        ) {
            PersonDetailScreen(navController = navController)
        }
    }
}
