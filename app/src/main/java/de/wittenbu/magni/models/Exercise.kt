package de.wittenbu.magni.models

data class Exercise(
    val id: Long,
    val name: String,
    val weight: Weight,
    val muscles: List<Muscle> = listOf(),
    val variations: List<Exercise> = listOf()
)