package com.company.takehome.views.fragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.takehome.data.Restaurant
import com.company.takehome.data.RestaurantFetchState
import com.company.takehome.network.places.PlacesRestaurantService
import com.company.takehome.network.yelp.YelpRestaurantService
import com.company.takehome.utils.formatPlaces
import com.company.takehome.utils.formatYelp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.awaitResponse
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val yelpManager: YelpRestaurantService,
    private val placesRestaurantApi: PlacesRestaurantService
) : ViewModel() {

    private val _restaurantList: MutableLiveData<List<Restaurant>> = MutableLiveData(emptyList())
    val restaurantList: MutableLiveData<List<Restaurant>> = _restaurantList

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: MutableLiveData<Boolean> = _isLoading

    private val _showError: MutableLiveData<Boolean> = MutableLiveData(false)
    val showError: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _showApiError: MutableLiveData<ResponseBody?> = MutableLiveData(null)
    val showApiError: MutableLiveData<ResponseBody?> = _showApiError

    var currentState = RestaurantFetchState.YELP

    // Save nextPageToken
    private var nextPageToken: String? = null
    // Save offset
    private var offset = 0

    private var longitude: Double = 0.0
    private var latitude: Double = 0.0

    fun init(longitude: Double, latitude: Double) {
        this.longitude = longitude
        this.latitude = latitude
    }

    fun fetchRestaurants() {
        _isLoading.value = true
        viewModelScope.launch {
            val restaurants = when (currentState) {
                RestaurantFetchState.YELP -> {
                    // Offset is half the pager size since the pager size is 2 lists of 20
                    fetchYelpRestaurants(offset = offset)
                }
                RestaurantFetchState.PLACES -> {
                    fetchPlacesRestaurants()
                }
            }
            val allRestaurants = _restaurantList.value?.plus(restaurants)
            _restaurantList.value = allRestaurants
            _isLoading.value = false
        }
    }

    private suspend fun fetchYelpRestaurants(offset: Int): List<Restaurant> {
        val response = yelpManager.getYelpRestaurants(
            latitude = latitude,
            longitude = longitude,
            offset = offset
        ).awaitResponse()

        // If there's an API Error then show it
        if (response.errorBody() != null) {
            response.errorBody()?.let {
                _showApiError.value = it
            }
            return emptyList()
        }

        this.offset += response.body()?.restaurants?.size ?: 0
        // If we didn't add 20 items, that means the YELP list is done and to show the error dialog
        // after the user goes through the remaining restaurants
        if (this.offset % 20 != 0) {
            _showError.value = true
        }
        return response.body().formatYelp()
    }

    private suspend fun fetchPlacesRestaurants(): List<Restaurant> {
        val response = placesRestaurantApi.getPlacesRestaurants(
            "$latitude,$longitude",
            nextPageToken ?: ""
        ).awaitResponse()

        // If there's an API Error then show it
        if (response.errorBody() != null) {
            response.errorBody()?.let {
                _showApiError.value = it
            }
            return emptyList()
        }

        this.nextPageToken = response.body()?.nextPageToken ?: ""
        // If nextPageToken is empty & not null after being set from the response, that means the PLACES
        // API is done and to show the error dialog after the user goes through the remaining restaurants
        if (this.nextPageToken.isNullOrEmpty()) {
            Log.e("Error", "Error: reached end of PLACES list; disallow continuation")
            _showError.value = true
        }
        return response.body().formatPlaces()
    }
}
