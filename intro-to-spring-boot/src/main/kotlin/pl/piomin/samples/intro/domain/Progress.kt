package pl.piomin.samples.intro.domain

import java.time.LocalDate

data class Progress(
    val id: Long,
    val goalId: Long,
    val progress: Int,
    val progressDate: LocalDate
)
