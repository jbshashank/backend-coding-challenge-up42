package com.up42.codingchallenge.service

import com.up42.codingchallenge.controller.model.Features
import com.up42.codingchallenge.exception.FeaturesNotFoundException
import com.up42.codingchallenge.repository.DataReaderRepositry
import org.apache.tomcat.util.codec.binary.Base64
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*


@Service
class FeatureService(@Autowired @Qualifier("resourceDataReader") var featureDataReader: DataReaderRepositry){
    var logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun getAllFeatures(): List<Features.Feature> {
        val features: List<Features.Feature>

        try {
            features = featureDataReader.dataReader()
            logger.debug("Reading all features from Resource Data Reader"+ features);
        }catch(featuresNotFoundException: FeaturesNotFoundException){
            throw FeaturesNotFoundException()
        }
        return features;
    }

    fun getFeatureQuicklookById(searchId: UUID): ByteArray {
        var imageByteArray = Base64.decodeBase64(getFeatureById(searchId).properties?.quicklook!!)
        logger.debug("Image Byte array for a given id is "+ imageByteArray);
        return imageByteArray
    }

    fun getFeatureById(searchId: UUID): Features.Feature =  getAllFeatures().filter { it.id == searchId }.first()
}