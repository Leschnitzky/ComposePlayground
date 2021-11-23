package com.example.composeplayground.ui.widgets

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Icecream
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Verified
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.composeplayground.R
import com.example.composeplayground.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

sealed class DrawerNavScreens(val route: String, @StringRes val resourceId: Int) {
    object Home : DrawerNavScreens("Home Screen", R.string.home)
    object Second : DrawerNavScreens("Second Screen", R.string.second_screen)
}

private const val TAG = "Widgets"

@Composable
fun CustomTopBar(
    state: ScaffoldState,
    scope: CoroutineScope,
    entry: State<NavBackStackEntry?>
) {

    TopAppBar(
        content = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    "Open drawer",
                    modifier = Modifier
                        .clickable(onClick = {
                            scope.launch {
                                state.drawerState.open()
                            }
                        })
                        .padding(16.dp)

                )

                val title = entry.value?.destination?.route
                if (!title.isNullOrEmpty()) {
                    Text(
                        text = entry.value?.destination?.route!!
                    )
                }
            }
        }
    )
}

@Composable
fun CustomDrawer(
    navController: NavController,
    drawerState: ScaffoldState = rememberScaffoldState(),
    scope: CoroutineScope
) {

    Column(
        Modifier.padding(16.dp)
    ) {
        Column(modifier = Modifier.weight(2f)) {

        }
        Divider()
        Column(modifier = Modifier.weight(4f)) {
            DrawerItem(title = "First", icon = Icons.Default.Icecream, onClickAction = {
                navController.navigate(Screen.Home.route)
                scope.launch {
                    drawerState.drawerState.close()
                }
            }
            )

            DrawerItem(title = "Second", icon = Icons.Default.Verified, onClickAction = {
                navController.navigate(Screen.Second.route)
                scope.launch {
                    drawerState.drawerState.close()
                }
            }
            )
        }
    }
}


@Composable
fun DrawerItem(
    title: String,
    icon: ImageVector,
    onClickAction: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClickAction),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Icon(
            imageVector = icon, contentDescription = "N/A",
            modifier = Modifier
                .padding(8.dp)
        )
        Text(text = title)
    }
}
