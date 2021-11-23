package com.example.composeplayground.ui.second

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.navigation.Screen
import com.example.composeplayground.ui.MyViewModel
import com.example.composeplayground.ui.home.HomeScreen
import java.lang.Float.min

@ExperimentalFoundationApi
@Composable
fun SecondScreen(
) {
    SecondScreenContent()
}

@ExperimentalFoundationApi
@Composable
fun SecondScreenContent() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth(), // Don't specify the TabRow's height!
            backgroundColor = White
        ) {
            listOf("Hello", "World","Serg").forEachIndexed { i, text ->
                Tab(
                    selected = selectedTabIndex == i,
                    onClick = { selectedTabIndex = i },
                    modifier = Modifier.height(50.dp), // Specify the Tab's height instead
                    text = { Text(text) }
                )
            }
        }

        when(selectedTabIndex) {
            0 -> HomeScreen()
            1 -> SecondScreen()
            2 -> HomeScreen()
        }

    }
}

