package hu.bme.aut.elvira.data

import java.io.Serializable

data class TrainInfo(
    val code: String,
    val delay_info: Any,
    val get_url: String,
    val havaria_reason: Any,
    val href: String,
    val info: String,
    val is_local_transport: Boolean,
    val text: String,
    val type: String,
    val url: String,
    val vsz_code: String
) : Serializable