package de.wittenbu.magni.models

class ExerciseDefinition(
    val id: Long,
    val name: String,
    val trainingType: TrainingType,
    val movementTypes: List<MovementType> = listOf(),
    weightType: List<WeightType> = listOf(),
    muscles: Set<Muscle> = setOf(),
    val regressions: List<ExerciseDefinition> = listOf(),
    val alternatives: List<ExerciseDefinition> = listOf(),
    val progressions: List<ExerciseDefinition> = listOf(),
) {
    val muscles = muscles.flatMap { it.belongsTo }.toMutableSet().also { it.addAll(muscles) }.toSet()
    val weightType = weightType.flatMap { it.belongsTo }.toMutableSet().also { it.addAll(weightType) }.toSet()
}

data class ExerciseExecution(
    val exerciseDefinition: ExerciseDefinition,
    val execution: List<ExecutionType>,
    val goal: Int,
    val weight: Weight
)