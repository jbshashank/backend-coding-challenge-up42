package com.up42.codingchallenge.exception

class FeatureNotFoundException(id: String): Exception("Feature is not found for id : $id")