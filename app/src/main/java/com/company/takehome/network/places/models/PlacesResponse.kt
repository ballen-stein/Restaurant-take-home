package com.company.takehome.network.places.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@JsonClass(generateAdapter = true)
@Serializable
data class PlacesResponse(
    @Json(name = "results") val restaurants: List<PlacesRestaurant> = listOf(),

  /* If there are more results, the response will contain this token which can be used to fetch them.
  If there are no more results to return, this will be empty. */
  @Json(name = "next_page_token") val nextPageToken: String = ""
)
