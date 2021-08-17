package com.example.composeplayground.ui

import Greeting
import Greeting2
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.R
import com.example.composeplayground.databinding.ActivityMainBinding
import com.example.composeplayground.theme.ComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTheme {
                MainScreen()
            }
        }


    }


}

@Preview
@Composable
fun MainScreen(){
    val navController = rememberNavController()


    Scaffold(
        topBar = {
                 TopAppBar(
                     title = { navController.currentDestination?.displayName }
                 )
        },
        content = {
            NavHost(navController = navController, startDestination = "greetings") {
                composable("greetings") { Greeting(navController) }
                composable("greetings2") { Greeting2() }
            }
        }
    )
}