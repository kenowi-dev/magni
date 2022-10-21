package de.wittenbu.magni.models

enum class TrainingType(private val description: String) {
    CARDIO("Cardio"),
    STRETCHING("Stretching"),
    STRENGTH("Strength"),
    TECHNIQUE("Technique");

    override fun toString(): String {
        return description
    }
}