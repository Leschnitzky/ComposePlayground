package com.example.composeplayground.di

import com.example.composeplayground.TestCoroutineRule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScope
import org.junit.rules.TestRule

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ComposeModule::class]
)
object TestModule {

    @ExperimentalCoroutinesApi
    val testRule = TestCoroutineRule()

    @Provides
    fun provideScopeProvider(): CoroutineScopeProvider {
        return CoroutineScopeProviderImpl(
            TestCoroutineScope(
                testRule.testDispatcher
            )
        )
    }

    @Provides
    fun provideRule(): TestRule {
        return testRule
    }
}