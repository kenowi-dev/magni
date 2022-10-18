package de.wittenbu.magni.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import de.wittenbu.magni.components.AppBar
import de.wittenbu.magni.components.DrawerNavHost
import de.wittenbu.magni.components.DrawerSheet
import de.wittenbu.magni.models.Exercise
import de.wittenbu.magni.services.Route
import de.wittenbu.magni.services.Routes
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DrawerLayout(
    onOpenExercise: (Exercise) -> Unit
) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val drawerStateScope = rememberCoroutineScope()
    val drawerContentNavController = rememberNavController()
    val selectedRoute = remember { mutableStateOf(Routes.Home) }
    var title: String by remember { mutableStateOf(selectedRoute.value.name) }

    fun onNavigateToRoute(route: Route) {
        drawerStateScope.launch { drawerState.close() }
        selectedRoute.value = route
        drawerContentNavController.navigate(route.route)
        title = route.name
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerSheet(
                selectedRoute = selectedRoute,
                onNavigateToRoute = { route -> onNavigateToRoute(route) }
            )
        },
    ) {
        Scaffold(
            topBar = {
                AppBar(
                    title = title,
                    onNavigationIconClick = { drawerStateScope.launch { drawerState.open() } })
            },
            content = { innerPadding ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    DrawerNavHost(
                        drawerContentNavController = drawerContentNavController,
                        onOpenExercise = onOpenExercise
                    )
                }
            }
        )
    }
}

