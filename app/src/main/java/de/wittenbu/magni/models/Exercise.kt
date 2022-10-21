package de.wittenbu.magni.models
class ExerciseDefinition(
    val id: Long,
    val name: String,
    val trainingType: List<TrainingType> = listOf(),
    val movementTypes: List<MovementType> = listOf(),
    weightType: List<WeightType> = listOf(),
    muscles: Set<Muscle> = setOf(),
    val regressions: List<ExerciseDefinition> = listOf(),
    val alternatives: List<ExerciseDefinition> = listOf(),
    val progressions: List<ExerciseDefinition> = listOf(),
) {
    val muscles: Set<Muscle>
    val weightType: Set<WeightType>
    val tags: List<String>

    init {
        this.muscles = muscles.flatMap { it.belongsTo }.toMutableSet().also { it.addAll(muscles) }.toSet()
        this.weightType = weightType.flatMap { it.belongsTo }.toMutableSet().also { it.addAll(weightType) }.toSet()
        val tempTags = mutableListOf<String>()
        tempTags.addAll(movementTypes.map { it.toString() })
        tempTags.addAll(this.weightType.map { it.toString() })
        tempTags.addAll(this.muscles.map { it.toString() })
        tempTags.addAll(trainingType.map { it.toString() })
        this.tags = tempTags
    }
}

data class ExerciseExecution(
    val exerciseDefinition: ExerciseDefinition,
    val execution: List<ExecutionType>,
    val goal: Int,
    val weight: Weight
)

