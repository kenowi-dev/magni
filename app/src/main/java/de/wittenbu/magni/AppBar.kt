package de.wittenbu.magni

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Toggle drawer")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sample() {
    // Get the current SystemUiController
    val systemUiController = rememberSystemUiController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box {
                var isShowingDropdownMenu by remember { mutableStateOf(false) }

                Button(
                    onClick = {
                        isShowingDropdownMenu = true
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = "Change System Bars Behavior")
                }

                DropdownMenu(
                    expanded = isShowingDropdownMenu,
                    onDismissRequest = { isShowingDropdownMenu = false }
                ) {
                    DropdownMenuItem(
                        onClick = {
                            systemUiController.systemBarsBehavior =
                                WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_TOUCH
                            isShowingDropdownMenu = false
                        },
                        text = {
                            Text("BEHAVIOR_SHOW_BARS_BY_TOUCH")
                        }
                    )
                    DropdownMenuItem(
                        onClick = {
                            systemUiController.systemBarsBehavior =
                                WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE
                            isShowingDropdownMenu = false
                        },
                        text = { Text("BEHAVIOR_SHOW_BARS_BY_SWIPE") }
                    )
                    DropdownMenuItem(
                        onClick = {
                            systemUiController.systemBarsBehavior =
                                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                            isShowingDropdownMenu = false
                        },
                        text = {
                            Text("BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE")
                        }
                    )
                }
            }

            /** Status bar */

            Button(
                onClick = {
                    systemUiController.isStatusBarVisible = true
                },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Show the status bar")
            }
            Button(
                onClick = {
                    systemUiController.isStatusBarVisible = false
                },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Hide the status bar")
            }

            /** Navigation bar */

            Button(
                onClick = { systemUiController.isNavigationBarVisible = true },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Show the navigation bar")
            }
            Button(
                onClick = {
                    systemUiController.isNavigationBarVisible = false
                },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Hide the navigation bar")
            }

            /** System bars */

            Button(
                onClick = { systemUiController.isSystemBarsVisible = true },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Show the system bars")
            }
            Button(
                onClick = { systemUiController.isSystemBarsVisible = false },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Hide the system bars")
            }
        }
    }
}