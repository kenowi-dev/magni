package de.wittenbu.magni.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import de.wittenbu.magni.R
import de.wittenbu.magni.services.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun Drawer() {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val drawerStateScope = rememberCoroutineScope()
    val navController = rememberAnimatedNavController()
    val selectedRoute = remember { mutableStateOf(Screen.Home.route) }

    val routes = listOf(
        Screen.Home,
        Screen.Exercises,
        Screen.Workouts,
        Screen.TrainingPlans
    )

    fun onNavigateToRoute(route: String) {
        drawerStateScope.launch {
            drawerState.close()
            selectedRoute.value = route
            navController.navigate(route) {
                launchSingleTop = true
            }
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(40.dp),
                modifier = Modifier.width(300.dp)
            ) {
                Spacer(Modifier.height(12.dp))
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    modifier = Modifier.padding(start = 16.dp, end = 28.dp)
                )
                Spacer(Modifier.height(12.dp))
                Divider(Modifier.padding(start = 16.dp, end = 28.dp))
                Spacer(Modifier.height(12.dp))

                routes.forEach { route ->
                    NavigationDrawerItem(
                        icon = { Icon(painterResource(id = route.icon!!), contentDescription = null) },
                        label = { Text(route.name) },
                        selected = selectedRoute.value == route.route,
                        onClick = { onNavigateToRoute(route.route) },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        }
    ) {
        Surface {
            NavHost(
                navController = navController,
                onOpenDrawer = { drawerStateScope.launch { drawerState.open() } })
        }
    }
}
