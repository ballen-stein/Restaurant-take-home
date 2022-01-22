package com.company.takehome.network.yelp.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@Serializable
@JsonClass(generateAdapter = true)
data class YelpResponse(
    @Json(name = "businesses") val restaurants: List<YelpRestaurant> = listOf()
)
