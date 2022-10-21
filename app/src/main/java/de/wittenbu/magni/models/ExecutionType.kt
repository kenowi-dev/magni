package de.wittenbu.magni.models

enum class ExecutionType(private val description: String) {
    FOR_REPS("For Reps"),
    FOR_TIME("For Time"),
    TO_FAILURE("To Failure");

    override fun toString(): String {
        return description
    }
}