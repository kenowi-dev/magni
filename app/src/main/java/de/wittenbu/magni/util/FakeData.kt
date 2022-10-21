package de.wittenbu.magni.util

import de.wittenbu.magni.models.*

object FakeData {

    object Exercise {
        val pushUp = ExerciseDefinition(
            id = 1,
            name = "Push Ups",
            trainingType = TrainingType.STRENGTH,
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC, MovementType.PUSH),
            weightType = listOf(WeightType.BODY_WEIGHT),
            muscles = setOf(Muscle.TRICEPS, Muscle.CHEST, Muscle.ABS)
        )

        val pullUps = ExerciseDefinition(
            id = 2,
            name = "Pull Ups",
            trainingType = TrainingType.STRENGTH,
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC, MovementType.PULL),
            weightType = listOf(WeightType.BODY_WEIGHT),
            muscles = setOf(Muscle.BICEPS, Muscle.LATS, Muscle.ABS)
        )

        val bodyWeightSquats = ExerciseDefinition(
            id = 3,
            name = "Body Weight Squats",
            trainingType = TrainingType.STRENGTH,
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC),
            weightType = listOf(WeightType.BODY_WEIGHT),
            muscles = setOf(Muscle.CALVES, Muscle.QUADS, Muscle.ABS)
        )

        val benchPress = ExerciseDefinition(
            id = 4,
            name = "Bench Press",
            trainingType = TrainingType.STRENGTH,
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC, MovementType.PUSH),
            weightType = listOf(WeightType.BARBELL),
            muscles = setOf(Muscle.TRICEPS, Muscle.CHEST, Muscle.ABS)
        )

        val latPullDown = ExerciseDefinition(
            id = 5,
            name = "Lat Pull Down",
            trainingType = TrainingType.STRENGTH,
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC, MovementType.PULL),
            weightType = listOf(WeightType.MACHINE),
            muscles = setOf(Muscle.LATS, Muscle.BICEPS, Muscle.ABS)
        )

        val barbellSquats = ExerciseDefinition(
            id = 6,
            name = "Barbell Squats",
            trainingType = TrainingType.STRENGTH,
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC),
            weightType = listOf(WeightType.BARBELL),
            muscles = setOf(Muscle.QUADS, Muscle.ABS)
        )

        val pullUpBurpees = ExerciseDefinition(
            id = 7,
            name = "Pull Up Burpees",
            trainingType = TrainingType.STRENGTH,
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC),
            weightType = listOf(WeightType.BODY_WEIGHT),
            muscles = setOf(Muscle.TRICEPS, Muscle.CHEST, Muscle.ABS, Muscle.BICEPS, Muscle.BACK)
        )

        val plank = ExerciseDefinition(
            id = 8,
            name = "Plank",
            trainingType = TrainingType.STRENGTH,
            movementTypes = listOf(MovementType.COMPOUND, MovementType.ISOMETRIC),
            weightType = listOf(WeightType.BODY_WEIGHT),
            muscles = setOf(Muscle.ABS)
        )

        fun getAll(): List<ExerciseDefinition> {
            return listOf(pushUp, pullUps, bodyWeightSquats, benchPress, latPullDown, barbellSquats, pullUpBurpees, plank)
        }
    }
}