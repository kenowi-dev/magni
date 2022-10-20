package de.wittenbu.magni.models

import de.wittenbu.magni.models.exerciseVariations.ExerciseExecution
import de.wittenbu.magni.models.exerciseVariations.ExerciseVariation
import de.wittenbu.magni.models.exerciseVariations.Tag

class ExerciseDefinition(
    val id: Long,
    val name: String,
    val variations: List<ExerciseVariation> = listOf(),
    val muscles: List<Muscle> = listOf(),
    val tags: Set<Tag> = setOf()
)

data class ExerciseExecution(
    val exerciseDefinition: ExerciseDefinition,
    val execution: List<ExerciseExecution>
)