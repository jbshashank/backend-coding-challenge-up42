package com.up42.codingchallenge.controller


import com.up42.codingchallenge.controller.model.Features
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import com.up42.codingchallenge.service.FeatureService
import java.util.*

@RestController
class FeaturesController(@Autowired var featureService: FeatureService) {

    @GetMapping
    fun getFeatures(): ResponseEntity<List<Features.Feature>> {
        return ResponseEntity(featureService.getAllFeatures(), HttpStatus.OK)
    }

    @GetMapping("/{featureId}/quicklook")
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

