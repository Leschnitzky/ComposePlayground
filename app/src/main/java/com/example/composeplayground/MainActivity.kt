package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.navigation.Screen
import com.example.composeplayground.ui.theme.CraneTheme
import com.example.composeplayground.ui.MyViewModel
import com.example.composeplayground.ui.widgets.CustomDrawer
import com.example.composeplayground.ui.widgets.CustomTopBar
import com.example.composeplayground.ui.home.HomeScreen
import com.example.composeplayground.ui.second.SecondScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val myViewModel : MyViewModel by viewModels()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        actionBar?.hide()
        super.onCreate(savedInstanceState)

        setContent {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                CraneTheme {
                    MainScreen()
                }
            }
        }
    }

}


@ExperimentalFoundationApi
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = state,
        drawerShape = RoundedCornerShape(10.dp),
        drawerContent = {
            CustomDrawer(
                navController = navController,
                state,
                scope
            )
        },
        content = {
            NavHost(navController = navController, startDestination = Screen.Home.route) {
                composable(Screen.Home.route) { HomeScreen() }
                composable(Screen.Second.route) { SecondScreen() }
            }

        } ,
        topBar = { CustomTopBar(entry = navController.currentBackStackEntryAsState(), state = state, scope = scope)}

    )
}