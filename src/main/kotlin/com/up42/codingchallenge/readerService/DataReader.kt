package com.up42.codingchallenge.service.readerService
import com.up42.codingchallenge.controller.model.Features


interface DataReader {
    fun dataReader(): List<Features.Feature>
}