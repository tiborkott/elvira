package hu.bme.aut.elvira.data

import java.io.Serializable

data class Service(
    val code: Int,
    val icon: String,
    val key: String
) : Serializable