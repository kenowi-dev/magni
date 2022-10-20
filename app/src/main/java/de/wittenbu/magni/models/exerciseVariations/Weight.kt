package de.wittenbu.magni.models.exerciseVariations

enum class WeightType(val readable: String) {
    BODY_WEIGHT("Body Weight"),
    WEIGHTED_VEST("Weighted Vest"),
    ANKLE_WEIGHTS("Ankle Weights"),
    BARBELL("Barbell"),
    DUMBBELL("Dumbbell"),
    MACHINE("Machine")
}

enum class WeightUnit {
    KG, LBS, BODY_WEIGHT_PERCENT, ONE_REP_MAX_PERCENT
}


class WeightVariation(val possibleWeightTypes: List<WeightType>): ExerciseVariation("Weight")

class WeightExecution(val weightType: WeightType, val amount: Int, val weightUnit: WeightUnit): ExerciseExecution()