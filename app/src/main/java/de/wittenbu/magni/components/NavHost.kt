package de.wittenbu.magni.components

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import de.wittenbu.magni.screens.*
import de.wittenbu.magni.services.Screen


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onOpenDrawer: () -> Unit
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier,
        enterTransition = { fadeIn(animationSpec = tween(400)) },
        exitTransition = { fadeOut(animationSpec = tween(400)) }
    ) {
        composable(Screen.Home.routeWithArgs()) { Home(onOpenDrawer = onOpenDrawer) }

        composable(Screen.Exercises.routeWithArgs()) {
            Exercises(
                onOpenDrawer = onOpenDrawer,
                onNavigateToExercise = { exercise -> navController.navigate("${Screen.Exercise.route}/${exercise.id}") },
                onNavigateToEditExercise = { exercise -> navController.navigate("${Screen.EditExercise.route}/${exercise.id}") }
            )
        }

        composable(
            Screen.Exercise.routeWithArgs(),
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(200))
            },
        ) { navBackStackEntry ->
            Exercise(
                exerciseId = navBackStackEntry.arguments!!.getString("exerciseId")!!,
                onGoBack = { navController.navigateUp() }
            )
        }

        composable(
            Screen.EditExercise.routeWithArgs(),
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(200))
            },
        ) { navBackStackEntry ->
            EditExercise(
                exerciseId = navBackStackEntry.arguments!!.getString("exerciseId")!!,
                onGoBack = { navController.navigateUp() }
            )
        }

        composable(Screen.Workouts.routeWithArgs()) { Workouts(onOpenDrawer = onOpenDrawer) }
        composable(Screen.TrainingPlans.routeWithArgs()) { TrainingPlans(onOpenDrawer = onOpenDrawer) }
    }
}
