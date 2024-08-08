package pl.piomin.samples.intro.domain



data class Recommendation(
    val id: Long,
    val goalId: Long,
    val recommendationType: RecommendationType,
    val recommendationDetails: String
)


enum class RecommendationType {
    EXERCISE,
    NUTRITION,
    STUDY_TIPS,
    OTHER
}