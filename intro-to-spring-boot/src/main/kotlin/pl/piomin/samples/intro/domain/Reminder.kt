package pl.piomin.samples.intro.domain

import java.time.LocalDate
import java.time.LocalTime


data class Reminder(
    val id: Long,
    val goalId: Long,
    val reminderDate: LocalDate,
    val reminderTime: LocalTime,
    val isCompleted: Boolean
)
