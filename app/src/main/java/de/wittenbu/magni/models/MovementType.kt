package de.wittenbu.magni.models

enum class MovementType(private val description: String) {
    COMPOUND("Compound"),
    ISOLATED("Isolated"),
    ISOMETRIC("Isometric"),
    DYNAMIC("Dynamic"),
    PUSH("Push"),
    PULL("Pull");

    override fun toString(): String {
        return description
    }

}