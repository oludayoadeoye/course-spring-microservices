package pl.piomin.samples.intro.domain



data class User(
    val id: Long,
    val username: String,
    val password: String,
    val email: String
)