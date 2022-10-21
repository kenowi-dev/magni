package de.wittenbu.magni.screens

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.wittenbu.magni.components.AnimatedSelectionView
import de.wittenbu.magni.components.DrawerScaffold
import de.wittenbu.magni.components.ExerciseCard
import de.wittenbu.magni.components.SelectionChip
import de.wittenbu.magni.models.*
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
        fun <T> SnapshotStateList<T>.swapList(newList: List<T>) {
            clear()
            addAll(newList)
        }

        val trainingTypes = remember { mutableStateListOf<TrainingType>() }
        val movementTypes = remember { mutableStateListOf<MovementType>() }
        val weightTypes = remember { mutableStateListOf<WeightType>() }
        val muscles = remember { mutableStateListOf<Muscle>() }

        val exercises = remember { mutableStateListOf<ExerciseDefinition>() }

        fun filterExercises() {
            exercises.swapList(ExerciseService.exercises.filter { exercise ->
                (trainingTypes.isEmpty() || trainingTypes.contains(exercise.trainingType)) &&
                (movementTypes.isEmpty() || exercise.movementTypes.containsAll(movementTypes)) &&
                (weightTypes.isEmpty() || exercise.weightType.containsAll(weightTypes)) &&
                (muscles.isEmpty() || exercise.muscles.containsAll(muscles))
            })
        }

        filterExercises()
        var selected: String? by remember { mutableStateOf(null) }
        fun select(select: String) {
            selected = if (selected != select) select else null
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 20.dp)
        ) {

            item {
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    SelectionChip(selected = muscles.isNotEmpty(), onClick = { select("muscle") }, text = "Muscle")
                    SelectionChip(selected = trainingTypes.isNotEmpty(), onClick = { select("training") }, text = "Training")
                    SelectionChip(selected = weightTypes.isNotEmpty(), onClick = { select("weight") }, text = "Weight")
                    SelectionChip(selected = movementTypes.isNotEmpty(), onClick = { select("movement") }, text = "Movement")
                }

            }
            item {
                AnimatedSelectionView(visible = selected == "training",
                    possibleValues = TrainingType.values(),
                    selectedValues = trainingTypes,
                    onClick = { filterExercises() })

                AnimatedSelectionView(visible = selected == "movement",
                    possibleValues = MovementType.values(),
                    selectedValues = movementTypes,
                    onClick = { filterExercises() })

                AnimatedSelectionView(visible = selected == "weight",
                    possibleValues = WeightType.values(),
                    selectedValues = weightTypes,
                    onClick = { filterExercises() })

                AnimatedSelectionView(visible = selected == "muscle",
                    possibleValues = Muscle.values(),
                    selectedValues = muscles,
                    onClick = { filterExercises() })
            }

            item { Divider(modifier = Modifier.offset(y = (-2).dp)) }
            items(exercises) { exercise ->
                ExerciseCard(
                    exercise = exercise,
                    onNavigateToExercise = onNavigateToExercise,
                    onNavigateToEditExercise = onNavigateToEditExercise
                )
            }
        }
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = false)
@Preview(name = "Light Mode")
@Composable
fun ExercisesPreview() {
    MagniTheme {
        Exercises(onOpenDrawer = { }, onNavigateToExercise = { }, onNavigateToEditExercise = { })
    }
}