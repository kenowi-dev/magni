package de.wittenbu.magni.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.wittenbu.magni.models.Exercise
import de.wittenbu.magni.screens.*
import de.wittenbu.magni.services.Routes


@Composable
fun DrawerNavHost(
    drawerContentNavController: NavHostController,
    modifier: Modifier = Modifier,
    onOpenExercise: (Exercise) -> Unit
) {
    NavHost(navController = drawerContentNavController, startDestination = Routes.Home.route, modifier = modifier) {
        composable(Routes.Home.route) { Home() }
        composable(Routes.Exercises.route) { Exercises( onOpenExercise = onOpenExercise) }
        // composable(Routes.Exercise.route) { navBackStackEntry ->  Exercise(exerciseId = navBackStackEntry.arguments!!.getString("exerciseId")!!) }
        composable(Routes.Workouts.route) { Workouts() }
        composable(Routes.TrainingPlans.route) { TrainingPlans() }
    }
}