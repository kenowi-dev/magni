package de.wittenbu.magni.models.exerciseVariations

enum class FeetPositionType {
    SHOULDER_WIDE, CLOSE, WIDE
}

class FeetPositionVariation(val possibleFeetPositions: List<FeetPositionType>) : ExerciseVariation("Feet Position")

class FeetPositionExecution(feetPosition: FeetPositionType) : ExerciseExecution()