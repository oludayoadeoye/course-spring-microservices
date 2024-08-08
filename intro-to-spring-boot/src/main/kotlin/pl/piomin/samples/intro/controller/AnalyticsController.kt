package pl.piomin.samples.intro.controller

import org.springframework.web.bind.annotation.*
import pl.piomin.samples.intro.domain.Analytics
import pl.piomin.samples.intro.repository.AnalyticsRepository

@RestController
@RequestMapping("/analytics")
class AnalyticsController(private val repository: AnalyticsRepository) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Analytics? = repository.findById(id)

    @GetMapping
    fun findAll(): MutableList<Analytics> = repository.findAll()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = repository.delete(id)

    @PutMapping
    fun update(@RequestBody analytics: Analytics) = repository.update(analytics)

    @PostMapping
    fun add(@RequestBody analytics: Analytics) = repository.add(analytics)
}
