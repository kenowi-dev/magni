package de.wittenbu.magni.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.wittenbu.magni.components.*
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

        // Pair of A: Name; C: All possible
        val training = Pair("Training", TrainingType.values().map { it.toString() })
        val movement = Pair("Movement", MovementType.values().map { it.toString() })
        val weightType = Pair("Weight Type", WeightType.values().map { it.toString() })
        val muscles = Pair("Muscles", Muscle.values().map { it.toString() })

        val types = listOf(training, muscles, movement, weightType)
        val tags = remember { mutableStateListOf<String>() }
        val exercises = remember { mutableStateListOf<ExerciseDefinition>() }

        val selectedTag: MutableState<String?> = remember { mutableStateOf(null) }
        val scrollState = rememberLazyListState()

        fun filterExercises() {
            exercises.clear()
            exercises.addAll(ExerciseService.exercises.filter { exercise ->
                tags.isEmpty() || exercise.tags.containsAll(tags)
            })
        }

        fun toggleTag(tag: String) {
            if (tags.contains(tag)) {
                tags.remove(tag)
            } else {
                tags.add(tag)
            }
            filterExercises()
        }


        filterExercises()

        if (scrollState.isScrollInProgress) {
            selectedTag.value = null
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 20.dp),
            state = scrollState
        ) {

            item {
                FilterBar(
                    selectedTag = selectedTag,
                    tags = tags,
                    types = types,
                    onClearTags = { tags.clear(); filterExercises() })
            }
            item {
                TagSelectors(
                    selectedTag = selectedTag.value,
                    tags = tags,
                    types = types,
                    onClickTag = { toggleTag(it) })
            }
            item { Divider(modifier = Modifier.offset(y = (-2).dp)) }
            item { TagView(tags = tags) }
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