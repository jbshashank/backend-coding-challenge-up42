package com.up42.codingchallenge.exception

import java.util.*

class FeatureNotFoundException(id: UUID): Exception("Feature is not found for id : $id")