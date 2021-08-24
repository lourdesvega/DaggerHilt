package com.example.models

import com.google.gson.annotations.SerializedName

data class Coverage(
    var id: Long? = null,

    @SerializedName("city_id")
    val cityId: String? = null,

    var city: String? = null,
)
