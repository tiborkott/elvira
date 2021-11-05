package hu.bme.aut.elvira.data

import java.io.Serializable

data class Detail(
    val dep: String,
    val dep_real: String,
    val from: String,
    val original_way: List<String>,
    val platform: String,
    val services: List<Service>,
    val train_info: TrainInfo
) : Serializable