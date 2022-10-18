package de.wittenbu.magni.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import de.wittenbu.magni.R
import de.wittenbu.magni.services.Route
import de.wittenbu.magni.services.Routes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalLayoutApi
@Composable
fun DrawerSheet(
    selectedRoute: MutableState<Route>,
    onNavigateToRoute: (Route) -> Unit
) {

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


        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text(Routes.Home.name) },
            selected = selectedRoute.value.route == Routes.Home.route,
            onClick = { onNavigateToRoute(Routes.Home) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        NavigationDrawerItem(
            icon = { Icon(painterResource(id = R.drawable.ic_baseline_fitness_center_24), contentDescription = null) },
            label = { Text(Routes.Exercises.name) },
            selected = selectedRoute.value.route == Routes.Exercises.route,
            onClick = { onNavigateToRoute(Routes.Exercises) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        NavigationDrawerItem(
            icon = { Icon(painterResource(id = R.drawable.ic_baseline_notes_24), contentDescription = null) },
            label = { Text(Routes.Workouts.name) },
            selected = selectedRoute.value.route == Routes.Workouts.route,
            onClick = { onNavigateToRoute(Routes.Workouts) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        NavigationDrawerItem(
            icon = { Icon(painterResource(id = R.drawable.ic_baseline_library_books_24), contentDescription = null) },
            label = { Text(Routes.TrainingPlans.name) },
            selected = selectedRoute.value.route == Routes.TrainingPlans.route,
            onClick = { onNavigateToRoute(Routes.TrainingPlans) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

    }
}