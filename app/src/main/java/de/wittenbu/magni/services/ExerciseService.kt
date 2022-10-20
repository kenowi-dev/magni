package de.wittenbu.magni.services

import de.wittenbu.magni.models.*
import de.wittenbu.magni.util.FakeData

object ExerciseService {
    val exercises: List<ExerciseDefinition> = FakeData.Exercise.getAll()

    fun getById(id: Long): ExerciseDefinition? {
        return exercises.find { exercise -> exercise.id == id }
    }
}
