package com.company.takehome

import com.company.takehome.data.Restaurant
import com.company.takehome.network.places.models.PlacesResponse
import com.company.takehome.network.places.models.PlacesRestaurant
import com.company.takehome.network.places.PlacesRestaurantService
import com.company.takehome.network.places.models.RestaurantPhoto
import com.company.takehome.network.yelp.models.YelpResponse
import com.company.takehome.network.yelp.models.YelpRestaurant
import com.company.takehome.utils.createPlacesPhoto
import com.company.takehome.utils.formatPlaces
import com.company.takehome.utils.formatYelp
import org.junit.Test

// Added code below
class FormatterUtilsTest {

    @Test
    fun `format yelp test`() {
        val yelpRestaurant = YelpResponse(
            restaurants = listOf(
                YelpRestaurant(
                    id = "100",
                    name = "Restaurant1",
                    image = "",
                    rating = "4"
                ),
                YelpRestaurant(
                    id = "101",
                    name = "Restaurant2",
                    image = "",
                    rating = "5"
                ),
                YelpRestaurant(
                    id = "102",
                    name = "Restaurant3",
                    image = "",
                    rating = "3"
                )
            )
        )
        val actual = yelpRestaurant.formatYelp()
        val expected = listOf(
            Restaurant(
                id = "100",
                name = "Restaurant1",
                image = "",
                rating = "4"
            ),
            Restaurant(
                id = "101",
                name = "Restaurant2",
                image = "",
                rating = "5"
            ),
            Restaurant(
                id = "102",
                name = "Restaurant3",
                image = "",
                rating = "3"
            )
        )

        assert(expected == actual)
    }

    @Test
    fun `format places test`() {
        val restaurants = listOf(
            PlacesRestaurant(
                id = "100",
                name = "Restaurant1",
                photos = emptyList(),
                rating = "4"
            ),
            PlacesRestaurant(
                id = "101",
                name = "Restaurant2",
                photos = emptyList(),
                rating = "5"
            ),
            PlacesRestaurant(
                id = "102",
                name = "Restaurant3",
                photos = emptyList(),
                rating = "3"
            )
        )
        val nextPageToken = ""

        val placesResponse = PlacesResponse(
            restaurants,
            nextPageToken
        )

        val actual = placesResponse.formatPlaces()
        val expected = listOf(
            Restaurant(
                id = "100",
                name = "Restaurant1",
                image = "",
                rating = "4"
            ),
            Restaurant(
                id = "101",
                name = "Restaurant2",
                image = "",
                rating = "5"
            ),
            Restaurant(
                id = "102",
                name = "Restaurant3",
                image = "",
                rating = "3"
            )
        )

        assert(expected == actual)
    }

    @Test
    fun `createPlacesPhoto test`() {
        val photo = RestaurantPhoto(
            photoReference = "PHOTO_NAME",
            height = 1000,
            width = 1000
        )
        val expected = "https://maps.googleapis.com/maps/api/place/photo?photoreference=${photo.photoReference}&sensor=false&maxheight=${photo.height}&maxwidth=${photo.width}&key=${PlacesRestaurantService.KEY}"
        val actual = photo.createPlacesPhoto()
        assert(expected == actual)
    }
}
//
