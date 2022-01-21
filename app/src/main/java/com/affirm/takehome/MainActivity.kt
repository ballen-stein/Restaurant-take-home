package com.affirm.takehome

import android.Manifest
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.affirm.takehome.adapter.RestaurantAdapter
import com.affirm.takehome.data.Restaurant
import com.affirm.takehome.data.RestaurantFetchState
import com.affirm.takehome.favorites.FavoritesActivity
import com.affirm.takehome.network.places.PlacesRestaurantApi
import com.affirm.takehome.network.places.PlacesRestaurantApiFactory
import com.affirm.takehome.network.yelp.YelpRestaurantApi
import com.affirm.takehome.network.yelp.YelpRestaurantApiFactory
import com.affirm.takehome.utils.formatPlaces
import com.affirm.takehome.utils.formatYelp
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.awaitResponse
import kotlin.properties.Delegates.observable


private const val LOCATION_PERMISSION_CODE = 101
private const val THUMB_UP = R.drawable.thumb_up
private const val THUMB_DOWN = R.drawable.thumb_down
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private var animating = false

    private val restaurantAdapter by lazy {
        RestaurantAdapter()
    }

    private var yesCounter: Int by observable(0) { _, _, newValue ->
        yesCounterText.text = newValue.toString()
    }

    private var noCounter: Int by observable(0) { _, _, newValue ->
        noCounterText.text = newValue.toString()
    }

    private val fusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(
            this
        )
    }

    private lateinit var placesRestaurantApi: PlacesRestaurantApi
    private lateinit var yelpRestaurantApi: YelpRestaurantApi

    // Save longitude/latitude locally to reuse for API services
    private var longitude: Double = 0.0
    private var latitude: Double = 0.0

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    // Start on YELP items
    private var currentState = RestaurantFetchState.YELP

    // Save nextPageToken
    private var nextPageToken: String? = null
    // Save offset
    private var offset = 0

    // Prevent extra clicks from loading extra data while waiting for API response
    private var isLoading: Boolean = false

    private val showError: MutableLiveData<Boolean> = MutableLiveData(false)
    private val favoritedRestaurants: ArrayList<Restaurant> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        placesRestaurantApi = PlacesRestaurantApiFactory.create()
        yelpRestaurantApi = YelpRestaurantApiFactory.create()

        viewPager.adapter = restaurantAdapter
        // Only allow button input, swiping not allowed
        viewPager.isUserInputEnabled = false

        yesButton.setOnClickListener {
            // Check if we have an error from hitting the end of the dataset;
            // if we do, and the view is at the end of the data, show the error dialog
            if (showError.value == true && viewPager.currentItem + 1 == restaurantAdapter.itemCount) {
                showGenericError()
            }
            // Make sure the previous animation finishes
            if (!animating) {
                yesCounter++

                val index = viewPager.currentItem
                val restaurant = restaurantAdapter.getCurrentRestaurant(index)
                favoritedRestaurants.add(restaurant)
                //Log.d("CurrentRestaurant", "Current restaurant : ${restaurant.name}")
                viewPager.currentItem = viewPager.currentItem + 1
                animateIcon(THUMB_UP)

                // If we're not loading, check if we can should an API request
                if (!isLoading && showError.value != true) {
                    checkCurrentIndex(viewPager.currentItem)
                }
            }
        }

        noButton.setOnClickListener {
            // Check if we have an error from hitting the end of the dataset;
            // if we do, and the view is at the end of the data, show the error dialog
            if (showError.value == true && viewPager.currentItem + 1 == restaurantAdapter.itemCount) {
                showError
            }
            // Make sure the previous animation finishes
            if (!animating) {
                noCounter++
                viewPager.currentItem = viewPager.currentItem + 1
                animateIcon(THUMB_DOWN)

                // If we're not loading, check if we can should an API request
                if (!isLoading && showError.value != true) {
                    checkCurrentIndex(viewPager.currentItem)
                }
            }
        }

        favoritedRestaurantsButton.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            intent.putParcelableArrayListExtra(FavoritesActivity.FAVORITED_RESTAURANTS, favoritedRestaurants)
            startActivity(intent)
        }

        yesCounterText.text = yesCounter.toString()
        noCounterText.text = noCounter.toString()

        checkAndRequestPermissionsForLocation()
    }

    private fun animateIcon(drawable: Int) {
        animating = true
        icon.setImageDrawable(ContextCompat.getDrawable(this, drawable))
        icon.alpha = 0.5f
        icon.visibility = View.VISIBLE
        icon.animate()
            .alpha(1f)
            .setDuration(300)
            .scaleX(2f)
            .scaleY(2f)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    icon.visibility = View.GONE
                    animating = false
                }
            })
    }

    private fun checkCurrentIndex(currentItemIndex: Int) {
        val amountOfRestaurants = restaurantAdapter.itemCount
        // When there's "a couple" (2) or less restaurants remaining, fetch more
        if (amountOfRestaurants - currentItemIndex <= TWO_RESTAURANTS_REMAINING) {
            currentState = when (currentState) {
                RestaurantFetchState.YELP -> {
                    // Currently viewing YELP items; switch to PLACES and make API call
                    RestaurantFetchState.PLACES
                }
                RestaurantFetchState.PLACES -> {
                    // Currently viewing PLACES items; switch to YELP and make API call
                    RestaurantFetchState.YELP
                }
            }
            fetchRestaurants()
        }
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == LOCATION_PERMISSION_CODE) {
            if ((grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED)
            ) {
                loadLocation()
            } else {
                Toast.makeText(this, getString(R.string.no_permission), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkAndRequestPermissionsForLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_CODE
            )
        } else {
            loadLocation()
        }
    }

    @SuppressLint("MissingPermission")
    private fun loadLocation() {
        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location ->
            if (location == null) {
                // request the location
                fusedLocationProviderClient.requestLocationUpdates(
                    LocationRequest.create(),
                    object : LocationCallback() {
                        override fun onLocationResult(locationResult: LocationResult) {
                            super.onLocationResult(locationResult)

                            locationResult.locations.lastOrNull().let { location ->
                                if (location == null) {
                                    Log.d(TAG, "Location load fail")
                                    false
                                } else {
                                    latitude = location.latitude
                                    longitude = location.longitude

                                    fetchRestaurants()
                                    true
                                }
                            }
                            fusedLocationProviderClient.removeLocationUpdates(this)
                        }
                    },
                    null
                )
            } else {
                latitude = location.latitude
                longitude = location.longitude

                fetchRestaurants()
            }
        }
    }

    private fun fetchRestaurants() {
        isLoading = true
        coroutineScope.launch {
            val restaurants = when (currentState) {
                RestaurantFetchState.YELP -> {
                    // Offset is half the pager size since the pager size is 2 lists of 20
                    Log.d(TAG, "Grabbing YELP restaurants from YELP state")
                    fetchYelpRestaurants(offset = offset)
                }
                RestaurantFetchState.PLACES -> {
                    Log.d(TAG, "Grabbing PLACES restaurants from PLACES state")
                    fetchPlacesRestaurants()
                }
            }

            restaurantAdapter.addRestaurants(restaurants)
            isLoading = false
        }
    }

    private suspend fun fetchYelpRestaurants(offset: Int): List<Restaurant> {
        val response = yelpRestaurantApi.getRestaurants(
                latitude = latitude,
                longitude = longitude,
                offset = offset
        ).awaitResponse()

        // If there's an API Error then show it
        if (response.errorBody() != null) {
            response.errorBody()?.let {
                showApiError(it)
            }
            return emptyList()
        }

        this.offset += response.body()?.restaurants?.size ?: 0
        // If we didn't add 20 items, that means the YELP list is done and to show the error dialog
        // after the user goes through the remaining restaurants
        if (this.offset % 20 != 0) {
            Log.e(TAG, "Error: reached end of YELP list; disallow continuation")
            showError.value = true
        }
        return response.body().formatYelp()
    }

    private suspend fun fetchPlacesRestaurants(): List<Restaurant> {
        val response = placesRestaurantApi.getRestaurants(
            latitude = latitude,
            longitude = longitude,
            nextPageToken = nextPageToken ?: ""
        ).awaitResponse()

        // If there's an API Error then show it
        if (response.errorBody() != null) {
            response.errorBody()?.let {
                showApiError(it)
            }
            return emptyList()
        }

        this.nextPageToken = response.body()?.nextPageToken ?: ""
        // If nextPageToken is empty & not null after being set from the response, that means the PLACES
        // API is done and to show the error dialog after the user goes through the remaining restaurants
        if (this.nextPageToken.isNullOrEmpty()) {
            Log.e(TAG, "Error: reached end of PLACES list; disallow continuation")
            showError.value = true
        }
        return response.body().formatPlaces()
    }

    private fun showApiError(responseBody: ResponseBody) {
        AlertDialog.Builder(this)
            .setTitle("Error with API or Connection")
            .setMessage("There's an issue with the API/Connection\n\n${responseBody.string()}")
            .setPositiveButton("OK") { _, _ ->
                Log.e(TAG, "API Error : ${responseBody.string()}")
            }
            .setOnDismissListener {
                Log.e(TAG, "API Error : ${responseBody.string()}")
            }
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }

    private fun showGenericError() {
        AlertDialog.Builder(this)
            .setTitle("End of the List")
            .setMessage("Oh no! You've reached the end of the list! Thanks for playing!")
            .setPositiveButton("This is OK") { _, _ ->
                Log.d(TAG, "User is happy that the list is done")
                disableViews()
            }
            .setNegativeButton("This is not OK") { _, _ ->
                Log.d(TAG, "User is not happy that the list is done")
                disableViews()
            }
            .setOnDismissListener {
                disableViews()
            }
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }

    private fun disableViews() {
        // Disable the buttons to prevent the counters from incrementing
        yesButton.isEnabled = false
        noButton.isEnabled = false
    }

    companion object {
        // Value to make next API call at
        const val TWO_RESTAURANTS_REMAINING = 2
    }
}
