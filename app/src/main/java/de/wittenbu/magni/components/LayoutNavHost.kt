package de.wittenbu.magni.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import de.wittenbu.magni.layouts.DetailsLayout
import de.wittenbu.magni.layouts.DrawerLayout


@Composable
fun LayoutNavHost() {
    val layoutNavController = rememberNavController()
    NavHost(navController = layoutNavController, startDestination = "drawer") {
        composable("drawer") { DrawerLayout(onOpenExercise = { exercise -> layoutNavController.navigate("details") }) }
        composable("details") { DetailsLayout() }
    }
}