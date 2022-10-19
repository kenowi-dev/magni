package de.wittenbu.magni.models

enum class WeightType(val readable: String) {
    BODY_WEIGHT("Body Weight"),
    WEIGHTED_VEST("Weighted Vest"),
    ANKLE_WEIGHTS("Ankle Weights"),
    BARBELL("Barbell"),
    DUMBBELL("Dumbbell"),
    MACHINE("Machine")

}

enum class WeightUnit {
    KG, LBS, BODY_WEIGHT_PERCENT
}

data class Weight(
    val type: WeightType,
    val unit: WeightUnit
)
