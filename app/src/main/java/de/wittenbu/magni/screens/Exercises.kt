package de.wittenbu.magni.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import de.wittenbu.magni.models.Exercise

import de.wittenbu.magni.services.ExerciseService

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Exercises(
    onOpenExercise: (Exercise) -> Unit
) {
    val exercises = ExerciseService.exercises

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(exercises) { exercise ->
            Card(
                onClick = { onOpenExercise(exercise) }
            ) {
                Box(Modifier.fillMaxSize()) {
                    Text(exercise.name, Modifier.align(Alignment.Center))
                }
            }
        }
    }
}