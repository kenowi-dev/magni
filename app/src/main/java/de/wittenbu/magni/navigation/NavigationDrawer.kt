package de.wittenbu.magni.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import de.wittenbu.magni.components.AppBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalLayoutApi
@Composable
fun NavigationDrawer() {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val selectedRoute = remember { mutableStateOf(Routes.Home) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavigationDrawerSheet(
                scope = scope,
                drawerState = drawerState,
                navController = navController,
                selectedRoute = selectedRoute
            ) },
        content = {
            Scaffold(
                topBar = {
                    AppBar(title = selectedRoute.value.name, onNavigationIconClick = { scope.launch { drawerState.open() } })
                },
                content = { innerPadding ->
                    Box(modifier = Modifier.consumedWindowInsets(innerPadding)) {
                        NavigationHost(navController = navController)
                    }
                }
            )
        }
    )
}
