package de.wittenbu.magni.services

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import de.wittenbu.magni.R

object Routes {
    val Home = Route("Home", "home")
    val Exercises = Route("Exercises", "exercises")
    val Exercise = Route("Exercise", "exercise/{exerciseId}")
    val Workouts = Route("Workouts", "workouts")
    val TrainingPlans = Route("Training Plans", "training_plans")

    fun exerciseRoute(exerciseId: Long) = "exercise/$exerciseId"
}

data class Route(
    val name: String,
    val route: String
)
