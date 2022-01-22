package com.company.takehome.network.places.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@JsonClass(generateAdapter = true)
@Serializable
data class PlacesRestaurant(
  @Json(name = "place_id") val id: String,
  @Json(name = "name") val name: String,
  @Json(name = "photos") val photos: List<RestaurantPhoto> = emptyList(),
  @Json(name = "rating") val rating: String = ""
)

@JsonClass(generateAdapter = true)
@Serializable
data class RestaurantPhoto(
  @Json(name = "photo_reference") val photoReference: String,
  val height: Int,
  val width: Int
)
