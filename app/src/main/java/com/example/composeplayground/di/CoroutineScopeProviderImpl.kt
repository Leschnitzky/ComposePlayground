package com.example.composeplayground.di

import kotlinx.coroutines.CoroutineScope

class CoroutineScopeProviderImpl(
    private val scope: CoroutineScope?
) : CoroutineScopeProvider {
    override val coroutineScope = scope
}