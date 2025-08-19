package com.example.app.navigation

import kotlinx.serialization.Serializable

sealed interface NavigationRoute {

    @Serializable
    data object ItemList : NavigationRoute

    @Serializable
    data class ItemDetail(val id: String) : NavigationRoute

}
