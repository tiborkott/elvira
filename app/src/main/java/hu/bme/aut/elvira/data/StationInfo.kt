package hu.bme.aut.elvira.data

data class StationInfo(
    val code: String,
    val delay_info: Any,
    val get_url: String,
    val havaria_reason: Any,
    val href: String,
    val info: String,
    val is_local_transport: Boolean,
    val text: String,
    val url: String,
    val vsz_code: Any
)