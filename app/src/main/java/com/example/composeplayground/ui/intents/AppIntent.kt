package com.example.composeplayground.ui.intents

sealed class AppIntent {
    object ClickedButtonInHome: AppIntent()
    object ClickSecondButtonInHome : AppIntent()
}
