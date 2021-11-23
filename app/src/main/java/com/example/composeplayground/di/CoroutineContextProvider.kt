package com.example.composeplayground.di

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    val ui: CoroutineContext
    val io: CoroutineContext
}
