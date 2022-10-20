package de.wittenbu.magni.models.exerciseVariations

import kotlin.time.Duration

class TimeVariation :  ExerciseVariation("Time")

class TimeExecution(val duration: Duration) : ExerciseExecution()