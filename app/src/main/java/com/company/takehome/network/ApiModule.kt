package com.company.takehome.network

import com.company.takehome.network.places.PlacesRestaurantService
import com.company.takehome.network.yelp.YelpRestaurantService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Provides
    @Singleton
    fun yelpRestaurantService(
        moshi: Moshi
    ): YelpRestaurantService {
        val newRetrofit = Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl(YELP_API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return newRetrofit.create(YelpRestaurantService::class.java)
    }

    @Provides
    @Singleton
    fun placesRestaurantService(
        moshi: Moshi
    ): PlacesRestaurantService {
        val newRetrofit = Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl(PLACES_API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return newRetrofit.create(PlacesRestaurantService::class.java)
    }

    companion object {
        internal const val PLACES_API_BASE_URL = "https://maps.googleapis.com/maps/api/place/"
        internal const val YELP_API_BASE_URL = "https://api.yelp.com/"
    }
}
