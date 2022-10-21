package de.wittenbu.magni.models

enum class Muscle(private val description: String, val belongsTo: List<Muscle> = listOf()) {
    LOWER_BODY("Lower Body"),
    UPPER_BODY("Upper Body"),
    ARMS("Arms", listOf(UPPER_BODY)),
    CHEST("Chest", listOf(UPPER_BODY)),
    BACK("Back", listOf(UPPER_BODY)),
    LEGS("Legs", listOf(LOWER_BODY)),
    CORE("Core", listOf(UPPER_BODY)),
    SHOULDERS("Shoulders", listOf(UPPER_BODY)),
    TRICEPS("Triceps", listOf(UPPER_BODY, ARMS)),
    BICEPS("Biceps", listOf(UPPER_BODY, ARMS)),
    FOREARMS("Forearms", listOf(UPPER_BODY, ARMS)),
    FINGERS("Fingers", listOf(UPPER_BODY, ARMS, FOREARMS)),
    TRAPS("Traps", listOf(UPPER_BODY, BACK)),
    LATS("Lats", listOf(UPPER_BODY, BACK)),
    LOWER_BACK("Lower Back", listOf(UPPER_BODY, BACK, CORE)),
    OBLIQUES("Obliques", listOf(UPPER_BODY, CORE)),
    ABS("Abs", listOf(UPPER_BODY, CORE)),
    GLUTES("Glutes", listOf(LOWER_BODY, LEGS)),
    QUADS("Quads", listOf(LOWER_BODY, LEGS)),
    HAMSTRINGS("Hamstrings", listOf(LOWER_BODY, LEGS)),
    CALVES("Calves", listOf(LOWER_BODY, LEGS));

    override fun toString(): String {
        return description
    }

}


