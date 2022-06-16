package com.up42.codingchallenge.repository
import com.up42.codingchallenge.controller.model.Features


interface DataReaderRepositry {
    fun dataReader(): List<Features.Feature>
}