package com.example.composeplayground.di

import kotlinx.coroutines.Dispatchers

class CoroutineContextProviderImpl: CoroutineContextProvider {
    override val ui = Dispatchers.Main
    override val io = Dispatchers.IO
}