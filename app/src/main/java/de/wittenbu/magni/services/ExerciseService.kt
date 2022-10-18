package de.wittenbu.magni.services

import de.wittenbu.magni.models.*
import de.wittenbu.magni.util.FakeData

object ExerciseService {
    val exercises: List<Exercise> = FakeData.Exercise.getAll()

    fun getById(id: Long): Exercise? {
        return exercises.find { exercise -> exercise.id == id }
    }
}
