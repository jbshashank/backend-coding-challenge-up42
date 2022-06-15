package com.up42.codingchallenge.exception

import com.up42.codingchallenge.constants.FeatureConstants

class FeaturesNotFoundException() : Exception(FeatureConstants.FEATURES_NOT_FOUND)