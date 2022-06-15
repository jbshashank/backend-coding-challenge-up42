package com.up42.codingchallenge.service

import com.up42.codingchallenge.constants.FeatureConstants
import com.up42.codingchallenge.controller.model.Features
import com.up42.codingchallenge.exception.FeaturesNotFoundException
import org.apache.tomcat.util.codec.binary.Base64
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import java.util.UUID

import com.up42.codingchallenge.service.readerService.DataReader


@Service
class FeatureService(@Autowired @Qualifier("resourceDataReader") var featureDataReader: DataReader){

    fun getAllFeatures(): List<Features.Feature> {
        val features: List<Features.Feature>

        try {
            features = featureDataReader.dataReader()
        }catch(featuresNotFoundException: FeaturesNotFoundException){
            throw FeaturesNotFoundException(FeatureConstants.FEATURES_NOT_FOUND)
        }
        return features;
    }

    fun getFeatureQuicklookById(searchId: UUID): ByteArray {
        return Base64.decodeBase64(getFeatureById(searchId).properties?.quicklook!!)
    }

    fun getFeatureById(searchId: UUID): Features.Feature =  getAllFeatures().filter { it.id == searchId }.first()

}