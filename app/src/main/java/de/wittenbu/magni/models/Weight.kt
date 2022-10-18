package de.wittenbu.magni.models

enum class WeightType {
    BODY_WEIGHT, WEIGHTED_VEST, ANKLE_WEIGHTS, BARBELL, DUMBBELL, MACHINE
}

enum class WeightUnit {
    KG, LBS, BODY_WEIGHT_PERCENT
}

data class Weight(
    val type: WeightType,
    val unit: WeightUnit
)
