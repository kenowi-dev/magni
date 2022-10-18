package de.wittenbu.magni.util

import de.wittenbu.magni.models.*

object FakeData {

    object Muscles {
        val triceps = Muscle(name = "Triceps", muscleGroup = MuscleGroup.ARMS)
        val pecs = Muscle(name = "Pecs", muscleGroup = MuscleGroup.CHEST)
        val biceps = Muscle(name = "Biceps", muscleGroup = MuscleGroup.ARMS)
        val lats = Muscle(name = "Lats", muscleGroup = MuscleGroup.BACK)
        val quads = Muscle(name = "Quads", muscleGroup = MuscleGroup.LEGS)
        val calves = Muscle(name = "Calves", muscleGroup = MuscleGroup.LEGS)


    }

    object Weight {
        val bodyWeight = Weight(type = WeightType.BODY_WEIGHT, unit = WeightUnit.BODY_WEIGHT_PERCENT)
    }

    object Exercise {
        val pushUp = Exercise(
            id = 1,
            name = "Push Ups",
            weight = Weight.bodyWeight,
            muscles = listOf(Muscles.triceps, Muscles.pecs)
        )

        val pullUps = Exercise(
            id = 2,
            name = "Pull Ups",
            weight = Weight.bodyWeight,
            muscles = listOf(Muscles.biceps, Muscles.lats)
        )

        val squats = Exercise(
            id = 3,
            name = "Squats",
            weight = Weight.bodyWeight,
            muscles = listOf(Muscles.quads, Muscles.calves)
        )

        fun getAll(): List<de.wittenbu.magni.models.Exercise> {
            return listOf(pushUp, pullUps, squats)
        }
    }
}