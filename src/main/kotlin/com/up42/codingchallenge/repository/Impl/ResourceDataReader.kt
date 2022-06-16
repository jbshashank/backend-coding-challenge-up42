package com.up42.codingchallenge.service.datareader


import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service

import com.up42.codingchallenge.constants.FeatureConstants
import com.up42.codingchallenge.controller.model.Features
import com.up42.codingchallenge.exception.FeaturesNotFoundException
import com.up42.codingchallenge.repository.DataReaderRepositry


@Service
@Qualifier("resourceDataReader")
class ResourceDataReader: DataReaderRepositry {
override fun dataReader(): List<Features.Feature> {
    return ClassPathResource(FeatureConstants.SOURCE_DATA_JSON).file
        .readText()
        .let { jsonString -> jacksonObjectMapper().readValue<List<Features>>(jsonString) }
        .flatMap { it.features }
        .map {
            it.apply {
                id = properties?.id
                timestamp = properties?.timestamp
                beginViewingDate = properties?.acquisition?.beginViewingDate
                endViewingDate = properties?.acquisition?.endViewingDate
                missionName = properties?.acquisition?.missionName
            }
        }
        .ifEmpty {
            throw FeaturesNotFoundException()
        }
}
}