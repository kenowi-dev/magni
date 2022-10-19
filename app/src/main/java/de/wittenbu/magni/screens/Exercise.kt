package de.wittenbu.magni.screens

import android.content.res.Configuration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import de.wittenbu.magni.components.DetailsScaffold
import de.wittenbu.magni.services.ExerciseService
import de.wittenbu.magni.ui.theme.MagniTheme

@Composable
fun Exercise(
    exerciseId: String,
    onGoBack: () -> Unit
) {
    val exercise = ExerciseService.getById(exerciseId.toLong())!!
    DetailsScaffold(
        title = exercise.name,
        onGoBack = onGoBack
    ) {
        Text(
            text = "Exercise Page",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = false)
@Preview(name = "Light Mode")
@Composable
fun ExercisePreview() {
    MagniTheme {
        Exercise(exerciseId = "1", onGoBack = {})
    }
}