package com.company.takehome.network.yelp.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@JsonClass(generateAdapter = true)
@Serializable
data class YelpRestaurant(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "image_url") val image: String,
    @Json(name = "rating") val rating: String
)
