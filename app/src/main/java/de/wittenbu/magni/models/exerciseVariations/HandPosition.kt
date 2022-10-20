package de.wittenbu.magni.models.exerciseVariations

enum class HandPositionType {
    SHOULDER_WIDE, CLOSE, WIDE, FRONT, BACK, HANDS_TOGETHER
}

class HandPositionVariation(val possibleHandPositions: List<HandPositionType>) : ExerciseVariation("Hand Position")

class HandPositionExecution(handPosition: HandPositionType) : ExerciseExecution()