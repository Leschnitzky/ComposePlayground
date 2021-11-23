package com.example.composeplayground.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeplayground.di.CoroutineContextProvider
import com.example.composeplayground.di.CoroutineScopeProvider
import com.example.composeplayground.ui.intents.AppIntent
import com.example.composeplayground.ui.screens.HomeScreenState
import com.example.composeplayground.ui.screens.initialHomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class MyViewModel @Inject constructor(
    var scopeProvider: CoroutineScopeProvider,
    var contextProvider : CoroutineContextProvider
) : ViewModel() {
    private val scope = getCoroutineScope()

    private fun getCoroutineScope(): CoroutineScope {
        return if(scopeProvider.coroutineScope == null){
            viewModelScope
        } else {
            scopeProvider.coroutineScope!!
        }
    }

    val homeScreenStateFlow: StateFlow<HomeScreenState>
        get() = _homeScreenStateFlow

    private val _homeScreenStateFlow = MutableStateFlow(
        initialHomeState
    )
    val intentChannel = Channel<AppIntent>(Channel.UNLIMITED)

    init {
        scope.launch {
            handleIntents()
        }
    }

    private suspend fun handleIntents() {
        intentChannel.consumeEach {
            when (it) {
                is AppIntent.ClickedButtonInHome -> {
                    _homeScreenStateFlow.value = HomeScreenState("LOADING", true)
                    delay(5000)
                    _homeScreenStateFlow.value = HomeScreenState("LOADED", false)
                }
                is AppIntent.ClickSecondButtonInHome -> {
                    _homeScreenStateFlow.value = HomeScreenState("LOADING", true)
                    delay(2000)
                    _homeScreenStateFlow.value = HomeScreenState("LOADED SECOND!", false)
                }
            }
        }
    }

    val name: StateFlow<String>
        get() = _name
    private val _name = MutableStateFlow("Serg")


    fun onNameChanged(newName: String) {
        _name.value = newName
    }


}