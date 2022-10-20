package de.wittenbu.magni.models.exerciseVariations

import de.wittenbu.magni.models.ExercisePosition
import kotlin.time.Duration

class HoldVariation(val possibleHoldPositions: List<ExercisePosition>) : ExerciseVariation("Hold")

class HoldExecution(val holdPosition: ExercisePosition, val duration: Duration) : ExerciseExecution()