package com.example.composeplayground.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.ui.MyViewModel
import com.example.composeplayground.ui.intents.AppIntent
import kotlinx.coroutines.CoroutineScope



@Composable
fun HomeScreen(
    myViewModel: MyViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val name by myViewModel.name.collectAsState()
    HelloContent(
        myViewModel,
        name = name
    ) { myViewModel.onNameChanged(it) }
}


@Composable
fun HelloContent(
    myViewModel: MyViewModel,
    name: String,
    onNameChange: (String) -> Unit
) {

    val homeScreenState by myViewModel.homeScreenStateFlow.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
        Button(
            modifier = Modifier.padding(8.dp),
            onClick = {
                myViewModel.intentChannel.trySend(AppIntent.ClickedButtonInHome)
            },
            content = {
                Text(text = "Click")
            }
        )

        Button(
            modifier = Modifier.padding(8.dp),
            onClick = {
                myViewModel.intentChannel.trySend(AppIntent.ClickSecondButtonInHome)
            },
            content = {
                Text(text = "SecondClick")
            }
        )
        if(homeScreenState.isLoading){
            CircularProgressIndicator()
        }
        if(!homeScreenState.isLoading){
            Text(text = homeScreenState.text)
        }

        
        

    }
}
