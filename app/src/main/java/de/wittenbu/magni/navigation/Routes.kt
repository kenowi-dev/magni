package de.wittenbu.magni.navigation

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.core.content.ContextCompat
import de.wittenbu.magni.R

object Routes {
    val Home = Route("Home", "home") {
        Icon(Icons.Default.Home, "Goto gome page.")
    }

    val Exercises = Route("Exercises", "exercises") {
        Icon(painterResource(id = R.drawable.ic_baseline_fitness_center_24), "Goto exercise page.")
    }

    val Exercise = Route("Exercise", "exercise/{exerciseId}") {
        Icon(Icons.Default.Home, "Goto gome page.")
    }

    val Workouts = Route("Workouts", "workouts") {
        Icon(Icons.Default.Home, "Goto gome page.")
    }

    val WorkoutPlans = Route("Workout Plans", "workout_plans") {
        Icon(Icons.Default.Home, "Goto gome page.")
    }

    fun exerciseRoute(exerciseId: Long) = "exercise/$exerciseId"
}

data class Route(
    val name: String,
    val route: String,
    val icon: @Composable () -> Unit
)
