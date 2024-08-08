package pl.piomin.samples.intro.domain


data class SocialIntegration(
    val id: Long,
    val goalId: Long,
    val socialNetwork: SocialNetwork,
    val socialId: String,
    val username: String
)

enum class SocialNetwork {
    FACEBOOK,
    TWITTER,
    INSTAGRAM
}
