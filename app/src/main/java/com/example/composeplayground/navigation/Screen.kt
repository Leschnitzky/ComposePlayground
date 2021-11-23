package com.example.composeplayground.navigation

sealed class Screen(val route: String) {
    object Home: Screen("Home Screen")
    object Second: Screen("Second")
}