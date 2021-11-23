package com.example.composeplayground

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.composeplayground.di.CoroutineScopeProvider
import com.example.composeplayground.ui.theme.CraneTheme
import kotlinx.coroutines.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    @Inject
    lateinit var testScopeProvider: CoroutineScopeProvider
    @Inject
    lateinit var testRule: TestCoroutineRule

    @ExperimentalFoundationApi
    @Before
    fun setup(){
        composeTestRule.setContent {
            CraneTheme {
                MainScreen()
            }
        }
    }


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.composeplayground", appContext.packageName)
    }


    @ExperimentalCoroutinesApi
    @Test
    fun testClickOnButton() {
        runBlocking {
            composeTestRule.onNodeWithText("Click").performClick()
            delay(5000)
            composeTestRule.onNodeWithText("LOADED").assertIsDisplayed()
        }
    }
}