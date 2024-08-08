package pl.piomin.samples.intro.repository

import org.springframework.stereotype.Repository
import pl.piomin.samples.intro.domain.Analytics

@Repository
class AnalyticsRepository(private val analyticsList: MutableList<Analytics> = mutableListOf()) {

 fun findById(id: Long): Analytics? = analyticsList.find { it.id == id }

 fun findAll(): MutableList<Analytics> = analyticsList

 fun delete(id: Long) = analyticsList.removeIf { it.id == id }

 fun add(analytics: Analytics) = analyticsList.add(analytics)

 fun update(analytics: Analytics) {
  val index: Int = analyticsList.indexOfFirst { it.id == analytics.id }
  if (index != -1) {
   analyticsList[index] = analytics
  }
 }
}
