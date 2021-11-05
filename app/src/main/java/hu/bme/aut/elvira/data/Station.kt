package hu.bme.aut.elvira.data

data class Station(
    val expected: Expected,
    val km: String,
    val platform: String,
    val real: Real,
    val schedule: Schedule,
    val station: StationInfo
)