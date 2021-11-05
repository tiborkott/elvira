package hu.bme.aut.elvira.data

import java.io.Serializable

data class Trains(
    val date: String,
    val route: String,
    val timetable: List<Timetable>
) : Serializable

