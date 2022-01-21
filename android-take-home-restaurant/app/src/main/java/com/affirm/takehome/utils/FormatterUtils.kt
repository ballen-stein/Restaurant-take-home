package com.affirm.takehome.utils

import com.affirm.takehome.data.Restaurant
import com.affirm.takehome.network.places.PlacesResponse
import com.affirm.takehome.network.places.PlacesRestaurantService
import com.affirm.takehome.network.places.RestaurantPhoto
import com.affirm.takehome.network.yelp.YelpResponse

fun YelpResponse?.formatYelp(): List<Restaurant> {
    return this?.restaurants?.map {
        Restaurant(
            id = it.id,
            name = it.name,
            image = it.image,
            rating = it.rating
        )
    } ?: emptyList()
}

fun PlacesResponse?.formatPlaces(): List<Restaurant> {
    return this?.restaurants?.map {
        Restaurant(
            id = it.id,
            name = it.name,
            image = it.photos.firstOrNull()?.createPlacesPhoto() ?: "",
            rating = it.rating
        )
    } ?: emptyList()
}

fun RestaurantPhoto.createPlacesPhoto(): String {
    /***
     * Picasso refused to load literally 1/20 of the images for me, so I went and found
     * this string on stack overflow to turn photoReference into a usable image string :)
     * https://stackoverflow.com/questions/13524834/google-place-api-placedetails-photo-reference
     *
     * It's an 80-20 split: sometimes it shows the placeholder instead of the image, but that's still
     * 1600% more images from before using this method. Also, I have no idea what's going on with the
     * Pizza palace(?) place (the 1 Star pizza place) but it sometimes shows the place holder and
     * sometimes shows the prior or another restaurant's image instead. If I had more time I'd tackle
     * fixing that first.
     */
    return "https://maps.googleapis.com/maps/api/place/photo?photoreference=${photoReference}&sensor=false&maxheight=${height}&maxwidth=${width}&key=${PlacesRestaurantService.KEY}"
}
