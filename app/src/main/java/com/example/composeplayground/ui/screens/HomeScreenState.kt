package com.example.composeplayground.ui.screens

data class HomeScreenState(
    val text: String,
    val isLoading: Boolean
)



val initialHomeState = HomeScreenState("IDLE", false)
