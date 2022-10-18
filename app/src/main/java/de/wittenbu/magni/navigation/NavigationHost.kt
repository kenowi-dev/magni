package de.wittenbu.magni.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.wittenbu.magni.screens.*


@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) { Home() }
        composable(Routes.Exercises.route) { Exercises() }
        composable(Routes.Exercise.route) { navBackStackEntry ->  Exercise(exerciseId = navBackStackEntry.arguments!!.getString("exerciseId")!!) }
        composable(Routes.Workouts.route) { Workouts() }
        composable(Routes.WorkoutPlans.route) { WorkoutPlans() }
    }
}