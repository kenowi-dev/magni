package de.wittenbu.magni.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.wittenbu.magni.components.DrawerScaffold
import de.wittenbu.magni.components.ExerciseCard
import de.wittenbu.magni.models.ExerciseDefinition
import de.wittenbu.magni.services.ExerciseService
import de.wittenbu.magni.ui.theme.MagniTheme

@Composable
fun Exercises(
    onOpenDrawer: () -> Unit,
    onNavigateToExercise: (ExerciseDefinition) -> Unit,
    onNavigateToEditExercise: (ExerciseDefinition) -> Unit
) {
    DrawerScaffold(
        title = "Exercises",
        onOpenDrawer,
    ) {
        val exercises = ExerciseService.exercises
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(20.dp)
        ) {
            items(exercises) { exercise ->
                ExerciseCard(exercise = exercise, onNavigateToExercise = onNavigateToExercise, onNavigateToEditExercise = onNavigateToEditExercise)
            }
        }
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = false)
@Preview(name = "Light Mode")
@Composable
fun ExercisesPreview() {
    MagniTheme {
        Exercises(onOpenDrawer = {  }, onNavigateToExercise = {  }, onNavigateToEditExercise = { })
    }
}