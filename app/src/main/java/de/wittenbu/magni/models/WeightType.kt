package de.wittenbu.magni.models

enum class WeightType(private val description: String, val belongsTo: List<WeightType> = listOf()) {
    MACHINE("Machine"),
    BODY_WEIGHT("Body Weight"),
    FREE_WEIGHT("Free Weight"),
    BARBELL("Barbell", listOf(FREE_WEIGHT)),
    DUMBBELL("Dumbbell", listOf(FREE_WEIGHT)),
    KETTLEBELL("Kettlebell", listOf(FREE_WEIGHT));

    override fun toString(): String {
        return description
    }
}