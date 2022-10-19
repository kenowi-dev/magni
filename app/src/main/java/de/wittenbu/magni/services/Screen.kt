package de.wittenbu.magni.services

import androidx.annotation.DrawableRes
import de.wittenbu.magni.R

sealed class Screen(val name: String, val route: String, val args: String = "", @DrawableRes val icon: Int? = null) {
    object Home : Screen("Home", "home", icon = R.drawable.home)
    object Exercises : Screen("Exercises", "exercises", icon = R.drawable.exercises)
    object Exercise : Screen("Exercise", "exercise", args = "/{exerciseId}")
    object Workouts : Screen("Workouts", "workouts", icon = R.drawable.workouts)
    object TrainingPlans : Screen("Training Plans", "training_plans", icon = R.drawable.training_plans)

    fun routeWithArgs(): String {
        return this.route + this.args;
    }
}