package com.example.web

import com.example.models.Coverage
import retrofit2.Response
import retrofit2.http.GET

interface APIAppService {
    //Coverage
    @GET(APIConstants.wsPath + "coverage")
    suspend fun getCoverages(): Response<List<Coverage>>

}