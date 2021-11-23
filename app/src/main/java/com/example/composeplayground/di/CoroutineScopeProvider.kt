package com.example.composeplayground.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

interface CoroutineScopeProvider {
    val coroutineScope: CoroutineScope?
}
