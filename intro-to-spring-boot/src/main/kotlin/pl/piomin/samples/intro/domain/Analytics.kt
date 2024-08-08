package pl.piomin.samples.intro.domain



data class Analytics(
    val id: Long,
    val goalId: Long,
    val totalProgress: Int,
    val averageProgress: Double,
    val completionRate: Double
)