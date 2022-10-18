package de.wittenbu.magni.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import de.wittenbu.magni.R
import de.wittenbu.magni.screens.WorkoutPlans
import de.wittenbu.magni.screens.Workouts
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalLayoutApi
@Composable
fun NavigationDrawerSheet(
    scope: CoroutineScope,
    drawerState: DrawerState,
    navController: NavHostController,
    selectedRoute: MutableState<Route>
) {

    fun onClick(route: Route) {
        scope.launch { drawerState.close() }
        selectedRoute.value = route
        navController.navigate(route.route)
    }

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


        NavigationItem(
            route = Routes.Home,
            imageVector = Icons.Default.Home,
            contentDescription = "Goto home page",
            selected = selectedRoute.value.route == Routes.Home.route,
            onClick = { onClick(Routes.Home) })

        NavigationItem(
            route = Routes.Exercises,
            painter = painterResource(id = R.drawable.ic_baseline_fitness_center_24),
            contentDescription = "Goto exercises page",
            selected = selectedRoute.value.route == Routes.Exercises.route,
            onClick = { onClick(Routes.Exercises) })

        NavigationItem(
            route = Routes.Workouts,
            painter = painterResource(id = R.drawable.ic_baseline_notes_24),
            contentDescription = "Goto workouts page",
            selected = selectedRoute.value.route == Routes.Workouts.route,
            onClick = { onClick(Routes.Workouts) })

        NavigationItem(
            route = Routes.WorkoutPlans,
            painter = painterResource(id = R.drawable.ic_baseline_library_books_24),
            contentDescription = "Goto workout plans page",
            selected = selectedRoute.value.route == Routes.WorkoutPlans.route,
            onClick = { onClick(Routes.WorkoutPlans) })
    }
}