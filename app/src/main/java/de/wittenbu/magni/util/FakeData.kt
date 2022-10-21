package de.wittenbu.magni.util

import de.wittenbu.magni.models.*

object FakeData {

    object Exercise {
        val pushUp = ExerciseDefinition(
            id = 1,
            name = "Push Ups",
            trainingType = listOf(TrainingType.STRENGTH),
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC, MovementType.PUSH),
            weightType = listOf(WeightType.BODY_WEIGHT),
            muscles = setOf(Muscle.TRICEPS, Muscle.CHEST, Muscle.ABS)
        )

        val pullUps = ExerciseDefinition(
            id = 2,
            name = "Pull Ups",
            trainingType = listOf(TrainingType.STRENGTH),
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC, MovementType.PULL),
            weightType = listOf(WeightType.BODY_WEIGHT),
            muscles = setOf(Muscle.BICEPS, Muscle.LATS, Muscle.ABS)
        )

        val bodyWeightSquats = ExerciseDefinition(
            id = 3,
            name = "Body Weight Squats",
            trainingType = listOf(TrainingType.STRENGTH),
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC),
            weightType = listOf(WeightType.BODY_WEIGHT),
            muscles = setOf(Muscle.CALVES, Muscle.QUADS, Muscle.ABS)
        )

        val benchPress = ExerciseDefinition(
            id = 4,
            name = "Bench Press",
            trainingType = listOf(TrainingType.STRENGTH),
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC, MovementType.PUSH),
            weightType = listOf(WeightType.BARBELL),
            muscles = setOf(Muscle.TRICEPS, Muscle.CHEST, Muscle.ABS)
        )

        val latPullDown = ExerciseDefinition(
            id = 5,
            name = "Lat Pull Down",
            trainingType = listOf(TrainingType.STRENGTH),
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC, MovementType.PULL),
            weightType = listOf(WeightType.MACHINE),
            muscles = setOf(Muscle.LATS, Muscle.BICEPS, Muscle.ABS)
        )

        val barbellSquats = ExerciseDefinition(
            id = 6,
            name = "Barbell Squats",
            trainingType = listOf(TrainingType.STRENGTH),
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC),
            weightType = listOf(WeightType.BARBELL),
            muscles = setOf(Muscle.QUADS, Muscle.ABS)
        )

        val pullUpBurpees = ExerciseDefinition(
            id = 7,
            name = "Pull Up Burpees",
            trainingType = listOf(TrainingType.STRENGTH),
            movementTypes = listOf(MovementType.COMPOUND, MovementType.DYNAMIC),
            weightType = listOf(WeightType.BODY_WEIGHT),
            muscles = setOf(Muscle.TRICEPS, Muscle.CHEST, Muscle.ABS, Muscle.BICEPS, Muscle.BACK)
        )

        val plank = ExerciseDefinition(
            id = 8,
            name = "Plank",
            trainingType = listOf(TrainingType.STRENGTH),
            movementTypes = listOf(MovementType.COMPOUND, MovementType.ISOMETRIC),
            weightType = listOf(WeightType.BODY_WEIGHT),
            muscles = setOf(Muscle.ABS)
        )

        val all = ExerciseDefinition(
            id = 9,
            name = "Everything",
            trainingType = TrainingType.values().toList(),
            movementTypes = MovementType.values().toList(),
            weightType = WeightType.values().toList(),
            muscles = Muscle.values().toSet()
        )

        fun getAll(): List<ExerciseDefinition> {
            return listOf(pushUp, pullUps, bodyWeightSquats, benchPress, latPullDown, barbellSquats, pullUpBurpees, plank, all)
        }
    }
}