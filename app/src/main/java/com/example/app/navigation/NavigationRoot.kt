package com.example.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.app.sampleFeature.presentation.detail.ItemDetailScreenRoot
import com.example.app.sampleFeature.presentation.list.ItemListScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.ItemList,
    ) {
        composable<NavigationRoute.ItemList> {
            ItemListScreenRoot(
                onBackClicked = { navController.navigateUp() },
                onNavigateToDetailsClicked = {
                    navController.navigate(NavigationRoute.ItemDetail(it.id))
                },
            )
        }
        composable<NavigationRoute.ItemDetail> {
            ItemDetailScreenRoot(
                onBackClicked = { navController.navigateUp() }
            )
        }
    }
}
