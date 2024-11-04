package com.example.retrofittest.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlaceResponse(
    @Json(name = "places")
    val places: List<Place>,
    @Json(name = "query")
    val query: String,
    @Json(name = "status")
    val status: String
) {

    @JsonClass(generateAdapter = true)
    data class Place(
        @Json(name = "formatted_address")
        val address: String,
        @Json(name = "id")
        val id: String,
        @Json(name = "location")
        val location: Location,
        @Json(name = "name")
        val name: String,
        @Json(name = "place_id")
        val placeId: String
    )

    @JsonClass(generateAdapter = true)
    data class Location(
        @Json(name = "lat")
        val lat: Double,
        @Json(name = "lng")
        val lng: Double
    )

}