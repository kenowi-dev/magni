package de.wittenbu.magni.models.exerciseVariations

enum class BodyWeightVariables(val readable: String) {
    AGAINST_WALL("Against a wall"),
    ELEVATED("Elevated"),
    ON_KNEES("On your knees"),
    ON_FEET("On your feet"),
    WITH_BANDS("With bands"),
    WEIGHTED_VEST("With a weighted Vest"),
    ANKLE_WEIGHTS("With ankle Weights"),
    FEET_ELEVATED("Feet elevated")
}

class BodyWeightVariation(val possibleVariations: List<BodyWeightVariables>) : ExerciseVariation("Body Weight")

class BodyWeightExecution(val variation: BodyWeightVariables) : ExerciseExecution()