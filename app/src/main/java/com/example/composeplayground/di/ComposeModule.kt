package com.example.composeplayground.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope

@Module
@InstallIn(SingletonComponent::class)
object ComposeModule {
    @Provides
    fun prodiveCoroutineContext() : CoroutineScopeProvider{
        return CoroutineScopeProviderImpl(
            null
        )
    }

    @Provides
    fun provideContextProvider(): CoroutineContextProvider{
        return CoroutineContextProviderImpl()
    }
}