package de.wittenbu.magni.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.wittenbu.magni.components.DrawerScaffold
import de.wittenbu.magni.models.Exercise
import de.wittenbu.magni.services.ExerciseService
import de.wittenbu.magni.ui.theme.MagniTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercises(
    onOpenDrawer: () -> Unit,
    onNavigateToExercise: (Exercise) -> Unit
) {
    DrawerScaffold(
        title = "Exercises",
        onOpenDrawer,
    ) {
        val exercises = ExerciseService.exercises
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 20.dp)
        ) {
            items(exercises) { exercise ->
                Card(
                    onClick = { onNavigateToExercise(exercise) }
                ) {
                    Column(Modifier.fillMaxSize()) {
                        Text(exercise.name, Modifier.align(Alignment.CenterHorizontally))

                        Text("Muscles", Modifier.align(Alignment.CenterHorizontally))
                        exercise.muscles.forEach { muscle ->
                            Text(muscle.name, Modifier.align(Alignment.CenterHorizontally))
                        }
                        exercise.variations.forEach { variation ->
                            Text(variation.name, Modifier.align(Alignment.CenterHorizontally))
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = false)
@Preview(name = "Light Mode")
@Composable
fun ExercisesPreview() {
    MagniTheme {
        Exercises(onOpenDrawer = {  }, onNavigateToExercise = {  })
    }
}