package hu.bme.aut.elvira.data

import java.io.Serializable

data class Timetable(
    val change: String,
    val `class`: String,
    val class_name: String,
    val cost1st: String,
    val cost2nd: String,
    val destination: String,
    val destinationtime: String,
    val details: List<Detail>,
    val distance: String,
    val start: String,
    val starttime: String,
    val totaltime: String,
    val type: String
) : Serializable