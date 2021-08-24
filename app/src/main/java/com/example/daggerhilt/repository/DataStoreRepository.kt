package com.example.daggerhilt.repository

import androidx.lifecycle.MutableLiveData

interface DataStoreRepository {
    fun callCoverage()
    fun getCoverage(): MutableLiveData<Any>
}