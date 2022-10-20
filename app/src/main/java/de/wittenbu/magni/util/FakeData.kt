package de.wittenbu.magni.util

import de.wittenbu.magni.models.*
import de.wittenbu.magni.models.exerciseVariations.*

object FakeData {

    object Muscles {
        val triceps = Muscle(name = "Triceps", muscleGroup = MuscleGroup.ARMS)
        val pecs = Muscle(name = "Pecs", muscleGroup = MuscleGroup.CHEST)
        val biceps = Muscle(name = "Biceps", muscleGroup = MuscleGroup.ARMS)
        val lats = Muscle(name = "Lats", muscleGroup = MuscleGroup.BACK)
        val quads = Muscle(name = "Quads", muscleGroup = MuscleGroup.LEGS)
        val calves = Muscle(name = "Calves", muscleGroup = MuscleGroup.LEGS)
        val core = Muscle(name = "Core", muscleGroup = MuscleGroup.CORE)
    }

    object Variations {
        val bodyWeightPush = BodyWeightVariation(
            listOf(
                BodyWeightVariables.AGAINST_WALL,
                BodyWeightVariables.ON_FEET,
                BodyWeightVariables.ELEVATED,
                BodyWeightVariables.FEET_ELEVATED,
                BodyWeightVariables.ON_KNEES,
                BodyWeightVariables.WEIGHTED_VEST
            )
        )
        val bodyWeightPull = BodyWeightVariation(
            listOf(
                BodyWeightVariables.WITH_BANDS,
                BodyWeightVariables.WEIGHTED_VEST
            )
        )
        val bodyWeightPlank = BodyWeightVariation(
            listOf(
                BodyWeightVariables.ON_FEET,
                BodyWeightVariables.ELEVATED,
                BodyWeightVariables.FEET_ELEVATED,
                BodyWeightVariables.ON_KNEES,
                BodyWeightVariables.WEIGHTED_VEST
            )
        )
        val concentric = ConcentricVariation();
        val eccentric = EccentricVariation();
        val handPosition = HandPositionVariation(listOf(HandPositionType.HANDS_TOGETHER, HandPositionType.CLOSE, HandPositionType.WIDE, HandPositionType.SHOULDER_WIDE))
        val hold = HoldVariation(listOf(ExercisePosition.TOP, ExercisePosition.MIDDLE, ExercisePosition.BOTTOM, ExercisePosition.HALF_TOP, ExercisePosition.HALF_TOP));
        val rangeOfMotion = RangeOfMotionVariation();
        val repetitions = RepetitionsVariation();
        val feetPosition = FeetPositionVariation(listOf(FeetPositionType.WIDE, FeetPositionType.CLOSE, FeetPositionType.SHOULDER_WIDE))
        val time = TimeVariation();
        val weightPress = WeightVariation(listOf(WeightType.DUMBBELL, WeightType.BARBELL));
        val weightPull = WeightVariation(listOf(WeightType.MACHINE));
        val weightSquat = WeightVariation(listOf(WeightType.MACHINE, WeightType.BARBELL, WeightType.WEIGHTED_VEST));
    }

    object Exercise {
        val pushUp = ExerciseDefinition(
            id = 1,
            name = "Push Ups",
            variations = listOf(Variations.bodyWeightPush, Variations.concentric, Variations.eccentric, Variations.handPosition, Variations.hold, Variations.rangeOfMotion, Variations.repetitions),
            muscles = listOf(Muscles.triceps, Muscles.pecs),
            tags = setOf(Tag.BODY_WEIGHT, Tag.PUSH, Tag.REPS)
        )

        val pullUps = ExerciseDefinition(
            id = 2,
            name = "Pull Ups",
            variations = listOf(Variations.bodyWeightPull, Variations.concentric, Variations.eccentric, Variations.handPosition, Variations.hold, Variations.rangeOfMotion, Variations.repetitions),
            muscles = listOf(Muscles.biceps, Muscles.lats),
            tags = setOf(Tag.BODY_WEIGHT, Tag.PULL, Tag.REPS)
        )

        val bodyWeightSquats = ExerciseDefinition(
            id = 3,
            name = "Body Weight Squats",
            variations = listOf(Variations.bodyWeightPull, Variations.concentric, Variations.eccentric, Variations.hold, Variations.rangeOfMotion, Variations.repetitions, Variations.feetPosition),
            muscles = listOf(Muscles.quads, Muscles.calves),
            tags = setOf(Tag.BODY_WEIGHT, Tag.REPS)
        )

        val benchPress = ExerciseDefinition(
            id = 4,
            name = "Bench Press",
            variations = listOf(Variations.weightPress, Variations.concentric, Variations.eccentric, Variations.handPosition, Variations.hold, Variations.rangeOfMotion, Variations.repetitions),
            muscles = listOf(Muscles.triceps, Muscles.pecs),
            tags = setOf(Tag.BARBELL, Tag.PUSH, Tag.REPS)
        )

        val latPullDown = ExerciseDefinition(
            id = 5,
            name = "Lat Pull Down",
            variations = listOf(Variations.weightPull, Variations.concentric, Variations.eccentric, Variations.handPosition, Variations.hold, Variations.rangeOfMotion, Variations.repetitions),
            muscles = listOf(Muscles.biceps, Muscles.lats),
            tags = setOf(Tag.MACHINE, Tag.PULL, Tag.REPS)
        )

        val barbellSquats = ExerciseDefinition(
            id = 6,
            name = "Barbell Squats",
            variations = listOf(Variations.weightSquat, Variations.concentric, Variations.eccentric, Variations.hold, Variations.rangeOfMotion, Variations.repetitions, Variations.feetPosition),
            muscles = listOf(Muscles.quads, Muscles.calves),
            tags = setOf(Tag.BARBELL, Tag.REPS)
        )

        val pullUpBurpees = ExerciseDefinition(
            id = 7,
            name = "Pull Up Burpees",
            variations = listOf(),
            muscles = listOf(Muscles.biceps, Muscles.lats, Muscles.triceps, Muscles.pecs, Muscles.quads, Muscles.calves),
            tags = setOf(Tag.PUSH, Tag.PULL, Tag.BODY_WEIGHT)
        )

        val plank = ExerciseDefinition(
            id = 8,
            name = "Plank",
            variations = listOf(Variations.time, Variations.bodyWeightPlank),
            muscles = listOf(Muscles.core),
            tags = setOf(Tag.TIMED, Tag.STATIC, Tag.BODY_WEIGHT)
        )

        fun getAll(): List<ExerciseDefinition> {
            return listOf(pushUp, pullUps, bodyWeightSquats, benchPress, latPullDown, barbellSquats, pullUpBurpees, plank)
        }
    }
}