package com.up42.codingchallenge.controller

import com.up42.codingchallenge.controller.model.Features
import com.up42.codingchallenge.service.FeatureService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class FeaturesController(@Autowired var featureService: FeatureService) {
    var logger: Logger = LoggerFactory.getLogger(this.javaClass)


    @GetMapping("/features")
    fun getFeatures(): ResponseEntity<List<Features.Feature>> {
        return ResponseEntity(featureService.getAllFeatures(), HttpStatus.OK)
    }

    @GetMapping("features/{featureId}/quicklook")
    fun getFeatureQuickLookByFeatureId(@PathVariable featureId: UUID): ResponseEntity<Any> {
        val headers = HttpHeaders()
        headers.contentType = MediaType.IMAGE_PNG

        return ResponseEntity(
            featureService.getFeatureQuicklookById(featureId),
            headers,
            HttpStatus.OK
        )
    }
}
