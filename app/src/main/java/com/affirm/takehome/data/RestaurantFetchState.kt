package com.affirm.takehome.data

/**
 * Enum to keep track of the Restaurant list's state
 * YELP -> Showing Yelp items / Most recent API call was for YELP items
 * PLACES -> Showing Places items / Most recent API call was for PLACES items
 */
enum class RestaurantFetchState {
    YELP,
    PLACES;
}
