package de.wittenbu.magni.models

enum class MuscleGroup {
    LEGS, BACK, CHEST, ARMS
}

data class Muscle(
    val name: String,
    val muscleGroup: MuscleGroup,
    val latinName: String? = null
)