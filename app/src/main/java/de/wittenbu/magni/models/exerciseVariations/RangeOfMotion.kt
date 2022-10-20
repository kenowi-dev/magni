package de.wittenbu.magni.models.exerciseVariations

import de.wittenbu.magni.models.ExercisePosition

class RangeOfMotionVariation : ExerciseVariation("Range Of Motion")

class RangeOfMotionExecution(val from: ExercisePosition, val to: ExercisePosition): ExerciseExecution()