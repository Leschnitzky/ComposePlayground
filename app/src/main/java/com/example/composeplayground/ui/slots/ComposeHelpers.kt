package com.example.composeplayground.ui.slots

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun TestCompose(
    content: @Composable () -> Unit
){
    Surface(
        elevation = 2.dp
    ) {
        content()
    }
}