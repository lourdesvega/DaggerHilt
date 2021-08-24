package com.example.web

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: APIAppService) {
    suspend fun getCoverages() = apiService.getCoverages()
}
